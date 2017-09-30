package cn.geekview.util;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommonUtil {
    public static String getNumber(String str){
        if (StringUtils.isEmpty(str)) return "0";
        String regEx="[^0-9]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        return  m.replaceAll("").trim();
    }

    public static boolean isEmpty(String str){
        if(!StringUtils.isEmpty(str)){
            return ("null".equals(str.toLowerCase()));
        }
        return true;
    }
}
