package com.uri;

import java.io.*;

public class SimpleSum1003{
	public static void main(String args[]) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int A=Integer.parseInt(br.readLine());
		int B=Integer.parseInt(br.readLine());
		int SOMA=A+B;
		System.out.printf("SOMA = %d\n",SOMA);
	}
}