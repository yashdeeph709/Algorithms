package com.algo.design.man.chap4;

public class BreadthFirstSearchTest{
	public static void main(String args[]) throws Exception{
		//LinkedListSearchTest();
		//LinkedListGetTest();
		//AdjecencyListTest();
		VerboseBFS();
		//LinkedListQueueTest();
	}
	public static void LinkedListSearchTest(){
		LinkedList list=new LinkedList();
		for(int i=0;i<10;i++){
			list.add(i);
		}
		boolean failure=false;
		for(int i=0;i<10;i++){
			Node n=list.search(i);
			if(n==null || i!=n.destination){
				failure=true;
			}
		}
		if(failure){
			System.out.println("LinkedList BaseCase Test Failure");
		}else{
			System.out.println("LinkedList BaseCase Test Success");
		}
	}
	public static void LinkedListGetTest() throws Exception{
		LinkedList list=new LinkedList();
		for(int i=0;i<10;i++){
			list.add(i);
		}
		boolean failure=false;
		for(int i=0;i<list.size();i++){
			Node n=list.get(i);
			if(n==null || i!=n.destination){
				failure=true;
			}
		}
		if(failure){
			System.out.println("LinkedList GetCase Test Failure");
		}else{
			System.out.println("LinkedList GetCase Test Success");
		}
	}

	public static void AdjecencyListTest() throws Exception{
		int noOfNodes=5;
		int[][] data=new int[][]{
			{1,2},{1,5},{1,3},{2,3},{2,5},{3,4},{4,5}
		};
		AdjecencyList adjecencyList=new AdjecencyList(noOfNodes);
		for(int i=0;i<data.length;i++){
			adjecencyList.addEdge(data[i][0],data[i][1]);
			adjecencyList.addEdge(data[i][1],data[i][0]);
		}
		//adjecencyList.print();
		boolean failure=false;
		for(int i=0;i<data.length;i++){
			int x=adjecencyList.search(data[i][0],data[i][1]);
		//	System.out.println(data[i][0]+" "+data[i][1]+" "+x);
			if(x!=data[i][1]){
				failure=true;
			}
		}
		if(failure){
			System.out.println("AdjecencyList base test failure");
		}else{
			System.out.println("AdjecencyList base test Success");
		}	
	}
	public static void VerboseBFS() throws Exception{
		int noOfNodes=5;
		int[][] data=new int[][]{
			{1,2},{1,5},{1,3},{2,3},{2,5},{3,4},{4,5}
		};
		AdjecencyList adjecencyList=new AdjecencyList(noOfNodes);
		for(int i=0;i<data.length;i++){
			adjecencyList.addEdge(data[i][0],data[i][1]);
			adjecencyList.addEdge(data[i][1],data[i][0]);
		}
		AdjecencyList.breadthFirstSearch(adjecencyList,1);
	}	

	public static class AdjecencyList{
		private LinkedList[] nodes;
		private int size=0;

