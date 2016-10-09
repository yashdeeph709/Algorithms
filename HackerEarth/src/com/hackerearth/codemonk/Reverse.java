package com.hackerearth.codemonk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Reverse {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int noOfTestCases = Integer.parseInt(br.readLine());
		while(noOfTestCases-->0){
			String line=br.readLine();
			for(int i=line.length()-1;i>=0;i--){
				System.out.print(line.charAt(i));
			}
		}
	}

}
