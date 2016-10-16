package org.elsys.echoserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;


public class ThreadPoolServer {

	private static ExecutorService executor;
	public ThreadPoolServer() {
			
	}
		
	public static void main(String[] args) throws Exception {
		executor = Executors.newFixedThreadPool(2);
		
		ServerSocket serverSocket = new ServerSocket(4444);
		while (true) {
			Socket socket = serverSocket.accept();
			Runnable work = new ClientRunnable(socket);
			executor.execute(work);
		}
	}
}
