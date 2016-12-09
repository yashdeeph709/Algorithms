package com.hackerearth.codemonk.implementation;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

class GiftForSagar{
	public static void main(String args[]) throws IOException,Exception{
		InputStreamReader is=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(is);
		int noOfTestcases=Integer.parseInt(br.readLine());
		while(noOfTestcases-->0){
			byte[] digits={0,0,0,0,0,0,0,0,0,0};
			br.readLine();
			String numbers=br.readLine().replaceAll("\\s", "");
			for(int i=0;i<numbers.length();i++){
				digits[Byte.parseByte(""+numbers.charAt(i))]++;
			}
			String answer="";
			for(int i=9;i>-1;i--){
				for(int j=0;j<digits[i];j++){
					answer+=i;
				}
			}
			System.out.println(answer);
		}
	}
}