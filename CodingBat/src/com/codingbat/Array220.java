package com.codingbat;

public class Array220{
	public static void main(String args[]){
		int[] array={2,19,4};
		System.out.println(array220(array,0));
	}
	public static boolean array220(int[] nums,int index){
		  if(index==nums.length-1 || nums.length==0){
		    return false;
		  }
		  if(index+1<nums.length && nums[index]*10==nums[index+1]){
		    return true;    
		  }else{
		    return array220(nums,++index);
		  }
	}
}
