package com.nightstory.mineboot.java.base;

/**
 * @Author: putao
 * @Date: 2019/5/9
 */
public final class FinalClass {

    public int filed;

    public FinalClass() {
        filed = 1;
    }


    public void method1(){
        System.out.println("mothed1");
    }


    static class InnerClass{
        static {
            System.out.println("InnerClass init");
        }
        public void method1(){
            System.out.println("InnerClass mothed1");
        }
    }
}
