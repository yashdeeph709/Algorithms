import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class StringSearch {
	//Input asdfasdfasdf and test asd
	private static Scanner sc;
	public static void main(String[] args) throws FileNotFoundException {
		sc = new Scanner(new File("C:\\Users\\c5244128\\Desktop\\HackerZone\\ICPC\\Tests\\StringSearchTests"));
		int testCases=0;
		testCases=sc.nextInt();
		while(testCases-->0){
			String master=sc.next();
			String test=sc.next();
			Finder f =new Finder(master,test);
			if(f.findFirst()){
				System.out.println("YES");
			}else{
				System.out.println("NO");
			}
		}
	}
}

class Finder{
	String master;
	String test;
	String[] listOfOccurences;
	
	public Finder(String master, String test) {
		super();
		this.master = master;
		this.test = test;
		this.listOfOccurences = new String[26];
		for(int j=0;j<listOfOccurences.length;j++){
			listOfOccurences[j]="";
		}
		for(int i=0;i<master.length();i++){
			listOfOccurences[((int)master.charAt(i))-97]+=listOfOccurences[((int)master.charAt(i))-97]==""?i:","+i;
		}
	}

	public boolean findFirst() {
		int index=((int)test.charAt(0))-97;
		String s[]=listOfOccurences[index].split(",");
		
		for(String t:s){
			if(t==""){
				return false;
			}else{
//				System.out.println("going for occurence number"+Integer.parseInt(t));
				if(master.substring(Integer.parseInt(t),Integer.parseInt(t)+test.length()).equals(test)){
					return true;
				}
			}
		}
		return false;
	}
}