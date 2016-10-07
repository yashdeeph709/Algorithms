package com.hackerearth;

import java.util.Scanner;

public class ToggleString {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		String resultant = "";
		for(int i=0;i<input.length();i++){
			if(input.charAt(i)>64 && input.charAt(i)<91){
				resultant +=(input.charAt(i)+"").toLowerCase();
			}else{
				resultant +=(input.charAt(i)+"").toUpperCase();
			}
		}
		System.out.println(resultant);
	}

}
