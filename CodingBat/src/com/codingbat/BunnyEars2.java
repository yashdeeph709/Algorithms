package com.codingbat;

public class BunnyEars2{
	public static void main(String args[]){
		int number = Integer.parseInt(args[0]);
		System.out.println(CountEars(number));	
	}
	public static int CountEars(int number){
		if(number==1){
			return 2;
		}
		if(number==0){
			return 0;
		}
		if(number%2==0){
			return 3+CountEars(number-1);
		}else{
			return 2+CountEars(number-1);
		}
	}
}
