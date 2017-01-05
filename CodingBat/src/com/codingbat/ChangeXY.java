package com.codingbat;

public class ChangeXY{
	public static void main(String args[]){
		System.out.println(changeXY(args[0]));
	}
	public static String changeXY(String str){
		if(str.length()==0){
			return "";
		}
		if(str.charAt(0)=='x'){
			return "y"+changeXY(str.substring(1));
		}else{
			return str.charAt(0)+changeXY(str.substring(1));
		}
	}
}
