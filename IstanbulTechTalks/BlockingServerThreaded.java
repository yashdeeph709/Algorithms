import java.io.*;
import java.net.*;

public class BlockingServerThreaded{
	public static void main(String args[]) throws IOException{
		ServerSocket ss = new ServerSocket(8080);
		while(true){
			final Socket s = ss.accept();
			new Thread(() -> handle(s)).start();
		}
	}
	private static void handle(Socket s){
		try(
			InputStream in = s.getInputStream();
			OutputStream os = s.getOutputStream();
		){
			int data;
			while((data = in.read()) != -1){
				data = transmogrify(data);
				os.write(data);
			}

		} catch(IOException ie){
			ie.printStackTrace();
		}
	}
	private static int transmogrify(int data){
		return Character.isLetter(data)?data^' ':data;
	}


}
