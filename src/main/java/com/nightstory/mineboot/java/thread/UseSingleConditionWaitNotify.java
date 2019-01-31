package com.nightstory.mineboot.java.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: putao
 * @Date: 2019/1/30
 */
public class UseSingleConditionWaitNotify {


    public static void main(String[] args) throws InterruptedException {
        MyService myService = new MyService();
        ThreadA a = new ThreadA(myService);
        a.start();
        Thread.sleep(1000);

        myService.signal();
    }

    /**
     * Thread.sleep不释放锁
     * Thread.yield 将cpu的资源让出，使得当前进程从运行状态转成就绪状态，和其他就绪状态的线程一起抢cpu的资源，所以存在再次进入运行状态的情况
     * object.wait会使当前进程阻塞,会释放锁
     *
     */
    static public class MyService{
        private Lock lock = new ReentrantLock();
        public Condition condition = lock.newCondition();

        public void await(){
            lock.lock();
            try {
                System.out.println("await时间为:" + System.currentTimeMillis());
                Thread.sleep(3000);
//                condition.await();
                System.out.println("这是condition.await()方法之后的语句，condition.signal()方法之后我才被执行");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        public void signal() throws InterruptedException {
//            lock.lock();
            try {
                System.out.println("signal时间为:" + System.currentTimeMillis());
//                condition.signal();
                Thread.sleep(3000);
                System.out.println("这是condition.signal()方法之后的语句");
            }finally {
//                lock.unlock();
            }
        }
    }
    static class ThreadA extends Thread{
        MyService myService;
        public ThreadA(MyService service) {
            this.myService = service;
        }

        @Override
        public void run() {
            super.run();
            myService.await();
        }
    }
}
