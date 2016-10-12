package com.hackerrank.woc24;

import java.util.Scanner;

public class AppleOrange {
    // a     s      t        b
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int t = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();
        int m = in.nextInt();
        int n = in.nextInt();
        int apple = 0, orange = 0 , appleCount = 0, orangeCount = 0;
        for(int i=0;i<m;i++){
          int x=in.nextInt();
          if(s<=(a+x) && (a+x)<=t){
            appleCount++;
          }
        }
        for(int i=0;i<n;i++){
          int x=in.nextInt();
          if(t>=(b+x) && s<=(b+x)){
            orangeCount++;
          }
        }
        System.out.println(appleCount);
        System.out.println(orangeCount);
    
    }

}