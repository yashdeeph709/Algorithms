package com.hackerearth.codemonk.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BatmanTicTacToe{
	public static void main(String args[]) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int noOfTestCases = Integer.parseInt(line);
		//System.out.println("No of TestCases:"+noOfTestCases);
		while(--noOfTestCases>=0){
			int[][] gamePlay = getGamePlay(br);
		        printGamePlay(gamePlay);		
			if(hasWinningMove(gamePlay)){
				System.out.println("YES");
			}else{
				System.out.println("NO");
		        }		
		}
	}
	public static boolean hasWinningMove(int[][] gamePlay){
		//1 topleft
		//2 top
		//3 topright
		//4 left
		//5 right
		//6 bottomleft
		//7 bottom
		//8 bottomright
		//-1 invalid
		for(int i=0;i<4;i++){
			for(int j=0;j<4;j++){
				if(gamePlay[i][j]==1){
					for(int k=1;k<9;k++){
						int[] root={i,j};
						int[] root1={i,j};
						int[] source=root;
						source=calculatePosition(root,k);
						//System.out.println("Looking in direction "+k+" For root"+i+","+j);
						if(isValidLocation(source)){ 
							if(gamePlay[source[0]][source[1]]==1){
								int[] newSource=calculatePosition(source,k);
	//System.out.println("Two contigous isValid:"+isValidLocation(newSource)+"newSource("+newSource[0]+","+newSource[1]+")"+" gamePlay:"+(isValidLocation(newSource)?gamePlay[newSource[0]][newSource[1]]:-1));
								if(isValidLocation(newSource)){ 
									if(gamePlay[newSource[0]][newSource[1]]==0){
										return true;
									}
								}else{
									//System.out.println("Looking in opposite direction");
									//Lookup in opposite direction
									newSource=calculatePosition(root1,9-k);
									if(isValidLocation(newSource) && gamePlay[newSource[0]][newSource[1]]==1){
										//System.out.println("Valid Location:"+newSource[0]+" "+newSource[1]+" gamePlay"+gamePlay[newSource[0]][newSource[1]]);
										return true;
									}	
								}		
							}else if(gamePlay[source[0]][source[1]]==0){
									//System.out.println("Looking for alternate");
									source=calculatePosition(source,k);
									if(isValidLocation(source) && gamePlay[source[0]][source[1]]==1){
										return true;
									}
							}
						}else{
							//System.out.println("Invalid direction or no move here isValid:"+isValidLocation(source)+"Source("+source[0]+","+source[1]+")"+" gamePlay:"+(isValidLocation(source)?gamePlay[source[0]][source[1]]:-1));
						}
					}		
				}		
			}
		}
		return false;
	}
	public static boolean isValidLocation(int[] source){
		if(source[0]==-1 || source[1]==-1 || source[0]==4 || source[1]==4){
			return false;
		}else{
			return true;
		}
	}
	public static int[] calculatePosition(int[] source,int direction){
		switch(direction){
		        case 1:	
			source[0]=source[0]-1;
			source[1]=source[1]-1;	
			break;
			case 2:
			source[0]=source[0]-1;
			break;
			case 3:
			source[0]=source[0]-1;
			source[1]=source[1]+1;
			break;
			case 4:
			source[1]=source[1]-1;
			break;
			case 5:
			source[1]=source[1]+1;
			break;
			case 6:
			source[0]=source[0]+1;
			source[1]=source[1]-1;
			break;
			case 7:
			source[0]=source[0]+1;
			break;
			case 8:
			source[0]=source[0]+1;
			source[1]=source[1]+1;
			break;
		}
		return source;
	}
	public static int[][] getGamePlay(BufferedReader br) throws Exception{
		int[][] gamePlay=new int[4][4];
		for(int lineNo=0;lineNo<4;lineNo++){
			String line = br.readLine();
			for(int charNo=0;charNo<4;charNo++){
				if(line.charAt(charNo)=='x'){
					gamePlay[lineNo][charNo]=1;
				}
				if(line.charAt(charNo)=='o'){
					gamePlay[lineNo][charNo]=-1;
				}
				if(line.charAt(charNo)=='.'){
					gamePlay[lineNo][charNo]=0;
				}
			}
		}
		return gamePlay;
	}
	public static void printGamePlay(int[][] gamePlay){
		for(int i=0;i<gamePlay.length;i++){
			for(int j=0;j<gamePlay[i].length;j++){
				//System.out.print(" "+gamePlay[i][j]);
			}
			//System.out.println();
		}
	}
}
