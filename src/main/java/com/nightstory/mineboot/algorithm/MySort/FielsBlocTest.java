package com.nightstory.mineboot.algorithm.MySort;

class B {
    B() {
        System.out.println("非静态字段");
    }
}

class A {
    private B b = new B();
    {
        System.out.println("A初始化代码块");
    }
    {
        System.out.println("A静态初始化代码块");
    }
 
    A() {
        System.out.println("A类构造器");
    }
}

public class FielsBlocTest {
//    private static A a = new A();
    static {
        System.out.println("FielsBlocTest类的静态代码块");
    }
 
    public static void main(String[] args) {
        System.out.println("main方法");
 
    }
 
}