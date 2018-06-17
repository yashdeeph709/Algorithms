package com.certification.foundations.array;

//Meet in the middle algorithm for finding sum
class SearchAPairSum{
	public static void main(String args[]){
		int[] array=new int[]{1,2,3,4,5,6,7,8};
		int sum=array[3]+array[6];
		System.out.println(findPair(array,sum));
	}
	public static int findPair(int[] array,int sum){
		int l=0;
		int r=array.length-1;
		while(l<r){
			int pairSum=array[l]+array[r];
			//System.out.println(l+" "+r+" "+pairSum);
			if(pairSum==sum){
				return 1;
			}else if(pairSum<sum){
				l++;	
			}else{
				r--;
			}
		}
		return 0;
	}
}
