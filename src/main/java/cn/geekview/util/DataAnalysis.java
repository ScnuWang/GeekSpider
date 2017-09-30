package cn.geekview.util;

import java.util.Map;

public class DataAnalysis {

    private static final int flow_weigths = 4000;
    private static final int flow_base = 100000;
    private static final int maoney_weigths = 3000;
    private static final int core_weigths = 3000;
    private static final int core_base = 60000;

    //计算总体排名
    public static void statisticsAnalysis(Map<String,Object> parmMap) {
        int flowValue = 0,moneyValue=0,coreValue = 0;
        //平台相对流量
        String parm_1 = parmMap.get("flowCount")+"";
        //极客指数评分暂时不计算流量评分：因为京东的抓取没有获得点赞、支持、关注的数据
		/*if(CommonUtils.isEmpty(parm_1)){
			parmMap.put("flowValue", 0);
		}else{
			//平台相对流量
			flowValue = (int)((Math.log10(Integer.parseInt(parm_1)+1)/Math.log10(flow_base+1))*flow_weigths);
			parmMap.put("flowValue",flowValue);
		}*/
        parmMap.put("flowValue", 0);
        //金额
        parm_1 = parmMap.get("currMoney")+"";
        String parm_2 = parmMap.get("targetMoney")+"";
        if(CommonUtil.isEmpty(parm_1)||CommonUtil.isEmpty(parm_2)){
            parmMap.put("moneyValue", 0);
        }else if(Double.parseDouble(parm_2) == 0){
            parmMap.put("moneyValue", 0);
        }else{
            moneyValue = (int)((Math.log10(Double.parseDouble(parm_1)+1)/Math.log10(Double.parseDouble(parm_2)+1))*maoney_weigths);
            parmMap.put("moneyValue",moneyValue);
        }

        //核心质量
       /* parm_1 = parmMap.get("coreSupport")+"";
        parm_2 = parmMap.get("coreTotal")+"";
        String parm_3 = parmMap.get("corePrice")+"";
        if(CommonUtil.isEmpty(parm_1)||CommonUtil.isEmpty(parm_2)||CommonUtil.isEmpty(parm_3)){
            parmMap.put("coreValue", 0);
        }else{
            int coreSupport = Integer.parseInt(parm_1),coreTotal =Integer.parseInt(parm_2);
            double corePrice = Double.parseDouble(parm_3);
            if(coreTotal == 0){
                coreTotal = core_base;
            }
            coreValue = (int)((Math.log10(coreSupport*corePrice+1)/Math.log10(coreTotal*corePrice+1))*core_weigths);
            parmMap.put("coreValue",coreValue);
        }*/
        parmMap.put("coreValue",coreValue);
        //总得分
        parmMap.put("totalValue",flowValue+moneyValue+coreValue);
    }

}
