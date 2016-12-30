package com.codingbat;

public class Count8{
	public static void main(String args[]){
		int n=Integer.parseInt(args[0]);
		System.out.println(count8(n));
	}
	public static int count8(int number){
		if(number<10){
			return number==8?1:0;
		}
		if(number%10==8){
			number=number/10;
			int x=number%10==8?2:1;
			return x+count8(number);	
		}else{
			return count8(number/10);
		}
	}
}
