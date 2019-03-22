package com.nightstory.mineboot.java.thread;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.List;
import java.util.concurrent.*;

/**
 * @Author: putao
 * @Date: 2019/3/7
 */
public class ExecutorDemo {
    // Executor
    public static void main(String[] args) throws InterruptedException {
        Executor executor;
        ExecutorService executorService;
        AbstractExecutorService abstractExecutorService;
        ThreadPoolExecutor threadPoolExecutor;
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor;
        ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("pool-%d").build();
        ThreadPoolExecutor threadPoolExecutor1 = new ThreadPoolExecutor(5,10,0,
                TimeUnit.SECONDS,new ArrayBlockingQueue<>(10),threadFactory,new ThreadPoolExecutor.AbortPolicy());
        threadPoolExecutor1.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    System.out.println("end");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });
        Thread.sleep(1000);
        List<Runnable> runnables = threadPoolExecutor1.shutdownNow();
        System.out.println(runnables.size());
//        threadPoolExecutor1.shutdown();
    }
}
