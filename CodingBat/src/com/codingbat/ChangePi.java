package com.codingbat;

public class ChangePi{
	public static void main(String args[]){
		System.out.println(changePI(args[0]));
	}
	public static String changePI(String str){
		if(str.length()<=1){
			return str;
		}
		if(str.charAt(0)=='p' && str.charAt(1)=='i'){
			:return "3.14"+changePI(str.substring(2));
		}else{
			return str.charAt(0)+changePI(str.substring(1));
		}
	}
}
