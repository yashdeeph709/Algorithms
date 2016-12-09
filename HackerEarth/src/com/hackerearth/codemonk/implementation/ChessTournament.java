package com.hackerearth.codemonk.implementation;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class ChessTournament{
	static int[][] array;
	static int counter=0;
	public static void main(String args[]) throws IOException{
		InputStreamReader is=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(is);
	//	BufferedReader br=new BufferedReader(new FileReader("C:\\Users\\c5244128\\Desktop\\HackerZone\\HackerEarth\\src\\com\\hackerearth\\codemonk\\sorting\\chesstournament.txt"));

		int N=Integer.parseInt(br.readLine());
		int size=(int)Math.pow(2,N);
		array=new int[size][size];
		String[] numbers;
		for(int i=1;i<size;i++){
			numbers=br.readLine().split(" ");
			for(int j=0;j<i;j++){
				array[i][j]=Integer.parseInt(numbers[j]);
			}
		}
		System.out.println(findWinner(0,array.length-1)+1);
	}
	public static int findWinner(int a,int b){
		if(b-a==1){
			return array[b][a]==0?a:b;
		}else{
			int mid=((b-a)/2)+a;
			int winner1=findWinner(a, mid);
			int winner2=findWinner(mid+1, b);
			return array[winner2][winner1]==0?winner1:winner2;
		}
	}
}