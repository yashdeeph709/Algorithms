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
		System.out.println();
		int[] rows = new int[N];
		for (int i = 0; i < R; i++) {
			int index = Integer.parseInt(line[i]);
			rows[index - 1]++;
			rows[index - 1] = rows[index - 1] > N ? rows[index - 1] % N : rows[index - 1];
		}
		printArray(rows);
		line = br.readLine().split(" ");
		int[] cols = new int[N];
		for (int i = 0; i < C; i++) {
			int index = Integer.parseInt(line[i]);
			cols[index - 1]++;
			cols[index - 1] = cols[index - 1] > N ? cols[index - 1] % N : cols[index - 1];
		}
		int[] extras = new int[N];
		printArray(cols);
		for (int i = 0; i < rows.length; i++) {
			if (rows[i] > 0) {
				rotateRow(matrix, rows[i], i, extras);
			}
		}
		printMatrix(matrix);
		for (int i = 0; i < cols.length; i++) {
			if (cols[i] > 0) {
				rotateColumn(matrix, cols[i], i, extras);
			}
		}
//		printMatrix(matrix);
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

	public static void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]);
		}
	}

	public static void rotateColumn(int[][] arr, int order, int columnnumber, int[] extras) {
		int j = 0;
		// System.out.println("\norder of rotation is:"+order);
		// write outofbound elements to covered area
		for (int i = arr.length - 1; j < order; i--) {
			// System.out.println("["+i+","+columnnumber+"]");
			extras[j] = arr[i][columnnumber];
			j++;
		}
		int length = j;
		// printArray(extras);
		// move from last to first
		for (int i = arr.length - order - 1; i >= 0; i--) {
			arr[i + order][columnnumber] = arr[i][columnnumber];
		}
		for (int i = 0; i < length; i++) {
			arr[i][columnnumber] = extras[length - i];
		}
	}

	public static void rotateRow(int[][] arr, int order, int rownumber, int[] extras) {
		int j = 0;
		// System.out.println("\norder of rotation is:"+order);
		// write outofbound elements to covered area
		for (int i = arr.length - 1; j < order; i--) {
			// System.out.println("["+rownumber+","+i+"]");
			extras[j] = arr[rownumber][i];
			j++;
		}
		int length = j;
		// printArray(extras);
		// move from last to first
		for (int i = arr.length - order - 1; i >= 0; i--) {
			arr[rownumber][i + order] = arr[rownumber][i];
		}
		for (int i = 0; i < length; i++) {
			arr[rownumber][i] = extras[length - i];
		}
	}
}
