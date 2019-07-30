package com.nightstory.mineboot.algorithm;

import java.util.PriorityQueue;

/**
 * @Author: putao
 * @Date: 2019/4/19
 */
public class Heap {


    public static void main(String[] args) {
        int[] array = {7,9,16,6,2,4,5,3,10};
        sort(array);
        printArray(array);
        PriorityQueue priorityQueue = new PriorityQueue();
    }


    public static void sort(int[] array){
        if(array == null || array.length < 2){
            return;
        }
        int heapSize = array.length;
        buildMinHeap(array);
        for(int i = 0; i < array.length ; i++){
            swap(array, 0, heapSize-1 );
            heapSize--;
            sink(array, 0,heapSize);
        }

    }



    private static void printArray(int[] arr){
        for(int i = 0; i< arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void buildMinHeap(int[] array){
        int len = array.length;
        int lastNode = len/2 -1;
        for(int i = lastNode; i >= 0; i--){
            sink(array, i,len);
        }
    }

    private static void sink(int[] array, int parentIndex, int len){
        int rightIndex = getRightIndex(parentIndex);
        int leftIndex = getLeftIndex(parentIndex);
        int minIndex = parentIndex;
        if(rightIndex < len){
            minIndex = array[minIndex] > array[rightIndex] ? rightIndex : minIndex;

        }
        if(leftIndex < len){
            minIndex = array[minIndex] > array[leftIndex] ? leftIndex : minIndex;
        }

        if(minIndex != parentIndex){
            swap(array, parentIndex, minIndex);
            sink(array,minIndex,len);
        }
    }

    private static void swap(int[] array,int x, int y){
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }

    private static int getLeftIndex(int parentIndex){
        return parentIndex * 2 + 1;
    }
    private static int getRightIndex(int parentIndex){
        return parentIndex * 2 + 2;
    }
}
