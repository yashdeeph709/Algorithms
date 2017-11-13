package com.algo.design.man.chap4;

import com.algo.design.man.chap4.LinkedList;

public class LinkedListTest{
	public static void main(String args[]){
		//addTests();		
		//getTests();
		LinkedListAsStack();
		//removeTests();
//		addTests1();
	}
	public static  void addTests(){
		System.err.println("addTests");
		LinkedList<Integer> list=new LinkedList<Integer>();
		list.add(15);
		list.print();
		list.addAtStart(20);
		list.print();
		System.out.println("Adding 14 at start of list");
		list.add(0,14);
		list.print();
		System.out.println("Adding 39 at 4 of list");
		list.add(4,39);
		list.print();
		System.out.println("Adding 24 at 2 of list");
		list.add(2,24);
		list.print();
	}
	public static void addTests1(){
		LinkedList<Integer> list=new LinkedList<Integer>();
		for(int i=0;i<10;i++){
			list.addAtStart(i);
		}
		list.print();
	}
	public static void getTests(){
		System.err.println("getTests");
		LinkedList<Integer> list=new LinkedList<Integer>();
		for(int i=0;i<5;i++){
			list.add(i);
		}
		for(int i=0;i<5;i++){
			if(i!=list.get(i)){
				list.print();
				System.out.printf("getTests:Test Failure: %d\n",i);
				return;
			}
		}
		System.out.println("Test Successful");
	}

	public static void LinkedListAsStack(){
		System.err.println("StackTests");
		LinkedList<Integer> list=new LinkedList<Integer>();
		for(int i=0;i<5;i++){
			list.push(i);
		}
		for(int i=4;i>=0;i--){
			if(i!=list.pop()){
				list.print();
				System.out.printf("Test Failure at %d",i);
			}
		}
		System.out.println("Test Successful");

	}
	public static void removeTests(){
		LinkedList<Integer> list=new LinkedList<Integer>();
		for(int i=0;i<10;i++){
			list.add(i);
		}
		list.print();
		int removed=list.remove(0);
		System.out.println(removed);
		if(0!=removed){
			System.out.println("Test Failure remove at start wrong return");
		}
		list.print();

		if((list.get(0))!=1){
			System.out.println("Test Failure at remove at start");
		}list.print();

		if(9!=(list.remove(8))){
			System.out.println("Test Failure at remove at end wrong return");
		}list.print();

		if((list.get(8))!=null){
			System.out.println("Test Failure at remove at end not removed or wrong removed");
		}list.print();

		if((list.remove(3))!=4){
			System.out.println("Test Failure at remove in between wrong return");
		}list.print();

		if((list.get(3))==4){
			System.out.println("Test Failure at remove not removed or wrong remove");
		}list.print();
	}
}
