package com.nightstory.mineboot.algorithm.source;

/**
 * @Author: putao
 * @Date: 2018/7/10
 */


class People{
    public People(){
        System.out.println("People contruc");
    }
    static {
        System.out.println("people static block");
    }
    public void eat(){
        System.out.println("people eat");
    }
    int age = 20;

}

class Student extends People
{
    public Student(){
        System.out.println("Student contruc");
    }
    static {
        System.out.println("Student static block");
    }
    public void eat(){
        System.out.println("Student eat");
    }
    String name = "Mary";
    int age = 18;
}


public class TestObject {

    public static void main(String[] args) {
        People people = new Student();
        people.eat();
        System.out.println("TestObject.main");
    }



    private static class LayHolder{
        static {
            System.out.println("LayHolder.static initializer");
        }
        public static final int a = 3;
    }
}
