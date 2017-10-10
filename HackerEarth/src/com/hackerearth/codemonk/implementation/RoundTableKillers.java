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
		int gunner=X;
		int remains=N;
		while(true){
			//System.out.println("Gunner Changed:"+gunner);
			int toBeKilled = gunner%K;			
			if(toBeKilled==0){
				gunner=gunner>=N?1+(N-gunner):gunner+1;
				//System.out.println("toBeKilled==0 so gunner shifts to "+gunner);
				continue;
			}
			if(toBeKilled>=remains){
				//System.out.println("remaining is less that to be killed"+gunner);
				return gunner;
			}
			int nextVictim = gunner>=N?1+(N-gunner):gunner+1;
			//System.out.println("nextVictim is "+nextVictim);
			while(true){
				if(toBeKilled==0){
					//System.out.println("Gun is in"+gunner);
					while(table[nextVictim]==-1){
						nextVictim = nextVictim>=N?1+(N-nextVictim):nextVictim+1;
					}
					gunner=nextVictim;
					break;
				}
				if(table[nextVictim]!=-1){
					table[nextVictim]=-1;
					toBeKilled--;
					remains--;
					//System.out.println("Killed"+nextVictim+"toBeKilled"+toBeKilled+"remains"+remains);
				}	
				nextVictim = nextVictim>=N?1+(N-nextVictim):nextVictim+1;
				//System.out.println("nextVictim is"+nextVictim);
			}
		}
	}
}
