package com.hackerearth.redlock;

import java.io.*;

class MatrixRangeQueries{

	/*public static void main(String args[]){
		int[][] matrix=new int[][]{
			{1,4},{2,5}
		};
		int[] resultant=new int[4];
		queryBuilder(matrix,resultant);	
		printArray(resultant);
	}*/
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int r=Integer.parseInt(br.readLine().trim());
		int c=Integer.parseInt(br.readLine().trim());
		int[][] matrix=new int[r][c];
		for(int i=0;i<matrix.length;i++){
			String[] tokens=br.readLine().split(" ");
			for(int j=0;j<matrix[i].length;j++){
				matrix[i][j]=Integer.parseInt(tokens[j]);
			}
		}
		int[] resultant=new int[r*c];
		//printMatrix(matrix);
		queryBuilder(matrix,resultant);
		int q=Integer.parseInt(br.readLine().trim());
		int m=Integer.parseInt(br.readLine().trim());
		int[] results=new int[q];
		for(int i=0;i<q;i++){
			String[] mask=br.readLine().split(" ");
			long start=Long.parseLong(mask[0]);
			long end=Long.parseLong(mask[1]);
			results[i]=findCountOfMatch(resultant,start,end);
		}	
		for(int i=0;i<q;i++){
			System.out.print(results[i]+" ");
		}
		//printArray(resultant);
	}
	public static  int findCountOfMatch(int[] resultant,long start,long end){
		int count=0;	
		for(int i=0;i<resultant.length;i++){
			if(start<=resultant[i] && end>=resultant[i]){
				count++;
			}
		}
		return count;
	}
	public static void printMatrix(int[][] matrix){
		for(int i=0;i<matrix.length;i++){
			for(int j=0;j<matrix[i].length;j++){
				System.out.printf("%d,",matrix[i][j]);
			}
			System.out.println();
		}
	}
	public static void printArray(int[] array){
		for(int i=0;i<array.length;i++){
			System.out.printf("%d,",array[i]);
		}
		System.out.println();
	}

	public static void queryBuilder(int[][] matrix,int[] resultant){
		int count=0;
		for(int i=0;i<matrix.length;i++){
			int rowsum=0;
			for(int j=0;j<matrix[i].length;j++){
				rowsum+=matrix[i][j];
			}
			resultant[count]=rowsum;
			count++;
		}
		for(int i=0;i<matrix[0].length;i++){
			int colsum=0;
			for(int j=0;j<matrix.length;j++){
				colsum+=matrix[j][i];
			}
			resultant[count]=colsum;
			count++;
		}
	}
}
