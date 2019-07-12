package com.nightstory.mineboot.java.base;

/**
 * @Author: putao
 * @Date: 2019/1/2
 */
public class MyObject {

    private int a = 9;

    public int printMethod(){
        System.out.println(a);
        privateMethod();
        return 1;
    }

    private void privateMethod(){
        System.out.println("father private method");
    }

    private final void finalMethod(){
        System.out.println("father final method");
    }
}
