package server;

import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(10000);
			System.out.println("Server is running....");

			Socket clientSocket;
			WorkerThread worker;

			for (;;) {
				clientSocket = serverSocket.accept();
				worker = new WorkerThread(clientSocket);
				worker.start();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
