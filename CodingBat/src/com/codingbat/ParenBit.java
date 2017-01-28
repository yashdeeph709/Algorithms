package com.codingbat;

public class ParenBit{
	public static void main(String args[]){
		System.out.println(parenBit(args[0]));
	}
	public static String parenBit(String str){
		if(str.length()<=1){
			return ")";
		}
		if(str.charAt(0)=='('){
			return "("+parenBit("*"+str.substring(1));
		}else if(str.charAt(0)=='*'){
			if(str.charAt(1)!=')'){
				return str.charAt(1)+parenBit("*"+str.substring(2));
			}else{
				return parenBit("");
 			}
		}else{
			return parenBit(str.substring(1));
		}
	}
}
