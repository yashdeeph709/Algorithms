package com.codingbat;

public class AllStar{
	public static void main(String args[]){
		System.out.println(allStar(args[0]));	
	}
	public static String allStar(String str){
		if(str.length()<=1){
			return str;
		}
		return str.charAt(0)+"*"+allStar(str.substring(1));	
	}
}
