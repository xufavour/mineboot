package com.nightstory.mineboot.main;

import com.nightstory.mineboot.pattern.proxy.Axx;
import com.nightstory.mineboot.pattern.proxy.MessageInterface;

/**
 * @Author: putao
 * @Date: 2018/12/22
 */
public class MainTest {

    static {
        System.out.println("MainTest init");
    }

    public static void main(String[] args){
        Class<?>[] interfaces = Axx.class.getInterfaces();
        System.out.println(interfaces[0]);
        System.out.println(MessageInterface.class.getInterfaces().length);
        Class<?> cl = MessageInterface.class;

    }
    public static int[] getTypeArray(String type){
        String[] strArray = type.split(",");
        int[] intArray = new int[strArray.length];
        for(int i = 0; i < strArray.length; i++){
            try{
                intArray[i] = Integer.valueOf(strArray[i]);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return intArray;
    }
}
class TestClass{
    final int a;
    static {
        System.out.println("TestClass init " );

    }
    public TestClass(){
        a = 1;
    }
}