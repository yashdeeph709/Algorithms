package com.datastructures;

public class TrieTest{
	public static void main(String args[]){
		Trie t=new Trie();
		t.initialize();	
		String[] text="The addWord function consists of two parameters the vertex of the insertion and the word that will be added The idea is that when a string word is added to a vertex vertex we will add word to the corresponding branch of vertex cutting the leftmost character of word If the needed branch does not exist we will have to create it All the TopCoder languages can simulate the process of cutting a character in constant time instead of creating a copy of the original string or moving the other characters other".split("\\s");
		for(String word:text){
			t.addWord(word);
		}
		System.out.println(t.countWords("the"));
		System.out.println(t.countWords("yash"));
	}
}
class Trie{
	private int words;
	private int prefixs;
	private Trie edges[];
	
	public Trie(){
		words=0;
		prefixs=0;
		edges=new Trie[57];
	}

	public void setPrefixs(int prefixs){
		this.prefixs=prefixs;
	}

	public void setWords(int words){
		this.words=words;	
	}

	public int getPrefixs(){
		return prefixs;	
	}

	public int getWords(){
		return words;
	}

	public void initialize(){
		this.setWords(0);	
		this.setPrefixs(0);
		for(int i=0;i<26;i++){
			this.edges[i]=null;	
		}
	}

	public void addWord(String word){
		System.out.println(word);
		if(word==null){
			return;
		}
		if(word.length()==0){
			words+=1;		
		}else{
			prefixs+=1;
			int k=word.charAt(0)-'A';
			if(notExists(k)){
				System.out.println("Path doesn't exists for "+word.charAt(0));
				edges[k]=createEdge();
			}
			edges[k].addWord(word.substring(1));
		}
	}

	public Trie createEdge(){
		System.out.println("Added Vertex");
		Trie t=new Trie();
		t.initialize();
		return t;
	}

	private boolean notExists(int k){
		if(k>=0 && edges[k]!=null){
			return false;
		}
		return true;
	}

	public int countWords(String word){
			int k = word.charAt(0)-'A';
			if(word.length()==1){
				return getPrefixs();
			}else if(notExists(k)){
				return 0;
			}else{
				return edges[k].countWords(word.substring(1));		
			}
	}

}
