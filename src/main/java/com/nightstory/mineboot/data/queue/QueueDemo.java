package com.nightstory.mineboot.data.queue;

import java.util.PriorityQueue;
import java.util.concurrent.*;

/**
 * @Author: putao
 * @Date: 2019/1/30
 */
public class QueueDemo {



    public static void main(String[] args) throws InterruptedException, BrokenBarrierException {

        CyclicBarrier barrier = new CyclicBarrier(2, new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread() + ",barrierCommand");
            }
        });
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    barrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        barrier.await();
        System.out.println("end");
        // ArrayBlockingQueue
//        LinkedBlockingQueue
//        QueueDemo instance = QueueDemo.instance();
//        instance.priorityQueueTest();
//        instance.arrayBlockingQueueTest();
//        instance.synchronousQueueTest();

    }
















    /**
     * ArrayBlockingQueue 有限阻塞队列,需指定大小,不能自动扩容,线程安全(使用了ReentrantLock)
     * offer/add(E e) e不能为空 put()添加元素时若队列满了则进入阻塞状态
     * pull()获取队首元素并出列,peek()获取队首元素,队列为空时都返回null,element()调用了peek()但如果获取的队首元素为null时抛出异常.
     *
     */
    public void arrayBlockingQueueTest(){
        ArrayBlockingQueue<Integer> arrayBlockingQueue = new ArrayBlockingQueue<>(10);
        for(int i = 0; i < 20; i++){
            arrayBlockingQueue.offer(i);
        }
        Integer a = arrayBlockingQueue.poll();
        while (a != null){
            System.out.println(a);
            a = arrayBlockingQueue.poll();
        }

    }

    public void linkedBlockingDequeTest(){
        BlockingQueue<Integer> arrayBlockingQueue = new LinkedBlockingDeque<>(1024);
        for(int i = 0; i < 20; i++){
            arrayBlockingQueue.offer(i);
        }
        Integer a = arrayBlockingQueue.poll();
        while (a != null){
            System.out.println(a);
            a = arrayBlockingQueue.poll();
        }

    }


    /**
     * SynchronousQueue 队列没有缓存：即最多有一个元素,进队和出队是对应的.
     * 调用put()方法时如果没出队的操作话会阻塞此线程, 调用take()时如果SynchronousQueue 队列中没有元素时也会阻塞主
     * 调用offer() pull()会立即返回,成功返回ture,否则返回false.
     * @throws InterruptedException
     */
    public void synchronousQueueTest() throws InterruptedException {
        final SynchronousQueue<Integer> queue = new SynchronousQueue<Integer>();

        Thread putThread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("put thread start");
                try {
                    queue.put(1);
                } catch (InterruptedException e) {
                }
                System.out.println("put thread end");
            }
        });

        Thread takeThread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("take thread start");
                try {
                    System.out.println("take from putThread: " + queue.poll());
                } catch (Exception e){

                }
                System.out.println("take thread end");
            }
        });


        takeThread.start();
        Thread.sleep(1000);
        putThread.start();
    }









    /**
     * PriorityQueue 优先队列,最小堆结构,内存数组存储,初始容量11,可扩容,非线程安全,PriorityBlockingQueue线程安全
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
