package com.algo.design.man.chap4;


public class DepthFirstSearch{

	public static void main(String args[]){
		AdjecencyList graph=new AdjecencyList(7);	
		int[][] graphList={
			{1,3},{2,5},{2,4},{3,4},{3,5},{3,1},{3,7},{3,6},{4,5},{4,7},{4,6},
		};
		for(int i=0;i<9;i++){
			if(graphList[i][1]>graphList[i][0]){
				graph.addEdge(graphList[i][0],graphList[i][1]);
				graph.addEdge(graphList[i][1],graphList[i][0]);
			}
		}
		DepthFirstSearching(1,graph);
	}
	public static void DepthFirstSearching(int root,AdjecencyList graph){
		boolean[] discovered=new boolean[graph.size()];
		boolean[] processed=new boolean[graph.size()];
		int[] parent=new int[graph.size()];
		
		LinkedList<Integer> stack=new LinkedList<Integer>();
		stack.push(root);
		discovered[root]=true;
		parent[root]=-1;
		processed[root]=true;
		while(stack.size()>0){
			int destination=stack.pop();
			System.out.println(""+destination);
			for(int i=0;i<graph.numberOfEdges(destination);i++){
				int destiny=graph.getEdge(destination,i);
				if(!discovered[destiny]){
					System.out.println("\t "+destiny);
					discovered[destiny]=true;
					parent[destiny]=destination;
					processed[destiny]=true;
					stack.push(destiny);
				}
			}
		}
	}
}
