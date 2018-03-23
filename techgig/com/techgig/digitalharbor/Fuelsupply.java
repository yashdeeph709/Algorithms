package com.techgig.digitalharbor;

import java.io.*;
import java.util.*;

public class Fuelsupply{
	public static void mainChange(String args[]){
		int[] storage=new int[]{3,0,0,2,0,4};
		String[] result=findHoles(storage);	
		print(result,"Test1");
		storage=new int[]{0,2,0,2,1,0,1,3,2,1,2,1,2,0,1,0,2};
		result=findHoles(storage);
		print(result,"Test2");
		storage=new int[]{2,0,2};
		result=findHoles(storage);
		print(result,"Test3");
		storage=new int[]{5,1,2,3,4};
		result=findHoles(storage);
		print(result,"Test4");
	}
	public static void print(String[] holes,String Testname){
		System.out.println("Starts: "+Testname);
		for(String hole:holes){
			System.out.println(hole);
		}
		System.out.println("Ends: "+Testname);
	}
	public static void main(String args[]) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] storagestr=br.readLine().split(",");
		int[] storage=new int[storagestr.length];
		for(int i=0;i<storagestr.length;i++){
			storage[i]=Integer.parseInt(storagestr[i]);
		}
		int[] fuels=new int[4];
		String[] fuelsStr=br.readLine().split("#");
		for(int i=0;i<fuels.length;i++){
			fuels[i]=Integer.parseInt(fuelsStr[i].split(":")[1]);
		}
		String[] result=findHoles(storage);
		ArrayList<Hole> holes=new ArrayList<Hole>();
		for(int i=0;i<result.length;i++){
			String[] data=result[i].split(" ");
			holes.add(new Hole(Integer.parseInt(data[0]),Integer.parseInt(data[1]),Integer.parseInt(data[2])));
		}
		Collections.sort(holes,new Comparator<Hole>(){
			public int compare(Hole a,Hole b){
				if(a.volume>b.volume) return -1;
				if(a.volume<b.volume) return 1;
				else			 return 0;
			}
		});
		System.out.println(holes);
	}
	public static String[] findHoles(int[] storage){
		ArrayList<String> holes=new ArrayList<String>();	
		for(int i=0;i<storage.length;i++){
			int volume=0;
			if(storage[i]==0){
				continue;
			}
			for(int j=i+1;j<storage.length;j++){
				if(storage[i]>storage[j]){
					volume+=storage[i]>storage[j]?storage[i]-storage[j]:storage[j]-storage[i];
					if(j-i>1 && storage[j]!=0){
						int v=0;
						for(int x=j-1;x>i;x--){
							if(storage[x]>=storage[j]){
								x=i+1;	
								v=0;
							}else{
								v+=storage[j]-storage[x];
							}
						}
						if(v!=0){
							holes.add(i+" "+j+" "+v);
						}
					}
				}else{
					if(volume!=0){
						holes.add(i+" "+j+" "+volume);
					}
					break;
				}
			}
		}
		return holes.toArray(new String[holes.size()]);
	}
	static class Hole implements Comparable<Hole>{
		public int i;
		public int j;
		public int volume;

		public Hole(int i,int j,int volume){
			this.i=i;
			this.j=j;
			this.volume=volume;
		}
		public String toString(){
			return "From "+i+" To "+j+" "+volume;
		}
		@Override
		public int compareTo(Hole b){
			if(this.volume>b.volume) return 1;
			if(this.volume<b.volume) return -1;
			else			 return 0;
		}
	}
}
