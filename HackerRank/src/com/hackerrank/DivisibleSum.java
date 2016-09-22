package com.hackerrank;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DivisibleSum {
	public static int findPairs(int n,int k,int ...numbers){
		int numberOfPairs=0;
		for(int i=0;i<numbers.length;i++){
			for(int j=i+1;j<numbers.length;j++){
				//System.out.println("Going for i:"+numbers[i]+"j:"+numbers[j]);
				if((numbers[i]+numbers[j])%k==0){
					numberOfPairs++;
				}
			}
		}
		return numberOfPairs;
	}
	public static void main(String args[]) throws Exception{
		Scanner sc=new Scanner(new File("C:\\Users\\c5244128\\Desktop\\HackerZone\\HackerRank\\DivisibleSumTests.txt"));
		int noOfTestCases=sc.nextInt();
		while(noOfTestCases-->0){
			int n=sc.nextInt();
			int k=sc.nextInt();
			int numbers[]=new int[n];
			while(n-->0){
				numbers[n]=sc.nextInt();
			}
			System.out.println(findPairs(n, k, numbers));
		}
	}
}
