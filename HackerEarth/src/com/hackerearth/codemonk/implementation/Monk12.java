package com.hackerearth.codemonk;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.*;

class Monk12 {
    public static void main(String args[] ) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int M=Integer.parseInt(line[0]);
        int N=Integer.parseInt(line[1]);
        int[] Monk1=new int[M];
        int[] Monk2=new int[N];
        line=br.readLine().split(" ");
        for(int i=0;i<M;i++){
        	Monk1[i]=Integer.parseInt(line[i]);
        }
        line=br.readLine().split(" ");
        for(int i=0;i<N;i++){
        	Monk2[i]=Integer.parseInt(line[i]);
        }
        Arrays.sort(Monk1);
        Arrays.sort(Monk2);
        int cntm1=0,cntm2=0;
        for(int i=0;i<Monk1.length;i++){
        	int a=binaryCounterf(Monk2, Monk1[i], 0, Monk2.length-1, 0);
        	int b=binaryCounterg(Monk2,Monk1[i],0,Monk2.length-1,0);
//        	System.out.println("a:"+a+"b:"+b);
        	cntm1+=a*b;
        }
//        System.out.println("monk1 count"+cntm1);
        for(int i=0;i<Monk2.length;i++){
        	int a=binaryCounterf(Monk1, Monk2[i], 0, Monk1.length-1, 0);
        	int b=binaryCounterg(Monk1, Monk2[i], 0, Monk1.length-1, 0);
//        	System.out.println("a:"+a+"b:"+b);
        	cntm2+=a*b;
        }
//        System.out.println("monk2 count"+cntm1);
        if(cntm1>cntm2){
        	System.out.println("Monk "+(cntm1-cntm2));
        }else if(cntm2>cntm1){
        	System.out.println("Monk "+(cntm2-cntm1));
        }else{
        	System.out.println("Tie");
        }
/*
            	int[] a={1,5,7,9,12,14,17,18};
            	System.out.println(binaryCounterg(a,17,0,a.length-1,0));
            	*/
    }
    public static int binaryCounterf(int[] list,int number,int start,int end,int count){
    	int mid=((end-start)/2)+start;
//    	System.out.println(list[mid]);
    	if(start==end){
    		return count;
    	}
    	if(number>list[mid]){
//    		System.out.println(mid+1+" "+end);
    		return binaryCounterf(list,number,mid+1,end,count+(mid+1-start));
    	}else if(number<list[mid]){
//    		System.out.println(start+" "+mid);
    		return binaryCounterf(list,number,start,mid,count);
    	}else{
    		return count;
    	}
    }
    public static int binaryCounterg(int[] list,int number,int start,int end,int count){
    	int mid=((end-start)/2)+start;
//    	System.out.println("list[mid]:"+list[mid]+" count:"+count+" mid"+mid);
    	if(start==end){
    		return count+number==list[start]?(list.length-start):0;
    	}
    	if(number>list[mid]){
//    		System.out.println(mid+1+" "+end);
    		return binaryCounterg(list,number,mid+1,end,count);
    	}else if(number<list[mid]){
//    		System.out.println(start+" "+mid);
    		return binaryCounterg(list,number,start,mid,count+(end-mid));
    	}else{
//   		System.out.println("end:"+end+"mid"+mid+"list[mid]"+list[mid]+"count"+count);
    		count+=end-mid;
    		return count;
    	}
    }

}
