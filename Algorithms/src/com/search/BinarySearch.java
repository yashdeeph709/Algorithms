package com.search;

public class BinarySearch{
	public static void main(String[] arg){
		int[] a={1,2,3,4,5,6,7,87,98,100};
		System.out.println(binarySearch(a,0,a.length,1122));
	}
	public static int binarySearch(int[] array,int start,int end,int x){
		int mid = (end-start)/2+start;
		if(end<=start){
			if(array[mid]==x){
				return mid;	
			}else if(array[mid]<x){
				return binarySearch(array,mid+1,end,x);
			}else if(array[mid]>x){
				return binarySearch(array,start,mid-1,x);
			}
                }
		return -1;
	}

}
