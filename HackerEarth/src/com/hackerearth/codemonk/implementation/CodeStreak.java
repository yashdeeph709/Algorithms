package com.hackerearth.codemonk.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CodeStreak{
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int noOfDays=Integer.parseInt(br.readLine());
		String logs=new String();
		int maxOfDay=0,maxOfAll=0;
		for(int i=0;i<noOfDays;i++){
			String temp=br.readLine();
			logs+=temp;
			int count=0;
		 	for(int j=0;j<temp.length();j++){
				if(temp.charAt(j)=='C'){
					count++;
				}
				if(temp.charAt(j)!='C' || j==temp.length()-1){
					if(count>maxOfDay){
						maxOfDay=count;
					}
					count=0;
				}
			}
			System.out.println(maxOfDay);
		}	
	        int count=0;	
		for(int j=0;j<logs.length();j++){
			if(logs.charAt(j)=='C'){
				count++;
			}
			if(logs.charAt(j)!='C' || j==logs.length()-1){
				if(count>maxOfAll){
					maxOfAll=count;
				}
				count=0;
			}
	
		}
		System.out.println(maxOfDay+" "+maxOfAll);
	}
}
