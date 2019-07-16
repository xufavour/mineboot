package com.nightstory.mineboot.algorithm.offer.par1;

/**
 * @Author: putao
 * @Date: 2019/2/25
 */
public class Bubble {

    public static void main(String[] args) {


    }

    private static void sort(int[] array){
        int length = array.length;
        boolean isSorted = true;
        for(int i = 0; i < length; i++){
            for(int j = 0; j < length - i - 1; j++){
                if(array[j] > array[j+1]){
                    swap(array, j, j+1);
                    isSorted = false;
                }
            }
            if(isSorted){
                break;
            }
        }
    }

    private static void swap(int[] array,int x,int y){
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }
}
