package cn.geekview.Schedule;

import cn.geekview.service.MailServiceImpl;
import cn.geekview.service.TDreamInProjectServiceImpl;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class ScheduleTask {


    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddhhmmss");

    @Autowired
    private TDreamInProjectServiceImpl inProjectService;

    @Autowired
    private MailServiceImpl mailService;

    //定时任务的注解不能加在有参数的方法上
    /**
     * 定时抓取任务(暂时和其他平台分开，避免冲突)
     */
    @Scheduled(cron = "0 0 15 * * ?")
    public void grapTask() {
        Date dateTime = new DateTime(DateTime.now().getYear(),DateTime.now().getMonthOfYear(),DateTime.now().getDayOfMonth(),12,0,0).toDate();
        String content = "";
        try {
            Integer grapProjects  = inProjectService.grap(dateTime);
            Integer analyProjects = inProjectService.analysis(dateTime);
            String  requestresult = inProjectService.statistic(dateFormat.format(dateTime));
            content = "抓取项目数："+grapProjects +";分析项目数："+analyProjects+";"+requestresult;
        } catch (Exception e) {
            e.printStackTrace();
            content = e.getMessage();
        } finally {
            mailService.sendMail("Indiegogo数据情况",content);
        }

    }

//    @Scheduled(cron = "*/1 * * * * ?")
    public void task1(){
        System.out.println("每过5分钟执行一次");
    }


}
