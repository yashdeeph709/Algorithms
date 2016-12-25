package com.hackerearth.codemonk.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
TestCases:
1
6 9
3
2 3
1 1 
-1 -1 

**/
public class SamuCardGame{
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int noOfTestCases = Integer.parseInt(br.readLine());
		while(noOfTestCases-->0){
			String line[]=br.readLine().split(" ");
			int N=Integer.parseInt(line[0]);
			int M=Integer.parseInt(line[1]);
			int K=Integer.parseInt(br.readLine());
			int jumps=0,x=1,y=1;
			while(K-->0){
				line=br.readLine().split(" ");
				int a=Integer.parseInt(line[0]);
				int b=Integer.parseInt(line[1]);
				while(x+a<N && y+b<M && x+a>0 && y+b>0){ jumps++; x+=a; y+=b; }
			}
			System.out.println(jumps);
		}
	}
}
