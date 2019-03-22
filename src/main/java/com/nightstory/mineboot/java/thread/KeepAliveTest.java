package com.nightstory.mineboot.java.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author: putao
 * @Date: 2019/3/20
 */
public class KeepAliveTest {
    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor executorService = new ThreadPoolExecutor(1,3,5,
                TimeUnit.SECONDS,new ArrayBlockingQueue<>(2),new ThreadPoolExecutor.CallerRunsPolicy());
        for(int i= 0; i< 4;i++){
            int finalI = i;
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        if(finalI == 0){
                            Thread.sleep(300000);
                        }else {
                            System.out.println("sleep 1");
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        System.out.println(executorService.getPoolSize() + "," + executorService.getActiveCount() + "," + executorService.getQueue().size());
        Thread.sleep(1000);
        System.out.println(executorService.getPoolSize() + "," + executorService.getActiveCount() + "," + executorService.getQueue().size());
        Thread.sleep(1000);
        System.out.println(executorService.getPoolSize() + "," + executorService.getActiveCount() + "," + executorService.getQueue().size());
        Thread.sleep(1000);
        System.out.println(executorService.getPoolSize() + "," + executorService.getActiveCount() + "," + executorService.getQueue().size());
        Thread.sleep(1000);
        System.out.println(executorService.getPoolSize() + "," + executorService.getActiveCount() + "," + executorService.getQueue().size());
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    System.out.println("后来加的");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread.sleep(1000);
        System.out.println(executorService.getPoolSize() + "," + executorService.getActiveCount() + "," + executorService.getQueue().size());
        Thread.sleep(1000);
        System.out.println(executorService.getPoolSize() + "," + executorService.getActiveCount() + "," + executorService.getQueue().size());
Thread.sleep(1000);
        System.out.println(executorService.getPoolSize() + "," + executorService.getActiveCount() + "," + executorService.getQueue().size());
Thread.sleep(1000);
        System.out.println(executorService.getPoolSize() + "," + executorService.getActiveCount() + "," + executorService.getQueue().size());

Thread.sleep(1000);
        System.out.println(executorService.getPoolSize() + "," + executorService.getActiveCount() + "," + executorService.getQueue().size());

Thread.sleep(1000);
        System.out.println(executorService.getPoolSize() + "," + executorService.getActiveCount() + "," + executorService.getQueue().size());


    }
}
