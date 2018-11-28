package com.cryptopals.sets.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Hex2B64{
	public static void main(String args[]) throws IOException{
		System.out.println(getHex2B64("49276d206b696c6c696e6720796f757220627261696e206c696b65206120706f69736f6e6f7573206d757368726f6f6d"));
	}
	public static String base64ToXor(String bas64){
		return "";		
	}
	public static String getHex2B64(String hexString){
		byte[] hextobin={0b0000,0b0001,0b0010,0b0011,0b0100,0b0101,0b0110,0b0111,0b1000,0b1001,0b1010,0b1011,0b1100,0b1101,0b1110,0b1111
		};
		char[] base64="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();
		int padding=hexString.length()%3;
		if(padding>0){
			for(int i=0;i<=padding;i++){
				hexString+=0;
			}
		}
		String resultFinal="";
		for(int j=0;j<hexString.length();j+=6){
			String result="";
			int number=0;
			for(int i=j;i<j+6;i++){
				number=number<<4;
				number=number|hextobin[getIndex(hexString.charAt(i))];
			}
			int base64byte=number & 0x3F;
			result=base64[base64byte]+result;
			number=number>>6;
			base64byte=number & 0x3F;
			result=base64[base64byte]+result;
			number=number>>6;
			base64byte=number & 0x3F;
			result=base64[base64byte]+result;
			number=number>>6;
			base64byte=number & 0x3F;
			result=base64[base64byte]+result;
			resultFinal=resultFinal+result;
		}
		resultFinal=resultFinal.substring(0,resultFinal.length()-padding);
		for(int i=0;i<padding;i++){
			resultFinal+="#";
		}
		return resultFinal;
	}
	public static int getIndex(char c){
		if(c=='a'||c=='b'||c=='c'||c=='d'||c=='e'||c=='f'){
			return ((int)c-96)+9;
		}else{
			return Integer.parseInt(c+"");
		}
	}
}
