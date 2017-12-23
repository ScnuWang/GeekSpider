package cn.geekview.service;

import cn.geekview.aop.LoggerManage;
import cn.geekview.domain.TDreamCurrency;
import cn.geekview.domain.TDreamInAnalysis;
import cn.geekview.domain.TDreamInProject;
import cn.geekview.domain.TDreamRankGrowth;
import cn.geekview.mapper.TDreamInAnalysisMapper;
import cn.geekview.mapper.TDreamInProjectMapper;
import cn.geekview.mapper.TDreamProductMapper;
import cn.geekview.mapper.TDreamRankGrowthMapper;
import cn.geekview.util.CommonConstant;
import cn.geekview.util.CommonUtil;
import cn.geekview.util.DataAnalysis;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 如果在这里新建Task任务与之前的系统进行对接的话，如果以后前面的系统进行更改，这里也需要更改，
 * 还是直接在这里进行分析比较合适一点
 */
@Service
public class TDreamInProjectServiceImpl {

    protected Logger logger = Logger.getLogger(this.getClass());

    @Autowired
    private TDreamInProjectMapper  inProjectMapper;

    @Autowired
    private TDreamProductMapper productMapper;

    @Autowired
    private TDreamInAnalysisMapper inAnalysisMapper;

    @Autowired
    private TDreamRankGrowthMapper growthMapper;

    @Value("${statistics.url}")
    private String statisticsUrl;

    private final static String indiegogourl = "https://www.indiegogo.com";

    /**
     * 初始化抓取任务
     *      目前暂时无法获取到只有单个项目的请求地址
     */
    public void init(){

    }

    /**
     *
     * 执行抓取任务并存放到数据库
     */
    @LoggerManage(description = "执行抓取任务")
    public Integer grap(Date update) throws Exception{//日期 + 中午12点   yyyy-MM-dd 12:00:00
        //删除已有的当日数据
        inProjectMapper.deleteByUpdate(update);

        String url = "https://www.indiegogo.com/private_api/discover";
        //项目总数
        Integer projects = 0;
        //页面编号
        int pg_num = 1;
        while (true){
            String reqUrl = url;
//            String reqUrl = url;
            logger.info("请求："+reqUrl);
            JSONObject result = CommonUtil.httpRequest_Post(reqUrl,pg_num);
            if (!StringUtils.isEmpty(result)) {
                JSONArray jsonArray = result.getJSONObject("response").getJSONArray("discoverables");
                int size = jsonArray.size();
                if (size<1) break;
                projects = projects + size;
                for (int i = 0; i < size; i++) {
                    JSONObject json = (JSONObject)jsonArray.get(i);
                    String originalId = json.getString("project_id");                                   //编号
                    String projectName = json.getString("title");                               //项目名称
                    String projectDesc = json.getString("tagline");                             //项目简介
                    String imageUrl = json.getString("image_url");                          //图片地址
                    Integer supportPerson = 0;//支持人数
                    BigDecimal currMoney = new BigDecimal(CommonUtil.getNumber(json.getString("funds_raised_amount")));//当前已筹金额
                    String moneyCurrency = json.getString("currency");                      //币种
                    String end_date = json.getString("close_date").split("T")[0];
                    String begin_date = json.getString("open_date").split("T")[0];
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    Date endDate = dateFormat.parse(end_date);
                    Date beginDate = dateFormat.parse(begin_date);
                    Long time = endDate.getTime()-System.currentTimeMillis();
                    int t = time.intValue()/(24*60*1000);
                    Integer remainDay = 0;
                    if (t>1){
                        remainDay = t;
                    }
                    String projectUrl = json.getString("clickthrough_url");                                   //项目地址
                    String collected_percentage = String.valueOf(json.getBigDecimal("funds_raised_percent").multiply(new BigDecimal(100)).intValue());      //完成百分比
                    Integer finishPer = Integer.valueOf(collected_percentage);
                    Boolean foreverStatus = false;             //是否是永久众筹
                    TDreamInProject inProject = new TDreamInProject();
                    inProject.setOriginalId(originalId);
                    inProject.setProjectName(projectName);
                    inProject.setProjectDesc(projectDesc);
                    inProject.setProjectImage(imageUrl);
                    inProject.setSupportPerson(supportPerson);
                    inProject.setCurrMoney(currMoney);
                    inProject.setMoneyCurrency(moneyCurrency);
                    inProject.setRemainDay(remainDay);
                    inProject.setProjectUrl(indiegogourl+projectUrl);
                    inProject.setFinishPer(finishPer);
                    if (foreverStatus){
                        inProject.setForeverStatus(1);//1表示永久众筹
                    }else {
                        inProject.setForeverStatus(0);
                    }
                    if (!json.getBoolean("is_indemand")){
                        inProject.setStatusValue(2);
                        inProject.setProjectStatus("众筹中");
                    }else if (finishPer>=100&&json.getBoolean("is_indemand")){
                        inProject.setStatusValue(3);
                        inProject.setProjectStatus("众筹成功");
                    }else if (finishPer<100 && remainDay==0&&!foreverStatus){
                        inProject.setStatusValue(4);
                        inProject.setProjectStatus("众筹失败");
                    }else {
                        inProject.setStatusValue(5);
                        inProject.setProjectStatus("众筹异常");
                    }
                    inProject.setShareCount(0);
                    inProject.setBeginDate(beginDate);
                    inProject.setUpdateDate(update);
                    //想法: 一次性插入一条项目，一次性插入一页项目，一次性插入所有的项目
                    int a = inProjectMapper.insert(inProject);
                    if (a !=1){
                        inProjectMapper.insert(inProject);
                    }
                }
            }else {
                logger.info("请求："+url+"返回结果无数据");
                break;
            }
            pg_num++;
        }
        logger.info("共抓取项目数："+projects);
        return projects;
    }

