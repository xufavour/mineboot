package com.nightstory.mineboot.algorithm.offer.par1;

/**
 * @Author: putao
 * @Date: 2019/2/13
 */
public class Merge {


    public static void main(String[] args) {
        int[] src = {3,1,2};
        mergeSort(src);
    }


    public static void mergeSort(int[] array){
        int[] temp = new int[array.length];
        recursion(array, 0, array.length - 1,temp);
        System.out.print("resutl :");
        for(int x : array){
            System.out.print(x + ",");
        }
        System.out.println();
    }

    public static void recursion(int[] array,int lowIndex,int highIndex,int[] temp){
        if(lowIndex < highIndex){
            int midIndex = (lowIndex + highIndex) / 2;
            recursion(array, lowIndex, midIndex, temp);
            recursion(array, midIndex + 1, highIndex, temp);
            merge(array, lowIndex, midIndex, highIndex, temp);
        }
    }

    public static void merge(int[] src,int lowIndex,int midIndex,int highIndex,int[] temp){
        int i = lowIndex;
        int m = midIndex;
        int j = midIndex + 1;
        int h = highIndex;
        int k = 0;
        while (i <= m && j <= h){
            if(src[i] < src[j]){
                temp[k++] = src[i++];
            } else {
                temp[k++] = src[j++];
            }
        }
        while (i <= m){
            temp[k++] = src[i++];
        }
        while (j <= h){
            temp[k++] = src[j++];
        }
        for(int y = 0; y < k; y++){
            src[lowIndex + y] = temp[y];
        }
        System.out.print("merge method temp:");
        for(int x : src){
            System.out.print(x + ",");
        }
        System.out.println();
    }

}
