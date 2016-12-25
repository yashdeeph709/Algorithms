package com.hackerearth.codemonk.implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class PerfectBaseline{
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int noOfTestCases=Integer.parseInt(br.readLine());
		while(noOfTestCases-->0){
			String[] inputLine=br.readLine().split(" +");
			int N=Integer.parseInt(inputLine[0]);
			int K=Integer.parseInt(inputLine[1]);
			ArrayList<String> names=new ArrayList<String>();
			while(N-->0){
				names.add(br.readLine());
			}
			String result="";
			int k=0;
			N=names.size();
			while(K-->0){
				ArrayList<String> charName=new ArrayList<String>();
				for(String s:names){
					charName.add(""+s.charAt(k));
				}
				k++;
				Collections.sort(charName);
				//System.out.println("char id is "+(N%2==0?N/2-1:N/2)+" "+charName.get(N%2==0?N/2-1:N/2));
				result+=charName.get(N%2==0?(N/2)-1:(N/2));
			}
			System.out.println(result);
		}
	}
}
