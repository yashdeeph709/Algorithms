package com.codingbat;

public class Triangle{
	public static void main(String args[]){
		int rows=Integer.parseInt(args[0]);
		System.out.println(triangle(rows));
	}
	public static int triangle(int rows){	
		if(rows==0 || rows==1){
			return rows;
		}else{
			return rows+triangle(rows-1);
		}
	}
}
