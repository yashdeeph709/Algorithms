package com.hackerrank;
import java.util.Scanner;

public class CavityMap {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int size=sc.nextInt();
		int mat[][]=new int[size][size];
		for(int i=0;i<size;i++){
			String s=sc.next();
			for(int j=0;j<size;j++){
				mat[i][j]=Integer.parseInt(""+s.charAt(j));
			}
		}
		String matu[]=findCavity(mat);
			for(int j=0;j<size;j++){
				System.out.println(matu[j]);
			}
	}

	private static String[] findCavity(int[][] mat) {
		String matu[]=new String[mat.length];
		for(int i=0;i<mat.length;i++){
			String s="";
			for(int j=0;j<mat[i].length;j++){
				if(i>0 && j>0 && j<mat[i].length-1 && i<mat.length-1 && checkNeibours(mat, i, j)){
					s+="X";
				}else{
					s+=mat[i][j];
				}
			}
			matu[i]=s;
		}
		return matu;
	}
	private static boolean checkNeibours(int[][] mat,int i,int j){
		if(i==mat.length-1 && j==mat.length-1 && i>0 && j>0){
			return false;
		}
		if(mat[i][j]>mat[i+1][j] && mat[i][j]>mat[i][j+1] && mat[i][j]>mat[i-1][j] && mat[i][j]>mat[i][j-1]){
			return true;
		}
		return false;
	}
}
