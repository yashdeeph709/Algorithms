/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	public static void main (String[] args) throws java.lang.Exception
	{
		String[] input1={"hello","hello","hello"};
		String input2="ell";
		if(diagonalCheck(input1,input2,0,1,0)){
			System.out.println("Passed");
		}
		if(diagonalCheck(input1,"ell",2,1,-1)){
			System.out.println("Passed");
		}
		if(diagonalCheck(input1,"lle",0,3,1)){
			System.out.println("Passed");
		}
		if(checkHorizontalAndVertical(input1,"hello",0,1,0)){
			System.out.println("Failed");
		}
		if(checkHorizontalAndVertical(input1,"hello",1,0,1)){
			System.out.println("Failed");
		}
		if(checkHorizontalAndVertical(input1,"ello",0,1,0)){
			System.out.println("Passed");
		}
		if(checkHorizontalAndVertical(input1,"hello",1,0,0)){
			System.out.println("Passed");
		}
	
	}
	public static boolean diagonalCheck(String[] input1,String input2,int i,int j,int k){
		int rowdiff=0,coldiff=0;
		switch(k){
		    case 0:
			rowdiff=1;
			coldiff=1;
		    break;
		    case 1:
			rowdiff=1;
			coldiff=-1;
		    break;
		    case -1:
			rowdiff=-1;
			coldiff=1;
		    break;
		}

		if(k==0 && (i+input2.length()-1>input1.length || j+input2.length()-1>input1[0].length())){
		    return false;
		}
		if(k==-1 && (input2.length()>i+1 || j+input2.length()-1>input1[0].length())){
		    return false;
		}
		if(k==1 && (i+input2.length()-1>input1.length || input2.length()>j+1)){
		    System.out.println("k==1");
		    return false;
		}

		int col=j,row=i,x=0;
		boolean result=false;
		//System.out.println("row="+row+",col="+col+",input1[row]="+input1[row]+",input2="+input2+",x"+x);
		while(input1[row].charAt(col)==input2.charAt(x)){
		    //System.out.println("row="+row+",col="+col+",input1[row]="+input1[row]+",input2="+input2+",x"+x);
		    row+=rowdiff;
		    col+=coldiff;
		    x++;
		    if(x==input2.length()){
			    result=true;
			    break;
		    }
		}
		return result;
    	}
	/*
	 * k=0 horizontal ell in hello
	 * k=1 vertical lll in hello,hello,hello 
	 */
	public static boolean checkHorizontalAndVertical(String[] input1,String input2,int i,int j,int k){
		if(k==0 && (j+input2.length()-1<input1[0].length())){
			int rowdiff=0,coldiff=1;
			int row=i,col=j,x=0;
			boolean result=false;
			while(input1[row].charAt(col)==input2.charAt(x)){
				row+=rowdiff;
				col+=coldiff;
				x++;
				if(x==input2.length()){
					result=true;
					break;
				}
			}
			return result;
		} 
		if(k==1 && (i+input2.length()-1<input1.length)){
			int rowdiff=1,coldiff=0;
			int row=i,col=j,x=0;
			boolean result=false;
			while(input1[row].charAt(col)==input2.charAt(x)){
				row+=rowdiff;
				col+=coldiff;
				x++;
				if(x==input2.length()){
					result=true;
					break;
				}
			}
			return result;
		}
		return false;
	}
}
