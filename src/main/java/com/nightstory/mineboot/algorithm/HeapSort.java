package com.nightstory.mineboot.algorithm;

public class HeapSort {

	public static void main(String[] args) {
		int[] a = {10,3,128, 186, 35, 280, 62, 4, 9, 6, 10};

		HeapSort sort = new HeapSort();
		sort.buildHeap(a);

	}



	private void buildHeap(int[] array){
		int heapSize = array.length;
		printArray(array);
		for(int x = heapSize/2 - 1 ; x >= 0; x--){
			heapAdjust(array,x,heapSize);
		}
		printArray(array);


	}
	private void deleteMin(int[] arr,int heapSize){
		swap(arr,0,heapSize-1);
		heapSize = heapSize - 1;
		heapAdjust(arr,0,heapSize);
		printArray(arr);

	}


	private void printArray(int[] arr){
		for(int i = 0; i< arr.length; i++){
			System.out.print(arr[i] + " ");
		}
		System.out.println();

	}

	private void heapAdjust(int[] array,int parentIndex,int heapSize){

		int maxIndex = maxIndex(array,parentIndex,heapSize);

		if(maxIndex != parentIndex){
			swap(array,maxIndex,parentIndex);
			heapAdjust(array,maxIndex,heapSize);
		}
	}

	private int maxIndex(int[] array,int parentIndex,int heapSize){
		int tempMaxIndex = parentIndex;


		int l = getLeftIndex(parentIndex);

		if(l < heapSize){
			tempMaxIndex = array[parentIndex] > array[l] ? parentIndex : l;
		}
		int r = getRightIndex(parentIndex);
		if( r < heapSize){
			tempMaxIndex = array[r] > array[tempMaxIndex] ? r : tempMaxIndex;
		}

		return tempMaxIndex;

	}

	private void swap(int[] arr,int x,int y){
		int temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
	}
	private int getLeftIndex(int parentIndex){
		return parentIndex * 2 + 1;
	}
	private int getRightIndex(int parentIndex){
		return parentIndex * 2 + 2;
	}

}
