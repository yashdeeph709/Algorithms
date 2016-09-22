package com.topcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Username {
	
	public String newMember(String[] existingNames,String newName){
		int max=0;
		boolean obvious=true;
		//n+nlogn+(n-2)
		ArrayList<Integer> names=new ArrayList<Integer>();
			for(int i=0;i<existingNames.length;i++){
				Pattern pattern=Pattern.compile("^"+newName+"(\\d+)");
				Matcher matcher=pattern.matcher(existingNames[i]);
				if(matcher.matches()){
					names.add(Integer.parseInt(matcher.group(1)));
					if(Integer.parseInt(matcher.group(1))>max){
						max=Integer.parseInt(matcher.group(1));
					}
				}
				
				if(existingNames[i].equals(newName)){
					obvious=false;
				}
			}
			if(obvious){
				return newName;
			}
			if(max==names.size()){
				return newName+(max+1); 
			}else{
				Collections.sort(names);
				int last=0;
				for(Integer i:names){
					if(i!=last+1){
						return newName+(last+1);
					}
				}
			}
	    return "hello";
	}
	
	public static void main(String[] args) {
		ArrayList<Testcase> testcases=new ArrayList<>();
		testcases.add(new Testcase("TygerTiger","TygerTiger","MasterOfDisaster", "DingBat", "Orpheus", "WolfMan", "MrKnowItAll"));
		testcases.add(new Testcase("TygerTiger","TygerTiger2","MasterOfDisaster", "TygerTiger1", "DingBat", "Orpheus", 
				 "TygerTiger", "WolfMan", "MrKnowItAll"));
		testcases.add(new Testcase("TygerTyger","TygerTyger","TygerTyger2000", "TygerTyger1", "MasterDisaster", "DingBat", 
				 "Orpheus", "WolfMan", "MrKnowItAll"));
		testcases.add(new Testcase("grokster","grokster1","grokster2", "BrownEyedBoy", "Yoop", "BlueEyedGirl", 
				 "grokster", "Elemental", "NightShade", "Grokster1"));
		testcases.add(new Testcase("Bart","Bart13","Bart4", "Bart5", "Bart6", "Bart7", "Bart8", "Bart9", "Bart10",
				 "Lisa", "Marge", "Homer", "Bart", "Bart1", "Bart2", "Bart3",
				 "Bart11", "Bart12"));
		testcases.add(new Testcase("HQu","HQu","lzO", "HQu65", "RAr", "gtY", "HQu18", "HQu26", "HQu70", "HQu60", "UpJ", "HHV", "HQu10", "HQu5", "eWI", "SQC", "HQu23", "ZvM", "HQu17", "TJG", "VDp", "HQu54", "HQu59", "nQd", "jYg", "pXB", "OQz", "bxj", "HQu31", "HQu12", "HQu64", "cdV", "HQu8", "MKs", "HQu19", "mAr", "HQu37", "HQu27", "PAA", "KFf", "HQu34", "nnn", "HQu6", "HQu21", "iGu", "HQu43", "HQu14", "AhW", "HQu4", "GLP", "HQu30", "Fgv"));
		testcases.add(new Testcase("kick","kick1","kick", "kick", "kick"));
		Username username=new Username();
		
		Iterator<Testcase> testIterator=testcases.iterator();
		
		
		int i=1;
		while(testIterator.hasNext()){
			Testcase testcase=testIterator.next();
			if(testcase.answer.equals(username.newMember(testcase.testlist,testcase.name))){
				System.out.println("Actual"+username.newMember(testcase.testlist,testcase.name));
				System.out.println("Test "+(i++)+": Passed");
			}else{
				System.out.println("Actual"+username.newMember(testcase.testlist, testcase.name));
				System.out.println("Test "+(i++)+": Failed");
			}
		}

	}
}
class Testcase{
	
	public String[] testlist;
	public String name;
	public String answer;
	public Testcase(String name,String answer,String ...testlist){
		this.testlist=testlist;
		this.name=name;
		this.answer=answer;
	}
}
	