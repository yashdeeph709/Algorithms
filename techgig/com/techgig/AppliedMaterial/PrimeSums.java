package com.techgig.AppliedMaterial;

import java.io.*;
import java.util.*;

public class PrimeSums{
	static boolean isPrime[]=new boolean[1000000];

	public static void main(String args[]) throws Exception{
		nsieveOfEratosthenes();
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int k=Integer.parseInt(br.readLine());
		int size=Integer.parseInt(br.readLine());
		int[] data=new int[size];
		for(int i=0;i<data.length;i++){
			data[i]=Integer.parseInt(br.readLine());
		}
		
	/*	int[] number=checkNumber(53);
		if(number==null){
			return;
		}
		*/
		//System.out.println(number[0]+" "+number[1]);
		System.out.println(primeDiv(data,k)?1:-1);
		//System.out.println(pieces(123124,5));
		//System.out.println(pieces(154,4));
		//System.out.println(pieces(77,3));
	}
	public static boolean primeDiv(int[] data,int k){
		for(int i=0;i<=k-1;i++){
			int sum=0,count=0;
			for(int j=i;j<data.length;j+=k){
				sum+=data[j];
				count++;
			}
			//System.out.println("running for "+sum+" "+count);
			if(!pieces(sum,count)){
				return false;
			}
		}
		return true;
	}
	public static boolean pieces(int num,int count){
		for(int i=0;i<count-1;i++){
			int[] result=checkNumber(num);
			if(result==null){
				return false;
			}else{
				num=result[0]>result[1]?result[0]:result[1];
			}
		}
		return true;
	}
	public static int[] checkNumber(int num){
		for(int i=0;i<num;i++){
			//System.out.println("checking for "+i+" "+(num-i));
			if(isPrime[i] && isPrime[num-i]){
				return new int[]{i,num-i};
			}
		}
		return null;
	}
	public static void nsieveOfEratosthenes(){
			int n=isPrime.length-1;
			isPrime[0]=isPrime[1]=false;
			for(int i=2;i<=n;i++){
				isPrime[i]=true;
			}
			for(int p=2;p*p<=n;p++){
				if(isPrime[p]){
					for(int i=p*2;i<=n;i+=p){
						isPrime[i]=false;
					}
				}
			}
	}
}
