package client.listener;

import java.io.ObjectInputStream;
import java.net.Socket;

import entity.NotifyObject;

public class PeerWorkerThread extends Thread {
private Socket peerSocket;
private EventHandler handler;
public PeerWorkerThread(Socket peerSocket) {
	super();
	this.peerSocket = peerSocket;
}
//SOCKET
public void run(){
	try{
		
		
	
	ObjectInputStream ois=
			new ObjectInputStream(
			peerSocket.getInputStream());
	NotifyObject notifyObject=
			(NotifyObject)ois.readObject();
	switch(notifyObject.getNotifyType()){
	case NotifyObject.TEXT_MSG:
		handler=new TesxMsgHandler();
		break;
	//
	default:
		break;
	}
	handler.handleEvent(notifyObject);
	}catch(Exception e){
		e.printStackTrace();			
	}
}

}
