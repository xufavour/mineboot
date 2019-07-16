package com.nightstory.mineboot.algorithm;

public class QuickSort {
	public static void main(String[] args) {
		int[] a = {95,89,6,39,5,83,40,7,59,86};
		QuickSort sort = new QuickSort();
		sort.quickSort(a);
	}
	public void quickSort(int[] a){
		quick(a);
		for(int i=0 ; i<a.length;i++)
		System.out.print(a[i]+",");
		
	}
	public void quick(int[] a){
		if(a.length>0){
			quickSort2(a,0,a.length-1);
		}
	}
	public void quickSort2(int[] a ,int low,int high){
		if(low<high){
		int middle = getMiddle(a,low,high);
		quickSort2(a,low,middle-1);
		quickSort2(a,middle+1,high);
		}
	}
	public int getMiddle(int[] a,int low,int high){
		int temp = a[low];
		while(low<high){
			while(low<high && a[high]>=temp){
				high--;
			}
			a[low] = a[high];
			while(low<high && a[low]<=temp){
				low++;
			}
			a[high]=a[low];
		}
		a[high]=temp;
		return high;
	}
	

}
