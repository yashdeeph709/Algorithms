package com.sedgewick;

public class PrintArray{
	public static void main(String args[]){
		boolean[][] array=new boolean[3][3];
		array[1][0]=true;
		array[1][2]=true;
		for(int i=0;i<array.length;i++){
			for(int j=0;j<array[i].length;j++){
				if(array[i][j]){
					System.out.print("*");	
				}else{
					System.out.print(" ");
				}
			}
		}
	}	
}
