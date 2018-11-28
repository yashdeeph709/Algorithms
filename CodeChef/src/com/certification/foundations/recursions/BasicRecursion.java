package com.certification.foundations.recursions;

class BasicRecursion{
	public static void main(String args[]){
		printHelloCount(10);
	}
	public static void printHelloCount(int count){
		if(count==0){
			return;
		}
		System.out.println("Hello world");
		printHelloCount(count-1);
	}
}
