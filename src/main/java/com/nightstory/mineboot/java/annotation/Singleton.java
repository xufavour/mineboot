package com.nightstory.mineboot.java.annotation;

/**
 * @Author: putao
 * @Date: 2018/12/27
 */
public class Singleton {
    private static Singleton ourInstance = new Singleton();

    public static Singleton getInstance() {
        return ourInstance;
    }

    private Singleton() {
    }
}
