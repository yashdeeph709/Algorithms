package com.hackerearth.codemonk.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import java.io.InputStreamReader;

public class RoundTableKillers{
	public static void main(String args[]) throws IOException{
		BufferedReader br=new BufferedReader(new FileReader("tests/com/hackerearth/codemonk/implementation/RoundTableKillers/BaseCases.txt"));
		//BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int noOfTests=Integer.parseInt(br.readLine());
		while(noOfTests-->0){
			String line=br.readLine();
			int N = Integer.parseInt(line.split(" ")[0]);
			int K = Integer.parseInt(line.split(" ")[1]);
			int X = Integer.parseInt(line.split(" ")[2]);
			int survivor = findSurvivor(N,K,X);
			System.out.println(survivor);
		}
	}
	public static int findSurvivor(int N,int K,int X){
		int[] table = new int[N+1];
		int killed = 0;
		int survivor = -1;
		while(true){
			int toBeKilled=X%K;
			int i=X+1>N?1:X+1;
			if((N-killed)<toBeKilled){
				break;	
			}
			while(toBeKilled!=0){
				if(table[i]!=-1 && i!=X){
					table[i]=-1;
					toBeKilled--;
					killed++;
				}
				i=i+1>N?1:i+1;
			}
			System.out.println("People Killed:"+killed);
			X=i;
		}
		return X>N?1:X;
	}

}
