package com.certification.foundations.array;

class SearchAPairSumInRotatedArray{
	public static void main(String args[]){
		int[] array=new int[]{5,6,7,8,9,10,1,2,3,4};
		System.out.println(findPivot(array,0,array.length));
		System.out.println(findPairInRotated(array,17));
	}
	public static int findPivot(int[] array,int low,int high){
		if(high<low){
			return -1;
		}	
		if(high==low){
			return low;
		}
		int mid=(low+high)/2;
		if(mid<high && array[mid]>array[mid+1]){
			return mid;
		}
		if(mid>low && array[mid]<array[mid-1]){
			return mid-1;
		}
		if(array[low]>=array[mid]){
			return findPivot(array,low,mid-1);
		}
		return findPivot(array,mid+1,high);
	}
	public static int findPairInRotated(){

	}
}
