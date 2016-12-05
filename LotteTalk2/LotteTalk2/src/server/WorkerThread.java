package server;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

//import server.handler.RegRequestHandler;
import server.handler.InitMsgsRequestHandler;
import server.handler.InitRequestHandler;
import server.handler.LoginRequestHandler;
import server.handler.LogoffRequestHandler;
import server.handler.OffChatRequestHandler;
import server.handler.RegPeerRequestHandler;
import server.handler.RegRequestHandler;
import server.handler.RequestHandler;
import entity.RequestObject;
import entity.ResponseObject;

public class WorkerThread extends Thread {
	private Socket clientSocket;
	private RequestHandler handler; //��������ӿ�RequestHandler �Ķ���
		
	// TODO Auto-generated constructor stub
	
	 //WorkThread���಻�ܼ̳и���thread�Ĺ�������
	//ֻ���ڹ���������super()���ø���Ĺ�����
	
   public WorkerThread(Socket clientSocket) {
		super();                          //����Ĺ���������Ҫ���ø���Ĺ�����             
		this.clientSocket = clientSocket;
	}
	
   public void run(){
		try{
		  ObjectOutputStream oos;
		  ObjectInputStream ois;
		
		  oos = new ObjectOutputStream(clientSocket.getOutputStream());
		  ois = new ObjectInputStream(clientSocket.getInputStream());
		  
		  RequestObject requestObject = (RequestObject) ois.readObject();
	      System.out.println(requestObject);
	      
		  ResponseObject responseObject=null;
		   //todo: 
	       switch (requestObject.getReqType()) {
	       case RequestObject.REG_REQ:
	    	   handler=new RegRequestHandler();
	    	   break; 
	       case RequestObject.INIT_REQ:
	    	   handler=new InitRequestHandler();
	    	   break; 
	    	   
	       case RequestObject.LOGIN_REQ:
	    	   handler=new LoginRequestHandler();
	    	   break; 
	       case RequestObject.LOGOFF_REQ:
	    	   handler=new LogoffRequestHandler();
	    	   break; 
	    	//chatstore
	       case RequestObject.OFF_CHAT:
	    	   handler=new OffChatRequestHandler();
	    	   break; 
	       case RequestObject.INIT_MSGS_REQ:
	    	   handler=new InitMsgsRequestHandler();
	    	   break; 
	       case RequestObject.REG_PEER_REQ:
	    	   handler=new RegPeerRequestHandler();
	    	   break; 
		default:
			
			break;
		}
	          responseObject=
	        		  handler.handleRequest(requestObject);
	           oos.writeObject(responseObject);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
   }

