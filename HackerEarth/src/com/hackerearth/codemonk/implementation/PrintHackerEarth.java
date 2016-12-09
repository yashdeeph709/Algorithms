package com.hackerearth.codemonk.implementation;

import java.util.Scanner;

public class PrintHackerEarth {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Scanner sc1 = new Scanner(System.in);
		int length = sc.nextInt();
		String str = sc1.nextLine();
		int[] freq=new int[26];
		int[] map={0,2,4,7,10,17,19};
		for(int i=0;i<str.length();i++){
			freq[(int)str.charAt(i)-97]++;
		}
		int mini=Integer.MAX_VALUE;
		for(int i=0;i<map.length;i++){
			if(i==0 || i==2 || i==5 || i==3){
				mini=min(mini,freq[map[i]]/2);
			}else if(i==1 || i==4 || i==6){
				mini=min(mini, freq[map[i]]); 
			}
		}
		System.out.println(mini);
	}
	public static int min(int a,int b){
		if(a>b){
			return b;
		}
		if(a<b){
			return a;
		}
		return a;
	}
}
