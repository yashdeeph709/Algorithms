package com.sedgewick;

public class Transposition{
	public static void main(String args[]){
		int[][] matrix=new int[3][3];
		printMatrix(matrix);			
	}
	public static int[][] transpose(int[][] matrix){
		return null;	
	}
	public static void printMatrix(int[][] matrix){
		for(int i=0;i<matrix.length;i++){
			for(int j=0;j<matrix[i].length;j++){
				System.out.print(" "+matrix[i][j]+" "); 
			}
			System.out.println();
		}
	}
}
