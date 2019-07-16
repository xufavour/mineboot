package com.nightstory.mineboot.algorithm.offer.par1;

/**
 * @Author: putao
 * @Date: 2019/5/9
 */
public class TestClass {

    private int value;
    static {
        System.out.println("TestClass static init");
    }

    {
        System.out.println("TestClass init");
    }

    public TestClass() {
        System.out.println("TestClass contron");
        value = 10;
    }

    static class InnerClass{
        static {
            System.out.println("InnerClass static init");
        }
        {
            System.out.println("InnerClass init");
        }
        public InnerClass() {
            System.out.println("InnerClass contron");


        }
        public static void test(){
            System.out.println("test");
        }
    }
}
