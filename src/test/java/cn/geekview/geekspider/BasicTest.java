package cn.geekview.geekspider;

import cn.geekview.util.CommonUtil;
import org.joda.time.DateTime;
import org.junit.Test;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BasicTest {
        @Test
        public void test(){
            System.out.println(new BigDecimal(CommonUtil.getNumber("")));
            int pa_num = 1;
            String url = "https://www.baidu.com";
            while (true){
                String requrl = url + pa_num;
                System.out.println(requrl);
                if(pa_num>5) break;
                pa_num ++;
            }
        }

    @Test
    public void test2() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddhhmmss");
        Date dateTime = new DateTime(DateTime.now().getYear(),DateTime.now().getMonthOfYear(),DateTime.now().getDayOfMonth(),12,0,0).toDate();
        System.out.println(dateFormat.format(dateTime));
    }
}
