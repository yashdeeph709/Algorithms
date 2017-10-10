package com.hackerearth.codemonk.implementation;

import java.io.*;
import static java.util.stream.Collectors.*;
import java.util.*;

public class OddSequence{
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int noOfTests=Integer.parseInt(br.readLine());
		while(noOfTests-->0){
			int length=Integer.parseInt(br.readLine());
			List<Integer> numbers=Arrays.asList(br.readLine().split(" ")).stream().map(Integer::valueOf).collect(toList());
			System.out.println(isSubed(numbers)?"Yes":"No");
		}
	}
	public static boolean isSubed(List<Integer> numbers){
		for(Integer i: numbers){
			if(i%2!=0){
				return true;
			}
		}
		return false;
	}
}
