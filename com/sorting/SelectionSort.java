package com.sorting;

public class SelectionSort {

	public static void main(String[] args) {
		int[] array={10,12,9,4,6,456,498,1,56};
		
		for(int i=0;i<array.length-1;i++){
			int jMin=i;
			for(int j=i+1;j<array.length;j++){
				if(array[j]<array[jMin]){
					jMin=j;
				}
			}
			if(jMin != i){
				array[i]=array[jMin]+array[i];
				array[jMin]=array[i]-array[jMin];
				array[i]=array[i]-array[jMin];
			}
		}
		
		for(int i=0;i<array.length;i++){
			System.out.println(array[i]);
		}
	}
}
