package com.codingbat;

public class NestParan{
	public static void main(String args[]){
		System.out.println(nestParan(args[0]));
	}
	public static boolean nestParan(String str){
		if(str.length()==0){
			return true;
		}
		if(str.charAt(0)=='(' && str.charAt(str.length()-1)==')'){
			return nestParan(str.substring(1,str.length()-1));
		}
		return false;
	}
}
