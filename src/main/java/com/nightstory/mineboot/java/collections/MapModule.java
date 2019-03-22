package com.nightstory.mineboot.java.collections;

import java.util.*;
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
        Map<String,String> linkedHashMap = new LinkedHashMap<>();

        ConcurrentHashMap<String,String> concurrentHashMap = new ConcurrentHashMap();
        concurrentHashMap.get("1");
        System.out.println(hashmap.put("1","2" ));
        ConcurrentSkipListMap concurrentSkipListMap = new ConcurrentSkipListMap();
        TreeMap<String,String> treeMap = new TreeMap<>();
        treeMap.put(null, "1");


    }



}
