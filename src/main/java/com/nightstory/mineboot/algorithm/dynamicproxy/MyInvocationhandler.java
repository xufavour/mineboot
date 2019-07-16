package com.nightstory.mineboot.algorithm.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author: putao
 * @Date: 2018/7/9
 */
public class MyInvocationhandler implements InvocationHandler{

    private Object target;

    public MyInvocationhandler(Object object){
        target = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("start");
        Object result = method.invoke(target,args);
        System.out.println("end");
        return null;

    }
}
