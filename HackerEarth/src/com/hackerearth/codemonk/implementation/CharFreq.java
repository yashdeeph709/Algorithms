package com.hackerearth.codemonk.implementation;

import java.io.*;

public class CharFreq{
	public static void main(String args[]) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String str=br.readLine();
		char c=br.readLine().charAt(0);
		int n=Integer.parseInt(br.readLine());
		int positions[]=new int[str.length()];
		int counter=-1,maxFreq=0,maxPosition=0;
		if(str.length()==n){
			System.out.println(str.lastIndexOf(c+"")+1);
			return;
		}
		for(int i=0;i<=str.length()-n+1;i++){
			String sub=str.substring(i,i+n-1);
			int freq=0;
			for(int j=0;j<sub.length();j++){
				if(sub.charAt(j)==c){
					freq++;
				}
			}
			if(freq>=maxFreq){
				maxFreq=freq;
				maxPosition=i+n-1;
			}
		}
		if(n!=1){
			if(maxPosition==str.length()){
				System.out.println(-1);
			}else{
				System.out.println(maxPosition);
			}
		}else{
			System.out.println(-1);
		}	
	}
}