package com.nightstory.mineboot.algorithm.edemo;

/**
 * @Author: putao
 * @Date: 2018/6/28
 */
public class People implements Action{
    @Override
    public void eat() {
        System.out.println("eat");
    }

    @Override
    public void sleep() {
        System.out.println("sleep");

    }
}
