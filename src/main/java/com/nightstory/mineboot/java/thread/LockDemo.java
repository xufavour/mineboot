package com.nightstory.mineboot.java.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: putao
 * @Date: 2019/1/3
 */
public class LockDemo {

    public void simpleUse() throws InterruptedException {
        Lock lock = new ReentrantLock();
        new Thread(() -> {
            try {
                doSometing1(lock);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                doSometing2(lock);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    public static void doSometing1(Lock lock) throws InterruptedException {
        lock.lock();
        try {
            System.out.println("doSometing1 start");
            Thread.sleep(3000);
            System.out.println("doSometing1 end");

        }finally {
            lock.unlock();
        }
    }
    public static void doSometing2(Lock lock) throws InterruptedException {
        lock.lock();
        try {
            System.out.println("doSometing2 start");
            Thread.sleep(3000);
            System.out.println("doSometing2 end");
        }finally {
            lock.unlock();
        }
    }



}
