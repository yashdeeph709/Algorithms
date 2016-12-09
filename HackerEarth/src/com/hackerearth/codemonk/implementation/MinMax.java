package com.hackerearth.codemonk.implementation;

import java.util.Arrays;
import java.util.Scanner;

public class MinMax {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int array[] = new int[n];
		while (--n >= 0) {
			array[n] = sc.nextInt();
		}
		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		for (int i = 0; i < array.length; i++) {
			if (array[i] < min) {
				min = array[i];
			}
			if (array[i] > max) {
				max = array[i];
			}
		}
		System.out.println("Minimum is: " + min + ", Maximum is: " + max);
		Arrays.sort(array);
		boolean flag=true;
		for (int i = min+1; i < max; i++) {
			if (0 > binarySearch(i, 0, array.length - 1, array)) {
				flag=false;
				break;
			}
		}
		if(flag){
			System.out.println("YES");
		}else{
			System.out.println("NO");
		}
	}

	public static int binarySearch(int value, int x, int y, int[] array) {
		if (x < y) {
			int center = x + (y - x) / 2;
			if (value < array[center]) {
				return binarySearch(value, x, center, array);
			} else if (value > array[center]) {
				return binarySearch(value, center + 1, y, array);
			} else {
				return center;
			}
		}
		return -(x + 1);
	}

}
