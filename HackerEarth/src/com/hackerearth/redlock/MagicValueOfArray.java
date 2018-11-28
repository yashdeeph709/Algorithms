package com.hackerearth.redlock;

import java.io.*;

class MagicValueOfArray{
	public static final boolean debug=false;
	public int heapsize;
	/*public static void main(String args[]){
		int[] array=new int[]{3,2,4,5,1,6};
		int[] arrayd=new int[]{0,4,0,0,1,3,4,1,0,2};
		MagicValueOfArray heap=new MagicValueOfArray();
		heap.heapsize=arrayd.length;
		heap.buildMaxHeap(arrayd);
		//System.out.println(magicValue(arrayd,SpecialSort(arrayd)));
		printSorted(heap,arrayd);
	}
	
	*/
	public static void main(String args[]) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int noOfTestCases=Integer.parseInt(br.readLine());
		String[] tokens=br.readLine().split(" ");
		int[] array=new int[tokens.length];
		int[] arrayu=new int[array.length];
		for(int i=0;i<array.length;i++){
			array[i]=Integer.parseInt(tokens[i]);
		}
		System.arraycopy(array,0,arrayu,0,array.length);
		MagicValueOfArray heap=new MagicValueOfArray();
		heap.buildMaxHeap(array);
		System.out.println(magicValue(heap,array,arrayu));
	}
	
	public static void printArray(int[] array){
		if(debug){
			for(int i=0;i<array.length;i++){
				System.out.printf("%d,",array[i]);
			}
			System.out.println();
		}
	}
	
	public static void printSorted(MagicValueOfArray heap,int[] array){
			for(int i=0;i<array.length;i++){
				System.out.printf("%d,",heap.extractMax(array));
			}
			System.out.println();
	}
	public static int magicValue(MagicValueOfArray heap,int[] array,int[] nonsorted){
		int goodSum=0,badSum=0;
		for(int i=array.length-1;i>=0;i--){
			int rightElement=heap.extractMax(array);
			if(nonsorted[i]==rightElement){
		//		System.out.printf("Good Integer Found %d at %d index:%d\n",nonsorted[i],rightElement,i);
				badSum+=nonsorted[i];
			}else{
		//		System.out.printf("Bad Integer Found %d at %d index:%d\n",nonsorted[i],rightElement,i);
				goodSum+=nonsorted[i];
			}
		}
		return badSum-goodSum;
	}
	public static int[] SpecialSort(int[] arrayOld){
		int[] array=new int[arrayOld.length];
		System.arraycopy(arrayOld,0,array,0,arrayOld.length);
		for(int i=0;i<array.length;i++){
			int min=array[i];
			int index=i;
			for(int j=i;j<array.length;j++){
				if(min>array[j]){
					min=array[j];
					index=j;
				}
			}
			array[index]=array[i];
			array[i]=min;
		}
		return array;
	}
	public void buildMaxHeap(int array[]){
		heapsize=array.length;
		for(int i=heapsize/2-1;i>=0;i--){
			maxHeapify(array,i);
		}
	}
	private void maxHeapify(int[] array, int index) {
		int largest = index;
		int leftIndex = 2 * index + 1;
		int rightIndex = 2 * index + 2;

		if (leftIndex < heapsize && array[index] < array[leftIndex]) {
		    largest = leftIndex;
		}
		if (rightIndex < heapsize && array[largest] < array[rightIndex]) {
		    largest = rightIndex;
		}

		if (largest != index) {
		    int temp = array[index];
	            array[index] = array[largest];
    	    	    array[largest] = temp;
		    maxHeapify(array,largest);
		}
	}
	public int left(int i){
		return 2*i+1;
	}
	public int right(int i){
		return 2*i+2;
	}

	public int extractMax(int[] heap){
		if (heapsize == 0){ return -1;}
		int min = heap[0];
		heap[0] = heap[heapsize - 1];
		heapsize--;
		maxHeapify(heap,0);
		return min;
	}
	/*public static void printArray(int[] array){
		for(int i=0;i<array.length;i++){
			System.out.print(array[i]+" ");
		}
	}
	public static void main(String[] args) {
		MagicValueOfArray heap=new MagicValueOfArray();
		int[] array={4,1,3,2,16,9,10,14,8,7};
		heap.buildMaxHeap(array);
		System.out.println(heap.extractMax(array));
		System.out.println(heap.extractMax(array));
		System.out.println(heap.extractMax(array));
		System.out.println(heap.extractMax(array));
		//printArray(array);	
	}*/

}
