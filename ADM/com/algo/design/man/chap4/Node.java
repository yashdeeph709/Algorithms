package com.algo.design.man.chap4;

public class Node<T>{
	public Node<T> next;
	public Node<T> previous;
	public T element;
	public Node(){
	}
	public Node(T element,Node<T> next,Node<T> previous){
		this.next=next;
		this.previous=previous;
		this.element=element;
	}
	public String toString(){
		return "["+element+","+next+"]";
	}
}
