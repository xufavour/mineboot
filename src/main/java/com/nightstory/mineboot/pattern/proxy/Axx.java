package com.nightstory.mineboot.pattern.proxy;

public class Axx implements MessageInterface{


    @Override
    public String msgTo() {
        return "B";
    }

    @Override
    public void content() {
        System.out.println("hello, i am A");
    }

    @Override
    public String msgFrom() {
        return "A";
    }
}