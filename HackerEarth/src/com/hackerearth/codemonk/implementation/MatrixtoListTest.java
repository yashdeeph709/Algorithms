package com.algo.design.man.chap4;

import java.util.Iterator;

/**
 * Title       : MatrixtoList
 * Description : Adjecency Matrix to Iterable Adjecency List Conversion of Graph Representation
 * 		 With a well tested Iterable LinkedList Implemenation
 * Author      : Yashdeep Hinge 
 **/
public class MatrixtoListTest{
	public static void main(String args[]){
		baseCase();
		testLinkedList();
		testAdjecencyList();
	}
	public static void testLinkedList(){
		LinkedList l=new LinkedList();
		for(int i=0;i<10;i++){
			l.add(i,0);
		}
		boolean b=true;
		for(int i=0;i<l.size();i++){
			if(l.get(i).getData()!=i){
				b=false;
				System.out.println("Test failure");
			}
		}
		if(b){
			System.out.println("Test Passed");
		}
	}
	public static void testAdjecencyList(){
		AdjecencyList list=new AdjecencyList(5);
		for(int i=0;i<5;i++){
			for(int j=0;j<5;j++){
				list.addEdge(i,j,i+j);
			}
		}
		for(int i=0;i<5;i++){
			for(int j=0;j<5;j++){
				//System.out.println(list.getEdge(i,j));	
			}
		}

		
	}
	public static void baseCase(){
		int[][] matrix=new int[][]{
			{0,0,5,0,0},
			{0,2,0,-4,0},
			{3,0,0,0,7},
			{6,0,4,0,0},
			{8,9,0,0,0}
		};
		AdjecencyList adlist=new AdjecencyList(matrix);
		boolean testResult=true;
		for(int i=0;i<matrix.length;i++){	
			for(int j=0;j<matrix[i].length;j++){
				if(adlist.getEdge(i,j)!=matrix[i][j]){
					testResult=false;
				}
			}
		}
		if(testResult){
			System.out.println("Base:Test Passed Successfully!");
		}else{
			System.out.println("Base:Test Failed");
		}

	}

	static class AdjecencyList implements Iterable<LinkedList>{
		private LinkedList[] data;
		private int size;	

		public AdjecencyList(int size){
			this.size=size;
			data=new LinkedList[size];	
		}
		// Constructor for converting adjecency matrix to adjecency list
		public AdjecencyList(int[][] adjecencyMatrix){
			data=new LinkedList[adjecencyMatrix.length];
			for(int i=0;i<adjecencyMatrix.length;i++){
				for(int j=0;j<adjecencyMatrix[i].length;j++){
					if(adjecencyMatrix[i][j]!=0){
						addEdge(i,j,adjecencyMatrix[i][j]);
					}
				}
			}	
			size=adjecencyMatrix.length;
		}
		public void addEdge(int i,int j,int d){
			if(i>=data.length){
				return;
			}
			LinkedList listForI=data[i];
			if(listForI==null){
				LinkedList l=new LinkedList();
				l.add(d,j);	
				data[i]=l;
			}else{
				if(listForI.size()+1>data.length+1){
					return;
				}
				listForI.add(d,j);
			}
		}
		public int getEdge(int i,int j){
			if(i<0 || i>size || j<0 || j>size){
				return 0;
			}
			LinkedList list=data[i];
			Node n=list.getDestination(j);
			if(n==null){
				return 0;
			}
			return n.getData();
		}
		public void removeEdge(int i,int j){
			LinkedList listForI=data[i];
			if(listForI==null){
				System.out.println("Node doesn't exists");
				return;
			}else{
				Node start=listForI.getStart();
				if(start.getData()==j){
					listForI.setStart(start.getNext());
				}
				while(start!=null){
					if(start.getNext().getData()==j){
						start.setNext(start.getNext().getNext());
						break;
					}
					start=start.getNext();
				}
			}
		}
		public boolean hasEdge(int i,int j){
			LinkedList listForI=data[i];
			if(listForI==null){
				return false;
			}else{
				Node start=listForI.getStart();
				while(start!=null){
					if(start.getData()==j){
						return true;
					}
					start=start.getNext();
				}
			}
			return false;
		}

		@Override
		public Iterator<LinkedList> iterator(){
			return new Iterator<LinkedList>(){
				int count=-1;

				public boolean hasNext(){
					if(count+1>=data.length){
						return false;
					}
					return data[count+1]!=null;
				}
				public LinkedList next(){
					if(hasNext()){
						return data[++count];
					}
					return null;
				}
			};
		}
	}
	static class LinkedList implements Iterable<Node>{
		private Node start;
		private Node end;
		private int size=0;	

		public void setStart(Node s){
			this.start=s;
		}
		public void setEnd(Node e){
			this.end=e;
		}
		public Node getStart(){
			return start;
		}
		public Node getEnd(){
			return end;
		}
		public Node get(int index){
			int i=0;
			if(index>size){
				return null;
			}
			Node n=start;
			while(i!=index){
				n=n.getNext();
				i++;
			}
			return n;
		}
		public Node getDestination(int d){
			Node n=start;
			while(n.getDestination()!=d){
				n=n.getNext();
				if(n==null){
					return null;
				}
			}
			return n;
		}
		public void add(int d,int dest){
			Node n=new Node();
			n.setData(d);
			n.setDestination(dest);
			if(n==null && n.getData()==0){
				System.err.println("Null/0 data Node cannot be added");
				return;
			}
			size++;
			if(start==null){
				this.start=n;
				this.end=n;
			}else{
				this.end.setNext(n);
				this.end=n;
			}
		}
		public int size(){
			return size;
		}
		public Iterator<Node> iterator(){
			return new NodeIterator();
		}
		class NodeIterator implements Iterator<Node>{
			private Node current;
			private int count;

			public NodeIterator(){
				current=start;
			}

			public boolean hasNext(){
				if(current==start){
					return start!=null;
				}else{
					return current!=null;
				}
			}
			public Node next(){
					Node node=current;
					count++;
					current=current.getNext();
					return node;
			}
		}
	}
	static class Node{
		private Node next;
		private int data;
		private int destination;

		public Node getNext(){
			return next;
		}
		public void setNext(Node n){
			this.next=n;
		}
		public void setDestination(int d){
			this.destination=d;
		}
		public int getDestination(){
			return destination;
		}
		public int getData(){
			return data;
		}
		public void setData(int d){
			this.data=d;
		}
		public String toString(){
			return data+"";
		}
	}
}
