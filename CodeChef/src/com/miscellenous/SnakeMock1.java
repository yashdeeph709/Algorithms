import java.io.*;

public class SnakeMock1{
	public static void main(String args[]) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int noOfTestcases=Integer.parseInt(br.readLine());
		while(noOfTestcases-->0){
			System.out.println("Running Test"+noOfTestcases);
			String[] line=br.readLine().split(" ");
			int N=Integer.parseInt(line[0]);
			int Q=Integer.parseInt(line[1]);
			line=br.readLine().split(" ");
			int[] snakes=new int[line.length];
			for(int i=0;i<snakes.length;i++){
				snakes[i]=Integer.parseInt(line[i]);
			}
			line=br.readLine().split(" ");
			for(int i=0;i<line.length;i++){
				int[] snakesnew=new int[snakes.length];
				System.arraycopy(snakes,0,snakesnew,0,snakes.length-1);
				findSurvivors(snakesnew,Integer.parseInt(line[i]));
				int count=0;
				for(int j=0;j<snakesnew.length;j++){
					if(snakesnew[i]>=Integer.parseInt(line[i])){
						count++;
					}
				}
				System.out.println(count);
			}
		}
	}
	/*public static void main(String args[]) throws Exception{
		int[] data=new int[]{1,2,3,4,5,0,-1,2,-3,5,8};
		int threshold=10;
		System.out.println(findMaximum(data,threshold));
		threshold=1;
		data=new int[]{2,3,4,5,6,7,8};
		System.out.println(findMaximum(data,threshold));

		System.out.println("EatTheOpponent Tests");
		data=new int[]{1,2,3,4,5,0,1,2,3,5,8};
		threshold=10;
		System.out.println(eatTheOpponent(data,data.length-1,threshold));
		int nextPlayer=findMaximum(data,threshold);
		data=new int[]{1,1,1,1,1,1,1};	
		threshold=2;
		System.out.println(eatTheOpponent(data,data.length-1,threshold));
		threshold=2;// it was 1
		System.out.println(eatTheOpponent(data,2,threshold));
		threshold=10;//it was 1
		data=new int[]{2,3,4,5,6,7,8};
		System.out.println(eatTheOpponent(data,3,threshold));
		threshold=100;
		data=new int[]{2,3,4,5,6,7,8};
		System.out.println(eatTheOpponent(data,nextPlayer,threshold));
		System.out.println(" Integration Test");
		data=new int[]{2,3,4,5,6,7,8};
		System.out.println(findSurvivors(data,10));
		System.out.println("All snakes have same length:10");
		data=new int[]{10,10,10,10,10,10};
		System.out.println(findSurvivors(data,11));
		threshold=1;
		data=new int[]{2,3,4,5,6,7,8};
		System.out.println(findSurvivors(data,threshold));
	}
	*/
	public static int findSurvivors(int[] snakes,int query) throws Exception{
		int player=findMaximum(snakes,query);
		int count=0;
		int i;
		for(i=0;i<snakes.length;i++){
			if(snakes[i]>query){
				break;
			}
		}
		if(i==snakes.length){
			return snakes.length;
		}
		while(player!=-1){
			count+=eatTheOpponent(snakes,player,query)?1:0;
			System.out.println("Player choosen"+player);
			player=findMaximum(snakes,query);
		}
		return count;
	}
	public static int findMaximum(int[] snakes,int threshold) throws Exception{
		int max=-1,index=-1;
		for(int i=0;i<snakes.length;i++){
			System.out.println((snakes[i]>max)+" Max check "+max+" "+snakes[i]+" "+(snakes[i]<threshold)+" "+threshold);
			if(snakes[i]!=0 && snakes[i]>max && snakes[i]<threshold){
				max=snakes[i];
				index=i;
			}
		}
		if(index==-1){
			System.out.println("No Snakes found which are winner");
			return index;
		}
		int i=0;
		for(i=0;i<snakes.length;i++){
			System.out.println("checking for snakes[index]"+snakes[index]+" "+index+" "+snakes[i]);
			if( snakes[i]!=0 && snakes[index]>=snakes[i] && i!=index){
				return index;
			}
		}
		if(i==snakes.length){
			return -1;
		}
		System.out.println("Choosen Snake"+index);	
		return index;
	}

	public static boolean eatTheOpponent(int[] snakes,int index,int threshold) throws Exception{
		if(snakes[index]>=threshold){
			throw new Exception("Incorrect value passed"+snakes[index]+" "+threshold);	
		}
		for(int i=0;i<snakes.length;i++){
			if(i!=index && snakes[index]>=snakes[i] && snakes[i]!=0){
				System.out.println("Eating snake of "+i);
				snakes[index]++;
				snakes[i]=0;
			}
			if(snakes[index]==threshold){
				return true;
			}
		}
		if(snakes[index]>=threshold){
			return true;
		}
		return false;
	}
}
