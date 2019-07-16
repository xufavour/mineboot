package com.nightstory.mineboot.algorithm;


import com.nightstory.mineboot.algorithm.edemo.StuAction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Test {
	public StuAction action;
	public void testEat(){
		action.eat();
	}
	// 使用 java 8 排序
	private void sortUsingJava8(List<String> names){
		Collections.sort(names, (s1, s2) -> s1.compareTo(s2));
	}
	public static void main(String[] args){
		int[] a ={3,128,186,35,7,62,4,9,6,10};
		Test test = new Test();
		ArrayList list = new ArrayList();
		test.action = new StuAction() {
			@Override
			public void goSchool() {

			}

			@Override
			public void eat() {
				System.out.println("..eat");
			}

			@Override
			public void sleep() {

			}
		};
		test.testEat();
		HashMap<String,String> map = new HashMap<>();
		//直接插入排序
//		InsertSort insert = new InsertSort();
//		insert.insertSort(a);
		
//		//希尔排序
//		ShellSort shell = new ShellSort();
//		shell.shellSort(a);
//
//		//简单选择排序
//		SelectSort select = new SelectSort();
//		select.selectSort(a);
//
//		//快速排序
//		QuickSort quick = new QuickSort();
//		quick.quickSort(a);
		
		//归并排序
		//MergingSort merging = new MergingSort();
		//merging.MergingSort(a);
		
//		冒泡排序
//		BubbleSort bubble= new BubbleSort();
//		bubble.bubbleSort(a);
		
		//基数排序
		//RadixSort radix =new RadixSort();
		//radix.RadixSort(a);
		
//		//堆排序
//		HeapSort heap = new HeapSort();
//		heap.heap_sort(a, a.length-1);
	
		
		
	}

}
