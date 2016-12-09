package com.uri;

import java.io.*;

public class Difference1007{
	public static void main(String args[]) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int a=Integer.parseInt(br.readLine());
		int b=Integer.parseInt(br.readLine());
		int c=Integer.parseInt(br.readLine());
		int d=Integer.parseInt(br.readLine());
		int e=a*b-c*d;
		System.out.printf("DIFERENCA = %d\n",e);
	}
}