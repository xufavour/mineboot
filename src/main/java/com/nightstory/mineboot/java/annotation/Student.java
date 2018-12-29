package com.nightstory.mineboot.java.annotation;

import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: putao
 * @Date: 2018/12/27
 */
@RestController
@CacheHandle
public class Student implements InterfaceType{
    @CacheHandle
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
