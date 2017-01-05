package com.codingbat;

public class EndX{
	public static void main(String args[]){
		System.out.println(endX(args[0]));
	}
	public static String endX(String str){
		if(str.length()==0){
			return str;
		}
		if(str.charAt(0)=='x'){
			return endX(str.substring(1))+'x';
		}else{
			return str.charAt(0)+endX(str.substring(1));
		}
	}
}
