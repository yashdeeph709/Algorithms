package com.;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Template{
	public static void main(String args[]){
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br=new BufferedReader(new FileReader(args[0]));
		BufferedReader solutions=new BufferedReader(new FileReader(args[1]));
		int noOfTests=Integer.parseInt(br.readLine());
		while(noOfTests-->0){
			int actual=solution(br);
			String line=br.readLine();
			int expected=line.split(" ")[0];
			String message=line.split(" ")[1];
			if(actual==expected){
				System.out.println("Test Passed");
			}else{
				System.out.println("Test Failed at:");
				System.out.println(message);
			}
		}
	}
	public static int solution(BufferedReader br){
	
	}
}
