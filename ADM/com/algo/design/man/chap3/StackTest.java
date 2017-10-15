package com.algo.design.man.chap3;

public class StackTest{
	public static void main(String args[]){
		testOverflow();	
		testUnderflow();
		testOrdering();
	}
	public static void testOrdering(){
		System.out.println("Starting Test for Ordering");
		int sizeOfStack=5;
		Stack s=new Stack(sizeOfStack);
		for(int i=0;i<sizeOfStack;i++){
			try{
				s.push(i);
			}catch(Exception e){
				System.out.println("Test Failed due to:");
				e.printStackTrace();
			}
		}
		for(int i=sizeOfStack-1;i>=0;i--){
			try{
				int d=s.pop();
				if(i!=d){
					System.out.println("Test Failed for Ordering"+d);
					s.printStack();
				}
			}catch(Exception e){
					System.out.println("Test Failed due to:");
					e.printStackTrace();
			}
		}
		System.out.println("Tests Passed!");
	}
	public static void testOverflow(){
		System.out.println("Starting Test Overflow");
		int sizeOfStack=5;
		Stack s=new Stack(sizeOfStack);
		for(int i=0;i<sizeOfStack+1;i++){
			try{
				s.push(i);
			}catch(Exception e){
				System.out.println("Overflow Test Succeded");
				//e.printStackTrace();
				return;
			}
		}
		System.out.println("Test Failed!");
	}
	public static void testUnderflow(){
		System.out.println("Starting Test Underflow");
		int sizeOfStack=5;
		Stack s=new Stack(sizeOfStack);
		try{
			s.pop();
		}catch(Exception e){
			System.out.println("Underflow Test Succedded");
			//e.printStackTrace();
			return;
		}
		System.out.println("Test Failed!");
	}
	public static class Stack{
		private int[] data;
		private int top;

		public Stack(int size){
			data=new int[size];
			top=-1;
		}
		public int pop() throws Exception{
			if(top==-1){
				throw new Exception("Stack Underflow");	
			}
			int result=data[top];
			top--;
			return result;	
		}
		public void push(int d) throws Exception{
			if(data.length-1==top){
				throw new Exception("Stack Overflow");	
			}
			top++;
			data[top]=d;
		}
		public void printStack(){
			for(int i=0;i<data.length;i++){
				System.out.print(data[i]+"");
			}
		}
	}
}
