package com.nightstory.mineboot.java.collections;

import java.util.*;

/**
 * @Author: putao
 * @Date: 2019/1/30
 */
public class CollectionDemo {
    public static void main(String[] args) {
        LinkedHashMap<Integer,String> linkedHashMap = new LinkedHashMap(16,0.75f,true);
        linkedHashMap.put(1, "item1");
        linkedHashMap.put(2, "item2");
        linkedHashMap.put(3, "item3");
        Set<Map.Entry<Integer, String>> entries = linkedHashMap.entrySet();
        for(Map.Entry<Integer, String> entry : entries){
            System.out.println(entry.getKey());
        }
        linkedHashMap.get(2);
        linkedHashMap.get(1);
        for(Map.Entry<Integer, String> entry : entries){
            System.out.println(entry.getKey());
        }
    }

















    /**
     * Collections类：
     * 1.synchronizedList(Collection c)等方法创建线程安全的集合,对集合进行封装,通过synchronized实现
     *
     */
    public static void collectionTest(){

    }





    /**
     * LinkList实现了List,Deque接口的双端链表,非线程安全
     */
    public static void linkListTest(){
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("item1");
        linkedList.add("item2");
        linkedList.add("item3");
        linkedList.listIterator();
        System.out.println(linkedList.get(5));
        linkedList.clone();
    }



}
