package com.nightstory.mineboot.java.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author: putao
 * @Date: 2018/12/12
 */
public class ThreadStatus {

    public static void main(String[] args) {

        ThreadPoolExecutor executor = new ThreadPoolExecutor(1,2,10,
                TimeUnit.SECONDS, new ArrayBlockingQueue<>(5),new ThreadPoolExecutor.DiscardOldestPolicy());
        Thread td = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("i am a thread and id is " + Thread.currentThread().getName());
            }
        });
        td.setName("hhhh");
        td.setPriority(10);

        td.start();


        System.out.println(Thread.currentThread().getThreadGroup() + "..main-----end");

    }

    /**
     * runnableTaskQueue
     */
    public void getTaskQueue(){
        ArrayBlockingQueue<Runnable> blockingQueue = new ArrayBlockingQueue<>(10);
    }

}
