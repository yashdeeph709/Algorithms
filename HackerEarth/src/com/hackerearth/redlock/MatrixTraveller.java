package com.hackerearth.redlock;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class MatrixTraveller{
	    public static void main(String args[] ) throws Exception {
		    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		    Integer noOfTestcases = Integer.parseInt(br.readLine());
		    while(noOfTestcases-->0){
			String[] target=br.readLine().split(" ");	
			int n=Integer.parseInt(target[0]);
			int m=Integer.parseInt(target[1]);
			int k=Integer.parseInt(target[2]);
		    	HashMap<String,Integer> specialcells=new HashMap<>();
			for(int i=0;i<k;i++){
				String tokens[]=br.readLine().split(" ");
				specialcells.put(tokens[0]+" "+tokens[1],Integer.parseInt(tokens[2]));
			}
			System.out.println(findPathStrength(specialcells,1,1,n,m));
		    }	
	    }
	    /*public static void main(String[] args){
		    int[][] specialRaw=new int[][]{
			    {4,2,3},{1,2,3},{5,2,3},{4,3,3},{5,1,3}
		    };
		    ArrayList<Specialcell> list=new ArrayList<Specialcell>();
		    for(int i=0;i<specialRaw.length;i++){
			    Specialcell specialcell=new Specialcell();
			    specialcell.x=specialRaw[i][0];		
			    specialcell.y=specialRaw[i][1];
			    specialcell.k=specialRaw[i][2];
			    list.add(specialcell);
		    }
		    Collections.sort(list); 
		    System.out.println(list);
	    }*/
	    public static int findPathStrength(HashMap<String,Integer> specialcells,int x,int y,int n,int m){
		    	//System.out.println("findPathStrength:"+x+" "+y+" "+n+" "+m+" "+findCellPower(specialcells,x,y));
			int sum=0;
			sum+=specialcells.get(x+" "+y)!=null?specialcells.get(x+" "+y):0;
			if(x<n){
				sum+=findPathStrength(specialcells,x+1,y,n,m);
			}		
			if(y<m){
				sum+=findPathStrength(specialcells,x,y+1,n,m);
			}
			return sum;
	    }
	    /*public static int findCellPower(ArrayList<Specialcell> specialcells,int low,int high){
		     
		    return 0;
	    }
	    static class Specialcell implements Comparable<Specialcell>{
		    public int x;
		    public int y;
		    public int k;
		    public Specialcell(){
		    }
		    public int compareTo(Specialcell cell){
			int result=Integer.compare(cell.x,this.x);
			if(result==0){
				result=Integer.compare(cell.y,this.y);
			}
			return result;
		    }
		    public String toString(){
			    return x+" "+y+" "+k;
		    }
	    }*/
}

