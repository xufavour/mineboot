package com.nightstory.mineboot.algorithm.offer.par1;

/**
 * @Author: putao
 * @Date: 2019/2/13
 */
public class quick {
    public static void main(String[] args) {

        int[] array = {15,36,72,44,45,72,19,35,14,26,};
        quickSort(array);
        System.out.print("sort array:");
        for(int i =0; i < 10;i++){
            System.out.print(array[i] + ",");
        }
    }

    public static void quickSort(int[] array){
        if(array == null || array.length == 0){
            return;
        }
        qSort2(array, 0, array.length - 1);
    }

    /**
     * 1. 以第一个数为基准
     * @param array
     * @param leftIndex
     * @param rightIndex
     */
    private static void qSort(int[] array,int leftIndex,int rightIndex){
        if(leftIndex >= rightIndex) return;
        int midIndex = getMidIndex(array, leftIndex, rightIndex);
        printArray(array);
        qSort(array,leftIndex,midIndex - 1);
        qSort(array,midIndex+1,rightIndex);
    }

    private static int getMidIndex(int[] array,int leftIndex,int rightIndex){
        int mid = array[leftIndex];
        while (leftIndex < rightIndex){
            while (leftIndex < rightIndex && array[rightIndex] >= mid){
                rightIndex --;
            }
            array[leftIndex] = array[rightIndex];
            while (leftIndex < rightIndex && array[leftIndex] <= mid){
                leftIndex ++;
            }
            array[rightIndex] =  array[leftIndex];
        }
        array[rightIndex] = mid;
        return leftIndex;
    }

    private static void qSort2(int[] array,int leftIndex,int rightIndex){
        if(leftIndex >= rightIndex) return;
        int mid = getProvit(array, leftIndex, rightIndex);
        System.out.println("mid =" + mid);
        qSort2(array,leftIndex,mid - 1);
        qSort2(array,mid + 1,rightIndex);

    }

    private static int getProvit(int[] array,int leftIndex,int rightIndex){
        int mid = array[leftIndex];
        int l = leftIndex;
        while (leftIndex < rightIndex){
            while (leftIndex < rightIndex && array[rightIndex] >= mid){
                rightIndex --;
            }
            while (leftIndex < rightIndex && array[leftIndex] <= mid){
                leftIndex ++;
            }
            if(leftIndex < rightIndex){
                swap(array, leftIndex, rightIndex);
            }
        }
        swap(array, l,leftIndex );
        return leftIndex;
    }


    private static void swap(int[] array,int x,int y){
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }

    private static int[] getRandomArray(){
        int[] array = new int[10];
        System.out.print("src array: ");
        for(int i =0; i < 10;i++){
            array[i] =(int) (Math.random() * 100);
            System.out.print(array[i] + ",");
        }
        System.out.println();
        return array;
    }

    private static void printArray(int[] array){
        for(int i : array){
            System.out.print(i + " ");
        }
        System.out.println();
    }


}
