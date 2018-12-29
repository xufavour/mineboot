package com.nightstory.mineboot.java.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: putao
 * @Date: 2018/12/28
 */
public class AtomicMain {
    public static void main(String[] args) {
        AtomicInteger integer = new AtomicInteger(0);
        int a = integer.getAndIncrement();
        System.out.println(integer.get());
        System.out.println(a);
        int x = 1;
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(x);
            }
        }).start();

    }
}
