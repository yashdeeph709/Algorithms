package com.hackerrank.projecteuler;

import java.util.Scanner;

public class MultiplesFiveThree {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int noOfTestCases = sc.nextInt();
		while(noOfTestCases-->0){
			int N=sc.nextInt();
			int threes=N%3==0?(N/3)-1:(N/3),fives=N%5==0?(N/5)-1:(N/5),fifteens=N%15==0?(N/15)-1:(N/15);
			
			long sumOfThrees = (1l*threes*(3+1l*threes*3))/2;
			long sumOfFives = (1l*fives*(5+1l*fives*5))/2;
			long sumOfFifteens = (1l*fifteens*(1l*15+1l*fifteens*15))/2;
			System.out.println(sumOfThrees+sumOfFives-sumOfFifteens);
		}
	}

}
