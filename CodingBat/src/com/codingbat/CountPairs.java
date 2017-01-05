package com.codingbat;

public class CountPairs{
	public static void main(String args[]){
		System.out.println(countPairs(args[0]));
	}
	public static int countPairs(String st){	
		if(str.length()<3){
			return 0;
		}
		if(str.charAt(0)==str.charAt(2)){
			return 1+countPairs(str.substring(1)); 
		}else{
			return countPairs(str.substring(1));
		}
	}	
}
