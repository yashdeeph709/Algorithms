package com.sorting;

public class HeapSort {
	int heapsize;
	public void buildMaxHeap(int array[]){
		heapsize=array.length;
		for(int i=heapsize/2;i>-1;i--){
			maxHeapify(array,i);
		}
	}
	
	
	private void maxHeapify(int[] array, int i) {
		int largest=0;
		int l=left(i);
		int r=right(i);
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
			maxHeapify(	array, largest);
		}
	}
	public int left(int i){
		return 2*i;
	}
	public int right(int i){
		return 2*i+1;
	}

	public static void main(String[] args) {
		HeapSort heap=new HeapSort();
		int[] array={4 , 5 , 45,12 ,5  , 4 , 58 ,5 , 1 };
		heap.buildMaxHeap(array);
		for(int i=0;i<array.length;i++){
			System.out.println(array[i]);
		}
	}

}
