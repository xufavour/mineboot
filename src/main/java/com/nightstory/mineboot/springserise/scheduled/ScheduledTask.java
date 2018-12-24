package com.nightstory.mineboot.springserise.scheduled;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;

/**
 * @Author: putao
 * @Date: 2018/12/11
 */

@Component
public class ScheduledTask {


//
//    @Scheduled(fixedRate = 5000)
//    public void test1() throws InterruptedException {
//        System.out.print(Thread.currentThread().getId());
//        System.out.println("scheduled task 1"  + "   " + new SimpleDateFormat("yyyyMMdd HH:mm:ss").format(System.currentTimeMillis()));
//        TimeUnit.SECONDS.sleep(10);
//    }
//
    @Scheduled(fixedRate = 10000)
    public void test2(){
        System.out.print(Thread.currentThread().getId());
        System.out.println("scheduled task 2"  + "   " + new SimpleDateFormat("yyyyMMdd HH:mm:ss").format(System.currentTimeMillis()));
    }
}
