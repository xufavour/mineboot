package com.nightstory.mineboot.algorithm.offer.part2;

import java.util.Stack;

/**
 * @Author: putao
 * @Date: 2019/3/5
 */
public class Unit_three {
    //用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop().intValue();
    }
    //把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。
    // 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。 NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。

    public static void main(String[] args) {
        System.out.println(JumpFloorII(3));
    }
    public static int minNumberInRotateArray(int [] array) {
//        if(array == null || array.length == 0){
//            return 0;
//        }
//        int len = array.length;
//        for(int i = len - 1; i > 0; i--){
//            if(array[i-1] > array[i]){
//                return array[i];
//            }
//        }
//        return 0;

        int low = 0 ; int high = array.length - 1;
        while(low < high){
            int mid = low + (high - low) / 2;
            if(array[mid] > array[high]){
                low = mid + 1;
            }else if(array[mid] == array[high]){
                high = high - 1;
            }else{
                high = mid;
            }
        }
        return array[low];

    }
    //大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
    //n<=39

    public int Fibonacci(int n) {
        if(n<=0) return 0;
        if(n==1 || n==2) return 1;
        return Fibonacci(n-1)+Fibonacci(n-2);
    }
    //一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
    //  用动态规划表来抽象出实际问题。在这个问题上，我们让f(n)表示走上n级台阶的方法数。
    //  那么当n为1时，f(n)= 1,n为2时，f(n)=2,就是说当台阶只有一级的时候，方法数是一种，台阶有两级的时候，方法数为2。
    //  那么当我们要走上n级台阶，必然是从n-1级台阶迈一步或者是从n-2级台阶迈两步，
    //  所以到达n级台阶的方法数必然是到达n-1级台阶的方法数加上到达n-2级台阶的方法数之和。即f(n)= f(n-1)+f(n-2),  
    //---------------------
    public int JumpFloor(int target) {
        if(target <= 0){
            return -1;
        }
        if(target == 1 || target == 2){
            return target;
        }else{
            return JumpFloor(target - 1) + JumpFloor(target - 2);
        }

    }
    //一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。

    public static int JumpFloorII(int target) {
        if (target <= 0)
            return 0;
        if (target == 1)
            return 1;
        return 2 * JumpFloorII(target - 1);
    }

    //我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
    public int RectCover(int target) {
        if(target < 1){
            return 0;
        }
        if(target  == 1){
            return 1;
        }
        if(target == 2){
            return 2;
        }
        return RectCover((target-1))+RectCover(target-2);

    }
}
