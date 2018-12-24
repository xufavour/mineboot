package com.nightstory.mineboot.springserise;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @Author: putao
 * @Date: 2018/12/13
 */
@Component
public class Service {


    @Async("asyncTest")
    public void syns(String josn) throws InterruptedException {
        System.out.println(Thread.currentThread().getId());
    }
}
