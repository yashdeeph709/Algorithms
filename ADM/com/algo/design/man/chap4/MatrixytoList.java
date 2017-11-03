package com.algo.design.man.chap4;

/**
 * Title       : MatrixtoList
 * Description : Adjecency Matrix to Adjecency List Conversion of Graph Representation.
 * Author      : Yashdeep Hinge 
 **/
public class MatrixtoListTest{
	public static void main(String args[]){
		baseCase();
	}
	public static void baseCase(){
		int[][] matrix=new int[5][5];
		matrix[0]={0,0,1,0,0};
		matrix[1]={0,1,1,0,0};
		matrix[2]={1,0,0,0,1};
		matrix[3]={1,0,1,0,0};
		matrix[4]={1,1,0,0,0};
		AdjecencyList adlist=new AdjecencyList(matrix);
		boolean testResult=true;
		for(int i=0;i<matrix.length;i++){
			for(int j=0;j<matrix[i].length;j++){
				if(matrix[i][j]==1 && !adlist.hasEdge(i,j)){
					System.out.println("There is no edge between "+i+" and "+j);	
					testResult=false;
					break;
				}
			}
		}
		if(testResult){
			System.out.println("Base:Test Passed Successfully!");
		}else{
			System.out.println("Base:Test Failed");
		}

	}

	public static class AdjecencyList{
		private LinkedList[] data;
		
		public AdjecencyList(int size){
			data=new LinkedList[size];	
		}
		// Constructor for converting adjecency matrix to adjecency list
		public AdjecencyList(int[][] adjecencyMatrix){
			for(int i=0;i<adjecencyMatrix.length;i++){
				for(int j=0;j<adjecencyMatrix[i].length;j++){
					if(adjecencyMatrix[i][j]==1){
						addEdge(i,j);
					}
				}
			}	
		}
		public void addEdge(int i,int j){
			LinkedList listForI=data[i];
			if(listForI==null){
				Node n=new Node();
				n.setData(j);
				data[i]=n;		
			}else{
				Node n=new Node();
				n.setData(j);
				listForI.addAtEnd(n);
			}
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
		}
	}
	public static class LinkedList{
		private Node start;
		private Node end;
		
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
		public void addAtEnd(Node n){
			if(n==null && n.getData()==0){
				System.err.println("Null/0 data Node cannot be added");
				return;
			}
			this.end.setNext(n);
		}
	}
	public static class Node{
		private Node next;
		private int data;

		public Node getNext(){
			return next;
		}
		public void setNext(Node n){
			this.next=n;
		}
		public int getData(){
			return data;
		}
		public void setData(int d){
			this.data=d;
		}
	}
}
