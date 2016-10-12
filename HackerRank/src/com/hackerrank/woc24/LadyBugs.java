package com.hackerrank.woc24;

import java.util.*;

public class LadyBugs {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int Q = in.nextInt();
        for(int a0 = 0; a0 < Q; a0++){
            int n = in.nextInt();
            String b = in.next();
            char[] chars = b.toCharArray();
            boolean pass=true;
            Arrays.sort(chars);
            boolean movement=false;
            for(int i=1;i<chars.length-1;i++){
              if((b.charAt(i)!=b.charAt(i-1)) || (b.charAt(i)!=b.charAt(i+1))){
            	  movement=true; 
              }
            }
            for(int i=1;i<chars.length-1;i++){
              if(!(chars[i]==chars[i-1] || chars[i]==chars[i+1])){
                pass=false;
                break;
              }
          }
          if(pass){
            System.out.println("YES");
          }else{
            System.out.println("NO");
          }
        }
    }
}
