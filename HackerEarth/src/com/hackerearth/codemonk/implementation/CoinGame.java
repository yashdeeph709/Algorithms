
import java.io.BufferedReader;
import java.util.stream.Collectors;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class CoinGame{
	public final static int[] poweroftwo={1,2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 131072, 262144, 524288, 1048576, 2097152, 4194304, 8388608, 16777216, 33554432, 67108864, 134217728, 268435456, 536870912, 1073741824};
	public static void main(String args[]) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));		
		int noOfTestCases=Integer.parseInt(br.readLine());	
		while(noOfTestCases-->0){
			br.readLine();
			List<Integer> piles=Arrays.asList(br.readLine().split(" "))
				.stream().map(Integer::parseInt).collect(Collectors.toList());
			if(findWinner(piles)){
				System.out.println("Alan");
			}else{
				System.out.println("Charlie");
			}
		}	
	}
	public static boolean findWinner(List<Integer> piles){					
		int totalMoves=0;
		for(Integer i :piles){
			//System.out.println("Processing pile"+i);
			if(i%2!=0){
				continue;
			}
			if(i!=0 && (i&(i-1))==0){
				int totalPower2Move=findLogBase2ForPowerOf2(i);		
				//System.out.println("coins in pile are "+i+" Number of times it can be halved"+totalPower2Move);
				totalMoves+=totalPower2Move;
			}else{
				int totalMoves1=numOfTrailingZeros(i);
				//System.out.println("coins in pile are "+i+" Number of times it can be halved"+totalMoves1);
				totalMoves+=totalMoves1;
			}
		}
		if(totalMoves%2==0){
			return true;
		}else{
			return false;
		}
	}
	public static int findLogBase2ForPowerOf2(int number){
		int result=0,low=0,high=poweroftwo.length;
		int mid=0;
		while(true){
			mid=(high+low)/2;
			if(poweroftwo[mid]==number){
				//System.out.println("mid for number"+number+" is "+mid);
				return mid;
			}else if(poweroftwo[mid]<number){
				low=mid;
				//System.out.println("Number is greater than"+poweroftwo[mid]+" I will check "+high+","+low);
			}else if(poweroftwo[mid]>number){
				high=mid;
				//System.out.println("Number is less than"+poweroftwo[mid]+" I will check "+high+","+low);
			}
		}	
	}
	public static int numOfTrailingZeros(int i){
		    int y;
	            if (i == 0) return 32;
	            int n = 31;
	 	    y = i <<16; if (y != 0) { n = n -16; i = y; }
	            y = i << 8; if (y != 0) { n = n - 8; i = y; }
		    y = i << 4; if (y != 0) { n = n - 4; i = y; }
		    y = i << 2; if (y != 0) { n = n - 2; i = y; }
		    return n - ((i << 1) >>> 31);
	} 
}
