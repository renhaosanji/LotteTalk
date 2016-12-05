package server.handler;

import java.sql.ResultSet;
import java.util.Vector;
import server.helper.DBAccessHelper;
import entity.RequestObject;
import entity.ResponseObject;
import entity.ChatInfo;

public class InitMsgsRequestHandler implements RequestHandler {

	@Override
	public ResponseObject handleRequest(RequestObject requestObject) {
		// TODO Auto-generated method stub
		ResponseObject responseObject=null;
		try {
			String uid=(String)requestObject.getReqBody();			
			String sqlString="select senderid,sendtime,content,receiverid from chatstore where receiverid="+uid;
			System.out.println(sqlString);
			ResultSet rs=DBAccessHelper.getDAO().executeQuery(sqlString);
			
			ChatInfo chatInfo=null;
			Vector<ChatInfo>allChatInfos=new Vector<ChatInfo>();
			while(rs.next()){
				chatInfo=new ChatInfo();				
				chatInfo.setReceiverid(rs.getInt(4));
				chatInfo.setContent(rs.getString(3));
				chatInfo.setSenderId(rs.getInt(1));
				chatInfo.setSendTime(rs.getString(2));
				System.out.println(chatInfo);
				allChatInfos.add(chatInfo);				
			}
			/******************************************************/
//			 sqlString=
//						"delete from chatstore where receiverid="+uid;
//						DBAccessHelper.getDAO().execute(sqlString);
//			DBAccessHelper.getDAO().execute(sqlString);
			responseObject= new ResponseObject(ResponseObject.ININ_MSGS_RES,allChatInfos);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return responseObject ;
	}

}
