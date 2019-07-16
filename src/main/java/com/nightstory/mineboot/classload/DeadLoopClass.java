package com.nightstory.mineboot.classload;

/**
 * @Author: putao
 * @Date: 2019/7/16
 */
public class DeadLoopClass {
    static {
        if(true){
            System.out.println(Thread.currentThread().getId() + "init DeadLoopClass");
            while (true){
            }
        }
    }

}
