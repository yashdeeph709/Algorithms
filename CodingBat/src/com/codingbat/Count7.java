package com.codingbat;

public class Count7{
	public static void main(String args[]){
		int number=Integer.parseInt(args[0]);
		System.out.println(count7(number));
	}
	public static int count7(int number){
		if(number<10){
			return number==7?1:0;
		}
		if(number%10==7){
			return 1+count7(number/10);
		}else{
			return count7(number/10);
		}
	}
}
