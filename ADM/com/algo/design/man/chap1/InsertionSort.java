package com.algo.design.man.chap1;

public class InsertionSort{
	public static void main(String args[]){
		int[] array={14,12,4,1,25,5,2,52,52,3,213,2};
		int i,j;
		for(i=0;i<array.length;i++){
			j=i;
			while((j>0) && (array[j]<array[j-1])){
				int temp=array[j];
				array[j]=array[j-1];
				array[j-1]=temp;
				j--;
			}
		}
		for(i=0;i<array.length;i++){
			System.out.print(array[i]+",");
		}
	}
}
