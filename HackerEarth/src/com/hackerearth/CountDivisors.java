package com.hackerearth;

import java.util.Scanner;

public class CountDivisors {
	/* 
	 * TestCases:
	 * 		divisor > endRange && startRange%divisor
	 * 		divisor > endRange && endRange%divisor
	 * 		divisor > endRange && both%divisor
	 * 		divisor between startRange,endRange && startRange%divisor
	 * 		divisor between startRange,endRange && endRange%divisor 
	 * 		divisor between startRange,endRange && both%divisor 
	 * 		divisor < startRange  && startRange%divisor
	 * 		divisor < startRange  && endRange%divisor
	 * 		divisor < startRange  && both%divisor
	 * 		divisor>endRange && divisor!%any
	 * 		divisor<startRange && divisor!%any
	 * 		divisor between them && divisor!%any
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int startRange = sc.nextInt();
		int endRange = sc.nextInt();
		int divisor = sc.nextInt();
		System.out.println((endRange/divisor)-(startRange-1)/divisor);
	}	
}
