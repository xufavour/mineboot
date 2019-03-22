package com.nightstory.mineboot.java.concurrent.collection;

import java.util.concurrent.*;

/**
 * @Author: putao
 * @Date: 2019/3/11
 */
public class ConcurrentList {

    public static void main(String[] args) throws InterruptedException {
        SynchronousQueue<String> synchronousQueue = new SynchronousQueue<>();
    }

    private void map(){
        ConcurrentHashMap<String,String> concurrentHashMap = new ConcurrentHashMap<>();
        ConcurrentSkipListMap<String,String> concurrentSkipListMap = new ConcurrentSkipListMap<>();
        ConcurrentSkipListSet<String> concurrentSkipListSet = new ConcurrentSkipListSet<>();
    }
    private void queue(){
        ArrayBlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<String>(1024);
        LinkedBlockingQueue<String> linkedBlockingQueue = new LinkedBlockingQueue<>();
        LinkedBlockingDeque<String> linkedBlockingDeque = new LinkedBlockingDeque<>();
        SynchronousQueue<String> synchronousQueue = new SynchronousQueue<>();
        LinkedTransferQueue<String> linkedTransferQueue = new LinkedTransferQueue<>();

        PriorityBlockingQueue<String> priorityBlockingQueue = new PriorityBlockingQueue<>();
    }

}
