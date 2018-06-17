package com.certification.foundations.array;

class ArrayRotationUsingBAS{
	public static void main(String args[]){
		int[] array=new int[]{1,2,3,4,5,6,7,8,9};
		int rotation=2;
		leftRotate(array,rotation,array.length);
		printArray(array);
	}
	public static void printArray(int[] array){
		for(int i=0;i<array.length;i++){
			System.out.print(array[i]);
		}
		System.out.println();
	}
	public static void leftRotate(int[] array,int d,int n){
		int i, j;
		if( d==0 || d==n){
			return;
		}	
		i=d;
		j=n-d;
		while(i!=j){
			if(i<j){
				swap(array,d-i,d+j-i,i);
				j-=i;
			}else{
				swap(array,d-i,d,j);
				i-=j;
			}
			System.out.printf("After: i:%d,j:%d\n",i,j);
			printArray(array);
		}
		swap(array,d-i,d,i);
	}

	public static void swap(int[] array,int start1,int start2,int numberOfElements){
		if(start2+numberOfElements>array.length){
			return;
		}
		int temp;
		for(int i=0;i<numberOfElements;i++){
			temp=array[start2+i];
			array[start2+i]=array[start1+i];
			array[start1+i]=temp;
		}
	}
}	
