package com.hackerearth.codemonk.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class War{
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int noOfTestcases=Integer.parseInt(br.readLine());
		while(noOfTestcases-->0){
			int length=Integer.parseInt(br.readLine());
			int alice[]=new int[length];
			int bob[]=new int[length];
			String[] line=br.readLine().split(" ");
			for(int i=0;i<length;i++){
				alice[i]=Integer.parseInt(line[i]);				
			}
			line=br.readLine().split(" ");
			for(int i=0;i<length;i++){
				bob[i]=Integer.parseInt(line[i]);
			}
			int max1=Integer.MIN_VALUE,max2=Integer.MIN_VALUE;
			for(int i=0;i<length;i++){
				if(alice[i]>max1){
					max1=alice[i];
				}
				if(bob[i]>max2){
					max2=bob[i];
				}
			}
			if(max1>max2){
				System.out.println("Bob");
			}else if(max2>max1){
				System.out.println("Alice");
			}else{
				System.out.println("Tie");
			}
		}
	}
}