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
//		printArray(rows);
		line = br.readLine().split(" ");
		int[] cols = new int[N];
		for (int i = 0; i < C; i++) {
			int index = Integer.parseInt(line[i]);
			cols[index - 1]++;
			cols[index - 1] = cols[index - 1] > N ? cols[index - 1] % N : cols[index - 1];
		}
//		printArray(cols);		
		for (int i = 0; i < rows.length; i++) {
			if(rows[i]>0){
				rotateRow(matrix, rows[i], i);
			}
		}
//		printMatrix(matrix);
		for (int i = 0; i < cols.length; i++) {
			if(cols[i]>0){
				rotateColumn(matrix, cols[i], i);
			}
		}
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
	
	public static void printArray(int[] array){
		for(int i=0;i<array.length;i++){
			System.out.print(array[i]);
		}
	}
	public static void rotateColumn(int[][] arr, int order, int columnnumber) {
		int[] extras=new int[order];
		int j=0;
//		System.out.println("\norder of rotation is:"+order);
		//write outofbound elements to covered area
		for(int i=arr.length-1;j<order;i--){
//			System.out.println("["+i+","+columnnumber+"]");
			extras[j]=arr[i][columnnumber];
			j++;
		}
//		printArray(extras);
		// move from last to first
		for(int i=arr.length-order-1;i>=0;i--){
			arr[i+order][columnnumber]=arr[i][columnnumber];
		}
		for(int i=0;i<extras.length;i++){
			arr[i][columnnumber]=extras[extras.length-1-i];
		}
	}
 
	public static void rotateRow(int[][] arr, int order, int rownumber) {
		int[] extras=new int[order];
		int j=0;
//		System.out.println("\norder of rotation is:"+order);
		//write outofbound elements to covered area
		for(int i=arr.length-1;j<order;i--){
//			System.out.println("["+rownumber+","+i+"]");
			extras[j]=arr[rownumber][i];
			j++;
		}
//		printArray(extras);
		// move from last to first
		for(int i=arr.length-order-1;i>=0;i--){
			arr[rownumber][i+order]=arr[rownumber][i];
		}
		for(int i=0;i<extras.length;i++){
			arr[rownumber][i]=extras[extras.length-1-i];
		}
	}
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.InputMismatchException;
 
class RubiksSquare2 {
 
	private static PrintWriter out = new PrintWriter(System.out);
	private static InputStreamReader in;
 
	public static void main(String args[]) throws Exception {
		InputStream is = RubiksSquare2.class.getResourceAsStream(RubiksSquare2.class.getSimpleName() + ".in");
		boolean testMode = is != null;
		
		in = new InputStreamReader(testMode ? is : System.in);
 
		long start = System.currentTimeMillis();
		main();
 
		if (testMode) {
			out.println();
			out.print(System.currentTimeMillis() - start + " ms");
		}
 
		out.close();
	}
 
	private static class InputStreamReader {
		private byte[] buf = new byte[1 << 8];
		private int curChar;
		private int charsRead;
		private InputStream stream;
 
		public InputStreamReader(InputStream stream) {
			this.stream = stream;
		}
 
		public int readInt() throws IOException {
			int c = read();
			while (skip(c))
				c = read();
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = read();
			}
			int res = 0;
			do {
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = read();
			} while (!skip(c));
			return res * sgn;
		}
 
		public long readLong() throws IOException {
			int c = read();
			while (skip(c))
				c = read();
			long sgn = 1L;
			if (c == '-') {
				sgn = -1L;
				c = read();
			}
			long res = 0L;
			do {
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res *= 10L;
				res += c - '0';
				c = read();
			} while (!skip(c));
			return res * sgn;
		}
 
		private int read() throws IOException {
			if (charsRead == -1)
				throw new InputMismatchException();
			if (curChar >= charsRead) {
				curChar = 0;
				charsRead = stream.read(buf);
				if (charsRead <= 0)
					return -1;
			}
			return buf[curChar++];
		}
 
		private static boolean skip(int c) {
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}
	}
 
	private static void main() throws Exception {
		int N = in.readInt();
		int R = in.readInt();
		int C = in.readInt();
		int ROW_COUNTS = N;
		int COL_COUNTS = N + 1;
 
		int[][] mat = new int[N + 2][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				mat[i][j] = in.readInt();
			}
		}
		for (int i = 0; i < R; i++) {
			++mat[ROW_COUNTS][in.readInt() - 1];
		}
		for (int i = 0; i < C; i++) {
			++mat[COL_COUNTS][in.readInt() - 1];
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int y = (i + N - mat[COL_COUNTS][j] % N) % N;
				int x = (j + N - mat[ROW_COUNTS][y] % N) % N;
				if (j > 0)
					out.print(" ");
				out.print(mat[y][x]);
			}
			out.println();
		}
 
	}
 
}