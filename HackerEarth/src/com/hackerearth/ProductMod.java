package com.hackerearth;

import java.util.Scanner;

public class ProductMod {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long result = 1;
		while(true){
			int a = sc.nextInt();
			if(a!=42){
				System.out.println(a);
			}else{
				break;
			}
		}
	}

}
