package com.codingbat;

public class StringClean{
	public static void main(String args[]){
		System.out.println(stringClean(args[0]));
	}
	public static String stringClean(String str){
		if(str.length()<2){
			return str;
		}
		if(str.charAt(0)==str.charAt(1)){
			return stringClean(str.charAt(0)+stringClean(str.substring(2)));
		}else{
			return str.charAt(0)+stringClean(str.substring(1));
		}
	}
}
