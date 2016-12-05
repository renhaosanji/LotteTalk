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
//从SOCKET中读东西，
public void run(){
	try{
		
		
	//对象的包装
	//InputStream 处理的是ByteArray数据
	ObjectInputStream ois=
			new ObjectInputStream(
			peerSocket.getInputStream());
	NotifyObject notifyObject=
			(NotifyObject)ois.readObject();
	switch(notifyObject.getNotifyType()){
	case NotifyObject.TEXT_MSG:
		handler=new TesxMsgHandler();
		break;
	//留作之后的扩展
	default:
		break;
	}
	handler.handleEvent(notifyObject);
	}catch(Exception e){
		e.printStackTrace();			
	}
}

}
