import java.io.*;
import java.util.*;
import java.util.Collections;
public class HarmoniamTripleRice1{
	public static void main(String args[]) throws Exception{
		InputReader is=new InputReader(System.in);
		int noOfTestCases=is.nextInt();
		while(noOfTestCases-->0){
			int sizeOfArray=is.nextInt();
			int numOfQueries=is.nextInt();
			ArrayList<NumberWithIndex> array=new ArrayList<NumberWithIndex>();
			int[] nonSorted=new int[sizeOfArray];
			for(int i=0;i<sizeOfArray;i++){
				int data=is.nextInt();
				array.add(new NumberWithIndex(data,i));
				nonSorted[i]=data;
			}
			Collections.sort(array);
			//System.out.println(array);
			while(numOfQueries-->0){
				int query=is.nextInt();
				query--;
				//System.out.println(array.size());
				if(query+1<array.size() || query!=0){
					//System.out.println("Search"+ nonSorted[query]);
					int i=binarySearch(array,nonSorted[query],query);
					//System.out.println("Searched the query"+nonSorted[query]+" in sorted array"+i);
					int leftMax=0,rightMax=0;
					for(int j=i-1;j>=0;j--){
						NumberWithIndex nwi=array.get(j);
						//System.out.println("evaluating "+nwi);
						//System.out.println("i=="+i);
						if(leftMax==0 && nwi.index<query){
							leftMax=array.get(j).data;
							if(rightMax!=0){
								break;
							}
						}		
						if(rightMax==0 && nwi.index>query){
							rightMax=array.get(j).data;
							if(leftMax!=0){
								break;
							}
						}
					}
					//System.out.println(array.size()+"array.size()");
					if(i<array.size()-1){
						i++;
						while(array.get(i).data==nonSorted[query]){
							if(array.get(i).index<query){
								leftMax=array.get(i).data;
							}
							if(array.get(i).index>query){
								rightMax=array.get(i).data;
							}
							i++;
							if(i>=array.size()){
								break;
							}
						}
					}
					System.out.println(leftMax*rightMax*nonSorted[query]);
				}else{
					System.out.println(0);
				}
			}
		}

	}
	static class NumberWithIndex implements Comparable<NumberWithIndex>{
		public int data;
		public int index;
		public NumberWithIndex(int data,int index){
			this.data=data;
			this.index=index;
		}
		public int compareTo(NumberWithIndex nwi){
			if(data==nwi.data){
				return 0;
			}else if(data>nwi.data){
				return 1;
			}else{
				return -1;
			}
		}
		public String toString(){
			return data+","+index;
		}
	}
	public static int binarySearch(ArrayList<NumberWithIndex> list,int a,int index){
		int start = 0;
		int end = list.size()- 1;
		while (start <= end) {
			int middle = (start + end) / 2;
			//System.out.println("middle for ("+start+","+end+")"+middle+" "+list.get(middle).data);
			NumberWithIndex valuemid=list.get(middle);
			if (a< valuemid.data ) {
				end = middle - 1;
			}
			if (a> valuemid.data) {
				start = middle + 1;
			}
			if (a== valuemid.data) {
				return middle;
			}
		}
		return -1;
	}
	static class InputReader
	{
		private InputStream stream;
		private byte[] buf = new byte[1024];
		private int curChar;
		private int numChars;
		private SpaceCharFilter filter;
		
		public InputReader(InputStream stream)
		{
			this.stream = stream;
		}
		
		public int read()
		{
			if (numChars==-1) 
				throw new InputMismatchException();
			
			if (curChar >= numChars)
			{
				curChar = 0;
				try 
				{
					numChars = stream.read(buf);
				}
				catch (IOException e)
				{
					throw new InputMismatchException();
				}
				
				if(numChars <= 0)				
					return -1;
			}
			return buf[curChar++];
		}
	 
		public String nextLine()
		{
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
		}
		public int nextInt()
		{
			int c = read();
			
			while(isSpaceChar(c)) 
				c = read();
			
			int sgn = 1;
			
			if (c == '-') 
			{
				sgn = -1;
				c = read();
			}
			
			int res = 0;
			do 
			{
				if(c<'0'||c>'9') 
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = read();
			}
			while (!isSpaceChar(c)); 
			
			return res * sgn;
		}
		
		public long nextLong() 
		{
			int c = read();
			while (isSpaceChar(c))
				c = read();
			int sgn = 1;
			if (c == '-') 
			{
				sgn = -1;
				c = read();
			}
			long res = 0;
			
			do 
			{
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = read();
			}
			while (!isSpaceChar(c));
				return res * sgn;
		}
		
		public double nextDouble() 
		{
			int c = read();
			while (isSpaceChar(c))
				c = read();
			int sgn = 1;
			if (c == '-') 
			{
				sgn = -1;
				c = read();
			}
			double res = 0;
			while (!isSpaceChar(c) && c != '.') 
			{
				if (c == 'e' || c == 'E')
					return res * Math.pow(10, nextInt());
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = read();
			}
			if (c == '.') 
			{
				c = read();
				double m = 1;
				while (!isSpaceChar(c)) 
				{
					if (c == 'e' || c == 'E')
						return res * Math.pow(10, nextInt());
					if (c < '0' || c > '9')
						throw new InputMismatchException();
					m /= 10;
					res += (c - '0') * m;
					c = read();
				}
			}
			return res * sgn;
		}
		
		public String readString() 
		{
			int c = read();
			while (isSpaceChar(c))
				c = read();
			StringBuilder res = new StringBuilder();
			do 
			{
				res.appendCodePoint(c);
				c = read();
			} 
			while (!isSpaceChar(c));
			
			return res.toString();
		}
	 
		public boolean isSpaceChar(int c) 
		{
			if (filter != null)
				return filter.isSpaceChar(c);
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}
	 
		public String next() 
		{
			return readString();
		}
		
		public interface SpaceCharFilter 
		{
			public boolean isSpaceChar(int ch);
		}
	}
}
