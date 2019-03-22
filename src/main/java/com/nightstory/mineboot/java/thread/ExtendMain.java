package com.nightstory.mineboot.java.thread;

import java.util.concurrent.locks.ReentrantLock;

public class ExtendMain {

    public static ReentrantLock lock;
    public static Thread th1;
    public static Thread th2;
    public static void main(String[] args) throws InterruptedException {
        lock = new ReentrantLock();

         th1 = new Thread(() -> {
            test();
        });
         th2 = new Thread(() -> {
            test();
        });
        th1.setName("th1");
        th2.setName("th2");
        th1.start();
        th2.start();
        Thread.sleep(1000);
        System.out.println("th1:" + th1.getState() + ",th2:" + th2.getState());
    }

    public synchronized static void test(){
        lock.lock();
        try {
            try {
                System.out.println("current Thread:" + Thread.currentThread().getName());
                System.out.println("th1:" + th1.getState() + ",th2:" + th2.getState());
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }finally {
            lock.unlock();
        }
    }
}
