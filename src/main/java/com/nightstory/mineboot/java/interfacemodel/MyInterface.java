package com.nightstory.mineboot.java.interfacemodel;

/**
 * @Author: putao
 * @Date: 2019/4/10
 */
public interface MyInterface {
    /**
     * 变量:默认都是public static final类型的常量
     */
    int variableA = 0;

    /**
     * 方法: 默认都是 public abstract
     * 没有非静态方法实现，也就是说要么是抽象方法，要么是静态方法
     */
    void methodA();

    static void methodB(){
        System.out.println("static method");
    }
    /**
     * java8后新特性:default(不是访问权限的default)修饰方法只能在接口中使用,等同于普通方法,实现的类都拥有这个方法
     * 如果一个类同时实现接口A和B，接口A和B中有相同的default方法，这时，该类必须重写接口中的default方法
     */
    default void defaultMethod(){
        System.out.println("interface default method");
    }



}
