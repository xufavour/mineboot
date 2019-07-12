package com.nightstory.mineboot.java.collections;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.*;

/**
 * @Author: putao
 * @Date: 2018/12/12
 */
public class MainTest {

    public static void main(String[] args) {
//        List<String> list = new ArrayList<>();
//        List<String> vector = new Vector<>();
//        List<String> linkList = new LinkedList<>();
//        linkList.add("1");
//        Map<String,String> hashMap = new HashMap<>();
//        Map<String,String> treeMap = new TreeMap<>();
        testLinkHashMap();
    }


    public static String streamToString(InputStream is) {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = is.read(buffer)) != -1) {
                baos.write(buffer, 0, len);
            }
            baos.close();
            is.close();
            byte[] byteArray = baos.toByteArray();
            return new String(byteArray);
        } catch (Exception e) {
            return null;
        }
    }

    private static void testLinkHashMap(){
        LinkedHashMap<String,String> linkedHashMap = new LinkedHashMap<>(10);
        linkedHashMap.put("10","first");
        linkedHashMap.put("2","second");
        linkedHashMap.put("30","thrid");
        linkedHashMap.put("4","thrid4");
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
