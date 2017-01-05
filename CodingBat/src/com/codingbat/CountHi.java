package com.codingbat;

public class CountHi{
	public static void main(String[] args){
		System.out.println(countHi(args[0]));
	}
	public static int countHi(String str){
		if(str.length()<=1){
			return 0;
		}
		if(str.charAt(0)=='h' && str.charAt(1)=='i'){
			return 1+countHi(str.substring(1));	
		}else{
			return 0+countHi(str.substring(1));
		}
	}
}
