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


        //1）每个节点或者是黑色，或者是红色。
        //（2）根节点是黑色。
        //（3）每个叶子节点（NIL）是黑色。 [注意：这里叶子节点，是指为空(NIL或NULL)的叶子节点！]
        //（4）如果一个节点是红色的，则它的子节点必须是黑色的。
        //（5）从一个节点到该节点的子孙节点的所有路径上包含相同数目的黑节点。
        Set<String> treeSet = new TreeSet<>();
    }
}
