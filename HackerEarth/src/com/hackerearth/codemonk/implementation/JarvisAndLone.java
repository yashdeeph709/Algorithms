package com.hackerearth.codemonk.implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashSet;

public class JarvisAndLone{
	public static void main(String args[]) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int noOfTestCases=Integer.parseInt(br.readLine());
		while(--noOfTestCases>=0){
			int n=Integer.parseInt(br.readLine());
			HashSet<Integer> numbers=new HashSet<Integer>();
			while(--n>=0){
				int number=Integer.parseInt(br.readLine());	
				if(numbers.contains(number)){
					numbers.remove(number);
				}else{
					numbers.add(number);
				}
			}
			if(numbers.size()>0){
			for(Integer i:numbers){
				System.out.println(i);
				break;
			}
			}else{
				System.out.println(-1);
			}
		}	

	}
}
