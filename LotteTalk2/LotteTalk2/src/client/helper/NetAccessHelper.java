package client.helper;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import entity.NotifyObject;
import entity.RequestObject;
import entity.ResponseObject;


public class NetAccessHelper {
	
	public static ResponseObject sendRequest(RequestObject reqObject) {
		ResponseObject resObject = null;
		try {
			// 1.connect to the server
			Socket server = new Socket("localhost", 10000);
			// 2.get oos,ois
			OutputStream os = server.getOutputStream();
			InputStream is = server.getInputStream();// TODO
			ObjectOutputStream oos = new ObjectOutputStream(os);
			ObjectInputStream ois = new ObjectInputStream(is);
			// 3.send
			oos.writeObject(reqObject);
			// 4.receive
			resObject = (ResponseObject) ois.readObject();
			System.out.print("successful sendRequest"+resObject);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return resObject;
	}
	//notify
	public static void notify(NotifyObject notifyObject) {

		ResponseObject resObject = null;
		// ChatServer
		//input and read message
		try {
			String ipString= notifyObject.getDestIp();
			System.out.println(ipString);
			int idx=ipString.indexOf('/');
			ipString=ipString.substring(idx+1);
		//	ipString = "172.20.10.2";
			System.out.println(ipString);	

			// 1. connect server
			Socket server = 
					new Socket(ipString,notifyObject.getDestPort());
			OutputStream os = server.getOutputStream();

			// /////////////////////////26_15:31
			// InputStream is = clientSocket.getInputStream();// TODO
			// 2.get oos,ois
			ObjectOutputStream oos = new ObjectOutputStream(os);
			// ObjectInputStream ois = new ObjectInputStream(is);

			// 3.send
			oos.writeObject(notifyObject);
			System.out.print(resObject);
		} catch (Exception e) {

			// TODO: handle exception\
			e.printStackTrace();
		}
		// return resObject;
	}

//	public static void main(String[] args) {
//		try {
//			NotifyObject notifyObject = new NotifyObject();
//			notifyObject.setDestIp(InetAddress.getLocalHost().toString());
//			notifyObject.setDestPort(10000);
//			NetAccessHelper.notify(notifyObject);
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//
//	}
}
