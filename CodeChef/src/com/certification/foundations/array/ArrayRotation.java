package com.certification.foundations.array;


public class ArrayRotation{
	public static void main(String args[]){
		
		int rotation=2;
		for(int i=1;i<10;i++){
			int[] array=new int[]{
					1,2,3,4,5,6,7,8,9,10,11,12,13,14
			};
		//	if(gcd(array.length,i)==1){
				rotateBlockWiseGCD(array,i);
		//	}
			printArray(array,i);
		}
	}
	public static int gcd(int size,int rotation){
		if(rotation==0){
			return size;
		}else{
			return gcd(rotation,size%rotation);
		}
	}
	public static void printArray(int[] array,int rotation){
		for(int i=0;i<array.length;i++){
			System.out.print(array[i]+":");
		}	
		System.out.println("rotation:"+rotation);
	}
	public static void rotateBlockWiseGCD(int[] array,int rotation){
		for(int i=0;i<gcd(array.length,rotation);i++){
			int temp=array[i];
			int destination=i;
			while(true){
				int source=destination+rotation;
				if(source>=array.length){
					source = source - array.length;
				}
				if(source==i){
					break;
				}
				array[destination]=array[source];
				destination=source;
			}
			array[destination]=temp;
		}	
	}
	public static void rotateOdd(int[] array,int rotation){
		int i=0,counter=0;
		int temp=0;
		while(counter!=array.length){
			//System.out.printf("Before:temp:%d,rotation:%d,counter:%d,array[i]:%d,i:%d,array.length:%d\n",temp,rotation,counter,array[i],i,array.length);
			//System.out.printf("(i+rotation)<array.length:%b\n",(i+rotation)<array.length);
			if((i+rotation)<array.length){
				int tem=array[i+rotation];
				array[i+rotation]=counter==0?array[i]:temp;
				temp=tem;
				i=i+rotation;
			}else{
				int tem=array[(i+rotation)-array.length];	
				array[(i+rotation)-array.length]=counter==0?array[i]:temp;
				temp=tem;
				i=(i+rotation)-array.length;
			}
			//printArray(array,rotation);
			//System.out.printf("After:temp:%d,rotation:%d,counter:%d,array[i]:%d,i:%d,array.length:%d\n",temp,rotation,counter,array[i],i,array.length);
			counter++;
		}		
	}
	public static void rotateEven(int[] array,int rotation){
		for(int i=0;i<rotation;i++){
			int index=i,temp=0;
			int start=array[index];
			int counter=0;
			while(counter<=array.length/rotation){
			//	System.out.printf("Before:temp:%d,rotation:%d,array[i]:%d,index:%d,array.length:%d\n",temp,rotation,array[i],index,array.length);
				if((index+rotation)<array.length){
					int tem=array[index+rotation];
					array[index+rotation]=index==i?array[index]:temp;
					temp=tem;
					index=index+rotation;
				}else{
					int tem=array[(index+rotation)-array.length];	
					array[(index+rotation)-array.length]=index==i?array[index]:temp;
					temp=tem;
					index=(index+rotation)-array.length;
				}
				//printArray(array);
			//	System.out.printf("After:temp:%d,rotation:%d,array[i]:%d,index:%d,array.length:%d\n",temp,rotation,array[i],index,array.length);
				counter++;
			}
		}	
	}
}
