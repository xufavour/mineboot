package com.nightstory.mineboot.algorithm;

public class SelectSort {
	public void selectSort(int[] a){
		for(int i=0;i<a.length;i++){
			int position = i;
			int temp =a[i];
			for(int j=i+1;j< a.length;j++){
				if(a[j]<temp){
					temp=a[j];
					position=j;
				}
			}
			System.out.println("??"+ i +"????????"+temp);
			a[position]=a[i];
			a[i]=temp;
		}
		for(int x=0;x<a.length;x++){
			System.out.print(a[x]+",");
		}
		
	}

}
