package com.algo.design.man.chap4;

import java.util.HashMap;

public class DisjointSetUsingLinkedList{
	public static void main(String args[]){
		ListSet sets=new ListSet();	
		for(int i=0;i<10;i++){
			sets.makeSet(i);
		}
		for(int i=0;i<10;i++){
			sets.printSet(sets.find(i));
		}
		for(int i=0;i<10;i++){
			System.out.println(sets.find(i));
			if(i%2==0){
				DisjointSet ds1=sets.find(i);
				DisjointSet ds2=sets.find(0);
				sets.union(ds2,ds1);
			}
		}	
		for(int i=0;i<10;i++){
			sets.printSet(sets.find(i));
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
