package com.algo.design.man.chap4;

import com.algo.design.man.chap4.Node;

public class LinkedList<T>{
	private Node<T> header=new Node<T>();
	private int size=0;
	
	public LinkedList(){
		header.next=header.previous=header;
	}
	/*
	 * Add Element at the end of the list.
	 * @args T element : Element to be added
	 */
	public void add(T element){
		Node<T> node=new Node<T>(element,header,header.previous);
		node.previous.next=node;
		node.next.previous=node;
		size++;
	}
	public void addAtStart(T element){
		Node<T> node=new Node<T>(element,header.next,header.next.previous);
		node.previous.next=node;
		node.next.previous=node;
		size++;
	}
	public void add(int index,T element){
		if(index==size){
			add(element);
		}else{
			Node<T> succesor=header;
			if(index < (size>>1)){
				for(int i=0;i<=index;i++){
					succesor=succesor.next;
				}	
			}else{
				for(int i=size;i>index;i--){
					succesor=succesor.previous;
				}
			}
			Node<T> newNode=new Node<T>(element,succesor,succesor.previous);
			newNode.next.previous=newNode;
			newNode.previous.next=newNode;
			size++;
		}
	}		
	public void print(){
		Node temp=header;
		System.out.printf("Printing LinkedList\n");
		System.out.print("[");
		for(int i=0;i<size;i++){
			System.out.print(","+get(i));
		}
		System.out.println("]");
	}
	public T get(int index){
		Node<T> succesor=header;

		if(index < (size>>1)){
			for(int i=0;i<=index;i++){
				succesor=succesor.next;
			}	
		}else{
			for(int i=size;i>index;i--){
				succesor=succesor.previous;
			}
		}
		return succesor.element;
				
	}
	public int size(){
		return size;
	}
	public T remove(int index){
		Node<T> succesor=header;
		if(index < (size>>1)){
			for(int i=0;i<=index;i++){
				succesor=succesor.next;
			}	
		}else{
			for(int i=size;i>index;i--){
				succesor=succesor.previous;
			}
		}
		T result=succesor.element;
		succesor.previous.next=succesor.next;
		succesor.next.previous=succesor.previous;
		succesor.next=null;
		succesor.previous=null;
		size--;
		return result;
	}
	int i=0;
 	public T pop(){
		return remove(0);
	}
	public void push(T element){
		addAtStart(element);
	}
	public T enqueue(){
		return remove(0);
	}
	public void dequeue(T element){
		add(element);
	}
}
