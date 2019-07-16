package com.nightstory.mineboot.algorithm;


import com.nightstory.mineboot.algorithm.edemo.Action;
import com.nightstory.mineboot.algorithm.edemo.People;
import com.nightstory.mineboot.algorithm.source.ProxyHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: putao
 * @Date: 2018/7/6
 */
public class MainTest {
    static int[] array = {};

    public static void main(String[] args) throws InterruptedException {

     List<String> list = new ArrayList<>();
     ProxyHandler proxyHandler = new ProxyHandler();
     List<String> proxyInstance = (List<String>) proxyHandler.getProxyObject(list);

     Action action = (Action) proxyHandler.getProxyObject(new People());
     MainTest test = new MainTest();
     Thread thread = new Thread(test.runnable);
     Thread thread2 = new Thread(test.runnable);
     thread.start();
     thread2.start();
     System.out.println(test.tally);
//     thread.join();
     System.out.println(test.tally);
//     thread2.join();
     System.out.println(test.tally);

    }
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            threadProc();
        }
    };
    int tally = 0;
    private void threadProc(){
        for(int i = 1; i <= 50; i++){
            tally++;
        }
    }
}
