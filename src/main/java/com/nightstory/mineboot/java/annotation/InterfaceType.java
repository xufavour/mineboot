package com.nightstory.mineboot.java.annotation;

/**
 * @Author: putao
 * @Date: 2018/12/27
 */
public interface InterfaceType {
    public static final int a = 0;
    default void print(){
        System.out.println("我是一辆车!");
    }
}
