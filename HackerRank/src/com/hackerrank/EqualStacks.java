package com.hackerrank;


import java.io.File;
import java.util.Scanner;

public class EqualStacks {
	private static Scanner sc;
	public static int findPairs(int n1,int n2,int n3,int stacks[][]){
		int numberOfPairs=0;
		
		return numberOfPairs;
	}
	public static void main(String args[]) throws Exception{
		sc = new Scanner(new File("C:\\Users\\c5244128\\Desktop\\HackerZone\\HackerRank\\EqualStacksTests"));
		int noOfTestCases=sc.nextInt();
		while(noOfTestCases-->0){
			int n1=sc.nextInt();
			int n2=sc.nextInt();
			int n3=sc.nextInt();
			int stacks[][]=new int[3][];
			stacks[0]=new int[n1];
			stacks[1]=new int[n2];
			stacks[2]=new int[n3];
			for(int i=0;i<3;i++){
				int n=stacks[i].length;
				while(n-->0){
					stacks[i][n]=sc.nextInt();
				}
			}
			System.out.println(findPairs(n1,n2,n3,stacks));
		}
	}
}
