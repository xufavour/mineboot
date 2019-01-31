package com.nightstory.mineboot.data.queue;

import java.util.PriorityQueue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * @Author: putao
 * @Date: 2019/1/30
 */
public class QueueDemo {

    public static void main(String[] args) {
        QueueDemo instance = QueueDemo.instance();
        instance.priorityQueueTest();

    }

    /**
     *
     */
    public void allImplementClass(){
        ArrayBlockingQueue<Integer> arrayBlockingQueue = new ArrayBlockingQueue<>(16);
        PriorityBlockingQueue<Integer> blockingQueue = new PriorityBlockingQueue<>(16);
        for(int i =0; i< 20; i++){
            blockingQueue.put(i);
        }
        System.out.println(arrayBlockingQueue.element());
    }






    /**
     * PriorityQueue 优先队列,最小堆结构,内存数组存储,初始容量11,可扩容,非线程安全,
     * add/offer添加元素, pull返回队列头部(优先级最高)的元素,空队列返回null,remove()空队列抛出异常
     * 元素不可为null,需要继承Comparator或自定义传入Comparator
     * 时间复杂度：offer:O(logn) remove(Object o)/contain:O(n) pull/remove():O(1)
     *
     */
    private void priorityQueueTest(){
        PriorityBlockingQueue<Integer> prioryQueue = new PriorityBlockingQueue<>();
        for(int i = 10; i >= 5; i--){
            prioryQueue.offer(i);
        }
        System.out.println("队列size:" + prioryQueue.size());
        for(int j = 0; j < 9; j++){
            System.out.println(prioryQueue.poll());
        }
        prioryQueue.remove(1);
        System.out.println("队列剩余size:" + prioryQueue.size());
    }

    /**
     * PriorityBlockingQueue : PriorityQueue的并发同步实现
     * 使用了独占锁,
     * offer pull size 等方法都加了锁
     * take()获取队列头部元素,队列为空则阻塞。
     * offer添加元素扩容时,使用了先释放锁，然后通过cas保证同时只有一个线程可以扩容成功
     */
    private void priorityBlockQueueTest(){
        PriorityQueue<Integer> prioryQueue = new PriorityQueue<>();
        for(int i = 10; i >= 5; i--){
            prioryQueue.offer(i);
        }
        System.out.println("队列size:" + prioryQueue.size());
        for(int j = 0; j < 9; j++){
            System.out.println(prioryQueue.poll());
        }
        prioryQueue.remove(1);
        System.out.println("队列剩余size:" + prioryQueue.size());
    }




    public static QueueDemo instance(){
        return new QueueDemo();
    }
}
