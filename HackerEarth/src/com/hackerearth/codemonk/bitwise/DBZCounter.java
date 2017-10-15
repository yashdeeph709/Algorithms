package com.hackerearth.codemonk.bitwise;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;

public class DBZCounter{
	public static void main(String[] args) throws Exception{
		InputStreamReader isr=new InputStreamReader(System.in);
    		Print p=new Print();

		while(true){
			long number=0,lastin=0,lastvalue=0;
			try{
				number=isr.readLong();
				if(number!=0 && lastin==number){
					lastin=number;
				}
		       	}catch(Exception e){
				p.flush();
				p.close();
				System.exit(0);
			}
			long cnt=0,i=1;
			while(number!=0){
				number&=(number-1);
				cnt++;
			}
			p.println(cnt);
			lastvalue=cnt;
	        }	
	}
	private static class Print
	{
		private final BufferedWriter bw;
		public Print(){
		    this.bw=new BufferedWriter(new OutputStreamWriter(System.out));
		}
	        public void print(Object object)throws IOException
		{
			bw.append(""+object);
	    	}
		public void println(Object object)throws IOException
	    	{
		        print(object);
		    	bw.append("\n");
	 	}
		public void flush() throws IOException{
			bw.flush();
		}	
	        public void close() throws IOException{
			bw.close();
	    	}
	}
	private static class InputStreamReader {
		private byte[] buf = new byte[1 << 8];
		private int curChar;
		private int charsRead;
		private InputStream stream;
 
		public InputStreamReader(InputStream stream) {
			this.stream = stream;
		}
 
		public int readInt() throws Exception {
			int c = read();
			while (skip(c))
				c = read();
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = read();
			}
			int res = 0;
			do {
				if (c < '0' || c > '9')
					throw new Exception();
				res *= 10;
				res += c - '0';
				c = read();
			} while (!skip(c));
			return res * sgn;
		}
 
		public long readLong() throws Exception {
			int c = read();
			while (skip(c))
				c = read();
			long sgn = 1L;
			if (c == '-') {
				sgn = -1L;
				c = read();
			}
			long res = 0L;
			do {
				if (c < '0' || c > '9')
					throw new Exception();
				res *= 10L;
				res += c - '0';
				c = read();
			} while (!skip(c));
			return res * sgn;
		}
 
		private int read() throws Exception {
			if (charsRead == -1)
				throw new Exception();
			if (curChar >= charsRead) {
				curChar = 0;
				charsRead = stream.read(buf);
				if (charsRead <= 0)
					return -1;
			}
			return buf[curChar++];
		}
 
		private static boolean skip(int c) {
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}
	}
}
