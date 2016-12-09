package com.hackerearth.codemonk.implementation;

import java.util.Scanner;

public class StrAdd {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		while(--n>-1){
			String teststr=sc.next();
			String teststrrev=new StringBuffer(teststr).reverse().toString();
			for(int i=0;i<teststr.length();i++){
//				System.out.println(teststr.charAt(i)+" "+teststrrev.charAt(i));
//				System.out.println((((int)teststr.charAt(i)-96)%26+" "+((int)teststrrev.charAt(i)-96)%26));
				int answer=(((int)teststr.charAt(i)-96))+(((int)teststrrev.charAt(i)-96));
//				System.out.println(answer);
				answer=answer%26>0?answer%26:26;
				System.out.print((char)((answer)+96));
			}
			System.out.println();
		}

	}

}
