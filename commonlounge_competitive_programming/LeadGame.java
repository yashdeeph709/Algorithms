import java.io.*;

public class LeadGame{
	public static void main(String args[]) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int noOfRounds=Integer.parseInt(br.readLine());
		int[][] rounds=new int[noOfRounds][2];
		String[] line;
		int lastsum1=0,lastsum2=0;
		for(int i=0;i<noOfRounds;i++){
			line=br.readLine().split(" ");
			int player1=lastsum1+Integer.parseInt(line[0]);
			int player2=lastsum2+Integer.parseInt(line[1]);
			rounds[i][0]=player1>player2?1:2;
			rounds[i][1]=player1>player2?player1-player2:player2-player1;
			lastsum1=player1;
			lastsum2=player2;
		}
		int max=rounds[0][1],winner=rounds[0][0];
		for(int i=1;i<noOfRounds;i++){
			if(max<rounds[i][1]){
				max=rounds[i][1];
				winner=rounds[i][0];
			}
		}
		System.out.println(winner+" "+max);
	}
}
