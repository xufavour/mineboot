package com.nightstory.mineboot.java.collections;

import java.util.*;

/**
 * @Author: putao
 * @Date: 2019/1/9
 */
public class SetModule {

    public static void main(String[] args) {
        //HashSet 内部使用hashmap的key来存储值.因此确定,互异,即没有重复数据,通过hash确定在数组的位置,因此无序性.
        //LinkedHashSet 继承HashSet,只是使用了LinkHashmap的结构,因此有序性。
        Set<String> hashSet = new HashSet<>();
        Set<String> linkedHashSet = new LinkedHashSet<>();

        Set<String> treeSet = new TreeSet<>();
    }
}
