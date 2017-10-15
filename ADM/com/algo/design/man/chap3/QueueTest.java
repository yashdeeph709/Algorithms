package com.algo.design.man.chap3;

public class QueueTest{
	public static final int SizeForTest=5;
	public static void main(String args[]){
		testOrdering();
		testOverflow();
		testUnderflow();
		testFullTraversal();
	}
	public static void testOrdering(){
		Queue q=new Queue(SizeForTest);
		System.out.println("Starting Ordering Test");
		for(int i=0;i<SizeForTest;i++){
			try{
				q.enqueue(i);
			}catch(Exception e){
				System.out.println("Test Failed:QueueException");
				e.printStackTrace();
				return;
			}
		}
		for(int i=0;i<SizeForTest;i++){
			int d=0;
			try{
				d=q.dequeue();
			}catch(Exception e){
				System.out.println("Test Failed:Queue Exception");
				e.printStackTrace();
				return;
			}
			if(i!=d){
				System.out.println("Element Didn't matched"+i+"=="+d);
				q.printQueue();
				return;
			}
		}
		System.out.println("Test Passed Successfully!");
	}
	public static void testOverflow(){
		System.out.println("Overflow Test Started");
		Queue q=new Queue(SizeForTest);
		for(int i=0;i<SizeForTest+1;i++){
			try{
				q.enqueue(i);
			}catch(Exception e){
				System.out.println("Overflow Test Passed");	
				return;
			}
		}
		System.out.println("Overflow Test Failed");
	}
	public static void testUnderflow(){
		System.out.println("Starting Test Underflow");
		Queue q=new Queue(SizeForTest);
		try{
			q.dequeue();
		}catch(Exception e){
			System.out.println("Underflow Test Passed!");
			return;
		}
		System.out.println("Underflow Test Failed!");
	}

	public static void testFullTraversal(){
		System.out.println("Starting Test Underflow");
		Queue q=new Queue(SizeForTest);
		try{
			q.enqueue(1);
			q.enqueue(2);
			q.dequeue();
			q.dequeue();
			q.dequeue();
		}catch(Exception e){
			System.out.println("Underflow Test Passed!");
			return;
		}
		System.out.println("Underflow Test Failed!");
	}

	public static class Queue{
		private int[] data;
		private int start;
		private int end;

		public Queue(int size){
			start=-1;
			end=-1;
			data=new int[size];
		}
		public void enqueue(int d) throws Exception{
			if(end==data.length){
				throw new Exception("Queue is full");
			}
			if(start==-1){
				start++;
			}
			end++;
			data[end]=d;
		}
		public int dequeue() throws Exception{
			if(start==end+1){
				start=-1;
				end=-1;
				throw new Exception("Queue is not filled");
			}
			int res=data[start];
			start++;
			return res; 
		}
		public void printQueue(){
			for(int i=0;i<data.length;i++){
				System.out.print(","+data[i]);
			}
		}
		public int size(){
			return end;
		}
	}	
}
