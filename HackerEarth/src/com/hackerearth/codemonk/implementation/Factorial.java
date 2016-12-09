package com.hackerearth.codemonk.implementation;

import java.util.Scanner;

public class Factorial {
	static long[] resultset;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testinput = sc.nextInt();
		resultset = new long[testinput];
		System.out.println(factorial(testinput));
	}
	
	public static long factorial(int n){
		if(resultset[n-1]!=0){
			return resultset[n];
		}
		if(n==1){
			return 1;
		}else{
			resultset[n-1] = n*factorial(n-1);
			return resultset[n-1];
		}
	}
}
