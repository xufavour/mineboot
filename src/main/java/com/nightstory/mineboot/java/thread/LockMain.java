package com.nightstory.mineboot.java.thread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

public class LockMain {
    public static void main(String[] args) throws InterruptedException {
        Thread th = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(2);
                    test();
                    System.out.println("th end");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    test();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }).start();
        System.out.println("th new");
        th.start();
        Thread.State  currentState = th.getState();
        System.out.println("当前状态" + currentState);
        while (true){
            System.out.println(th.getState());
            TimeUnit.SECONDS.sleep(1);
        }
    }

    public static synchronized void test() throws InterruptedException {
    }

    /**
     * 总结：
     * sleep 使线程进入TIMED_WAITING状态,会释放的cpu资源，但不会释放锁
     *
     */

}
