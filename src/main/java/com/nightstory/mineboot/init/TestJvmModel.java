package com.nightstory.mineboot.init;

import com.nightstory.mineboot.bean.Student;

import java.util.EventListener;

/**
 * @Author: putao
 * @Date: 2019/7/12
 */
public final class TestJvmModel implements EventListener{

    public int m = 1;
    public static int sm = 2;
    public final int fm = 3;
    public static final int sfm = 4;

    private String str = "hello";
    public static String sStr = "static hello";
    public final String fStr = "final hello";
    public static String sempty;
    public static final String sfStr = "aastatic final hello";

    public final Student student = new Student("1","ls");
    public void testMethod(){
        int x = 0;
        System.out.println(x);
    }

    private String testa = "a";
    public static void main(String[] args) {
        String a = "a";
        System.out.println();
    }
}
