package com.certification.foundations.recursions;

class AllSubsequencesString{
	public static void main(String args[]){
		System.out.println(subsequences("abcde"));
		//System.out.println(allSubStrings("abcde"));
	}
	public static String subsequences(String word){
		if(word.isEmpty()){
			return "";
		}else{
			char firstletter = word.charAt(0);
			String restOfword= word.substring(1);

			String subsequenceOfRest = subsequences(restOfword);
			System.out.printf("subsequenceOfRest:%s,sequences:%s\n",restOfword,subsequenceOfRest);
			String result = "";
			for(String subsequence : subsequenceOfRest.split(",",-1)){
				result +=","+subsequence;
				result +=","+firstletter+subsequence;
			}
			result = result.substring(1);
			return result;
		}
	}
	public static String allSubStrings(String word){
		if(word.isEmpty()){
			return "";
		}else{
			allPartitions(word);
			return allSubStrings(word.substring(1));
		}
	}
	public static String allPartitions(String word){
		if(word.isEmpty()){
			return "";
		}else{
			System.out.println(word);
			return allPartitions(word.substring(0,word.length()-1));
		}
	}
}
