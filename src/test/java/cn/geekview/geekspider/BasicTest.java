package cn.geekview.geekspider;

import cn.geekview.util.CommonUtil;
import org.joda.time.DateTime;
import org.junit.Test;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BasicTest {
        @Test
        public void test(){
            String date = "2017-12-29T23:59:59-08:00".split("T")[0];
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            try {
                Date d = dateFormat.parse(date);
                System.out.println(d);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

    @Test
    public void test2() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddhhmmss");
        Date dateTime = new DateTime(DateTime.now().getYear(),DateTime.now().getMonthOfYear(),DateTime.now().getDayOfMonth(),12,0,0).toDate();
        System.out.println(dateFormat.format(dateTime));
    }
}
