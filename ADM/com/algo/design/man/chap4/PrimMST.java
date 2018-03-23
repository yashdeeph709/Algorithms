package com.algo.design.man.chap4;

import java.util.PriorityQueue;

public class PrimMST{

	public static void main(String args[]){
		int[][] matrix=new int[5][5];
		int startNode=1;
		matrix[1][2]=1;
		matrix[2][4]=2;
		matrix[1][3]=4;
		matrix[3][4]=5;
		matrix[1][4]=4;
		matrix[5][4]=1;
		System.out.println(prim(matrix,startNode));
	}	
	static public int prims(int[][] graph,int startNode){
		PriorityQueue queue=new PriorityQueue<Node>();
		boolean marked[]=new boolean[graph.length];
		int mincost=0,x,y;
		Node node=new Node();
		node.x=startNode;
		node.y=startNode;
		node.weight=0;
		queue.add(node);
		while(!queue.isEmpty()){
			Node temp=queue.poll();
			x=temp.x;
			if(marked[x]){
				continue;
			}
			minimumcost+=node.weight;
			marked[x]=true;
			for(int i=0;i<graph.length;i++){
				y=adj[x][i];
			}
		}
	}
	static class Node implements Comparable<Node>{
		int x;
		int y;
		int weight;

		public int compareTo(Node node){
			return Integer.compare(this.weight,node.weight);
		}	
	}
}
