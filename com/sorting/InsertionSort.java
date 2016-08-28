package com.sorting;

class InsertionSort{
	public static void main(String args[]){
		int[] array={10,12,9,4,6,456,498,1,56};
		for(int i=0;i<array.length;i++){
			for(int j=i;j<array.length;j++){
				if(array[i]>array[j]){
					int temp=array[i];
					array[i]=array[j];
					array[j]=temp;
				}
			}
		}
		for(int i=0;i<array.length;i++){
			System.out.println(array[i]);
		}
	}
}