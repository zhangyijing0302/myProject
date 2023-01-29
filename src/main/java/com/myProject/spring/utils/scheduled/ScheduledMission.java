package com.myProject.spring.utils.scheduled;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
@Configuration      //1.主要用于标记配置类，兼备Component的效果。
@EnableScheduling
public class ScheduledMission {
    //@Scheduled(cron="1/30 * * * * *")//第一秒执行一次，后面每隔30秒执行一次
//    @Scheduled(fixedRate=5000)//每5秒执行一次，不受任务执行时间的影响
//    @Scheduled(fixedDelay=5000)//每5秒执行一次，受任务执行的时间的影响
    //@Scheduled(fixedRate=1800000)
    public void test() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d = new Date();
        String format = simpleDateFormat.format(d);
        System.out.println("定时任务执行时间" + format);
    }
}
