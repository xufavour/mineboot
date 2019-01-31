package com.nightstory.mineboot.java.collections;

import java.util.*;

/**
 * @Author: putao
 * @Date: 2018/12/12
 */
public class MainTest {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        List<String> vector = new Vector<>();
        List<String> linkList = new LinkedList<>();
        linkList.add("1");
        Map<String,String> hashMap = new HashMap<>();
        Map<String,String> treeMap = new TreeMap<>();
        testLinkHashMap();
    }




    private static void testLinkHashMap(){
        LinkedHashMap<String,String> linkedHashMap = new LinkedHashMap<>(10,0.75f,true);
        linkedHashMap.put("1","first");
        linkedHashMap.put("2","second");
        linkedHashMap.put("3","thrid");
        linkedHashMap.put("4","thrid4");
        linkedHashMap.get("1");
        Set<Map.Entry<String, String>> entries = linkedHashMap.entrySet();
        for(Map.Entry<String, String> entry : entries){
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
        Iterator<Map.Entry<String, String>> iterator = entries.iterator();
        while (iterator.hasNext()){
            Map.Entry<String,String> entry = iterator.next();
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }

    }
}
