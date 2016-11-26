package org.geeksforgeeks;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

public class FrequencySort{
	public static void main(String args[]){
		try{
			BufferedReader reader=new BufferedReader(new FileReader(new File("../resources/FrequencySort.test")));
			int noOfTestCases=Integer.parseInt(reader.readLine());
			System.out.println("noOfTestCases:"+noOfTestCases);
			while(noOfTestCases-->0){
				System.out.println("TestCase:"+noOfTestCases);
				String line=reader.readLine();
				int length=Integer.parseInt(line);
				String[] array=reader.readLine().split(" ");
				int[] arr=new int[length];
				for(int i=0;i<array.length;i++){
					arr[i]=Integer.parseInt(array[i]);
					System.out.print(arr[i]+" ");
				}	
				int[] result=frequencySort(arr);
				System.out.println("");
				}
		}catch(FileNotFoundException fnf){
			fnf.printStackTrace();
		}catch(IOException ioe){
			ioe.printStackTrace();
		}
	}
	public static int[] frequencySort(int[] arr){
		int length=arr.length;
		Arrays.sort(arr);
		int[][] result=new int[length][2];
		int[] frequencies=new int[length];
		frequencies[0]=1;
		int last=arr[0],counter=0;
		for(int i=1;i<arr.length;i++){
			if(arr[i]!=last){
//				System.out.println("element "+last+" counter "+counter+" frequencies "+frequencies[counter]);
				result[counter][0]=last;
				result[counter][1]=frequencies[counter];
				last=arr[i];
				counter++;
			}
			++frequencies[counter];
		}
		result[counter][0]=last;
		result[counter][1]=frequencies[counter];
		for(int i=0;i<result.length;i++){
			for(int j=i+1;j<result.length;j++){
				if(result[i][1]<result[j][1]){
					int temp1=result[i][1],temp2=result[i][0];
					result[i][1]=result[j][1];
					result[i][0]=result[j][0];
					result[j][1]=temp1;
					result[j][0]=temp2;
				}
			}
		}
		for(int i=0;i<result.length;i++){
			System.out.println("Element is :"+result[i][0]+" frequencies:"+result[i][1]);
		}
		int index=0;
		for(int i=0;i<result.length;i++){
			if(result[i][1]!=0){
				for(int j=0;j<result[i][1];j++){
					arr[index+j]=result[i][0];
				}
				index+=result[i][1];
			}
		}
		printArray(arr);
		return arr;
	}
	public static void printArray(int[] arr){
		System.out.println();
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
	}
}