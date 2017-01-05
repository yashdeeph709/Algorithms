package com.codingbat;

public class Count11{
	public static void main(String args[]){
		System.out.println(count11(args[0]));
	}
	public static int count11(String str){
		if(str.length()<2){
			return 0ear

		}
		if(str.charAt(0)=='1' && str.charAt(1)=='1'){	
			return 1+count11(str.substring(2));
		}else{
			return count11(str.substring(1));
		}

	}
}
