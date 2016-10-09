package com.distributed.storage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	public static void main(String[] args) throws NumberFormatException, UnknownHostException, IOException {
		Socket client = new Socket("127.0.0.1",1500);
		System.out.println("Client Initiated");
		DataOutputStream dos=new DataOutputStream(client.getOutputStream());
		DataInputStream dis=new DataInputStream(client.getInputStream());
		dos.writeUTF("ADD");
		dos.writeInt(12);
		dos.writeInt(12);
		System.out.println(dis.readUTF());
		System.out.println();
	}

}
