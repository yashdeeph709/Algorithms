package com.hackerearth.codemonk.implementation;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;

public class ArrayInsertSegTree{
	public static void main(String args[]) throws IOException{
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader br=new BufferedReader(new FileReader("tests/com/hackerearth/codemonk/implementation/ArrayInsertSegTree/ExtremeCaseHE.txt"));
/*		int noOfTestCases=Integer.parseInt(br.readLine());	
		while(noOfTestCases-->0){
*/			processQueries(br);
/*		}
*/	}
	public static void processQueries(BufferedReader br) throws IOException{
		String line=br.readLine();
		int N = Integer.parseInt(line.split(" ")[0]);
		int Q = Integer.parseInt(line.split(" ")[1]);
		int[] array=new int[N];
		line=br.readLine();
		for(int j=0;j<N;j++){
                      array[j]=Integer.parseInt(line.split(" ")[j]);
		}
		int[] tree=new int[N];
		buildTree(array,tree);
		for(int j=0;j<Q;j++){
	              line=br.readLine();
		      int type = Integer.parseInt(line.split(" ")[0]);
		      int from = Integer.parseInt(line.split(" ")[1]);
		      int to   = Integer.parseInt(line.split(" ")[2]);
		      //System.out.println("Query of type:"+type+" from:"+from+" to:"+to);
                      if(type==1){
			updateTree(array,tree,from,to);
		      }
		      if(type==2){
		      	queryTree(array,tree,from,to);
		      }
		      //System.out.println("Tree state is:");
		      //System.out.print("[");
		      //for(int i=0;i<tree.length;i++){
		//	System.out.print(tree[i]+" ");
		 //     }
		      //System.out.println("]");
		}
	}
	public static void buildTree(int[] array,int[] tree){
		tree[0]=array[0];
	 	for(int i=1;i<array.length;i++){	
			tree[i]=tree[i-1]+array[i];
		}
	}
	public static void updateTree(int[] array,int[] tree,int index,int value){
		if(index<0){
	           return;	
		}else if (index>=array.length){
		   return;	
		}else{
		   int diff=array[index]>tree[index]?array[index]-tree[index]:tree[index]-array[index];
		   array[index]=value;
		   for(int i=index;i<tree.length;i++){
		       if(i==0){
		       	    tree[i]=array[i];
		       }else{
			    tree[i]=tree[i-1]+array[i];
		       }
		   } 
		}
	}
	public static void queryTree(int[] array,int[] tree,int from,int to){
		if(from<0 || to>tree.length){
			System.out.println("-1");
			return;
		}
		if(from==0){
			System.out.println(tree[to]);
			return;
		}else if(from==to){
			System.out.println(array[from]);
			return;
		}else{
		        System.out.println(tree[from-1]>tree[to]?tree[from-1]-tree[to]:tree[to]-tree[from-1]);
			return;
		}
	}
}
