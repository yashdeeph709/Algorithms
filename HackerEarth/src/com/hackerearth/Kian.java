package com.hackerearth;

import java.util.Scanner;

public class Kian {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int noOfTestCases = sc.nextInt();
		int a[]=new int[3];
		int i=0;
		while(i++<noOfTestCases){
			a[i%3]+=sc.nextInt();
		}
		System.out.println(a[1]+" "+a[2]+" "+a[0]);
	}

}
