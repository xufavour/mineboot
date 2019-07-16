package com.nightstory.mineboot.algorithm;

public class BubbleSort {
	public static void main(String[] args) {
		int[] a = {3, 128, 186, 35, 7, 62, 4, 9, 6, 10};
		sort(a);
		for(int k=0;k<a.length;k++){
			System.out.println(a[k]+",");

		}
	}


	public void bubbleSort(int[] a){
		int temp=0;
		for(int i=a.length-1;i>0;i--){
			for(int j=a.length-1;j>a.length-i-1;j--){
				if(a[j]<a[j-1]){
					temp=a[j];
					a[j]=a[j-1];
					a[j-1]=temp;
				}
			}
		}
		for(int k=0;k<a.length;k++){
			System.out.print(a[k]+",");
			
		}
	}



	public static void sort(int[] a){
		for(int i = 0; i < a.length; i++){
			for(int j = 0; j < a.length - i - 1; j ++){
				if(a[j] > a[j+1]){
					int temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
				}
			}
			for(int k=0;k<a.length;k++){
				System.out.println(a[k]+",");

			}
		}
	}
}
