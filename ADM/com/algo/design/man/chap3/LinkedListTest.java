package com.algo.design.man.chap3;

public class LinkedListTest{
	public static void main(String args[]){
		deleteTest();
	}
	public static void testInsert(int size){
		LinkedList list=new LinkedList();
		String[] names={"harshal","raku","guptaji","shashwat"};
		for(int i=1;i<size;i++){
			list.add(names[i%4]);
		}
		System.out.println(list.size);
		for(int i=1;i<size;i++){
			String data=list.get(i);
			if(!names[i%4].equals(data)){
				System.out.println("Insertion Check Test Failed");
			}	
		}
	}
	public static void deleteTest(){
		LinkedList list=new LinkedList();
		int size=10;
		String[] names={"harshal","raku","guptaji","shashwat"};
		for(int i=0;i<size;i++){
			list.add(names[i%4]);
		}
		System.out.println("Test front Deletion");
		list.delete(1);
		System.out.println("Test internal Deletion");
		list.delete(5);
		System.out.println("Test end Deletion");
		list.delete(9);
	}
	public static class LinkedList{
		public Node start;
		public Node end;
		public int size;
		public LinkedList(){
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
				start=temp;
				end=temp;
				size++;
				return;
			}
			Node temp=new Node();
			temp.data=name;
			temp.next=null;
			end.next=temp;
			end=temp;
			size++;
			Node ptr=start;
			while(ptr!=null){
				ptr=ptr.next;
			}
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
	}
	public static class Node{
		public Node next;
		public String data;
		public Node(){next=null;}
	}
}
