package com.nightstory.mineboot.data.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: putao
 * @Date: 2019/1/8
 */
public class QueueMain {
    public static void main(String[] args) {
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(1024);
        for(int i = 0; i< 100; i++){
            queue.offer(i);
        }
//        for(int j = 0; j < 5 ;j ++){
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    int id = queue.element();
//                    System.out.println(id);
//                }
//            }).start();
//        }
        System.out.println(getTaskId());
        System.out.println(getTaskId());
    }

    private static int id = 1;
    public static int getTaskId(){
        final ReentrantLock lock = new ReentrantLock(false);;
        lock.lock();
        try {
            return id++;
        } finally {
            lock.unlock();
        }
    }
}
