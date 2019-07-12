package com.nightstory.mineboot.pattern.singleton;

/**
 * @Author: putao
 * @Date: 2019/4/1
 */
public class SingleStatic {

    private SingleStatic instance;

    static {
        System.out.println("static init ");
    }
    private SingleStatic(){
        System.out.println("construction method");
    }

    public static SingleStatic getInstance(){
        return SingleHolder.SINGLETON;
    }

    public static void test(){
        System.out.println("static method");
    }

    private static class SingleHolder{
        static {
            System.out.println("SingleHolder static init ");
        }
        private static final SingleStatic SINGLETON = new SingleStatic();
    }
}
