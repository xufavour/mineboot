package com.nightstory.mineboot.pattern.proxy;

import java.lang.reflect.Proxy;

/**
 * @Author: putao
 * @Date: 2019/1/9
 */
public class JdkDynamicProxy {

    public static void main(String[] args) {
        MessageInterface msg = new Axx();
        ProxyHelper helper = new ProxyHelper(msg);
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        MessageInterface proxy = (MessageInterface) Proxy.newProxyInstance(
                MessageInterface.class.getClassLoader(), msg.getClass().getInterfaces(),helper);
        proxy.content();
        System.out.println(proxy.msgTo());
    }


}




