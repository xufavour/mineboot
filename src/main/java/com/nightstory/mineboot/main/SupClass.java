package com.nightstory.mineboot.main;

/**
 * @Author: putao
 * @Date: 2018/12/22
 */
public class SupClass {
    public static int SIZE_1_MB = 1024 * 1024;
    static {
        System.out.println("SupClass init" + SIZE_1_MB);
    }
}
