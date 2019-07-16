package com.nightstory.mineboot.algorithm.dynamicproxy;

/**
 * 内部类实现单例模式 1.懒加载，2.不能防止反射重复构建对象
 * @Author: putao
 * @Date: 2018/7/12
 */
public class Singleton {

    private static class SingleHolder{
        private static final Singleton SINGLETON = new Singleton();
    }

    private Singleton(){

    }

    public static Singleton getIntence(){
        return SingleHolder.SINGLETON;
    }

}
