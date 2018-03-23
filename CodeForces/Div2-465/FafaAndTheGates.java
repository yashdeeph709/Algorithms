import java.io.*;
import java.util.*;

public class FafaAndTheGates{
	public static void main(String args[]) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		String commands=br.readLine();
		System.out.println(findCost(commands));
	}
	public static int findCost(String commands) throws Exception{
		int cost=0,x=0,y=0;
		int kingdom=0,prevkingdom=0;
		for(int i=0;i<commands.length();i++){
			if(commands.charAt(i)=='U'){
				y++;	
			}else{
				x++;
			}
			prevkingdom=kingdom;
			kingdom=getKingdom(prevkingdom,x,y);
			if(kingdom!=0 && prevkingdom!=0 && prevkingdom!=kingdom){
				cost++;
			}
		}
		return cost;
	}
	public static int getKingdom(int prevkingdom,int x,int y) throws Exception{
		if(y>x){
			return 2;
		}else if(x>y){
			return 1;
		}else if(x==y){
			return prevkingdom;
		}else{
			throw  new Exception("Wrong Input");
		}
	}
}
