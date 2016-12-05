package client.listener;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class EventListenerThread extends Thread {
	private InetAddress peerIp;
	private int peerPort;
	private ServerSocket eventListener;

	public InetAddress getPeerIp() {
		return peerIp;
	}

	public int getPeerPort() {
		return peerPort;
	}

	public void run() {
		//
		try {
			eventListener = new ServerSocket(0);
			this.peerPort = eventListener.getLocalPort();// ��÷���Ķ˿ں�
			System.out.println(peerPort);
			this.peerIp = InetAddress.getLocalHost();
			System.out.println("mytLocalHosttLocalHosttLocalHosttLocalHost"+peerIp);
			Socket peerSocket=null;
			PeerWorkerThread worker=null;
			
			while (true) {
				peerSocket = eventListener.accept();
				worker = new PeerWorkerThread(peerSocket);
				worker.start();

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {

		EventListenerThread eventListenerThread = new EventListenerThread();
		eventListenerThread.start();
		/***************** 26_13:50 **********************/


	}
}
