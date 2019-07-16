package com.nightstory.mineboot.algorithm;

import java.util.ArrayList;
import java.util.List;

public class RadixSort {
	public void RadixSort(int[] a){
		sort(a);
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+",");
		}
		
	}
	public void sort(int[] a){
		int max=a[0];
		for(int i=1;i<a.length;i++){ //�ҳ�����Ԫ�����ֵ��ȷ�������������
			if(a[i]>max){
				max=a[i]; 
			
			}
			
		}
		System.out.println("���ֵ��:" +max);
		//�ж����ֵ��λ����
		int time=0;
		while(max>0){
			max/=10;
			time++;
		}
		System.out.println("���ֵλ��:" +time);
		
		List<ArrayList> queue = new ArrayList<ArrayList>();
		for(int i=0; i<10;i++){
			ArrayList<Integer> queue1 =new ArrayList<Integer>();
			queue.add(queue1);
		}
		//����time�η�����ռ�
		for(int i=0;i<time;i++){
			//��������Ԫ��
			for(int j=0;j<a.length;j++){
				int x =a[j]%(int)Math.pow(10, i+1)/(int)Math.pow(10, i);
				ArrayList<Integer> queue2 =queue.get(x);
			
				queue2.add(a[j]);
				queue.set(x, queue2);
				
			}
			int count =0;
			for(int k=0;k<10;k++){
				while(queue.get(k).size()>0){
					ArrayList<Integer> queue3=queue.get(k);
					a[count]=queue3.get(0);
					queue3.remove(0);
					count++;
				}
			}
			
		}
		
		
	}

}
