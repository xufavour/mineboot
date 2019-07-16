package com.nightstory.mineboot.algorithm.network;

/**
 * @Author: putao
 * @Date: 2018/6/14
 */
public class HttpUtils {





    public static void main(String[] args){
        final Business b = new Business();
        new Thread(){
            @Override
            public void run(){
                for(int i=1; i<=50; i++){
                    b.sub(i);
                }
            }
        }.start();


        for(int i=1; i<=50; i++){
            b.main(i);
        }
    }

}

class Business{
    private boolean bShouldSub = true;
    public synchronized void main(int i){
        while(bShouldSub){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for(int j=1; j<=3; j++){
            System.out.println(Thread.currentThread().getName() + ", loop times: " + j + " of " + i);
        }
        bShouldSub = true;
        this.notify();
    }
    public synchronized void sub(int i){
        while(!bShouldSub){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for(int j=1; j<=2; j++){
            System.out.println(Thread.currentThread().getName() + ", loop times: " + j + " of " + i);
        }
        bShouldSub = false;
        this.notify();
    }
}
