package com.nightstory.mineboot.pattern.singleton;

/**
 * @Author: putao
 * @Date: 2019/1/9
 */
public class Singleton {
    private static Singleton ourInstance = new Singleton();

    public static Singleton getInstance() {
        return ourInstance;
    }
    private Singleton() {
    }
}
