package com.certification.foundations.recursion;

import java.io.*;

class FitSquares{
	/*public static void main(String args[]){
		int[] array=new int[]{1,2,3,4,5,6,7,8,9,10,11};
		for(int i=0;i<array.length;i++){
			System.out.println(numberOfSquares(array[i]));
		}
	}*/
	public static void main(String args[]) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0){
			System.out.println(numberOfSquares(Integer.parseInt(br.readLine())));
		}	
	}
	public static int numberOfSquares(int base){
		if(base==4){
			return 1;
		}
		if(base<4){
			return 0;
		}
		base=base%2==0?base:base-1;
		return ((base/2)-1)+numberOfSquares(base-2);
	}
}
