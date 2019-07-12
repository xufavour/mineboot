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
        System.out.println("before : " + method.getDeclaringClass());
        System.out.println(Object.class.equals(method.getDeclaringClass()));
        System.out.println(method.getModifiers());
//        System.out.println("before : " + proxy.getClass().getInterfaces()[0]);
//        System.out.println("before : " + method.getName());
//        System.out.println("before : " + method.getParameterCount());
        if(args != null){
            System.out.println("args:");
            for(Object arg : args){
                System.out.println(arg.getClass() + "name:" + arg +" value:" + arg);
            }
        }
        Class result = method.getReturnType();
        System.out.println(result);
        System.out.println("after");
        return "test";
    }
}
