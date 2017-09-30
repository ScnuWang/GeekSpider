package cn.geekview.controller;

import cn.geekview.service.TDreamInProjectServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.websocket.server.PathParam;
import java.text.SimpleDateFormat;

@Controller
public class HandController {

    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddhhmmss");

    @Autowired
    private TDreamInProjectServiceImpl inProjectService;

    @RequestMapping("/grap")
    @ResponseBody
    public String grap(@PathParam("time") String time){
        if (time==null){
            return "请添加统计时间,时间格式：yyyyMMdd120000";
        }
        try {
            return inProjectService.grap(dateFormat.parse(time)).toString();
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    @RequestMapping("/analysis")
    @ResponseBody
    public String analysis(@PathParam("time") String time){
        if (time==null){
            return "请添加统计时间,时间格式：yyyyMMdd120000";
        }
        try {
            return inProjectService.analysis(dateFormat.parse(time)).toString();
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    @RequestMapping(value = "/statistic",method = RequestMethod.GET)
    @ResponseBody
    public String statistic(@PathParam("time") String time){
        if (time==null){
            return "请添加统计时间,时间格式：yyyyMMdd120000";
        }
        try {
            //校验日期格式
            dateFormat.parse(time);
            return inProjectService.statistic(time).toString();
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }
}
