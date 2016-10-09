package com.distributed.storage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String args[]) throws Exception{
		ServerSocket ssocket = new ServerSocket(1500);
		Socket socket = ssocket.accept();
		System.out.println("Got my first Client");
		DataOutputStream os = new DataOutputStream(socket.getOutputStream());
		DataInputStream is = new DataInputStream(socket.getInputStream());
		is.readUTF().equals("ADD");
		os.writeUTF("Addition is :"+(is.readInt()+is.readInt()));
		os.close();
		is.close();
		socket.close();
	}
}
