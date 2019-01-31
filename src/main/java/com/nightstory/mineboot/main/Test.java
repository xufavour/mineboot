package com.nightstory.mineboot.main;

/**
 * @Author: putao
 * @Date: 2019/1/28
 */
public class Test {
    public static void main(String[] args)
    {
        testFrame();
    }
    public static void testFrame(){
        People people = new Student();
        people.print();
    }

}
class People{
    private int age = 1;
    public void print(){
        System.out.println(age);
    }

}
class Student extends People{
    private int age = 2;
    @Override
    public void print(){
        super.print();
        System.out.println(age);
    }
}