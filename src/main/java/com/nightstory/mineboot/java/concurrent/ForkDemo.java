package com.nightstory.mineboot.java.concurrent;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * @Author: putao
 * @Date: 2019/2/22
 */
public class ForkDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        MyTask task = new MyTask(0,12);
        ForkJoinTask<Integer> submit = forkJoinPool.submit(task);
        System.out.println("submit");
        forkJoinPool.shutdown();
        System.out.println("shutdown");
        System.out.println(submit.get());
        System.out.println("get");

    }
}
class MyTask extends RecursiveTask<Integer>{

    private int start;
    private int end;

    public MyTask(int start,int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        if(end - start < 5){
            int a = 0;
           for(int i = start; i< end;i++){
               System.out.println(Thread.currentThread().getName() + " print " + i);
               a++;
           }
           return a;
        }else {
            int mid = (start + end)/2;
            MyTask task1 = new MyTask(start,mid);
            MyTask task2= new MyTask(mid,end);
            task1.fork();
            task2.fork();
            return task1.join() + task2.join();
        }
    }
}
