package com.hackerearth.codemonk.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PresedentialProblem{
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int noOfTestCases = Integer.parseInt(br.readLine());
		while(--noOfTestCases>=0){
			String line = br.readLine();
			int Q = Integer.parseInt(line.split(" ")[0]);
			int N = Integer.parseInt(line.split(" ")[1]);
			StringBuffer data = new StringBuffer(br.readLine());
			int[][] queries=new int[N][2];
			while(--N>=0){
				line=br.readLine();
				queries[N][0] = Integer.parseInt(line.split(" ")[0]);
				queries[N][1] = Integer.parseInt(line.split(" ")[1]);
			}
			System.out.println("Queries Stored");
			for(int i=0;i<queries.length;i++){
				System.out.println("Going for "+(queries[i][0]+1)+" to "+(queries[i][0]));
				for(int j=queries[i][0]-1;j<queries[i][1];j++){
					if(data.charAt(j)=='a'){
						data.setCharAt(j,'z');
					}else{
					int charCode=data.charAt(j);
					char c=(char)--charCode;
					System.out.println("Character at "+(j-1)+" is modified from "+data.charAt(j)+" to "+c+"");
					data.setCharAt(j,c);
					}
				}
				System.out.println(data+" after query"+i);
			}
			System.out.println(data);
		}
	}
}
