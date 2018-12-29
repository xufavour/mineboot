package com.nightstory.mineboot.main;

/**
 * @Author: putao
 * @Date: 2018/12/22
 */
public class MainTest {

    static {
        System.out.println("MainTest init");
    }

    public static void main(String[] args){
        String str = "1,2，3";
        String[] array = str.split(",");
        for(int i : getTypeArray(str)){
            System.out.println(i);
        }
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