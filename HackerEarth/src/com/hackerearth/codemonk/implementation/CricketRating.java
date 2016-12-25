package com.hackerearth.codemonk.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class CricketRating{
	public static void main(String args[]) throws IOException{
		//BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		//int n=Integer.parseInt(br.readLine());
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[] ratings=new int[n];
		//String[] numbers=br.readLine().split(" +");
		//sc.nextInt();
		for(int i=0;i<n;i++){
			ratings[i]=sc.nextInt();
		}
		int i=0,max=0,sum=0;
		while(n-->0)
		{
			int k=ratings[i++];
			if(sum+k>0)
				sum+=k;
			else
				sum=0;
			
			max=Math.max(max,sum);
		}
		System.out.println(max);	
	}
}
