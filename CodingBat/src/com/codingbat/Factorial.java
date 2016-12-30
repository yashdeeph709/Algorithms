package com.codingbat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Factorial{
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int number=Integer.parseInt(br.readLine());
		System.out.println(factorial(number));
	}
	public static long factorial(long number){
		if(number==0 || number==1){
			return 1;
		}else{
			return number*factorial(number-1);
		}
	}
}
