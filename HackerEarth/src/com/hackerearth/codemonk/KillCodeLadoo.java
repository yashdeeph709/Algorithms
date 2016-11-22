package com.hackerearth.codemonk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KillCodeLadoo {

	public static void main(String[] args) throws IOException {
		InputStreamReader is = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(is);
		int noOfTestCases = Integer.parseInt(br.readLine());
		while (noOfTestCases-- > 0) {
			String[] laddoos = br.readLine().split(" ");
			int n = Integer.parseInt(laddoos[0]);
			int m = Integer.parseInt(laddoos[1]);
			String[] kids = br.readLine().split(" ");
			int[] kidsList = new int[n];
			int max = Integer.MIN_VALUE, maxi = -1;
			for (int i = 0; i < n; i++) {
				kidsList[i] = Integer.parseInt(kids[i]);
				if (kidsList[i] > max) {
					maxi = i;
					max = kidsList[i];
				}
			}
			if (max <= m) {
				System.out.println(kidsList.length);
				continue;
			}
			/*
			 * 7 3 
			 * 6 1 5 4 3 2 1
			 */

			int answer = Integer.MAX_VALUE,answeri=-1;
			for (int i = maxi+1; i < n; i++) {
				if (max % m == 0) {
					if (kidsList[i] > (max - m) ) {
						answer=kidsList[i];
						answeri=i;
//						System.out.println("Found "+answer);
					}
				} else {
					if (kidsList[i] > max - (max % m) ) {
						answer=kidsList[i];
						answeri=i;
					}
				}
			}
			if(answeri==-1){
				System.out.println(maxi+1);
			}else{
				System.out.println(answeri+1);
			}
		}
	}
}
