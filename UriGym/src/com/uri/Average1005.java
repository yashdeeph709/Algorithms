package com.uri;

import java.io.*;

public class Average1005{
	public static void main(String args[]) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		double a=Double.parseDouble(br.readLine());
		double b=Double.parseDouble(br.readLine());
		double d=(a*3.5+b*7.5)/11;
		System.out.printf("MEDIA = %.5f\n",d);
	}
}