		public AdjecencyList(int size){
			this.size=size;
			nodes=new LinkedList[size];
		}
		public int size(){
			return size;
		}
		public void print() throws Exception{
			LinkedList list=nodes[0];
			int i=0;
			while(i<nodes.length){
				list=nodes[i];
				System.out.println((i+1)+":");
				Node n=list.start;
				while(n!=null){
					System.out.print("\t"+n.destination+"\n");
					n=n.next;
				}
				i++;
			}
		}
		public void addEdge(int source,int destination) throws Exception{
			source--;
			if(source>=size){
				throw new Exception("ArrayIndexOutOfBound: "+source+" out of "+size);
			}
			if(nodes[source]==null){
				LinkedList list=new LinkedList();
				list.add(destination);
				nodes[source]=list;
			}else{
				LinkedList list=nodes[source];
				list.add(destination);
			}
		}
		public int search(int node,int destination){
			node--;
			//System.out.println(node+","+nodes[node]+","+degree(node)+","+destination);
			if(node>=size || nodes[node]==null){
				return -1;
			}
			int x=nodes[node].search(destination).destination;
			//System.out.println(x);
			return x;	
		}
		public int get(int node,int index) throws Exception{
			node--;
			if(node>=size || nodes[node]==null){
				return -1;
			}
			LinkedList list=nodes[node];
			return list.get(index).destination;
		}
		public int degree(int node){
			node--;
			if(node>=size || nodes[node]==null){
				return -1;
			}
			return nodes[node].size();
		}
		public static void breadthFirstSearch(AdjecencyList list,int startNode) throws Exception{
			System.out.println("Starting Breadth First Search");
			boolean discovered[]=new boolean[list.size()];
			boolean processed[]=new boolean[list.size()];
			discovered[startNode-1]=true;	
			int parent[]=new int[list.size()];
			LinkedList toBeProcessed=new LinkedList();
			int node=startNode;
			int i=0;
			while(i<list.size()){
				int degree=list.degree(node);
				System.out.println("Started Processing "+node);
				int j=0;
				while(j<degree){
					int dest=list.get(node,j);
					System.out.println("Looking at "+dest);
					if(!discovered[dest-1]){
						System.out.println("Discovered "+dest);
						toBeProcessed.enqueue(dest);
						parent[dest-1]=node;
						discovered[dest-1]=true;
					}
					j++;
				}
				processed[node-1]=true;
				node=toBeProcessed.dequeue();
				i++;	
			}
			for(i=0;i<parent.length;i++){
				System.out.println((i+1)+" is the child of  "+(1+parent[i]));
			}
		}
	}
	public static void LinkedListQueueTest(){
		LinkedList queue=new LinkedList();
		for(int i=0;i<5;i++){
			queue.enqueue(i);
		}
		for(int i=0;i<5;i++){
			int a=queue.dequeue();
			if(a!=i){
				System.out.println("test failure"+i+""+a);
			}else{
				System.out.println("test success:"+i+""+a);
			}
		}
	}
	public static class LinkedList{
		private Node start;
		private Node end;
		private int size;

		public LinkedList(){
			this.size=0;
		}		
		public Node getStart(){
			return start;
		}
		public void add(int d){
			Node n=new Node();
			n.destination=d;
			if(start==null){
				start=n;
				end=n;
			}else{
				end.next=n;
				end=n;	
			}
			size++;
		}
		public Node search(int destination){
			Node temp=start;
			while(temp!=null && temp.destination!=destination){
				temp=temp.next;
			}
			return temp;	
		}
		public Node get(int index) throws Exception{
			if(index>=size){
				throw new Exception("IndexOutOfBound");
			}
			Node node=start;
			int i=0;
			while(i!=index){
				node=node.next;
				i++;
			}
			return node;
		}
		public void print() throws Exception{
			int i=size-1;
			Node temp=start;
			while(temp!=null && i>=0){
				System.out.print("\t"+temp.destination+"\n");
				temp=temp.next;
			}
		}
		public int size(){
			return size;
		}
		public void enqueue(int destination){
			Node n=new Node();
			n.destination=destination;
			if(start==null){
				start=n;
				end=n;
			}else{
				end.next=n;
				end=n;
			}
			size++;
			System.out.println(destination);
		}
		public int dequeue(){
			if(start==null){
				System.out.println("queue is underflow");
				return -1;
			}
			if(start.next==null){
				int data=start.destination;
				start=null;
				return data;
			}
			Node node=start;
			int i=0;
			while(i!=size-2){
				node=node.next;
				i++;
			}
			System.out.println("Node:"+node);
			int data=node.next.destination;
			node.next=null;
			size--;
			return data;
		}
		public boolean hasNext(){
			return end!=null;
		}
	}
	public static class Node{
		public Node next;
		public int destination;

		public String toString(){
			return "["+next+","+destination+"]";
		}
	}
}
