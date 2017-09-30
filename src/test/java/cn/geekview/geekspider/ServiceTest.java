package cn.geekview.geekspider;

import cn.geekview.mapper.TDreamInAnalysisMapper;
import cn.geekview.service.MailServiceImpl;
import cn.geekview.service.TDreamInProjectServiceImpl;
import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ServiceTest {

    @Autowired
    private TDreamInProjectServiceImpl inProjectService;

    @Autowired
    private TDreamInAnalysisMapper inAnalysisMapper;

    @Autowired
    private MailServiceImpl mailService;


    @Test
    public void test2() throws Exception {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddhhmmss");
        DateTime now = DateTime.now();
        Date dateTime = new DateTime(now.getYear(),now.getMonthOfYear(),now.getDayOfMonth(),12,0,0).toDate();

//        inProjectService.grap(dateTime);
//        inProjectService.analysis(dateTime);
//        inProjectService.statistic(dateFormat.format(dateTime));
    }

    @Test
    public void mailtest(){
//        mailService.sendMail("测试邮件功能","邮件发送");
    }
}
