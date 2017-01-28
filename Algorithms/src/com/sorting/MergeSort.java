package com.sorting;

public class MergeSort {

	public static void main(String[] args) {
		int[] array={38, 27, 43, 3, 9, 82, 10};
		mergeSort(array,0,array.length-1);
		for(int i=0;i<array.length;i++){
			System.out.println(array[i]);
		}
	}

	private static void mergeSort(int[] array, int left, int right) {
		if(left<right){
			int middle=(left+right)/2;
			mergeSort(array,left,middle);
			mergeSort(array,middle+1,right);
			merge(array,left,middle,right);
		}
	}

	private static void merge(int[] array, int left, int middle, int right) {
		int[] leftArray=new int[middle-left+1];
		int[] rightArray=new int[right-middle];
		for(int i=0;i<leftArray.length;i++)
			leftArray[i]=array[left+i];
		for(int j=0;j<rightArray.length;j++)
			rightArray[j]=array[middle+1+j];
		int i=0,j=0;
		int k=left;
		while(i<leftArray.length && j<rightArray.length){
			if(leftArray[i]<=rightArray[j]){
				array[k]=leftArray[i];
				i++;
			}else{
				array[k]=rightArray[j];
				j++;
			}
			k++;
		}
		while(i<leftArray.length){
			array[k]=leftArray[i];
			i++;
			k++;
		}
		while(j<rightArray.length){
			array[k]=rightArray[j];
			j++;
			k++;
		}
	}


}
