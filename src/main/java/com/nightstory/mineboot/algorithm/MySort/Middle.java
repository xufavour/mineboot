package com.nightstory.mineboot.algorithm.MySort;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Middle {
    public static void main(String[] args) {
        int [] a ={1,6,3,9};
        int[] b = getMiddle(a,4);
        for(int i : b){
            System.out.print(i);
        }
    }

    public static int[] getMiddle(int[] A, int n) {
        // write code here
        int[] res = new int[A.length];

        // 构造最大堆
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        };
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(n, comparator);
        // 构造最小堆
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(n);

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                // 存入最小堆前判断当前元素是否小于最大堆的堆顶元素
                if (!maxHeap.isEmpty() && A[i] < maxHeap.peek()) {
                    minHeap.offer(maxHeap.poll());
                    maxHeap.offer(A[i]);
                } else {
                    minHeap.offer(A[i]);
                }
                res[i] = minHeap.peek();
            } else {
                // 存入最大堆之前判断当前元素是否大于最小堆的堆顶元素
                if (!minHeap.isEmpty() && A[i] > minHeap.peek()) {
                    maxHeap.offer(minHeap.poll());
                    minHeap.offer(A[i]);
                } else {
                    maxHeap.offer(A[i]);
                }
                res[i] = maxHeap.peek();
            }
        }

        return res;
    }
}