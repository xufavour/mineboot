package com.nightstory.mineboot.java.thread;


import com.nightstory.mineboot.common.ThreadPoolUtil;

import java.util.concurrent.*;

/**
 * @Author: putao
 * @Date: 2019/2/18
 */
public class ThreadFuture {


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletionService<String> completionService = new ExecutorCompletionService<String>(
                ThreadPoolUtil.instance().executorService);
        Callable<String> callable = () -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName());
            return "耗时2s,任务完成返回:" + Thread.currentThread().getName();
        };
        Callable<String> callable2 = () -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName());
            return "耗时2s,任务完成返回:" + Thread.currentThread().getName();
        };
        FutureTask<String> futureTask = new FutureTask<String>(callable);
        System.out.println("start：");
        completionService.submit(callable);
        completionService.submit(callable2);
        System.out.println(completionService.take().get());
        System.out.println(completionService.take().get());
        System.out.println("end；");

    }

    private static void test(String name){
        int a = 8;
        name = "hello";
        System.out.println("hello world" + name);
    }
}
