package com.algo.design.man.chap4;

import java.util.HashMap;
import java.util.Collections;
import java.util.ArrayList;

public class KruskalMST{
	public static void main(String args[]){
		ArrayList<NodeRep> nodeList=new ArrayList<NodeRep>();
		nodeList.add(new NodeRep(1,2,1));
		nodeList.add(new NodeRep(1,3,7));
		nodeList.add(new NodeRep(2,3,5));
		nodeList.add(new NodeRep(2,5,3));
		nodeList.add(new NodeRep(2,4,4));
		nodeList.add(new NodeRep(3,5,6));
		nodeList.add(new NodeRep(5,4,2));
		Collections.sort(nodeList);
		System.out.println(kruskal(nodeList));
	}	
	static public int kruskal(ArrayList<NodeRep> rep){
		int x,y;
		int cost,minimumcost=0;
		ListSet list=new ListSet();
		for(int i=0;i<rep.size();i++){
			list.makeSet(i);
		}	
		for(int i=0;i<rep.size();i++){
			x=rep.get(i).x;
			y=rep.get(i).y;
			cost=rep.get(i).weight;
			System.out.println("Evaluating connected attribute of "+x+","+y+","+cost);
			System.out.println(list.find(x));
			if(list.find(x).start.data!=list.find(y).start.data){
				minimumcost+=cost;
				list.union(list.find(x),list.find(y));	
			}
		}
		return minimumcost;
	}
	static class NodeRep implements Comparable<NodeRep>{
		int x;
		int y;
		int weight;

		public NodeRep(int x,int y,int weight){
			this.x=x;
			this.y=y;
			this.weight=weight;
		}
		
		public int compareTo(NodeRep rep){
			if(weight==rep.weight){
				return 0;
			}else if(weight>rep.weight){
				return 1;
			}else{
				return -1;
			}
		}
	}
	static class ListSet{
		private HashMap<Integer,Node> sets;

		public ListSet(){
			sets=new HashMap<Integer,Node>();
		}

		public void makeSet(int data){
			DisjointSet set=new DisjointSet();
			Node node=new Node();
			node.data=data;
			node.next=null;
			node.parent=set;
			set.start=node;
			set.end=node;
			sets.put(data,node);
		}
		public DisjointSet find(int data){
			return sets.get(data).parent;
		}
		public void union(DisjointSet set1,DisjointSet set2){
			Node n=set2.start;
			while(n!=null){
				n.parent=set1;
				n=n.next;
			}
			set1.end.next=set2.start;
			set1.end=set2.end;
			set2.start=null;
			set2.end=null;
		}
		public void printSet(DisjointSet set){
			if(set==null || set.start==null){
				System.out.println("Empty Set");
				return;
			}
			System.out.print("Set("+set.start.data+"):");
			Node node=set.start;	
			while(node!=null){
				System.out.print(node+",");
				node=node.next;
			}
			System.out.println(")");
		}
	}
	static class DisjointSet{
		Node start;
		Node end;
		public String toString(){
			if(start!=null){
			return "Set("+start.data+")";
			}
			return "EmptySet()";
		}
	}
	static class Node{
		Node next;
		DisjointSet parent;
		int data;

		public boolean equals(Node n){
			if(n.data==data){
				return true;
			}else{
				return false;
			}
		}
		public String toString(){
			return ""+data;	
		}
	}
}
