package com.nightstory.mineboot.java.annotation;

/**
 * @Author: putao
 * @Date: 2019/6/25
 */
public abstract class MyAbstract {

    public static String staticStr = "str";
    int x = 1;

    static {
        System.out.println(staticStr);
    }

    {
        System.out.println("common init");
    }
    public MyAbstract() {
        System.out.println("contruction MyAbstract");
    }

    public void test(){
        System.out.println(staticStr);
    }

    public static void test2(){
        System.out.println(staticStr);
    }
}
