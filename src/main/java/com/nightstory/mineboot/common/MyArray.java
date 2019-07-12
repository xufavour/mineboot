package com.nightstory.mineboot.common;

/**
 * @Author: putao
 * @Date: 2019/3/6
 */
public class MyArray {


    public static void main(String[] args) {
       P.terst();
       C.terst();
    }
}
class P{
    public static void terst(){
        System.out.println("p static");
    }
}
class C extends P{
//    public static void terst(){
//        System.out.println("C static");
//    }
}