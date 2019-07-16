package com.nightstory.mineboot.algorithm.offer.part2;

/**
 * @Author: putao
 * @Date: 2019/3/5
 */
public class Unit_one {

    public static void main(String[] args) {
        int [][] array = {{1,2,3,4},{5,6,7,8}};
        System.out.println(array.length);
        System.out.println(array[0].length);
    }


    /**
     *   在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
     *    请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
     * @param target
     * @param array
     * @return
     */
    public static boolean Find(int target, int [][] array) {
        if(array.length == 0){
            return false;
        }
        int row = array.length - 1;
        int col = 0;
        while (row >= 0 && col < array[0].length){
            if(target == array[row][col]){
                return true;
            }else if(target > array[row][col]){
                col ++;
            }else {
                row --;
            }
        }
        return false;
    }
}
