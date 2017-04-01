package com.hackerearth.codemonk.implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.*;

public class JarvisAndNumbers {
    public static void main(String args[] ) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int f = Integer.parseInt(line);
        while(--f>=0){
            line = br.readLine();
            int y = Integer.parseInt(line);
            int count=0;
            for(int i=2;i<y;i++){
                    int x=y;
                    while(x/i>=1){
                         count+=x%i;
                         x=x/i;
                    }
                    count+=x;
                   System.out.println(count+" for "+i);
            }
            
            int m=count>y-2?count:y-2;
            int n=count>y-2?y-2:count;
            boolean flag=false;
            System.out.println(m+" "+n);
            while(m%n!=0){
                flag=true;
                int diff=m-n;
                if(diff>n){
                    m=diff;
                }else{
                    m=n;
                    n=diff;
                }
            }
            System.out.println(m+" "+n);
            if(!flag){
                System.out.println(1);
            }else{
                System.out.println((y-2)/n);
            }
        }
    }
}
