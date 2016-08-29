package com.sorting;

public class QuickSort {
	public static void main(String args[]) {
		int[] array={38, 27, 43, 3, 9, 82, 10};
		qsort(array,0,array.length-1);
		printArray(array);
	}
	public static void qsort(int[] array,int start,int end){
		if(start<end){
			int partition_key=standardPartition(array,start,end);
			//printArray(array);
			qsort(array,partition_key+1,end);
			qsort(array,start,partition_key-1);
		}
	}
	private static void printArray(int[] array) {
		for(int i=0;i<array.length;i++){
			System.out.print(array[i]+",");
		}
		System.out.println();
	}
	private static int partition(int[] array, int start, int end) {
		int pivot_index=end;
		for(int i=end-1;i>=0;i--){
			if(array[pivot_index]<array[i]){
				int j=i;
				while(j!=pivot_index){
					int temp=array[j+1];
					array[j+1]=array[j];
					array[j]=temp;
					j++;
				}
				pivot_index=j-1;
			}
		}
		return pivot_index;
	}
	private static int standardPartition(int[] array,int start,int end){
		int pivot=array[end];
		int pIndex=start;
		for(int i=start;i<end;i++){
			if(array[i]<=pivot){
				int temp=array[pIndex];
				array[pIndex]=array[i];
				array[i]=temp;
				pIndex+=1;
			}
		}
		int temp=array[pIndex];
		array[pIndex]=array[end];
		array[end]=temp;
		return pIndex;
	}
}
