package com.codingbat;

public class CountX{
	public static void main(String args[]){
		System.out.println(countX(args[0]));
	}
	public static int countX(String str){
		if(str.length()==1 || str.length()==0){
			return str.equals("x")?1:0;
		}
		if(str.charAt(str.length()-1)=='x'){
			return 1+countX(str.substring(0,str.length()-1));
		}else{
			return countX(str.substring(0,str.length()-1));
		}	
	}
}
	
