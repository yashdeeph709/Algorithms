package com.uri;

import java.io.*;

public class SimpleProduct1004{
	public static void main(String args[]) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int a=Integer.parseInt(br.readLine());
		int b=Integer.parseInt(br.readLine());
		System.out.printf("PROD = %d\n",(a*b));
	}
}