package com.nightstory.mineboot.pattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author: putao
 * @Date: 2019/1/9
 */
public class ProxyHelper implements InvocationHandler{

    private Object object;

    public ProxyHelper(Object obj){
        this.object = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before : " + proxy.getClass());
        Object result = method.invoke(object, args);
        System.out.println("after");
        return result;
    }
}
