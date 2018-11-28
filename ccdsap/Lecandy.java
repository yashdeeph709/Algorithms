import java.io.*;

public class Lecandy{
	public static void main(String args[]) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		while(T-->0){
			String[] line=br.readLine().split(" ");
			int N=Integer.parseInt(line[0]);
			int C=Integer.parseInt(line[1]);
			int[] elephants=new int[N];	
			line=br.readLine().split(" ");			
			for(int i=0;i<line.length;i++){
				elephants[i]=Integer.parseInt(line[i]);
			}
			if(checkCandies(elephants,C)){
				System.out.println("Yes");
			}else{
				System.out.println("No");
			}
		}

	}
	

	public static boolean checkCandies(int[] elephants,int C){
		int sum=0;
		for(int i=0;i<elephants.length;i++){
			sum+=elephants[i];
		}
		if(sum>C){
			return false;
		}
		return true;
	}
}
