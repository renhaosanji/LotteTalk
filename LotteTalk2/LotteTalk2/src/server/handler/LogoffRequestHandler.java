package server.handler;

import server.helper.DBAccessHelper;
import entity.RequestObject;
import entity.ResponseObject;

public class LogoffRequestHandler implements RequestHandler {

	@Override
	
	//chatstore online
	public ResponseObject handleRequest(RequestObject requestObject) {
		// TODO Auto-generated method stub
		ResponseObject responseObject=null;
		try {
			
			String uid=(String)requestObject.getReqBody();
			String sqlString="update contacts set online=0 where uid="+uid;
			System.out.println(sqlString);
	        DBAccessHelper.getDAO().execute(sqlString);
	        
	        responseObject =
						new ResponseObject(ResponseObject.LOGOFF_RES, 
								null);	
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}		
		return responseObject;
	}

}
