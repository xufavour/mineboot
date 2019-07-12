package com.nightstory.mineboot.java.collections;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @Author: putao
 * @Date: 2019/1/9
 */
public class MapModule {
    public static void main(String[] args) {
//        Map<String,String> hashmap = new HashMap<>(128);
//        Map<String,String> hashtable = new Hashtable<>();
//        Map<String,String> linkedHashMap = new LinkedHashMap<>();
//
//        ConcurrentHashMap<String,String> concurrentHashMap = new ConcurrentHashMap();
//        concurrentHashMap.get("1");
//        System.out.println(hashmap.put("1","2" ));
//        ConcurrentSkipListMap concurrentSkipListMap = new ConcurrentSkipListMap();
//        List<String> list = new ArrayList<>();
//        list.add("1");
//        list.add("2");
//        list.add("3");
//        Iterator<String> iterator = list.iterator();
//        iterator.next();
//        iterator.remove();
//        System.out.println(list.get(0));
//        TreeMap<Integer,String> treeMap = new TreeMap<>();
//        treeMap.put(3, "3");
//        treeMap.put(1, "1");
//        treeMap.put(2, "2");
//        Set<Map.Entry<Integer, String>> entries = treeMap.entrySet();
//        Iterator<Map.Entry<Integer, String>> iterator = entries.iterator();
//        Map.Entry<Integer, String> next = iterator.next();
//        System.out.println(next.getKey());
//        Set<Map.Entry<Integer, String>> entries2 = treeMap.entrySet();
//        entries2.iterator();
//
//        Set<Integer> set = treeMap.keySet();
//        System.out.println(treeMap.firstEntry());
//        for(int i : set){
//            System.out.println(i);
//        }

        test();
    }


    private static void test(){
        List<Integer> list = Lists.newArrayList();
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(2);
        list.add(2);
        for(int i=0;i<list.size();i++){
            if(list.get(i)==2){
                list.remove(i);
            }
        }
        System.out.println(list.size());
    }

}
