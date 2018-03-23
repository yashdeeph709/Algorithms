package com.hackerearth.codemonk.implementation;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
/*
 *
 * javac -cp . KillJee.java
 * java -cp . KillJee
 *
 */

public class KillJee{

	public static void main(String args[]) throws IOException{
		int n,m;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String line[]=br.readLine().split(" ");
		n=Integer.parseInt(line[0]);
		m=Integer.parseInt(line[1]);
		AdjecencyList graph=new AdjecencyList(n,false);	
		int root=0;
		while(m-->0){
			if(m==0){
				root=Integer.parseInt(line[0]);
			}	
			line=br.readLine().split(" ");
			graph.addEdge(Integer.parseInt(line[0]),Integer.parseInt(line[1]));
		}
		int[] array=DepthFirstSearching(root,graph);
		for(int i=0;i<array.length;i++){
			System.out.println(array[i]);
		}
	}
	
	public static int[] DepthFirstSearching(int root,AdjecencyList graph){
		boolean[] discovered=new boolean[graph.size()];
		boolean[] processed=new boolean[graph.size()];
		int[] parent=new int[graph.size()];
		int[] path=new int[graph.size()];		
		LinkedList<Integer> stack=new LinkedList<Integer>();
		stack.push(root);
		discovered[root]=true;
		parent[root]=-1;
		processed[root]=true;
		while(stack.size()>0){
			int destination=stack.pop();
			//System.out.println(""+destination);
			for(int i=0;i<graph.numberOfEdges(destination);i++){
				int destiny=graph.getEdge(destination,i);
				if(!discovered[destiny]){
					//System.out.println("\t "+destiny);
					discovered[destiny]=true;
					parent[destiny]=destination;
					processed[destiny]=true;
					stack.push(destiny);
				}
			}
		}
		return parent;
	}
}
