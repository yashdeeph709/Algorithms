package com.lendingkart;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


//TestCase 1: Hydra HydraHydra Pass
//TestCase 2: Hydra HydraScene Fail
//TestCase 3: Hydra HydraHydraa Fail
//TestCase 4: Hydra HydraScen Fail
//TestCase 5: Hydra HydraHydr Fail
//TestCase 6: Hydra HydHydrara Pass
//TestCase 7: Hydra HydardyHra Fail : frequency matches but not expected to possible.

public class DaisyPassword{
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        int noOfTestCases = Integer.parseInt(br.readLine());
		while(noOfTestCases-->0){
			String line = br.readLine();
			String S = line.split(" ")[0];
			String P = line.split(" ")[1];
			System.out.println(checkPossiblity(S,P)?"Possible":"Impossible");
		}	
	}
	public static boolean checkPossiblity(String S,String P){
		if(P.length()!=S.length()*2){
			return false;
		}
		Pattern r = Pattern.compile(S);
		Matcher m = r.matcher(P);
		if(m.find())
/*
		boolean contains=false;
		for(int i=0;i<S.length();i++){
			if(S.charAt(i)!=P.charAt(i)){
				String peice=P.substring(i,i+S.length());
				System.out.println(peice);
				if(!peice.equals(S)){
				    return false;
				}
				i+=S.length();
			}
		}
*/
		return true;
	}
}
