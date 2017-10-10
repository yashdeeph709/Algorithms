
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.FileReader;

class CountingRR{
	public static void main(String[] args) throws IOException{
		//BufferedReader br=new BufferedReader(new FileReader("tests/com/hackerearth/codemonk/implementation/CountingRR/BaseCases.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		//int noOfTestCases=Integer.parseInt(br.readLine());
		//while(noOfTestCases-->0){
			String line=br.readLine();
			//System.out.println(line);
			System.out.println(countRR(line));
		//}
	}//main ends
	public static int countRR(String s){
		int result=0,count=0;
		//System.out.println(s);
		boolean streak=false;
		for(int i=0;i<s.length();i++){
			if(s.charAt(i)=='r'){
				count+=1;
				streak=true;
			}else{
				result+=(count==0)?count:count-1;
				streak=false;
				count=0;
			}
		}
		if(streak){
			result+=(count-1);
		}
		return result;
	}
}//class ends
