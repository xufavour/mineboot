package com.nightstory.mineboot.java.thread;

/**
 * @Author: putao
 * @Date: 2019/1/18
 */
public class NotifyWriteDemo {


    public static void main(String[] args) throws Exception{
        Object lock = new Object();
        new Thread(new Runnable() {
            @Override
            public void run() {
                test(lock);
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                test2(lock);
            }
        }).start();
    }

    public synchronized static void test(Object lock)   {

            System.out.println("start");
            try {
//                lock.wait();
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("end");

    }
    public synchronized static void test2(Object lock)   {
            System.out.println("start2");
            try {
//                lock.notify();
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("end2");
        }

}

