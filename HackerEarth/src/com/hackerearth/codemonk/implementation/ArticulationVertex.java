package com.algo.design.man.chap4;


import java.util.ArrayList;
import com.algo.design.man.chap4.AdjecencyList;
import com.algo.design.man.chap4.LinkedList;

public class ArticulationVertex{
	public static void main(String args[]){
		AdjecencyList graph=new AdjecencyList(5,false);
		/*graph.addEdge(1,2);
		graph.addEdge(1,3);
		graph.addEdge(3,4);
		graph.addEdge(2,4);
		graph.addEdge(4,5);
		graph.addEdge(4,10);
		graph.addEdge(5,6);
		graph.addEdge(6,7);
		graph.addEdge(7,8);
		graph.addEdge(8,9);
		graph.addEdge(9,10);
		graph.addEdge(6,9);*/
		graph.addEdge(2, 1);
		graph.addEdge(1, 3);
		graph.addEdge(3, 2);
		graph.addEdge(1, 4);
	        graph.addEdge(4, 5);
		ArrayList<Integer> artiVerts=findArticulationVertices(graph);
		System.out.print(artiVerts);
	}
	/*
	 * @Description This method find the list of articulation vertexes in the graph
	 * @param graph: The graph which is to be searched.
	 */
	public static ArrayList<Integer> findArticulationVertices(AdjecencyList graph){
		ArrayList<Integer> articulationVertices=new ArrayList<Integer>();
		int startVertex=1;
		for(int i=1;i<graph.size();i++){
			int result=DFSWithArticulationVertext(graph,i,i==1?2:startVertex);
			if(result<graph.size()-2){
				System.out.println("Found numberOfNodes:"+result+"for i:"+i);
				articulationVertices.add(i);
			}
		}
		return articulationVertices;
	}
	/*
	 * @Description: Find the number of node traversed when a node is deleted.
	 * @param: AdjecencyList Graph that represents the graph where we need to search the articulation vertices.
	 * @param: deleted[] the node which is deleted should be marked here in this array.
	 * @param: startVertex the Vertex Where the traversal should start.
	 */
	public static int DFSWithArticulationVertext(AdjecencyList graph,int deleted,int startVertex){
		boolean[] discovered=new boolean[graph.size()];
		int[] parent=new int[graph.size()];
		LinkedList<Integer> stack=new LinkedList<Integer>();	
		stack.push(startVertex);
		discovered[startVertex]=true;
		parent[startVertex]=-1;
		int nodesTraversed=0;
		System.out.println("deleted"+deleted+" startVertex"+startVertex);
		while(stack.size()>0){
			int vertex=stack.pop();
			for(int i=0;i<graph.numberOfEdges(vertex);i++){
				int discovery=graph.getEdge(vertex,i);
				if(!discovered[discovery] && discovery!=deleted){
					stack.push(discovery);
					discovered[discovery]=true;
					parent[discovery]=vertex;
				}
			}
			System.out.println("Processing :"+vertex);
			nodesTraversed++;
		}
		return nodesTraversed;
	}
}
