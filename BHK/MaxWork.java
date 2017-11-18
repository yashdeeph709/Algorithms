import java.io.*;
import java.util.*;

public class MaxWork{
	public static void main(String args[]) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String line[]=br.readLine().split(" ");
		int noOfworkers=Integer.parseInt(line[0]);
		int amtOfWork=Integer.parseInt(line[1]);
		line=br.readLine().split(" ");
		ArrayList<Integer> list=new ArrayList<Integer>();
		for(int i=0;i<line.length;i++){
			list.add(Integer.parseInt(line[i]));
		}
		Collections.sort(list);
		int maxFreq=0;
		for(int i=line.length-1;i>=0;i--){
			int workNeeded=0;
			int max=list.get(i);
			int j=0;
			int tempFreq=1;
			for(j=i-1;j>=0;j--){
				workNeeded+=max-list.get(j);
				if(workNeeded>amtOfWork){
					break;
				}else{
					tempFreq++;
				}
			}
			if(tempFreq>maxFreq){
				maxFreq=tempFreq;
			}
		}
		System.out.println(maxFreq);
	}
}
