package com.nightstory.mineboot.springserise.controller;

import com.nightstory.mineboot.springserise.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: putao
 * @Date: 2018/12/12
 */
@RestController
public class WebController {


    @Autowired
    Service service;

    private String LOG_TAG = "WebController";

    @RequestMapping(value = "test",method = RequestMethod.POST)
    public boolean test(String json){
        try {
            System.out.println(Thread.currentThread().getId());
        }catch (Exception e){

        }
        return true;
    }

    @RequestMapping(value = "test2",method = RequestMethod.GET)
    public String get(){
        System.out.println(Thread.currentThread().getId());
        System.out.println(Thread.currentThread().getThreadGroup());
        System.out.println(Thread.currentThread().getPriority());
        return "hhh";
    }
    @RequestMapping(value = "data/id",method = RequestMethod.GET)
    public String print(int id) throws InterruptedException {
        if(id == 1){
            Thread.sleep(2000);
        }
        System.out.println(id);
        return "hhh";
    }
}
