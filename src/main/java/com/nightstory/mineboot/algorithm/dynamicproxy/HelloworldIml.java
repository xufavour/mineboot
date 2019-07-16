package com.nightstory.mineboot.algorithm.dynamicproxy;

/**
 * @Author: putao
 * @Date: 2018/7/9
 */
public class HelloworldIml implements Helloworld{
    @Override
    public String sayHello() {
        System.out.println("Hello world!");
        return "hello";
    }
}
