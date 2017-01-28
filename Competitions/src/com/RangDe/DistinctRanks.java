package com.RangDe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
	
public class DistinctRanks{
	public static void main(String args[]) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int noOfTestCases=Integer.parseInt(br.readLine());
		while(noOfTestCases-->0){
			int size=Integer.parseInt(br.readLine());
			int[] array=new int[size];
			String[] numbers=br.readLine().split(" ");
			for(int i=0;i<array.length;i++){
				array[i]=Integer.parseInt(numbers[i]);
			}
			Arrays.sort(array);
			int effort=0;
			for(int i=array.length-1;i>=0;i--){
				effort+=findPlace(i,array);		
			}
			System.out.println(effort);
		}
/*	
		int[] array={1,2,3,4,5};
		System.out.println(find(0,4,2,array));
*/	}
	public static int findPlace(int i,int[] list){
		int effort=0;
		int searchTerm=list[i];
		while(find(0,list.length,searchTerm,list)){
			//printArray(list);
			searchTerm++;
			effort++;
		}	
		list[i]=searchTerm;
		return effort;
	}	
	public static boolean find(int start,int end,int x,int[] list){
		//System.out.println("find called with x="+x+"s:"+start+"e:"+end);
		//printArray(list);
		int mid=((end-start)/2)+start;
		if(mid==start || mid==end){
			return list[mid]==x;
		}	
		if(list[mid]<x){
			//System.out.println("calling find with find("+start+""+(mid-1)+""+x+"list");
			return find(mid+1,end,x,list);

		}
		if(list[mid]>x){
			//System.out.println("calling find with find("+(mid+1)+","+end+","+x+",list");

			return find(start,mid,x,list);
		}
		if(list[mid]==x){
			return true;
		}else{
			return false;
		}
	}
}
