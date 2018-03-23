import java.io.*;
import java.util.*;

@SuppressWarnings("unchecked")
public class MobileSelection{
	
	public static void main(String args[]) throws Exception{
		Reader br=new Reader();	
		int noOfTests = br.nextInt();
		Object[] db=new Object[400];
		while(noOfTests-->0){
			String handSetId="";
			String handset=br.readString();
			if(handset.startsWith("w")){
				handSetId+="1";
			}
			if(handset.startsWith("a")){
				handSetId+="2";
			}
			if(handset.startsWith("i")){
				handSetId+="3";
			}
			int ram=br.nextInt();
			if(ram==2){
				handSetId+="1";
			}
			if(ram==4){
				handSetId+="2";
			}
			if(ram==8){
				handSetId+="3";
			}
			int memory=br.nextInt();
			if(memory==32){
				handSetId+="1";
			}
			if(memory==64){
				handSetId+="2";
			}
			int price=br.nextInt();
			int rating=br.nextInt();
			ArrayList<Value> phones=(ArrayList<Value>)db[Integer.parseInt(handSetId)];
			if(phones==null){
				phones=new ArrayList<Value>();
				db[Integer.parseInt(handSetId)]=phones;	
			}
			phones.add(new Value(rating,price));
		}	
		for(int i=0;i<db.length;i++){
			ArrayList<Value> phones=(ArrayList<Value>)db[i];
			if(phones!=null){
			Collections.sort(phones);
			}
		}
		noOfTests=Integer.parseInt(br.readLine());	
		while(noOfTests-->0){
			String handSetId="";
			String handset=br.readString();
			if(handset.startsWith("w")){
				handSetId+="1";
			}
			if(handset.startsWith("a")){
				handSetId+="2";
			}
			if(handset.startsWith("i")){
				handSetId+="3";
			}
			int ram=br.nextInt();
			if(ram==2){
				handSetId+="1";
			}
			if(ram==4){
				handSetId+="2";
			}
			if(ram==8){
				handSetId+="3";
			}
			int memory=br.nextInt();
			if(memory==32){
				handSetId+="1";
			}
			if(memory==64){
				handSetId+="2";
			}
			int price=br.nextInt();
			ArrayList<Value> phones=(ArrayList<Value>)db[Integer.parseInt(handSetId)];
			if(phones==null){
				System.out.println(-1);
				continue;
			}else{
				System.out.println(findMaxRatingInBudget(phones,price));
			}
		}
	}
	public static int findMaxRatingInBudget(ArrayList<Value> phones,int budget){
		int maxRating=-1;
		for(Value v: phones){
			if(v.price<=budget){
				if(maxRating<v.rating){
					maxRating=v.rating;
				}
			}else{
				return maxRating;
			}
		}
		return maxRating;
	}
	
	public static class Value implements Comparable<Value>{
		public int rating;
		public int price;
		public Value(int rating,int price){
			this.rating=rating;
			this.price=price;
		}
		public String toString(){
			return "["+rating+","+price+"]";
		}
		public int compareTo(Value v){
			if(v.price>this.price){
				return -1;
			}else{
				return 1;
			}
		}
	}
static class Reader
    {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;
 
        public Reader()
        {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }
 
        public Reader(String file_name) throws IOException
        {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }
 
        public String readLine() throws IOException
        {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1)
            {
                if (c == '\n')
                    break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }
        public String readString() throws IOException
        {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1)
            {
                if (c == ' ')
                    break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }
 
        public int nextInt() throws IOException
        {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do
            {
                ret = ret * 10 + c - '0';
            }  while ((c = read()) >= '0' && c <= '9');
 
            if (neg)
                return -ret;
            return ret;
        }
 
        public long nextLong() throws IOException
        {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }
 
        public double nextDouble() throws IOException
        {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
 
            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');
 
            if (c == '.')
            {
                while ((c = read()) >= '0' && c <= '9')
                {
                    ret += (c - '0') / (div *= 10);
                }
            }
 
            if (neg)
                return -ret;
            return ret;
        }
 
        private void fillBuffer() throws IOException
        {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }
 
        private byte read() throws IOException
        {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }
 
        public void close() throws IOException
        {
            if (din == null)
                return;
            din.close();
        }
    }
 
}
