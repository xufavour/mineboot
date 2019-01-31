package com.nightstory.mineboot.java.collections;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * @Author: putao
 * @Date: 2019/1/9
 */
public class MapModule {
    public static void main(String[] args) {
        Map<String,String> hashmap = new HashMap<>(128);
        Map<String,String> hashtable = new Hashtable<>();
        ConcurrentHashMap<String,String> concurrentHashMap = new ConcurrentHashMap();
        System.out.println(hashmap.put("1","2" ));
        ConcurrentSkipListMap concurrentSkipListMap = new ConcurrentSkipListMap();

    }



}
