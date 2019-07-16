package com.nightstory.mineboot.algorithm.source;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 *
 * JDK 动态代理方法生成
 * @Author: putao
 * @Date: 2018/7/10
 */
public class ProxyHandler implements InvocationHandler{
    private Object target = null;

    public Object getProxyObject(Object target){
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before");
        System.out.println("调用目标对象的某个方法之前：xxx服务");
        Object obj = method.invoke(target,args); //目的：调用目标方法
        System.out.println("调用目标对象的某个方法之后：xxx服务");
        System.out.println("after");
        return obj;
    }
}
