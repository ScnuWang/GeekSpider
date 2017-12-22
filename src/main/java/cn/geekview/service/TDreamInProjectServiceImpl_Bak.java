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
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 如果在这里新建Task任务与之前的系统进行对接的话，如果以后前面的系统进行更改，这里也需要更改，
 * 还是直接在这里进行分析比较合适一点
 */
@Service
public class TDreamInProjectServiceImpl_Bak {

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

        RestTemplate restTemplate = new RestTemplate();
        //获取数据的接口地址
        String url = "https://www.indiegogo.com/private_api/explore?filter_category=Technology&filter_funding=&filter_percent_funded=&filter_quick=popular_all&filter_status=&per_page=100&pg_num=";
        //项目总数
        Integer projects = 0;
        //页面编号
        int pg_num = 1;
        //请求头
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "application/json, text/plain, */*");
        headers.set("Accept-Language", "zh-CN,zh;q=0.8");
        headers.set("Cache-Control", "max-age=0");
        headers.set("Connection", "keep-alive");
        headers.set("Host", "www.indiegogo.com");
        headers.set("If-None-Match", "W/\"749ba3252715ea927aa60ea709d6040f\"");
        headers.set("Upgrade-Insecure-Requests", "1");
        headers.set("Referer","www.indiegogo.com");
        headers.set("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.111 Safari/537.36");
        headers.set("Cookie", "ki_t=1482987544992%3B1487728858942%3B1487729104639%3B4%3B16; ki_r=; D_SID=113.104.195.55:YisvIcHF4Z24s3TB2TKbitxWEwrmGlyymljvxklDswE; __ar_v4=MNA52ZMPS5A5HHGLKMZP3O%3A20170602%3A3%7CZIENZZYANBHC5MQ4WYNKZI%3A20170602%3A3%7C6RP73TXU3VCT7KLJC3P7EZ%3A20170602%3A3; __stripe_mid=35ce441a-7019-4221-b482-b0cba67f7fd4; romref=sch-baid; romref_referer_host=www.baidu.com; D_IID=02B91A75-51CD-3F94-A882-07B72A5961C2; D_UID=8506F25A-0F30-31AC-81E7-2864983C64A4; D_ZID=FDDDFB6A-67FA-340D-9C89-564B5A0B9899; D_ZUID=5D0201DE-2FF3-3A22-AD4E-8F28FE310CF0; D_HID=2FCF09D9-15AF-3626-BC88-5C189ABE314C; _ga=GA1.2.378922805.1482987529; _gid=GA1.2.772188293.1496800270; _ceg.s=or7ggq; _ceg.u=or7ggq; __hstc=223492548.37066d182471c31df2df71226efcf1aa.1482987568028.1496806912327.1496885823487.12; __hssrc=1; __hssc=223492548.1.1496885823487; hubspotutk=37066d182471c31df2df71226efcf1aa; locale=en; cohort=www.baidu.com%7Csch-baid%7Cshr-pica%7Csch-baid%7Cshr-pica%7Csch-baid; visitor_id=bba58762b2348bf353961ae7353f1e7ab5ff697484ba0a55993771e32402d354; analytics_session_id=2cab9c7316a54d91e73058b25c9e12748d7b3fda0ea06d63e02fb536b212e3d6; recent_project_ids=2001745%262132365%262115568%262107867%261905844%261637253%262115621%261931378%262063864%261787929%262024430%261978687%261993728%262016897%262023232%261994449%262017684%262022194%261319420%261625355; _session_id=742dc34425f25f0f10f5962f23becc4f");
        HttpEntity httpEntity = new HttpEntity(headers);
        while (true){
            String reqUrl = url+pg_num;
            logger.info("请求："+reqUrl);
            ResponseEntity responseEntity = restTemplate.exchange(reqUrl, HttpMethod.GET,httpEntity,String.class);
            String result = ((String) responseEntity.getBody()).trim();
            if (!StringUtils.isEmpty(result)) {
                JSONObject jsonObject = (JSONObject) JSONObject.parse(result);
                JSONArray jsonArray = jsonObject.getJSONArray("campaigns");
                int size = jsonArray.size();
                if (size<1) break;
                projects = projects + size;
                for (int i = 0; i < size; i++) {
                    JSONObject json = (JSONObject)jsonArray.get(i);
                    String originalId = json.getString("id");                                   //编号
                    String projectName = json.getString("title");                               //项目名称
                    String projectDesc = json.getString("tagline");                             //项目简介
                    String imageUrl = json.getString("igg_image_url");                          //图片地址
                    Integer supportPerson = json.getInteger("cached_collected_pledges_count");//支持人数
                    BigDecimal currMoney = new BigDecimal(CommonUtil.getNumber(json.getString("balance")));//当前已筹金额
                    String moneyCurrency = json.getString("currency_code");                      //币种
                    String time_left = json.getString("amt_time_left");                          //剩余天数
                    //21 hours left   28 days left   No time left
                    Integer remainDay = 0;
                    if (time_left.indexOf("days")>0){
                        remainDay = Integer.valueOf(CommonUtil.getNumber(time_left));
                    }
                    String projectUrl = json.getString("url");                                   //项目地址
                    String collected_percentage = json.getString("collected_percentage");      //完成百分比
                    Integer finishPer = Integer.valueOf(CommonUtil.getNumber(collected_percentage));
                    Boolean foreverStatus = json.getBoolean("in_forever_funding");             //是否是永久众筹

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
                    if (foreverStatus||remainDay>0){
                        inProject.setStatusValue(2);
                        inProject.setProjectStatus("众筹中");
                    }else if (finishPer>100 && remainDay==0&&!foreverStatus){
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
                    inProject.setBeginDate(new Date());
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
        //核心质量(由于目前Indiegogo的接口拿不到item相关数据)
        /*int coreSupport = 0,coreTotal = 0;
        double corePrice = 0;
        Map<BigDecimal,Integer[]> itemMap = new HashMap<BigDecimal,Integer[]>();
        if(project.getItemList()!=null&&project.getItemList().size()>0){
            List<TDreamInIterm> limitList = new ArrayList<TDreamInIterm>();
            List<TDreamInIterm> unLimitList = new ArrayList<TDreamInIterm>();
            for(TDreamInIterm item : project.getItemList()){
                if(item.getItemPrice().doubleValue()< 5 ) continue;
                if(item.getItemTotal() == 0)
                    unLimitList.add(item);
                else
                    limitList.add(item);
            };
            if(limitList.size()>0){
                for(TDreamInIterm item : limitList){
                    if(itemMap.get(item.getItemPrice())!=null){
                        Integer[] numArray = itemMap.get(item.getItemPrice());
                        numArray[0] = numArray[0]+item.getItemSupport();
                        numArray[1] = numArray[1]+item.getItemTotal();
                        itemMap.put(item.getItemPrice(), numArray);
                    }else{
                        Integer[] numArray = {item.getItemSupport(),item.getItemTotal()};
                        itemMap.put(item.getItemPrice(), numArray);
                    }
                };
                for(Map.Entry<BigDecimal,Integer[]> entry : itemMap.entrySet()){
                    Integer[] values = entry.getValue();
                    if(values[1] > coreTotal){
                        corePrice = entry.getKey().doubleValue();
                        coreSupport = values[0];
                        coreTotal = values[1];
                    }else if(values[1] == coreTotal){
                        if(corePrice>entry.getKey().doubleValue()){
                            corePrice = entry.getKey().doubleValue();
                            coreSupport = values[0];
                            coreTotal = values[1];
                        }
                    }
                }
            }else{
                if(unLimitList.size()>0){
                    for(TDreamInIterm item : unLimitList){
                        if(itemMap.get(item.getItemPrice())!=null){
                            Integer[] numArray = itemMap.get(item.getItemPrice());
                            numArray[0] = numArray[0]+item.getItemSupport();
                            numArray[1] = numArray[1]+1;
                            itemMap.put(item.getItemPrice(), numArray);
                        }else{
                            Integer[] numArray = {item.getItemSupport(),1};
                            itemMap.put(item.getItemPrice(), numArray);
                        }
                    };
                    for(Map.Entry<BigDecimal,Integer[]> entry : itemMap.entrySet()){
                        Integer[] values = entry.getValue();
                        if(values[1] > coreTotal){
                            corePrice = entry.getKey().doubleValue();
                            coreSupport = values[0];
                            coreTotal = values[1];
                        }else if(values[1] == coreTotal){
                            if(corePrice>entry.getKey().doubleValue()){
                                corePrice = entry.getKey().doubleValue();
                                coreSupport = values[0];
                                coreTotal = values[1];
                            }
                        }
                    }
                    coreTotal = 0;
                }
            }
        }
        entity.setItemCorePriceOrg(new BigDecimal(corePrice));
		entity.setItemCorePrice(new BigDecimal(corePrice).multiply(currency.getCurrencyExchange()));
		entity.setItemCoreSupport(coreSupport);
		entity.setItemCoreTotal(coreTotal);*/
        entity.setItemCorePriceOrg(new BigDecimal(0));
        entity.setItemCorePrice(new BigDecimal(0));
        entity.setItemCoreSupport(0);
        entity.setItemCoreTotal(0);
        return entity;
    }
}
