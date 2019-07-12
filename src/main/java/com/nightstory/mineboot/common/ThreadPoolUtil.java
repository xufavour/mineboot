package com.nightstory.mineboot.common;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author: putao
 * @Date: 2018/11/28
 */
public class ThreadPoolUtil {
    public ExecutorService executorService;


    private ThreadPoolUtil(){
        executorService = new ThreadPoolExecutor(3,3,3 * 60,
                TimeUnit.SECONDS,new ArrayBlockingQueue<>(5),new ThreadPoolExecutor.CallerRunsPolicy());
    }

    public static ThreadPoolUtil instance(){
        return SingleHolder.SINGLETON;
    }

    public void addTask(Runnable runnable){
        executorService.execute(runnable);
    }


    private static class SingleHolder{
        private static final ThreadPoolUtil SINGLETON = new ThreadPoolUtil();
    }
}
