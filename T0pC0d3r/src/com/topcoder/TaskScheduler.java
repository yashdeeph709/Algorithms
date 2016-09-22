package com.topcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class TaskScheduler {
	
	public String newMember(String[] list,int n){
		ArrayList<String> tasks=new ArrayList<String>(Arrays.asList(list));
		while(tasks.size()>n){
			tasks.remove(n);
			System.out.println(tasks.get(n-1));
		}
		return tasks.get(0);
	}
	
	public static void main(String[] args) {
		ArrayList<TaskSchedulerTestcase> testcases=new ArrayList<>();
		
		testcases.add(new TaskSchedulerTestcase("a",2,"a","b","c","d"));
		testcases.add(new TaskSchedulerTestcase("d",3,"a","b","c","d","e"));
		testcases.add(new TaskSchedulerTestcase("epsilon",1,"alpha","beta","gamma","delta","epsilon"));
		testcases.add(new TaskSchedulerTestcase("a",1000,"a","b"));
		testcases.add(new TaskSchedulerTestcase("n",17,"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t",
				"u","v","w","x","y","z"));
		testcases.add(new TaskSchedulerTestcase("fxjqzznvg",9000000,"zlqamum","yjsrpybmq","tjllfea","fxjqzznvg","nvhekxr","am","skmazcey","piklp",
				"olcqvhg","dnpo","bhcfc","y","h","fj","bjeoaxglt","oafduixsz","kmtbaxu",
				"qgcxjbfx","my","mlhy","bt","bo","q"));
		TaskScheduler taskScheduler=new TaskScheduler();
		
		Iterator<TaskSchedulerTestcase> testIterator=testcases.iterator();
		
		
		int i=1;
		while(testIterator.hasNext()){
			TaskSchedulerTestcase testcase=testIterator.next();
			if(testcase.answer.equals(taskScheduler.newMember(testcase.testlist,testcase.n))){
				System.out.println("Actual "+taskScheduler.newMember(testcase.testlist,testcase.n));
				System.out.println("Test "+(i++)+": Passed");
			}else{
				System.out.println("Actual "+taskScheduler.newMember(testcase.testlist, testcase.n));
				System.out.println("Test "+(i++)+": Failed");
			}
		}

	}
}
class TaskSchedulerTestcase{
	
	public String[] testlist;
	public int n;
	public String answer;
	public TaskSchedulerTestcase(String name,int n,String ...testlist){
		this.testlist=testlist;
		this.n=n;
		this.answer=name;
	}
}
	