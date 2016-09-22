package com.hackerrank;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LibraryFine {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc=new Scanner(new File("C:\\Users\\c5244128\\Desktop\\HackerZone\\HackerRank\\LibraryTests"));	
		int n=sc.nextInt();
		for(int i=0;i<n;i++){
			int d=sc.nextInt();
			int m=sc.nextInt();
			int y=sc.nextInt();
			int d1=sc.nextInt();
			int m1=sc.nextInt();
			int y1=sc.nextInt();
			System.out.println("going of actual "+d+"/"+m+"/"+y+" expected "+d1+"/"+m1+"/"+y1);
			if(y>y1){
				System.out.println(10000);
			}
			if(y<y1){
				System.out.println(0);
				continue;
			}
			if(m>m1){
				System.out.println(500*(m-m1));
			}
			if(m<m1){
				System.out.println(0);
				continue;
			}
			if(d>d1){
				System.out.println(15*(d-d1));
			}
			System.out.println(0);
		}
		
	}

}
