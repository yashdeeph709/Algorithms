package com.hackerearth.codemonk;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class RubikRotationRaj {

	public static void main(String[] args) throws IOException {
		InputStreamReader is = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(is);
		String[] line = br.readLine().split(" ");
		int N = Integer.parseInt(line[0]), R = Integer.parseInt(line[1]), C = Integer.parseInt(line[2]);
		int[][] matrix = new int[N][N];
		for (int i = 0; i < N; i++) {
			line = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				matrix[i][j] = Integer.parseInt(line[j]);
			}
		}
		line = br.readLine().split(" ");
		int[] rows = new int[N];
		for (int i = 0; i < R; i++) {
			int index = Integer.parseInt(line[i]);
			rows[index-1]++;
			rows[index-1] = rows[index-1] > N ? rows[index-1] % N : rows[index-1];
		}
		line = br.readLine().split(" ");
		int[] cols = new int[N];
		for (int i = 0; i < C; i++) {
			int index = Integer.parseInt(line[i]);
			cols[index-1]++;
			cols[index-1] = cols[index-1] > N ? cols[index-1] % N : cols[index-1];
		}
		
		for(int i=0;i<rows.length;i++){
			rotateRow(matrix,rows[i],i);
		}
		printMatrix(matrix);
/*		for(int i=0;i<cols.length;i++){
			rotateColumn(matrix,cols[i],i);
		}
		printMatrix(matrix);
*/	}

	public static void printMatrix(int[][] matrix) {
		System.out.println();
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void rotateColumn(int[][] arr, int order,int columnnumber) {
		if (arr == null || order < 0) {
		    throw new IllegalArgumentException("Illegal argument!");
		}
	 
		for (int i = 0; i < order; i++) {
			for (int j = arr.length - 1; j > 0; j--) {
				int temp = arr[j][columnnumber];
				arr[j][columnnumber] = arr[j - 1][columnnumber];
				arr[j - 1][columnnumber] = temp;
			}
		}
	}
	public static void rotateRow(int[][] arr, int order,int rownumber) {
		if (arr == null || order < 0) {
		    throw new IllegalArgumentException("Illegal argument!");
		}
	 
		for (int i = 0; i < order; i++) {
			for (int j = arr.length - 1; j > 0; j--) {
				int temp = arr[rownumber][j];
				arr[rownumber][j] = arr[rownumber][j-1];
				arr[rownumber][j-1] = temp;
			}
		}
	}
}
