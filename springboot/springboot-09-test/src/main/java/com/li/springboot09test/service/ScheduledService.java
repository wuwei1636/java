package com.li.springboot09test.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledService {

    // 在特定的时间执行
    // cron 表达式 秒 分 时 日 月 周几
    @Scheduled(cron = "00 09 11 * * ?")
    public void hello(){
        System.out.println("你被执行了");
    }

}
