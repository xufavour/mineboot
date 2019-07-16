package com.nightstory.mineboot.algorithm.offer;

/**
 * @Author: putao
 * @Date: 2019/5/2
 */
public class HeapSort {

    /**
     * 堆排序：利用完全二叉树特性，使用数组实现最大堆,最小堆。
     * 数组中完全二叉树，第一个非叶子节点的下标：1.数组中元素的个数/2-1 2.（数组最后一个数的下标 - 1）/2.
     * O(nlogn) O(1)
     * @param args
     */
    public static void main(String[] args) {
        int[] array = {7,9,16,6,2,4,5,3,10};
        new HeapSort().heapify(array);
    }


    public void sort(int[] array){
        if(array == null || array.length == 1){
            return;
        }
        printArray(array);
        //堆化
        heapify(array);
        //排序:将堆顶元素与最后一个元素交换,然后数组元素减1进行堆调整.
        int size = array.length;
        for(int i = size; i > 0; i --){
            swap(array, 0, i - 1);
            printArray(array);
            siftDown(0, array[0], array, i - 1);
            printArray(array);
        }
        printArray(array);
    }


    /**
     * 将数组堆化
     * @param array
     */
    public void heapify(int[] array){
        int size = array.length;
        int firstNoLeafNode = size/2 -1;
        for(int i = firstNoLeafNode; i >= 0; i--){
            siftDown(i, array[i],array ,size );
        }

    }


    /**
     * 下沉：用于删除
     * @param index
     * @param value
     * @param array
     * @param size
     */
    public void siftDown(int index,int value,int[] array,int size){
        int half = size/2;
        while (index < half){
            int child = (index << 1) + 1; //左孩子 must not null;
            int tempValue = array[child]; //左孩子值
            int rightIndex = child + 1; //右孩子下标
            if(rightIndex < size && tempValue > array[rightIndex]){
                tempValue = array[child = rightIndex]; //如果有右孩子节点，并且右孩子值比左孩子值小,则将右孩子值赋值给leftValue,右孩子下标赋值给leftIndex
            }
            if(value < tempValue){
                break;
            }
            array[index] = tempValue;
            index = child;
        }
        array[index] = value;
    }



    private static void swap(int[] array,int x, int y){
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }

    private static void printArray(int[] arr){
        for(int i = 0; i< arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

}
