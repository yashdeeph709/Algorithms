package com.hackerearth.codemonk.implementation;

import java.io.BufferedReader;
import java.util.*;
import java.util.Comparator;
import java.io.IOException;
import java.io.InputStreamReader;

public class JarvisSevenSegments{
	public static void main(String args[]) throws IOException{
		System.out.println(calcEnergy(27)+"="+calcEnergy(411));
		System.out.println(calcEnergy(1313)+"="+calcEnergy(4177));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int noOfTests = Integer.parseInt(br.readLine());
		while(noOfTests-->0){
			int length= Integer.parseInt(br.readLine());	
			Integer[] array=new Integer[length];
			String[] numbers=br.readLine().split(" ");
			for(int i=0;i<length;i++){
				array[i] = Integer.parseInt(numbers[i]);
			}
			int min=array[0];
			for(int i=1;i<array.length;i++){
				int newt=calcEnergy(array[i]);
				if(newt<calcEnergy(min)){
					min=array[i];
				}			
			}
			System.out.println(min);			
		}	
	}	
	public static void printArray(Integer[] array){
		for(int i=0;i<array.length;i++){
			System.out.println(array[i]);
		}
	}	
	public static int calcEnergy(int num){
		int[] digitEnergy={6,2,5,5,4,5,6,3,7,6};
		int sum=0;
		if(num==0){
			return digitEnergy[0];
		}
		while(num>0){
	               sum+=digitEnergy[num%10];
		       num=num/10;
		}
		return sum;
	}
}
