package com.techgig.samsung;

public class ChocolateDistribution{
	public static int[][] Solutions=new int[1000][1000];
	public static void main(String args[]){
//		System.out.println(getChunks(2,8));	
//		System.out.println(getChunks(2,9));	
//		System.out.println(getChunks(2,10));	
//		System.out.println(getChunks(3,8));	
//		System.out.println(getChunks(3,9));	
//		System.out.println(getChunks(3,10));	
//		System.out.println(getChunks(4,8));	
//		System.out.println(getChunks(4,9));	
//		System.out.println(getChunks(4,10));	
//		System.out.println(getChunks(4,10);	
//		System.out.println(getChunks(4,10);	
//		System.out.println(getChunks(4,10);	
//		System.out.println(getChunks(4,10);	
//		System.out.println(getChunks(4,10);	
		System.out.println(getBars(5,6,3,4));
	}	
	public static int getBars(int input1,int input2,int input3,int input4){
		int result=0;
		for(int i=input1;i<=input2;i++){
			for(int j=input3;j<=input4;j++){
				System.out.println("Starting Count for "+i+"*"+j);
			 	int temresult=getChunks(i,j);
				System.out.println("And result is "+temresult);
				result+=temresult;
			}
		}
		return result;
	}
	public static int getChunks(int x,int y){
		if(Solutions[x][y]!=0){
			System.out.println("Dyna Impact");
			return Solutions[x][y];
		}
		int count=0;
		while(x!=0 || y!=0){
			if(Solutions[x][y]!=0){
				count+=Solutions[x][y];
				break;
			}
			if(x<y){
				count+=1;
				y=y-x;
				continue;
			}
			if(y<x){
				count+=1;
				x=x-y;
			}
			if(x==y){
				count+=1;
				x=0;
				y=0;
			}
			if(x==1 || y==1){
				count+=x==1?y:x;
				x=0;
				y=0;
			}
		}
		Solutions[x][y]=count;
		Solutions[y][x]=count;
		return count;
	}
}
