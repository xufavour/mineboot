package com.nightstory.mineboot.classload;

import com.nightstory.mineboot.bean.One;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Author: putao
 * @Date: 2019/7/16
 */
public class BootMain {

    public static final String a = One.str;

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(2000);
                return Thread.currentThread().getName();
            }
        };
        FutureTask<String> future = new FutureTask<>(callable);
        Thread thread = new Thread(future);
        thread.start();
        System.out.println(future.get());

    }


    /**
     *
     */
    public static void testClassLoadOrder(){

    }




    /**
     * 虚拟机会保证一个类的<clinit>方法在多线程环境中被正确的加锁,同步
     */
    public static void testDeadLoopClass() throws InterruptedException {
        Runnable script = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getId() + " start");
                DeadLoopClass deadLoopClass = new DeadLoopClass();
                System.out.println(Thread.currentThread().getId() + " end");
            }
        };
        Thread th1 = new Thread(script);
        Thread th2 = new Thread(script);
        th1.start();
        th2.start();
    }
}
