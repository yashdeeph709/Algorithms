package com.codingbat;

public class PairStar{
	public static void main(String args[]){
		System.out.println(pairStar(args[0]));
	}
	public static String pairStar(String str){
		if(str.length()<=1){
			return str;
		}
		if(str.charAt(0)==str.charAt(1)){
			return str.charAt(0)+"*"+pairStar(str.substring(1));
		}else{
			return str.charAt(0)+pairStar(str.substring(1));
		}
	}
}
