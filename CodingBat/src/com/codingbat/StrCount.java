package com.codingbat;

public class StrCount{
	public static void main(String args[]){
		System.out.println(strCount(args[0],args[1]));	
	}
	public static int strCount(String str,String sub){
		if(str.length()<sub.length()){
			return 0;
		}
		if(str.startsWith(sub)){
			return 1+strCount(str.substring(sub.length()),sub);	
		}else{
			return strCount(str.substring(1),sub);
		}
	}
}
