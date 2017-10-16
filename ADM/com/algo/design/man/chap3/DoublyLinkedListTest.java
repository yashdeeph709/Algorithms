package com.algo.design.man.chap3;

public class DoublyLinkedListTest{
	public static void main(String args[]){
		deleteTest();
		testInsert(5);
		testReverse(5);
	}
	public static void testReverse(int size){
		DoublyLinkedList list=new DoublyLinkedList();
		String[] names={"harshal","raku","guptaji","shashwat"};
		String[] expected=new String[size];
		for(int i=1;i<size;i++){
			list.add(names[i%4]);
			expected[i]=names[i%4];
		}
		String[] dat=new String[size];
		for(int i=1;i<size;i++){
			String data=list.get(i);
			dat[i]=data;
		}
		for(int i=1;i<size;i++){
			if(!dat[i].equals(expected[i])){
				System.out.println("TestFailed");
				return;
			}
		}
		list.print();
		list.printReverse();
		System.out.println("Test Reverse Passed Successfully");
	}
	public static void testInsert(int size){
	DoublyLinkedList list=new DoublyLinkedList();
		String[] names={"harshal","raku","guptaji","shashwat"};
		for(int i=1;i<size;i++){
			list.add(names[i%4]);
		}
		for(int i=1;i<size;i++){
			String data=list.get(i);
			if(!names[i%4].equals(data)){
				System.out.println("Insertion Check Test Failed");
			}	
		}
	}
	public static void deleteTest(){
	DoublyLinkedList list=new DoublyLinkedList();
		int size=10;
		String[] names={"harshal","raku","guptaji","shashwat"};
		for(int i=0;i<size;i++){
			list.add(names[i%4]);
		}
		list.print();
		list.delete(1);
		list.delete(5);
		list.delete(8);
		System.out.println("After deletign 1,5,8");
		list.print();
	}
	public static class DoublyLinkedList{
		public Node start;
		public Node end;
		public int size;
		public DoublyLinkedList(){
			start=null;
			end=null;
			size=0;
		}
		//Add a value to linkedlist
		public void add(String name){ 
			if(start==null){
				Node temp=new Node();
				temp.data=name;
				temp.next=null;
				temp.previous=null;
				start=temp;
				end=temp;
				size++;
				return;
			}
			Node temp=new Node();
			temp.data=name;
			temp.next=null;
			temp.previous=end;
			end.next=temp;
			end=temp;
			size++;
		}
		public String get(int index){
			index=index!=0?index-1:index;	
			int i=0;
			Node ptr=start;
			while(index!=i ){
				ptr=ptr.next;
				i++;
			}
			return ptr.data;
		}
		//Delete by index
		public void delete(int index){
			index=index==0?index:index-1;
			int i=0;
			//if its start index
			if(index==0){
				start=start.next;
				size--;
				return;
			}
			//if its end index
			if(index==size){
				Node ptr=start;
				i=0;
				// Go to the second last element
				while(index!=size-2){
					ptr=ptr.next;
					i++;
				}
				ptr.next=null;
				end=ptr;
				size--;
				return;
			}
			//if its index is in between end and start
			Node ptr=start;
			i=0;
			while(i!=index-1){
				ptr=ptr.next;
				i++;
			}
			ptr.next=ptr.next.next;
			size--;
		}
		public void delete(String name){
			Node ptr=start;
			for(int i=1;i<size-1;i++){
				if(ptr.data.equals(name)){
					ptr.next=ptr.next.next;
				}
			}
		}
		//Search Returns index of that data
		private int search(String data){
			Node ptr=start;
			for(int i=1;i<size-1;i++){
				if(ptr.data.equals(data)){
					return i;
				}
			}
			return -1;
		}		
		public void print(){
			Node ptr=start;
			System.out.print("\n[");
			while(ptr!=null){
				System.out.print(ptr.data+",");
				ptr=ptr.next;
			}
			System.out.println("]");
		}
		public void printReverse(){
			Node ptr=start;
			while(ptr.previous!=null){
				System.out.println(ptr.data);
				ptr=ptr.next;
			}
		}
	}
	public static class Node{
		public Node next;
		public Node previous;
		public String data;
		public Node(){next=null;}
	}
}
