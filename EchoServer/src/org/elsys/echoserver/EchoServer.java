package org.elsys.echoserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;


public class EchoServer {

	public EchoServer() {
			
	}
		
	public static void main(String[] args) throws Exception {
		ServerSocket serverSocket = new ServerSocket(4444);
		while (true) {
			Socket socket = serverSocket.accept();
			new Thread(new ClientRunnable(socket)).start();
		}
	}
}
