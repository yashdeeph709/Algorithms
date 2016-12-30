package com.codingbat;

class PowerN{
	public static void main(String args[]){
		int number=Integer.parseInt(args[0]);
		int power=Integer.parseInt(args[1]);
		System.out.println(power(number,power));		
	}
	public static int power(int base,int n){
		if(n==1 || n==0){
		 	return base;
		}else{
			return base*power(base,n-1);
		}
	}
}
