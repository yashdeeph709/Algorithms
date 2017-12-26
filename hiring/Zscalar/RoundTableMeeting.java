
import java.util.*;
import java.io.*;


public class RoundTableMeeting{
	public static void main(String args[]) throws Exception{
		InputReader br=new InputReader(System.in);
		int N=br.nextInt();
		int Q=br.nextInt();
		ArrayList<Student> table=new ArrayList<Student>();
		for(int i=0;i<N;i++){
			Student s=new Student();	
			s.university=br.nextInt();
			s.position=i+1;
			table.add(s);
		}
		Collections.sort(table);
		System.out.println(table);
		int[][] query=new int[Q][2];
		for(int i=0;i<Q;i++){
			query[i][0]=br.nextInt();
			query[i][1]=br.nextInt();
		}
		int i=0;
		while(i<query.length){
			int minDistance=Integer.MAX_VALUE;
			int student1=binarySearch(table,query[i][0],0,table.size());
			int student2=binarySearch(table,query[i][1],0,table.size());
			int j=0;
			fullLoop:
			while(table.get(student1+j).university==query[i][0]){
				Student s1=table.get(student1+j);
				int z=0;
				while(table.get(student2+z).university==query[i][1]){
					Student s2=table.get(student2+z);
					minDistance=maxCalc(s1,s2,minDistance,table.size());
					if(minDistance==0){
						break fullLoop;
					}
					z++;
					if(student2+z>=table.size()){
						break;
					}
				}
				j++;
				if(student1+j>=table.size()){
					break;
				}
			}
			System.out.println(minDistance);
			i++;
		}

	}
	public static int maxCalc(Student firstPos,Student secondPos,int minDistance,int tablesize){	
			if(firstPos.position>secondPos.position){
				int ndist=(firstPos.position-secondPos.position)/2;
				int cdist=((tablesize-firstPos.position)+secondPos.position)/2;
				if(minDistance>ndist){
					minDistance=ndist;
				}
				if(minDistance>cdist){
					minDistance=cdist;
				}
			}else{
				int ndist=(secondPos.position-firstPos.position)/2;
				int cdist=((tablesize-secondPos.position)+firstPos.position)/2;
				if(minDistance>ndist){
					minDistance=ndist;
				}
				if(minDistance>cdist){
					minDistance=cdist;
				}
			}
			//System.out.println("minDistance between"+firstPos+","+secondPos+" "+minDistance);
			return minDistance;
	}
	public static int binarySearch(ArrayList<Student> array, int value, int left, int right) {
	          if (left > right){
	                return -1;
		  }
	          int middle = (left + right) / 2;
	          if (array.get(middle).university== value)
	          {
	            if(middle==0 || array.get(middle-1).university<array.get(middle).university){
	                return middle; 
		    }else{
	                return binarySearch(array, value, left, middle - 1);
		    }
	          }
	          else if (array.get(middle).university>value){
	                return binarySearch(array, value, left, middle - 1);
		  }else{
	                return binarySearch(array, value, middle + 1, right);           
		  }
	 }
	 static class Student implements Comparable<Student>{
		 public int university;
		 public int position;
		 public int actualpositon;

		 public int compareTo(Student s){
			if(s.university>this.university){
				return -1;
			}else if(s.university<this.university){
				return 1;
			}else{
				return 0;
			}
		 }
		 public String toString(){
			 return "[ university: "+university+", position: "+position+" ]";
		 }
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
