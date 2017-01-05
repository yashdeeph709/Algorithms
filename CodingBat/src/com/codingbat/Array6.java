package com.codingbat;

public class Array6{
	public static void main(String args[]){
		int[] array={3,4,5,0,2,3,4,1};
		System.out.println(array6(array,0));
	}
	public static boolean array6(int[] nums,int index){
		if(index<nums.length && nums[index]==6){
			return true;
		}else if(index+1<nums.length){	
			return array6(nums,++index);
		}else{
			return false;
		}
	}
}
