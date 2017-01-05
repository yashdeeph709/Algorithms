package com.codingbat;

public class CountAbc{
	public static void main(String args[]){
		System.out.println(countAbc(args[0]));
	}
	public static int countAbc(String str){
		if(str.length()<3){
			return 0;
		}
		if(str.startsWith("abc") || str.startsWith("aba")){
			return 1+countAbc(str.substring(1));
		}else{
			return countAbc(str.substring(1));
		}
	}
}
