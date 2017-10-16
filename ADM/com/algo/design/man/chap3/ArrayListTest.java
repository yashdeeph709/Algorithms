package com.algo.design.man.chap3;

public class ArrayListTest{
	public static void main(String[] args)throws Exception{
		testInsert(10);
	}
	public static void testInsert(int size)throws Exception{
		ArrayList n=new ArrayList();
		for(int i=0;i<size;i++){
			n.add(i);
		}
		for(int i=0;i<size;i++){
			try{
				int f=n.get(i);
				if(i!=f){
					System.out.println("test insert failure"+i+"=="+f);	
					return;
				}
			}
			catch(Exception e){
				e.printStackTrace();
				System.out.println("Exception occured");
			}
		}
		System.out.println("Test Passed Successfully");

	}
	public static class ArrayList{
		private int[] data;
		private int length;

		public ArrayList(){
			data=new int[1<<5];
			length=0;
		}
		public void add(int d){
			if(length==data.length-1){
				int[] array=new int[data.length*2];
				for(int i=0;i<data.length;i++){
					array[i]=data[i];
				}
				data=array;
				data[length]=d;
				length++;
				return;
			}	
			data[length]=d;
			length++;
		}
		public int get(int i) throws Exception{
			if(i<0 || i>data.length){
				throw new Exception("ArrayIndexOutOfBoundException Occured"+i+" is not a correct index");
			}
			return data[i];
		}
		public int length(){
			return length-1;
		}
	}
}

