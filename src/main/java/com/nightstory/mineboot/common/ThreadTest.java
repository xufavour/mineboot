package com.nightstory.mineboot.common;

import java.util.concurrent.TimeUnit;

/**
 * @Author: putao
 * @Date: 2019/5/7
 */
public class ThreadTest {


    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getId());
        int count = 1000;
        for(int i = 0; i < count; i++){
            int finalI = i;
            ThreadPoolUtil.instance().addTask(new Runnable() {
                @Override
                public void run() {
                    try {
                        TimeUnit.SECONDS.sleep(1);

                        System.out.println("id = " + finalI + " th Id =" + Thread.currentThread().getId());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}
