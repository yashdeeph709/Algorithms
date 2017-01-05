package com.codingbat;

public class SumOfDigit{
	public static void main(String args[]){
		int no=Integer.parseInt(args[0]);
		System.out.println(sumOfDigits(no));
	}
	public static int sumOfDigits(int n){
		if(n<10){
		 	return n;
		}else{
			return n%10+sumOfDigits(n/10);
		}
	}
}
