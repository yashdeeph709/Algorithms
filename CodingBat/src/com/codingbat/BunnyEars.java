package com.codingbat;

public class BunnyEars{
	public static void main(String args[]){
		int noOfBunnies=Integer.parseInt(args[0]);
	 	System.out.println(earCount(noOfBunnies));
	}
	public static int earCount(int noOfBunnies){
		if(noOfBunnies==0){
			return 0;
		}else{
			return 2+earCount(noOfBunnies-1);
		}
	}
}
