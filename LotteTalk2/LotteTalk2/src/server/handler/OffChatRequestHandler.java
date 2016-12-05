package server.handler;

import server.helper.DBAccessHelper;
import entity.RequestObject;
import entity.ResponseObject;
import entity.ChatInfo;

public class OffChatRequestHandler implements RequestHandler {

	
	
	//chatstore save chattxt in chatstore
	@Override
	public ResponseObject handleRequest(RequestObject requestObject) {
		// TODO Auto-generated method stub
		ResponseObject responseObject = null;
		try {
			ChatInfo chatInfo = (ChatInfo) requestObject.getReqBody();

			int senderId = chatInfo.getSenderId();
			int receiverId = chatInfo.getReceiverid();
			String sendTime = chatInfo.getSendTime();
			String content = chatInfo.getContent();

			/*****************************************************************/
			String sqlString = "insert into chatstore(senderid, receiverid,sendtime,content)"
			+ " values('"+ senderId+ "',"+ receiverId+ ",'"+ sendTime + "','" + content + "')";
					
			System.out.println(sqlString);
			DBAccessHelper.getDAO().execute(sqlString);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return responseObject;
	}
}
