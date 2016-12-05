package com.hackerearth;

import java.util.Scanner;

public class CountDigits {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String number = sc.next();
		int[] results=new int[10];
		for(int ch=0;ch<number.length();ch++){
			results[Integer.parseInt(number.charAt(ch)+"")]++;
		}
		for(int i=0;i<results.length;i++){
			System.out.println(i+" "+results[i]);
		}
	}

}
