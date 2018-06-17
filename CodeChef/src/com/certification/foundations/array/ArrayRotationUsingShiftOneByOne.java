package com.certifications.foundations.array;

class ArrayRotationUsingShiftOneByOne{
	public static void main(String args[]){
		int[] array=new int[]{1,2,3,4,5,6,7,8,9};
		rotateLeft(array,1);
		printArray(array);
	}
	public static void rotateLeft(int[] array,int rotation){
		int last=array[array.length];
		for(int i=array.length-1;i>0;i--){
			array[i]=array[i-1];
		}
		arr[0]=last;
	}
	public static void printArray(int[] array){
		for(int i=0;i<array.length;i++){
			System.out.print(array[i]);
		}
		System.out.println();
	}
}

