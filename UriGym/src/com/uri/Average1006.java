package com.uri;

import java.io.*;

public class Average1006{
	public static void main(String args[]) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		double a=Double.parseDouble(br.readLine());
		double b=Double.parseDouble(br.readLine());
		double c=Double.parseDouble(br.readLine());
		double d=(a*2+b*3+c*5)/10;
		System.out.printf("MEDIA = %.1f\n",d);
	}
}