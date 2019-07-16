package com.nightstory.mineboot.bean;

import com.nightstory.mineboot.common.Two;

public class One {

    public static final String str = "one";
    static {
        System.out.println("class One init" );
    }
    public One(){
        System.out.println("class One Constrctor");
    }
    public One(String name){
        System.out.println("class One Constrctor name:" + name);
    }


    public static void parStaticMethod(){
        System.out.println("One parStaticMethod");
    }

    public void OneMethod(){
        System.out.println("one method");
        protectedprintA();
    }

    public static void staticMethod(){
        System.out.println("One staticMethod");
    }

    protected int a = 1;
    protected static int staA = 1;
    public static int staB = 1;
    protected One protectedprintA() {
        System.out.println("父类printA");
        return new Two(1);
    }


}
