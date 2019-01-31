package com.nightstory.mineboot.java.thread;

import java.util.concurrent.TimeUnit;

/**
 * @Author: putao
 * @Date: 2019/1/31
 */
public class NotifyDemo {
    public static void main(String[] args) throws InterruptedException {
        ThreadA a = new ThreadA();
        a.start();
        TimeUnit.SECONDS.sleep(3);
        synchronized (a){
            a.notify();
        }
    }



}
class ThreadA extends Thread{
    @Override
    public void run() {
        super.run();
        synchronized (this){
            System.out.println(Thread.currentThread().getId() + "start" + System.currentTimeMillis());
            try {
                Object object = new Object();
                object.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getId() + "end" + + System.currentTimeMillis());
        }

    }
}