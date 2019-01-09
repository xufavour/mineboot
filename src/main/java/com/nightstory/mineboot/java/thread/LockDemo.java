package com.nightstory.mineboot.java.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: putao
 * @Date: 2019/1/3
 */
public class LockDemo {

    public void simpleUse() throws InterruptedException {
        Lock lock = new ReentrantLock();
        lock.lock();//获取锁
        lock.lockInterruptibly();//获取锁,获取不到则禁止进行线程调度
        try{
          }finally {
            lock.unlock();
        }
    }

}
