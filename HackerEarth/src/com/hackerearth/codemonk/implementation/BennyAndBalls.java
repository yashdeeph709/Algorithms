package com.hackerearth.codemonk.implementation;

import java.util.Arrays;
import java.util.Scanner;

public class BennyAndBalls {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int noOfTestcases = sc.nextInt();
		while(noOfTestcases-->0){
			
			int N=sc.nextInt(),N1=N;
			int baskets[]=new int[N];
			int oldbackets[]=new int[N];
			while(N-->0){
				baskets[baskets.length-N-1]=sc.nextInt();
				oldbackets[baskets.length-N-1]=baskets[baskets.length-N-1];
			}
			
			long x1 = sc.nextLong();
			int a = sc.nextInt(),b = sc.nextInt();
			int t = sc.nextInt();
			int result=0;
			while(--t>=0){
				int temp=(int)x1;
				if(--baskets[temp]==0){
					result++;
					baskets[temp]=oldbackets[temp];
				}
				x1=(1l*a*x1+b)%N1;
			}
			System.out.println(result);
		}
	}

}
