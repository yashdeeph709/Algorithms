package com.certification.foundations.array;

class SearchAPairSumInRotatedArray{
	public static void main(String args[]){
		int[] array=new int[]{5,6,7,8,9,10,1,2,3,4};
		//System.out.println(findPivot(array,0,array.length-1));
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
	public static int findPairInRotated(int[] array,int sum){
		int pivot=findPivot(array,0,array.length-1);
		int l=(pivot+1)%array.length;
		int r=pivot;
		while(l!=r){
			if(array[l]+array[r]==sum){
				return 1;
			}
			if(array[l]+array[r]<sum){
				l=(l+1)%(array.length-1);
			}else{
				r=((array.length-1)+r-1)%(array.length-1);
			}
		}
		return 0;
	}
}
