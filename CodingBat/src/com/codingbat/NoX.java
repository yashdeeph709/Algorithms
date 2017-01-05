package com.codingbat;

public class NoX{
	public static void main(String args[]){
		System.out.println(noX(args[0]));
	}
	public static String noX(String str){
		if(str.length()==0){
			return "";
		}
		if(str.charAt(0)=='x'){
			return noX(str.substring(1));
		}else{
			return str.charAt(0)+noX(str.substring(1));
		}	
	}
}
