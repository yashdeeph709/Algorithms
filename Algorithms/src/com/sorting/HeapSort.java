package com.sorting;

public class HeapSort {
	int heapsize;
	public void buildMaxHeap(int array[]){
		heapsize=array.length-1;
		for(int i=heapsize/2;i>=0;i--){
			maxHeapify(array,i);
		}
	}
	private void maxHeapify(int[] array, int i) {
		System.out.print("{");
		int largest=-1;
		int l=left(i);
		int r=right(i);
		printArray(array);
		System.out.println("\nCall on array: "+i+" "+left(i)+" "+right(i)+"\n");
		if(l<=heapsize && array[l]>array[i]){
			largest=l;
		}else{ 
			largest=i;
		}
		if(r<=heapsize && array[r]>array[largest]){
			largest=r;
		}
		if(largest!=i){
			int temp=array[i];
			array[i]=array[largest];
			array[largest]=temp;
			maxHeapify(array, largest);
		}else{
			System.out.println("largest is default");
		}
		System.out.print("}");
	}
	public int left(int i){
		return 2*i+1;
	}
	public int right(int i){
		return 2*i+2;
	}
	public static void printArray(int[] array){
		for(int i=0;i<array.length;i++){
			System.out.print(array[i]+" ");
		}
	}
	public static void main(String[] args) {
		HeapSort heap=new HeapSort();
		int[] array={4,1,3,2,16,9,10,14,8,7};
		heap.buildMaxHeap(array);
		printArray(array);	
	}
}
