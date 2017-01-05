package com.codingbat;

public class Fibonacci{
	public static void main(String args[]){
		int target=Integer.parseInt(args[0]);
		System.out.println(fibonacci(target));
	}
	public static int fibonacci(int target){
		if(target==0 || target==1){
			return target;
		}else{
			return fibonacci(target-1)+fibonacci(target-2);
		}
	} 
}
