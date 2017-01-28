package com.sorting;

public class HeapSort1{
	private static int heapsize;
	public static void main(String args[]){
		int[] array={5,75,1,5,4,1,2,4,8,4,2,15,4,2,1,5,779,9,1};
		heapsize=array.length-1;			
		for(int i=heapsize/2;i>=0;i--){
			maxHeapify(array,i,heapsize);
		}
		for(int i=heapsize;i>0;i--){
			array[i]=array[0]+array[i];
			array[0]=array[i]-array[0];
			array[i]=array[i]-array[0];
			maxHeapify(array,0,--heapsize);
		}
		printArray(array);
	}
	public static void maxHeapify(int[] array,int i,int heapsize){
		int largest=i;
		int left=2*i+1;
		int right=2*i+2;
		if(left<=heapsize && array[left]>array[i]){
			largest=left;
		}
		if(right<=heapsize && array[right]>array[largest]){
			largest=right;
		}
		if(largest!=i){
			array[i]=array[largest]+array[i];
			array[largest]=array[i]-array[largest];
			array[i]=array[i]-array[largest];
			maxHeapify(array,largest,heapsize);
		}
	}
	public static void printArray(int[] array){
		System.out.print("\n [");
		for(int i=0;i<array.length;i++){
			System.out.print(array[i]+" ");
		}
		System.out.print("] \n");
	}
	public static int getMax(){
		int max=array[0];
		array[0]=array[heapsize];
		maxHeapify(array,0,--heapsize);
	}
		
}
