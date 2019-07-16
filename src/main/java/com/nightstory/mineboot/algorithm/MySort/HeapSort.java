package com.nightstory.mineboot.algorithm.MySort;

/**
 * 此堆排序以小根堆排序示例
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] a = {0,3,128, 186, 35, 280, 62, 4, 9, 6, 10};

        HeapSort sort = new HeapSort();
        sort.heapSort(a);

    }

    private void heapSort(int[] arr){
        int heapSize = arr.length - 1;
        buildHeap(arr,heapSize);
        for(int i = 1; i <= arr.length  - 1;i++){
            System.out.print(arr[1] + " ");
            deleteMin(arr,heapSize);
            heapSize--;

        }

    }

    private void buildHeap(int[] arr,int heapSize){
        //对第一个非叶子节点开始sink调整，也就是堆大小的一半处;
        for(int i = heapSize/ 2; i >= 1; i--){
            sink(arr,i,heapSize);
        }
    }

    private void deleteMin(int[] arr,int heapSize){
        swap(arr,1,heapSize);
        heapSize = heapSize - 1;
        sink(arr,1,heapSize);
    }


    /**
     * 对以arr[parentIndex] 为父节点的堆进行调整(此处为下沉）
     * @param arr  要调整的数组
     * @param parentIndex 父节点下标
     */
    private void sink(int[] arr, int parentIndex,int heapSize){

        int minIndexNode = minIndex(arr,parentIndex,heapSize);

        if(minIndexNode != parentIndex){
            swap(arr,minIndexNode,parentIndex);
            sink(arr,minIndexNode,heapSize);
        }

    }

    /**
     *
     * @param arr
     * @param parentIndex
     * @param heapSize
     */
    private int minIndex(int[] arr,int parentIndex,int heapSize) {
        int minIndex = parentIndex; //保存最小节点下标

        int leftIndex = getLeftIndex(parentIndex);
        if(leftIndex <= heapSize){
            minIndex = arr[leftIndex] < arr[parentIndex] ? leftIndex : parentIndex;
        }

        int rightIndex = getRightIndex(parentIndex);
        if(rightIndex <= heapSize){
            minIndex = arr[rightIndex] < arr[minIndex] ? rightIndex : minIndex;
        }

        return minIndex;
    }

    private void swap(int[] arr,int x,int y){
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    private int getLeftIndex(int parentIndex){
        return parentIndex * 2;
    }
    private int getRightIndex(int parentIndex){
        return parentIndex * 2 + 1;
    }

}
