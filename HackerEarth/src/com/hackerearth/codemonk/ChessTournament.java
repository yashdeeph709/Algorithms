package com.hackerearth.codemonk;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;

public class ChessTournament{
	public static void main(String args[]) throws IOException{
		InputStreamReader is=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(new FileReader("C:\\Users\\c5244128\\Desktop\\input-d9c39df.txt"));
//		BufferedReader br=new BufferedReader(is);

		int N=Integer.parseInt(br.readLine());
		int size=(int)Math.pow(2,N);
		int[][] array=new int[size][size];
		int[] winnings=new int[size];
		String[] numbers;
		for(int i=1;i<size;i++){
			numbers=br.readLine().split(" ");
			int winningstemp=0;
			for(int j=0;j<i;j++){
				array[i][j]=Integer.parseInt(numbers[j]);
				if(array[i][j]!=0){
					winningstemp++;
				}
			}
			if(winningstemp<=N){
				winnings[i]=winningstemp;
			}else{
				winnings[i]=0;
			}
		}
		for(int i=0;i<winnings.length;i++){
			System.out.println(i+" :"+winnings[i]);
		}
	}
}