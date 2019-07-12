package com.nightstory.mineboot.java.thread;

import java.util.concurrent.TimeUnit;

public class SynchronizedMain {

    /**
     * 总结：Synchronized 加锁释义：
     * 重点，锁是对象，对象，对象。
     * @param args
     */
    public static void main(String[] args) throws InterruptedException {
        SyncObject object = new SyncObject();
        MyThread th1 = new MyThread(object,1);
        MyThread th2 = new MyThread(object,9);
        th1.start();
        th2.start();
        th1.join(3000);
//        th2.join();

    }

    public synchronized void anotherObjectLock(){
        System.out.println("进入Main对象中方法，拿到锁");
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
class MyThread extends Thread{
    SyncObject object;
    int value;
    public MyThread(SyncObject object,int value){
        this.object = object;
        this.value = value;
    }

    @Override
    public void run() {
        super.run();
        if(value == 1){
            object.setNumX(value);
        }else {
            object.setNumY(value);
        }

//        try {
//            TimeUnit.SECONDS.sleep(1);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        object.setNumY(value);
    }
}
class SyncObject{
    private int numX;
    private int numY;
    public synchronized void setNumX(int value){
        System.out.println("线程" + Thread.currentThread().getId() +"进入XXX方法");
        try {
            TimeUnit.SECONDS.sleep(5);
            SynchronizedMain main = new SynchronizedMain();
            main.anotherObjectLock();
            TimeUnit.SECONDS.sleep(5);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.numX = value;
        System.out.println("线程：" + Thread.currentThread().getId() +"设置numX为" + numX);
//        setNumY(value);
    }

    public synchronized void setNumY(int value){
        System.out.println("线程" + Thread.currentThread().getId() +"进入YYY方法");
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.numY = value;
        System.out.println("线程：" + Thread.currentThread().getId() +"设置numY为" + numY);
    }
}
