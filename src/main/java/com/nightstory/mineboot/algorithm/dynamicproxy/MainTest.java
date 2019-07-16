package com.nightstory.mineboot.algorithm.dynamicproxy;

import java.lang.reflect.Proxy;

/**
 * @Author: putao
 * @Date: 2018/7/9
 */
public class MainTest {

    public static void main(String[] args){

        Helloworld hw = new HelloworldIml();
        MyInvocationhandler invocationhandler = new MyInvocationhandler(hw);

        Helloworld proxy = (Helloworld) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),hw.getClass().getInterfaces(),invocationhandler);
        System.out.println(proxy.sayHello());

    }

}

class SupClass{
    public static int value = 123;
    static {
        System.out.println("sup class init");
    }
}

class SubClass extends SupClass{
    static {
        System.out.println("sub class init");
    }

}
