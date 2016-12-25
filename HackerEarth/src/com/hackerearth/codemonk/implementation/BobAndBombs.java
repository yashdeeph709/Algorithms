package com.hackerearth.codemonk.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BobAndBombs{
	public static void main(String args[]) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int noOfTestcases=Integer.parseInt(br.readLine());
		while(noOfTestcases-->0){
			String line=br.readLine();
			char[] sb=new char[line.length()];
			for(int i=0;i<line.length();i++){
				sb[i]=line.charAt(i);
			}
			for(int i=0;i<line.length();i++){
				if(line.charAt(i)=='B'){
					if(i>0){
						sb[i-1]=sb[i-1]=='B'?'B':'-';
					}
					if(i>1){
						sb[i-2]=sb[i-2]=='B'?'B':'-';
					}
					if(i<line.length()-1){
						sb[i+1]=sb[i+1]=='B'?'B':'-';
					}
					if(i<line.length()-2){
						sb[i+2]=sb[i+2]=='B'?'B':'-';
					}
				}
			}
/*			for(int i=0;i<line.length();i++){
				System.out.print(sb[i]);
			}
*/			int count=0;
			for(int i=0;i<sb.length;i++){
				if(sb[i]=='-'){
					count++;
				}
			}
			System.out.println("\n"+count);
		}
	}
}