package com.hackerearth.codemonk.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class RecursiveSums{
        public static void main(String[] args) throws IOException{
                BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
                int noOfTestCases=Integer.parseInt(br.readLine());
                while(noOfTestCases-->0){
                        int M=Integer.parseInt(br.readLine());
			String[] block=null;
			Long digitSum=0l;
			while(M-->0){
				block = br.readLine().split(" ");
				Long len=Long.parseLong(block[0]);
				Long d=Long.parseLong(block[1]);
				digitSum+=sumOfDigit(d,len);	
			}
			System.out.println(sumOfDigit(digitSum,1));
                }
        }
	public static long sumOfDigit(long d,long len){
		long number=d*len;
		while(number>10){
			long temp=number;
			number=0;
			while(temp!=0){
				number+=temp%10;
				temp/=10;
			}
		}			
		return number;
	}
}

