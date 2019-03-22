package com.nightstory.mineboot.java.collections;

import java.util.*;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Author: putao
 * @Date: 2019/2/27
 */
public class SummaryClass {

    public static void main(String[] args) {

        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        ConcurrentSkipListMap<String,String> concurrentSkipListMap = new ConcurrentSkipListMap<>();
        ConcurrentSkipListSet concurrentSkipListSet = new ConcurrentSkipListSet();


    }

















    public static void unitSet(){
        HashSet<String> hashSet = new HashSet<>();
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        TreeSet<String> treeSet = new TreeSet<>();
    }






    public static void unitList(){
        Vector<String> vector = new Vector<>();
        Stack<String> stack = new Stack<>();
        List<String> list = new ArrayList<>();
        List<String> arrayList = new CopyOnWriteArrayList<>();
        List<String> linkedList = new LinkedList<>();
    }
}
