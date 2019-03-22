package com.nightstory.mineboot.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: putao
 * @Date: 2019/2/21
 */
public class RedisDemo {


    static List<Integer> integerArrayList=new ArrayList<Integer>();
    ArrayList<String> stringArrayList =new ArrayList<>();
    Map<String,String> map = new HashMap<>();
    public static void main(String[] args) throws Exception {
        List<Integer> integerArrayList2 =new ArrayList<Integer>();
        ArrayList<String> stringArrayList2 =new ArrayList<>();
        integerArrayList2.add(1);
        integerArrayList.add(1);
        stringArrayList2.add("str");
        RedisDemo demo = new RedisDemo();
        demo.test();
        System.out.println(integerArrayList.getClass());
        System.out.println(integerArrayList2.getClass());

    }

    private void test(){
        map.put("key", "value");

    }

}
