package com.codingbat;

public class Array11{
	public static void main(String[] args){
	
	}
	public static int array11(int[] nums,int index){
		if(nums.length==0){
                        return 0;
                }
                if(index<nums.length && nums[index]==11){
                        return 1+array11(nums,++index);
                }else{
                    if(index+1<nums.length){
                        return array11(nums,++index);
                    }else{
                        return 0;
                    }
                }
	}
}
