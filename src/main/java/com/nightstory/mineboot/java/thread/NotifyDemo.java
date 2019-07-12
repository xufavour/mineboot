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
        Object object = new Object();
        synchronized (object){
            object.notifyAll();
        }
    }

}
class ThreadA extends Thread implements Cloneable{
    @Override
    public void run() {
        super.run();
        Object object = new Object();
        synchronized (this){
            System.out.println(Thread.currentThread().getId() + "start" + System.currentTimeMillis());
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getId() + "end" + + System.currentTimeMillis());
        }

    }
}