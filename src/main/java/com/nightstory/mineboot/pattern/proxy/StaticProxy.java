package com.nightstory.mineboot.pattern.proxy;
/**
 * @Author: putao
 * @Date: 2019/1/9
 */
public class StaticProxy {

    public static void main(String[] args) {
        MessageInterface a = new Axx();
        MessageInterface proxy = new Proxy(a);
        proxy.content();
        // A将所要做的内容托付给proxy(这个代理的人),proxy依赖于A所提供的具体做的内容(代码中即是A提供的方法)去执行
        // proxy将A的行为sayHello()作为一个(整体)动作,可以对这个动作的前后,结果(不能操作方法中的内容)做一些操作。
        // 1. 隐藏A的具体实现.对于proxy来说接收到的是MessageInterface引用,因此是无法得知A的实现内容,不能修改方法中的内容
        // 2. 可以在不修改A方法内容前提下,添加一些额外操作,方法执行前,执行后,返回后,抛出异常等。
    }

}

class Proxy implements MessageInterface{

    MessageInterface msg;
    public Proxy(MessageInterface msg) {
        this.msg = msg;
    }


    @Override
    public String msgTo() {
        return msg.msgTo();
    }

    @Override
    public void content() {
        System.out.println("msg start:");
        msg.content();
        System.out.println("msg end:");
    }

    @Override
    public String msgFrom() {
        return msg.msgFrom();
    }
}

