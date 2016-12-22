package com.hackerearth.codemonk.implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class FinalDestination{
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s=br.readLine();
		int x=0,y=0;
		for(int i=0;i<s.length();i++){
			switch(s.charAt(i)){
				case 'L':
					x--;
				break;
				case 'R':
					x++;
				break;
				case 'U':
					y++;
				break;
				case 'D':
					y--;
				break;
			}
		}
		System.out.println(x+" "+y);
	}
}