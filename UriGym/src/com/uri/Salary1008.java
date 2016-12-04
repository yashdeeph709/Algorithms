package com.uri;

import java.io.*;

public class Salary1008{
	public static void main(String args[]) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int a=Integer.parseInt(br.readLine());
		int b=Integer.parseInt(br.readLine());
		float c=Float.parseFloat(br.readLine());
		System.out.printf("NUMBER = %d\n",a);
		System.out.printf("SALARY = U$ %.2f\n",(b*c));
	}
}