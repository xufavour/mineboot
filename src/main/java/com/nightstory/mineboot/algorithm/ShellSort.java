package com.nightstory.mineboot.algorithm;

public class ShellSort {
	public void shellSort(int[] a){
		int d= a.length/2;
	 while(true){
         for(int i=0;i<d;i++){
             for(int j=i ; j+d < a.length; j+=d){
             int temp;
             if(a[j]>a[j+d]){
                 temp=a[j];
                 a[j]=a[j+d];
                 a[j+d]=temp;

             }
             }
         }
          
          
         if(d==1){
             break;
         }
         d--;
        }
	 for(int x=0;x<a.length;x++)
	 System.out.print(a[x]+",");
	 
	}

}
