package com.hackerrank.java;

public class Anagrams{
	public static void main(String args[]){

	}
	static boolean isAnagram(String a, String b) {
		a=a.toLowerCase();
		b=b.toLowerCase();
    	if(a.length()!=b.length()){
    		return false;
    	}else{
    		int[][] frequencies=new int[26][2];
    		for(int i=0;i<a.length();i++){
    			anagrams[(int)(a.charAt(i)-'a')-1][0]++;
    			anagrams[(int)(b.charAt(i)-'a')-1][1]++;
    		}
    		for(int i=0;i<26;i++){
    			if(anagrams[i][0]!=anagrams[i][1]){
    				return false;
    			}
    		}
    		return true;
    	}
    }
}