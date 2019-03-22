package com.nightstory.mineboot.pattern.proxy;

import org.springframework.stereotype.Component;

import java.lang.reflect.Proxy;

/**
 * @Author: putao
 * @Date: 2019/1/9
 */
@Component
public class JdkDynamicProxy {

    public static void main(String[] args) {
        ProxyHelper helper = new ProxyHelper(null);
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        IEXInterface proxy = (IEXInterface) Proxy.newProxyInstance(JdkDynamicProxy.class.getClassLoader(), new Class[]{IEXInterface.class}, helper);
        proxy.content2();
        System.out.println();
    }


}
interface IEXInterface{
    Object content();
    Object content2();
}



