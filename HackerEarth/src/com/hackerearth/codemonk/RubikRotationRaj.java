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
			rows[index]++;
			rows[index] = rows[index] > N ? rows[index] % N : rows[index];
		}
		line = br.readLine().split(" ");
		int[] cols = new int[N];
		for (int i = 0; i < C; i++) {
			int index = Integer.parseInt(line[i]);
			cols[index]++;
			cols[index] = cols[index] > N ? cols[index] % N : cols[index];
		}
		int element = N % 2 == 0 ? N / 2 : (N / 2) - 1;
		int temp = Integer.MIN_VALUE;
		System.out.println(rows[0] + "" + rows[1] + "" + rows[2] + "" + rows[3]);
		// rows update
		for (int i = 0; i < rows.length; i++) {
			if (rows[i] > 0) {
				for (int j = 0; j < element; j++) {
					// swap element with i,j with i,rows[i]
					temp = matrix[i][j];
					matrix[i][j] = matrix[i][rows[i]+j];
					matrix[i][rows[i]+j] = temp;
				}
			}
		}
		printMatrix(matrix);
		// cols update
		System.out.println(cols[0] + "" + cols[1] + "" + cols[2] + "" + cols[3]);
		for (int i = 0; i < cols.length; i++) {
			if (cols[i] > 0) {
				for (int j = 0; j < element; j++) {
					temp = matrix[j][i];
					matrix[j][i] = matrix[cols[i]+j][i];
					matrix[cols[i]+j][i] = temp;
				}
			}
		}
		System.out.println("col tx");
		printMatrix(matrix);
	}

	public static void printMatrix(int[][] matrix) {
		System.out.println();
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
	public static void rotateColumn(int[][] matrix,int coln,int times){
		int temp=0;
		for(int i=0;i<matrix[coln].length;i+=times){
			if(i+times>matrix[coln].length){
				i=i%matrix[coln].length;
			}
			temp=matrix[i+times][coln];
			matrix[i+times][coln]=matrix[i][coln];
		}
	}
}
