package com.nightstory.mineboot.bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import javax.annotation.PostConstruct;

/**
 * @Author: putao
 * @Date: 2019/2/15
 */
@Configuration
@Lazy
public class PeopleBean {

    public PeopleBean() {
        System.out.println("PeopleBean construct");
    }

    @PostConstruct
    public void testtest(){
        System.out.println("testtest");
    }
//    // @Bean注解注册bean,同时可以指定初始化和销毁方法
//    @Bean
//    @Scope("prototype")
//    public Student testBean() {
//        return new Student("1","hhhhh");
//    }
}
