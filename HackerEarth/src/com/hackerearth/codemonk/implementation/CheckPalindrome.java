package com.hackerearth.codemonk.implementation;

import java.util.Scanner;

public class CheckPalindrome {
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		
		String input = sc.next();
		boolean palindrome = true;
		for(int i=0;i<input.length();i++){
			if(input.charAt(i)!=input.charAt(input.length()-1-i)){
				palindrome = false;
			}
		}
		System.out.println(palindrome?"YES":"NO");
	}
}
