package com.hackerrank;

import java.util.Scanner;

public class CeaserCipher {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int size=sc.nextInt();
		String payload=sc.next();
		int key=sc.nextInt();
		System.out.println(encrypt(payload,key));
	}

	private static String encrypt(String payload, int key) {
		String out="";
		key=key%26;
		for(int i=0;i<payload.length();i++){
			int charcode=(int)payload.charAt(i);
			if(charcode>=65 && charcode<=90){	
				if(charcode+key>90){
					charcode=64+(charcode+key)%90;
				}else{
					charcode=charcode+key;
				}
			}
			if(charcode>=97 && charcode<=122){
				if(charcode+key>122){
					charcode=96+(charcode+key)%122;
				}else{
					charcode=charcode+key;
				}
			}
			out+=(char)charcode;
		}
		return out;
	}

}
