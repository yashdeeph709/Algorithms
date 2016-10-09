package com.hackerearth.codemonk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GoodBadStrings {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int noOfTestcases = Integer.parseInt(br.readLine());
		while(noOfTestcases-->0){
			String input = br.readLine();
			char previous = input.charAt(0);
			String result = previous+"";
			for(int i=1;i<input.length();i++){
				if(previous != input.charAt(i)){
					result += input.charAt(i);
				}
				previous = input.charAt(i);
			}
			System.out.println(result);
		}
	}

}
