package com.algo.design.man.chap4;

import com.algo.design.man.chap4.LinkedList;

@SuppressWarnings("unchecked")
public class AdjecencyList{
	private LinkedList data[];
	private boolean directed; 
	
	/*
	 * @param: size is number of nodes the graph has.
	 * @param: directed of the graph directed or undirected true:directed false:undirected
	 */
	public AdjecencyList(int size,boolean type){
		data=new LinkedList[size+1];
		directed=type;
	}	
	public int size(){
		return data.length;
	}
	public int numberOfEdges(int index){
		//System.out.println("numberOfEdges:"+index);
		if(index<=0 || index>data.length){
			return -1;
		}
		LinkedList list=data[index];
		if(list!=null){
			return list.size();
		}else{
			return 0;
		}
	}
	/* 
	 * Description : Adds an edge to the graph represented by this adjecency list from i to j. 
	 * @param start	: Node number where edge starts
	 * @param end : Node number where edge ends.
	 */
	public void addEdge(int start,int end){
		if(start<=0 || start>=data.length || end<=0 || end>=data.length){
			return;
		}
		//System.out.println("List::addEdge called"+start+","+end);
		LinkedList<Integer> list=data[start];
		if(list==null){
			//System.out.println("List is null");	
			list=new LinkedList<Integer>();
			data[start]=list;
		}
		list.add(end);
		if(!directed){
			LinkedList<Integer> l1=data[end];
			if(l1==null){
				l1=new LinkedList<Integer>();
				data[end]=l1;
			}
			l1.add(start);
		}
		//System.out.println("Added "+end+", at"+(list.size()+1));
	}
	public int search(int end,LinkedList<Integer> list){
		for(int i=0;i<list.size();i++){
			if(list.get(i)==end){
				return i;
			}
		}
		return -1;
	}
	/* 
	 * Description : Removes an edge to the graph represented by this adjecency list from i to j. 
	 * @param start	: Node number where edge starts
	 * @param end : Node number where edge ends.
	 */
	public void removeEdge(int i,int j){
		if(i<=0 || i>=data.length){
			return;
		}	
		LinkedList<Integer> list=data[i];
		if(list!=null){
			list.remove(search(j,list));	
		}
	}
	/* 
	 * Description : checks an edge whether an edge exists from i to j 
	 * @param start	: Node number where edge starts
	 * @param end : Node number where edge ends.
	 */
	public boolean hasEdge(int i,int j){
		if(i<=0 || i>=data.length){
			return false;
		}	
		LinkedList<Integer> list=data[i];
		if(list!=null){
			int index=search(j,list);
			return index!=-1;
		}
		return false;
	}
	public int getEdge(int i,int j){
		if(i<=0 || i>=data.length){
			return -1;
		}	
		LinkedList<Integer> list=data[i];
		if(list!=null || list.size()<j){
			return list.get(j);
		}else{
					return -1;
		}
	}
}
