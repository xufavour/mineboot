package com.nightstory.mineboot.java.genericity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenericityMain {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Double> list3 = new ArrayList<>();
        Integer[] array = {1,2,3,4,5};
        swap(array,0,1);
        System.out.println(Arrays.toString(array));
        printList1(list); // ok
        printList2(list); //ok
        printList2(list2); // ok
    }
    public static void printList1(List<String> list){
        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }
    }
    public static void printList2(List<?> list){
        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }
    }

    public static void test(List<? extends Number> list){
        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }
    }

    public static <T> int countGreaterThan(T[] anArray, T elem) {
        int count = 0;
        for (T e : anArray)
            if (e == elem)  // compiler error
                ++count;
        return count;
    }
    /**
     * 交换数组中两个元素
     * @param array
     * @param x
     * @param y
     * @param <T>
     * @return
     */
    public static <T> T[] swap(T[] array,int x,int y){
        if(x > array.length - 1 || y > array.length -1){
            throw new IndexOutOfBoundsException();
        }
        T temp = array[x];
        array[x] = array[y];
        array[y] = temp;
        return array;
    }


}
