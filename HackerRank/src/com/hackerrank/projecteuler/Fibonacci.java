package com.hackerrank.projecteuler;

import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int noOfTestCases = sc.nextInt();
		while(noOfTestCases-->0){
			long N=sc.nextLong();
			long a=2,sum=0,a2last=0,alast=2;
			while(a<N){
				System.out.println(a);
				sum+=a;
				a=alast*4+a2last;
				a2last=alast;
				alast=a;
			}
			System.out.println(sum);
		}
	}

}
