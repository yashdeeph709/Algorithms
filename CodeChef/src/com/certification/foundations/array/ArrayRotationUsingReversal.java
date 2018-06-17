package com.certification.foundations.array;

public class ArrayRotationUsingReversal{
	public static void main(String args[]){
		int[] array=new int[]{1,2,3,4,5,6,7,8};
		leftRotate(array,2);
		printArray(array,2);	
	}
	public static void reverseSection(int[] array,int start,int end){
		int temp;
		while(start<end){
			temp=array[start];
			array[start]=array[end];
			array[end]=temp;
			start++;
			end--;
		}
	}
	public static void printArray(int[] array,int rotation){
		for(int i=0;i<array.length;i++){
			System.out.print(array[i]+":");
		}
		System.out.println(rotation);
	}
	public static void leftRotate(int[] array,int rotation){
		reverseSection(array,0,rotation-1);
		reverseSection(array,rotation,array.length-1);
		reverseSection(array,0,array.length-1);
	}
}	
