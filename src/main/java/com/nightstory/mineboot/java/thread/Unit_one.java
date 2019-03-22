package com.nightstory.mineboot.java.thread;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: putao
 * @Date: 2019/3/6
 */
public class Unit_one {
    public static AtomicInteger integer;
    public static int end = 10000;
    public static void main(String[] args) throws InterruptedException {
        integer = new AtomicInteger(0);
        ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("pool-%d").build();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5,10,0,
                TimeUnit.SECONDS,new ArrayBlockingQueue<>(10),threadFactory,new ThreadPoolExecutor.AbortPolicy());
        final CountDownLatch endGate = new CountDownLatch(3);
        Runnable runable = new Runnable() {
            @Override
            public void run() {
                System.out.println("start:"+Thread.currentThread().getId() + Thread.currentThread().getName() + Thread.currentThread().getThreadGroup().toString());
                int a = 0;
                while ((a = getId()) <= end){
                    System.out.println(Thread.currentThread().getName() + ", id=" + a);
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("end and integer = " + integer.get() + ","+Thread.currentThread().getId() + Thread.currentThread().getName() + Thread.currentThread().getThreadGroup().toString());
                try {
                    endGate.countDown();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        executor.execute(runable);
        executor.execute(runable);
        executor.execute(runable);
        System.out.println(executor.getCorePoolSize());
        Long start = System.currentTimeMillis();
        endGate.await();
        System.out.println("all thread end" + (System.currentTimeMillis() - start));
    }

    public static int getId(){
        return integer.getAndIncrement();
    }

}
