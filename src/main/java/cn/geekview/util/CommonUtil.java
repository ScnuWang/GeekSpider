package cn.geekview.util;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
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

    public static JSONObject httpRequest_Post(String url,Integer page_num){
        try {
            RestTemplate restTemplate = new RestTemplate();
            //请求头
            HttpHeaders headers = new HttpHeaders();
            headers.set("Accept", "application/json, text/plain, */*");
//        headers.set("Accept-Encoding", "gzip, deflate, br");
            headers.set("Accept-Language", "zh-CN,zh;q=0.9");
            headers.set("Connection", "keep-alive");
            headers.set("Content-Length", "157");
            headers.set("Content-Type", "application/json;charset=UTF-8");
            headers.set("Cookie", "locale=en; _session_id=a3ee3d0df91c8001290da489f8065274; _ga=GA1.2.476924684.1513840501; _gid=GA1.2.612838228.1513840501; __stripe_mid=56fef2a6-0df2-435b-a93f-67661de5beaf; hidden_info_message_55=true; visitor_id=286789c76520b6b7a74111185f180c68595aa91fd27dc54fde77548a7c870b1d; analytics_session_id=e12b82c028c9a3006ece5f62ee9319fe7b21f703f547628e6e8885d848eeea93; __stripe_sid=62783b68-6756-4859-8818-68757c2aa5a4; romref=shr-pica; romref_referer_host=www.indiegogo.com; cohort=www.indiegogo.com%7Cdir-XXXX%7Cshr-pica%7Csch-baid%7Cref-XXXX%7Cshr-pica; has_visited_product_page=true; recent_project_ids=2264760%262200993%262280988");
            headers.set("Host", "www.indiegogo.com");
            headers.set("Origin", "https://www.indiegogo.com");
            headers.set("Referer","https://www.indiegogo.com/explore/tech-innovation?project_type=campaign&project_timing=all&sort=trending");
            headers.set("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.108 Safari/537.36");
            headers.set("X-CSRF-Token", "cjGwpLMszfnw/UtDCNdLrnFCONg+5uxa/U/LG4cQB8QgBl2Dl6F+Uwj3pasqvvneO1HBBTnnEZHsFcOswu/NcA==");
            headers.set("X-Locale", "en");

            Map<String,Object> paramMap = new HashMap();
            paramMap.put("category_main",null);
            paramMap.put("category_top_level","Tech & Innovation");
            paramMap.put("page_num",page_num);
            paramMap.put("per_page",100);
            paramMap.put("project_timing","all");
            paramMap.put("project_type","campaign");
            paramMap.put("sort","trending");
            HttpEntity httpEntity = new HttpEntity(paramMap,headers);
            return restTemplate.postForEntity(url,httpEntity, JSONObject.class).getBody();
        }catch (Exception e){
            return null;
        }

    }
    public static String httpRequest_Get(String url){
        try {
            RestTemplate restTemplate = new RestTemplate();
            //请求头
            HttpHeaders headers = new HttpHeaders();
            headers.set("Accept", "application/json, text/plain, */*");
//        headers.set("Accept-Encoding", "gzip, deflate, br");
            headers.set("Accept-Language", "zh-CN,zh;q=0.9");
            headers.set("Connection", "keep-alive");
            headers.set("Content-Length", "157");
            headers.set("Content-Type", "application/json;charset=UTF-8");
            headers.set("Cookie", "locale=en; _session_id=a3ee3d0df91c8001290da489f8065274; _ga=GA1.2.476924684.1513840501; _gid=GA1.2.612838228.1513840501; __stripe_mid=56fef2a6-0df2-435b-a93f-67661de5beaf; hidden_info_message_55=true; visitor_id=286789c76520b6b7a74111185f180c68595aa91fd27dc54fde77548a7c870b1d; analytics_session_id=e12b82c028c9a3006ece5f62ee9319fe7b21f703f547628e6e8885d848eeea93; __stripe_sid=62783b68-6756-4859-8818-68757c2aa5a4; romref=shr-pica; romref_referer_host=www.indiegogo.com; cohort=www.indiegogo.com%7Cdir-XXXX%7Cshr-pica%7Csch-baid%7Cref-XXXX%7Cshr-pica; has_visited_product_page=true; recent_project_ids=2264760%262200993%262280988");
            headers.set("Host", "www.indiegogo.com");
            headers.set("Origin", "https://www.indiegogo.com");
            headers.set("Referer","https://www.indiegogo.com/explore/tech-innovation?project_type=campaign&project_timing=all&sort=trending");
            headers.set("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.108 Safari/537.36");
            headers.set("X-CSRF-Token", "cjGwpLMszfnw/UtDCNdLrnFCONg+5uxa/U/LG4cQB8QgBl2Dl6F+Uwj3pasqvvneO1HBBTnnEZHsFcOswu/NcA==");
            headers.set("X-Locale", "en");

            HttpEntity httpEntity = new HttpEntity(headers);
            return restTemplate.getForEntity(url,String.class,httpEntity).getBody();
        }catch (Exception e){
            return null;
        }
    }


    public static void main(String args[]){
//        JSONObject result  = httpRequest_Post("https://www.indiegogo.com/private_api/discover",1);
//        System.out.println(result.getJSONObject("response").getJSONArray("discoverables"));
        String string = httpRequest_Get("https://www.indiegogo.com/projects/amabrush-world-s-first-automatic-toothbrush");
        System.out.println(string);//可以抓取数据
    }
}
