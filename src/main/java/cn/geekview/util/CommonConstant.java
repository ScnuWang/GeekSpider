package cn.geekview.util;

import cn.geekview.domain.TDreamCurrency;

import java.util.HashMap;
import java.util.Map;

/**
 * 公共常量
 */
public class CommonConstant {

    /***每天的毫秒数*/
    public static final double MSEC_DAY = 24*60*60*1000;

    /** 汇率转换表*/
    public static Map<String,TDreamCurrency> CURRENCY_MAP = new HashMap<String, TDreamCurrency>();

    /** 任务执行状态*/
    public static int TaskStatus = 0;

    public static final int INIT = 1;
    public static final int INITDONE = 2;
    public static final int GRAP = 3;
    public static final int GRAPDONE = 4;
    public static final int PERSIS = 5;
    public static final int PERSISDONE = 6;
    public static final int ANALYSIS = 7;
    public static final int ANALYSISDONE = 8;
    public static final int STATISTIC = 9;
    public static final int STATISTICSDONE = 10;

}
