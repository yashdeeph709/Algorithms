package com.RangDe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DistinctPowers{
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int noOfTestCases=Integer.parseInt(br.readLine());
		while(noOfTestCases-->0){
			int number=Integer.parseInt(br.readLine());
			int mask=0x01;
			int result=0;
			boolean flag=true;
			for(int i=0;i<32;i++){
				if((number & mask)!=0){
					result+=twoPower(i);	
					System.out.println(1+" "+result);
				}else{
					if(flag){
						result+=twoPower(i);
						System.out.println("first 0 switching it to 1 "+result);
						flag=false;	
					}else{	
						System.out.print(0);
					}
				}
				mask=mask << 1;
			}
			System.out.println(result);
		}
	}
	public static int twoPower(int i){
		if(i<=0){
			return 1;
		}else{
			return 2<<i-1;	
		}
	}
}
