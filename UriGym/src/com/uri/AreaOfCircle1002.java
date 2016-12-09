package com.uri;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class AreaOfCircle1002{
	public static void main(String args[]) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		double a=Double.parseDouble(br.readLine());
		double pi=3.14159;
		System.out.printf("A=%.4f\n",(pi*a*a));
	}
}