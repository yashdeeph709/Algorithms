package com.hackerearth.codemonk.implementation;

import java.util.Scanner;

public class FacebookPhoto {

	/**
	 * 	TestCases:
	 * 			h>idealsize && w==idealSize 
	 * 			h<idealsize && w==idealSize 
	 * 			h=idealsize && w==idealSize 
	 * 			h=0 && w==idealSize 
	 * 			h>idealsize && w>idealSize 
	 * 			h<idealsize && w>idealSize 
	 * 			h=idealsize && w>idealSize 
	 * 			h=0 && w>idealSize 
	 * 			h>idealsize && w<idealSize 
	 * 			h<idealsize && w<idealSize 
	 * 			h=idealsize && w<idealSize 
	 * 			h=0 && w<idealSize 
	 */
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int idealSize = sc.nextInt();
		int noOfTestCases = sc.nextInt();
		while(noOfTestCases-->0){
			int height = sc.nextInt();
			int width = sc.nextInt();
			if(height<idealSize || width<idealSize){
				System.out.println("UPLOAD ANOTHER");
				continue;
			}
			if(height>=idealSize || width>=
					idealSize){
				if(height==width){
					System.out.println("ACCEPTED");
				}else{
					System.out.println("CROP IT");
				}
			}
		}
	}
}
