package com.sorting;

public class SelectionSort {

	public static void main(String[] args) {
		int[] array={12,23,2,3452,34,4,435,234,234,24,3};
		
		for(int i=0;i<array.length;i++){
			for(int j=i+1;j<array.length;j++){
				if(array[j]>array[i]){
					int temp=array[i];
					array[i]=array[j];
					array[j]=array[i];
				}
			}
		}
		for(int i=0;i<array.length;i++){
			System.out.println(array[i]);
		}
	}
}
