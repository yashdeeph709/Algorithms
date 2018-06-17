package com.certification.foundations.array;

class SearchInRotateArray{
	public static void main(String args[]){
		int[] array=new int[]{3,4,5,6,7,8,1,2};
		System.out.println(pivotedBinarySearch(array,array.length,5));
	}
	public static int pivotedBinarySearch(int[] array,int n,int key){
		int pivot = findPivot(array,0,n-1);

		if(pivot == -1){
			return binarySearch(array, 0, n-1, key);
		}
		if(array[pivot]==key){
			return pivot;
		}
		if(array[0]<=key){
			return binarySearch(array,0,pivot-1,key);
		}
		return binarySearch(array,pivot+1,n-1,key);
	}
	public static int binarySearch(int[] array,int low,int high,int key){
		if(high < low){
			return -1;
		}
		int mid = (low+high)/2;
		if(key==array[mid]){
			return mid;
		}
		if(key>array[mid]){
			return binarySearch(array,(mid+1),high,key);
		}
		return binarySearch(array,low,mid-1,key);
	}
	public static int findPivot(int[] array,int low,int high){
		if( high < low ) return -1;
		if(high == low) return low;
		
		int mid = (low+high)/2;
		if( mid<high && array[mid]>array[mid+1]){
			return mid;
		}
		if( mid>low  && array[mid]<array[mid-1]){
			return mid-1;
		}	
		if(array[low] >= array[mid]){
			return findPivot(array,low,mid-1);
		}
		return findPivot(array, mid+1, high);
	}
}	
