import java.io.*;
import java.util.*;

public class FafaAndHisCompany{
	public static void main(String args[]) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		System.out.println(findWays(n));
	}
	public static int findWays(int n){
		if(n==0 || n==1){
			return 0;
		}
		int count=0;
		for(int i=1;i<n;i++){
			if((n-i)%i==0){
				count++;
			}
		}
		return count;
	}
}
