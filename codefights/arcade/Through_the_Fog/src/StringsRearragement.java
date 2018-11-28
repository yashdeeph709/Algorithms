import java.io.*;
import java.util.*;

public class StringsRearragement{
	public static void main(String args[]) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int noOfTestCases=Integer.parseInt(br.readLine());
		while(noOfTestCases-->0){
			String[] testdata=br.readLine().split(" ");
			boolean expected=Boolean.parseBoolean(br.readLine());
			boolean actual=stringsRearrangement(testdata);
			if(actual==expected){
				System.out.println("Test no. "+noOfTestCases+" Passed!");
			}else{
				System.out.println("Test no. "+noOfTestCases+" Failed!");
			}
		}
	}
	public static boolean stringsRearrangement(String[] inputArray){

		return false;
	}
}
