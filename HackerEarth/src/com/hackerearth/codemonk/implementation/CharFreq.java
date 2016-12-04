package com.hackerearth.codemonk.implementation;

import java.io.*;

public class CharFreq{
	public static void main(String args[]) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String str=br.readLine();
		char c=br.readLine().charAt(0);
		int n=Integer.parseInt(br.readLine());
		int positions[]=new int[str.length()];
		
		if(n!=1){
			System.out.println(maxPos);
		}else{
			System.out.println(-1);
		}	
	}
}