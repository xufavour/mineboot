package com.nightstory.mineboot.java.base;

import java.util.Scanner;

/**
 * @Author: putao
 * @Date: 2019/7/9
 */
public class SubMyObject extends MyObject{


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String next = input.next();
        String next2 = input.nextLine();
        System.out.println(next);
        input.close();
    }

    public void test(){
        printMethod();
        privateMethod();
    }

    private void privateMethod(){
        System.out.println("sun private method");

    }


}
