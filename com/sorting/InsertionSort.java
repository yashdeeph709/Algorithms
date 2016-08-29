package com.sorting;

class InsertionSort {
	public static void main(String args[]){
		int[] array={10,12,9,4,6,456,498,1,56};
		for (int j = 1; j < array.length; j++) {
			int key = array[j];
			int i = j-1;
			while ( (i > -1) && ( array [i] > key ) ) {
			  array [i+1] = array [i];
			  i--;
			}
			array[i+1] = key;
		}
		for(int i=0;i<array.length;i++){
			System.out.println(array[i]);
		}
	}
}