package com.topcoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CoinSearchDP{
	public static void main(String args[]) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int noOfTestcases=Integer.parseInt(br.readLine());
		while(noOfTestcases-->0){
			int noOfDenomination=Integer.parseInt(br.readLine());
			int denominations[]=new int[noOfDenomination];
			String line[]=br.readLine().split(" ");
			int i=0;
			while(noOfDenomination-->0){
				denominations[i]=Integer.parseInt(line[i]);
				i++;
			}
			int targetSum=Integer.parseInt(br.readLine());
				
		}
	}
}
