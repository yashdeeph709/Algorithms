package com.algo.design.man.chap4;

public class DisjointSetUsingArray{
	public static void main(String[] args) throws Exception{
		DisjointSet ds=new DisjointSet(10);
		for(int i=0;i<10;i++){
			ds.makeSet(i);
		}
		ds.union(1,2);
		ds.union(1,3);	
		ds.union(5,1);
		ds.union(2,8);
		ds.print();
		if(ds.find(3)==ds.find(2)){
			System.out.println("2 and 3 are in same set");
		}
		if(ds.find(8)!=ds.find(3)){
			System.out.println("8 and 3 are in different set");
		}
	}
	static class DisjointSet{
		int[] parent;
		int n;
		
		public DisjointSet(int n){
			parent=new int[n];
			this.n=n;
		}
		public void makeSet(int element) throws Exception{
			if(parent[element]==0){
				parent[element]=element;
			}else{
				throw new Exception("Set already Exists");
			}
		}
		public int find(int i){
			if(parent[i]==i){
				return i;
			}
			parent[i]=find(parent[i]);
			return parent[i];
		}
		public void union(int i,int j){
			int iroot=find(i);
			int jroot=find(j);
			this.parent[iroot]=jroot;
		}
		public void print(){
			String[] sets=new String[parent.length];
		
			for(int i=0;i<parent.length;i++){
				if(i==parent[i]){
					sets[i]="Set of "+i+":";
					for(int j=0;j<parent.length;j++){
						if(find(j)==i){
							sets[i]+=j==parent.length-1?j:j+",";
						}
					}
					System.out.println(sets[i]);
				}	
			}
		}
	}
}
