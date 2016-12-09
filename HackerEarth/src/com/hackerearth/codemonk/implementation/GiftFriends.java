package com.hackerearth.codemonk.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GiftFriends {
	/**
	 * TestCases:
3
5
24
1 2 3 4 16 1 5
10
240
120 120 0 0 0 0 0 0 0 0
8
32
2 2 2 2 2 2 2 32
	 * 
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int noOfTestCases = Integer.parseInt(br.readLine());
		
		while(noOfTestCases-->0){
			System.out.println("TestCases"+noOfTestCases);
			String data = br.readLine();
			int noOfFriends = Integer.parseInt(data.split(" ")[0]);
			int cost = Integer.parseInt(data.split(" ")[1]);
			int costs[] = new int[noOfFriends];
			String costsList=null;
			for(int i=0;i<noOfFriends;i++){
				costs[i]=Integer.parseInt(br.readLine());
			}
			int start=0,sum=costs[0];
			for(int i=1;i<noOfFriends;i++){
				if(sum==cost){
					break;
				}
				sum+=costs[i];
				while(sum>cost){
					sum -= costs[start];
					start++;
				}
				
			}
			System.out.println("sum="+sum+"start="+start);
			if(sum==cost){
				System.out.println("YES");
			}else{
				System.out.println("NO");
			}
		}
	}

}
