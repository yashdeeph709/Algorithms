package com.algo.design.man.chap4;

import com.algo.design.man.chap4.*;

public class ConnectedComponents{
	public static boolean discovered[];
	public static int parent[];
	public static void main(String args[]){
		AdjecencyList graph=new AdjecencyList(6,false);
		graph.addEdge(1,2);
		graph.addEdge(1,3);
		graph.addEdge(2,3);
		graph.addEdge(4,5);
		connected_components(graph);	
	}
	public static void process_vertex(int v){
		System.out.printf(" %d", v);
	}
	public static void DepthFirstSearch(AdjecencyList graph,int startNode){
		LinkedList<Integer> stack=new LinkedList<Integer>();
		stack.push(startNode);
		discovered[startNode]=true;
		parent[startNode]=-1;
		while(stack.size()>0){
			int node=stack.pop();
			process_vertex(node);
			for(int i=0;i<graph.numberOfEdges(node);i++){
				int destiny=graph.getEdge(node,i);	
				if(!discovered[destiny]){
					discovered[destiny]=true;
					parent[destiny]=startNode;
					stack.push(destiny);
				}
			}
		}
	}
	public static void initgraph(AdjecencyList graph){
		for(int i=0;i<graph.size();i++){
			discovered[i]=false;
			parent[i]=-1;
		}
	}
	public static void connected_components(AdjecencyList graph){
		discovered=new boolean[graph.size()];
		parent=new int[graph.size()];
		int components=0;
		initgraph(graph);
		for(int i=1;i<graph.size();i++){
			if(!discovered[i]){
				components++;
				System.out.printf("Connected Components %d:",components);
				DepthFirstSearch(graph,i);
				System.out.printf("\n");
			}
		}
		graph.print();
	}
}
