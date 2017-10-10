////package com.hackerearth.codemonk.bitwise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OddFreq{
	public static void main(String args[]) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		//int noOfTests=Integer.parseInt(br.readLine());
		//while(noOfTests-->0){
			int n = Integer.parseInt(br.readLine());
			String[] numbers= br.readLine().split(" ");
			System.out.println(oddFreqFinder(numbers));
		//}
	}
	public static int oddFreqFinder(String[] numbers){
		int result=0;
		for(int i=0;i<numbers.length;i++){
			result=result^Integer.parseInt(numbers[i]);
		}
		return result;
	}
}