    /**
     * 持久化抓取结果到数据库
     */
    public void persistance(){

    }

    /**
     * 分析数据
     */
    @LoggerManage(description = "分析数据")
    public Integer analysis(Date updateDate) throws Exception{
        //删除已有的当日数据
        inAnalysisMapper.deleteByUpdate(updateDate);
        growthMapper.deleteByWebsiteAndUpdateDate(4,updateDate);

        List<TDreamInProject> projectList = inProjectMapper.selectListByUpdateDate(updateDate);
        Map<String,Object> parmMap = new HashMap<String, Object>();
        for(TDreamInProject project : projectList){
            Integer productId = productMapper.selectProductId(4,project.getOriginalId());
            if(productId == null){
                inProjectMapper.insertProduct(project);
                productId = productMapper.selectProductId(4,project.getOriginalId());
            }else{
                inProjectMapper.updateProduct(project);
            }
            TDreamInAnalysis entity = creatPrepareEntity(project);
            entity.setProductId(productId);
            parmMap.put("flowCount", entity.getSupportPerson());
            parmMap.put("currMoney", entity.getCurrMoney().doubleValue());
            parmMap.put("targetMoney", entity.getTargetMoney().doubleValue());
            parmMap.put("coreSupport", entity.getItemCoreSupport());
            parmMap.put("coreTotal", entity.getItemCoreTotal());
            parmMap.put("corePrice", entity.getItemCorePrice().doubleValue());
            DataAnalysis.statisticsAnalysis(parmMap);
            entity.setFlowValue((int)parmMap.get("flowValue"));
            entity.setMoneyValue((int)parmMap.get("moneyValue"));
            entity.setItemCoreValue((int)parmMap.get("coreValue"));
            entity.setGvIndex((int)parmMap.get("totalValue"));

            inAnalysisMapper.insert(entity);
            inAnalysisMapper.updateProduct(entity);

            TDreamInAnalysis prevEntity = inAnalysisMapper.selectPrevAnalysis(productId,updateDate);
            insertRankGrowth(project,entity,prevEntity);
        }
        logger.info("-- 数据分析完成！");
        return projectList.size();
    }

    @LoggerManage(description = "调用统计接口")
    public String statistic(String time) throws Exception{
        //发送请求到http://localhost:8080/task/statistics  ---->//http://54.222.243.20:8084/task/statistics
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity responseEntity = restTemplate.exchange(statisticsUrl+time,HttpMethod.GET,HttpEntity.EMPTY,String.class);
        return "统计请求响应状态码："+responseEntity.getStatusCode();
    }


