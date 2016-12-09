package com.hackerearth.codemonk.implementation;
/* IMPORTANT: Multiple classes and nested static classes are supported */
 
import java.util.*;
 
class TestClass {
    public static void main(String args[] ) throws Exception {
 
        Scanner s = new Scanner(System.in);
        String input = s.next();
        String character = s.next();
        int substringsLength = s.nextInt();
        
        int maxFrequency = getMaxFrequency(input, character, substringsLength);
        int position = -1;
        int [] frequencies = getFrequencies(input, character, substringsLength-1);
		for(int i=frequencies.length-1;i>=0;i--){
			if(frequencies[i] == maxFrequency){
				position=i+substringsLength-1;
				break;
			}
		}
		System.out.println(position);
 
    }
    
    private static int getMaxFrequency(String input, String character, int substringsLength){
    	int noOfSubstrings = input.length() - substringsLength;
        int maxFrequency = 0;
        String substr =null;
        for(int i=0; i<=noOfSubstrings; i++){
        	substr = input.substring(i,i+substringsLength);
        	int count = countMatches(substr, character);
        	if (count > maxFrequency){
        		maxFrequency = count;
        	}
        }
		return maxFrequency;
    }
    
    private static int[] getFrequencies(String input, String character, int substringsLength){
    	int noOfSubstrings = input.length()+1 - substringsLength;
        int [] frequencies = new int[noOfSubstrings];
        String substr =null;
        for(int i=0; i<noOfSubstrings; i++){
        	substr = input.substring(i,i+substringsLength);
        	int count = countMatches(substr, character);
        	frequencies[i]=count;
        }
		return frequencies;
    }
    
    private static int countMatches(String string, String character){
    	int noOfOccurences =-1;
    	int index=-1; 	
    
    	do{
    		index=string.indexOf(character,index+1);
    		noOfOccurences++;
    	}
    	while(index != -1);
   			return noOfOccurences;
    }
}