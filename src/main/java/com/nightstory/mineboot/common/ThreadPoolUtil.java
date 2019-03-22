package com.nightstory.mineboot.common;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: putao
 * @Date: 2018/11/28
 */
public class ThreadPoolUtil {
    public ExecutorService executorService;


    private ThreadPoolUtil(){
        executorService = Executors.newCachedThreadPool();
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