    private void insertRankGrowth(TDreamInProject project, TDreamInAnalysis entity, TDreamInAnalysis prevEntity) {
        int days = 1;
        logger.info("-- 生成"+entity.getProductId()+"的增速榜数据！");
        TDreamRankGrowth growth = new TDreamRankGrowth();
        growth.setProductId(entity.getProductId());
        growth.setUpdateDate(entity.getUpdateDate());
        if(prevEntity == null){
            growth.setCurrMoneyLast(new BigDecimal(0));
            growth.setCurrMoneyLastOrg(new BigDecimal(0));
            growth.setSupportLast(0);
        }else{
            growth.setCurrMoneyLast(prevEntity.getCurrMoney());
            growth.setCurrMoneyLastOrg(prevEntity.getCurrMoneyOrg());
            growth.setSupportLast(prevEntity.getSupportPerson());
            days = (int) Math.ceil(((entity.getUpdateDate().getTime()-prevEntity.getUpdateDate().getTime())/CommonConstant.MSEC_DAY));
            days = days<1?1:days;
        }
        growth.setCurrMoneyNow(entity.getCurrMoney());
        growth.setCurrMoneyNowOrg(entity.getCurrMoneyOrg());
        growth.setSupportNow(entity.getSupportPerson());

        growth.setGrowthMoney(new BigDecimal(growth.getCurrMoneyNow().subtract(growth.getCurrMoneyLast()).doubleValue()/days));
        growth.setGrowthMoneyOrg(new BigDecimal(growth.getCurrMoneyNowOrg().subtract(growth.getCurrMoneyLastOrg()).doubleValue()/days));
        growth.setGrowthSupport((growth.getSupportNow()-growth.getSupportLast())/days);

        growth.setTargetMoney(entity.getTargetMoney());
        int costDays = 0;long startMsec = 0,endMsec = 0;
        if(project.getEndDate()!=null){
            endMsec = project.getEndDate().getTime();
        }else{
            endMsec = System.currentTimeMillis();
        }
        if(project.getBeginDate() != null){
            startMsec = project.getBeginDate().getTime();
        }else{
            startMsec = endMsec;
        }
        costDays = (int) ((endMsec - startMsec)/ CommonConstant.MSEC_DAY);
        if(costDays < 1){
            growth.setTargetAverage(entity.getTargetMoney());
        }else{
            growth.setTargetAverage(new BigDecimal(entity.getTargetMoney().doubleValue()/costDays));
        }
        if(entity.getTargetMoney() == null||growth.getTargetAverage() == null
                ||entity.getTargetMoney().doubleValue() == 0||growth.getTargetAverage().doubleValue() == 0){
            growth.setGrowthSpeed(0);
        }else{
            int speed = (int) (growth.getGrowthMoney().doubleValue()/growth.getTargetAverage().doubleValue())*100;
            growth.setGrowthSpeed(speed);
        }
        growthMapper.insert(growth);
        logger.info(entity.getProductId()+"-- 增速榜数据生成完毕！");
    }

    private  TDreamInAnalysis creatPrepareEntity(TDreamInProject project){
        TDreamInAnalysis entity = new TDreamInAnalysis();
        entity.setFinishPer(project.getFinishPer());
        entity.setUpdateDate(project.getUpdateDate());
        TDreamCurrency currency = CommonConstant.CURRENCY_MAP.get("USD");
        if(project.getMoneyCurrency()!=null){
            currency = CommonConstant.CURRENCY_MAP.get(project.getMoneyCurrency().toUpperCase());
        }
        if(currency!=null){
            entity.setCurrencyId(currency.getPkId());
        }else{
            entity.setCurrencyId(1);
            currency = CommonConstant.CURRENCY_MAP.get(1);
        }

        entity.setTargetMoney(new BigDecimal(0));
        entity.setTargetMoneyOrg(new BigDecimal(0));

        entity.setCurrMoneyFund(new BigDecimal(0));
        entity.setCurrMoneyFundOrg(new BigDecimal(0));

        entity.setCurrMoneyForever(new BigDecimal(0));
        entity.setCurrMoneyForeverOrg(new BigDecimal(0));

        entity.setCurrMoneyExternal(new BigDecimal(0));
        entity.setCurrMoneyExternalOrg(new BigDecimal(0));

        if(project.getCurrMoney() == null){
            entity.setCurrMoney(new BigDecimal(0));
            entity.setCurrMoneyOrg(new BigDecimal(0));
        }else{
            entity.setCurrMoneyOrg(project.getCurrMoney());
            entity.setCurrMoney(project.getCurrMoney().multiply(currency.getCurrencyExchange()));
        }
        if(project.getSupportPerson() == null||project.getSupportPerson() == 0){
            entity.setSupportPerson(0);
            entity.setAverageMoney(new BigDecimal(0));
        }else{
            entity.setSupportPerson(project.getSupportPerson());
            entity.setAverageMoney(new BigDecimal((entity.getCurrMoney()).doubleValue()/entity.getSupportPerson()));
        }
        if(entity.getAverageMoney() == null){
            entity.setAverageMoney(new BigDecimal(0));
        }
        entity.setShareCount(0);
        entity.setItemCorePriceOrg(new BigDecimal(0));
        entity.setItemCorePrice(new BigDecimal(0));
        entity.setItemCoreSupport(0);
        entity.setItemCoreTotal(0);
        return entity;
    }
}
