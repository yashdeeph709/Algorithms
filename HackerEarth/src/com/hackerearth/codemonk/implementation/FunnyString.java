package com.hackerearth.codemonk.implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class FunnyString{
	public static void main(String args[]) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String line=br.readLine();
		line=br.readLine();
		String[] numbers=line.split(" ");
		int[][] store=new int[numbers.length][2];
		for(int i=0;i<numbers.length;i++){
			int number=Integer.parseInt(numbers[i]);	
			if(store[number][0]==0){
				store[number][0]=i+1;
			}else{
				store[number][1]=i+1;
			}
		}
		/*for(int i=0;i<store.length;i++){
			System.out.println(store[i][0]+" "+store[i][1]);
		}*/
		int max=Integer.MIN_VALUE;
		for(int i=1;i<store.length;i++){
			if(store[i][1]-store[i][0]>max){
				max=store[i][1]-store[i][0];
			}
		}
		System.out.println(max+1);
	}
}
