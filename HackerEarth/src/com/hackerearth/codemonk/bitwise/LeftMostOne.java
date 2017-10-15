
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LeftMostOne{
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int noOfTests=Integer.parseInt(br.readLine());
		while(noOfTests-->0){
			int number=Integer.parseInt(br.readLine());
			int count=0;
			while(number!=0){
				number=number&(number-1);
				count++;
			}
			System.out.println(count);
		}
	}
}
