package server.handler;

import java.sql.ResultSet;

import entity.Loginfo;
import entity.RequestObject;
import entity.ResponseObject;
import server.handler.RequestHandler;
import server.helper.DBAccessHelper;

public class LoginRequestHandler implements RequestHandler {

	@Override
	public ResponseObject handleRequest(RequestObject requestObject) {
		// TODO Auto-generated method stub
		ResponseObject responseObject=null;
		try {
			Loginfo loginfo=(Loginfo)requestObject.getReqBody();
			int uid=loginfo.getUid();
			String pass=loginfo.getPassword();
			
			String sqlString=
				"select count(0) from contacts where uid="+uid+" and pass='"+pass+"'";
			System.out.println(sqlString);
		
			ResultSet rs= DBAccessHelper.getDAO().executeQuery(sqlString);
		  boolean isOK=false;
		  if(rs.next()){
			  if(1==rs.getInt(1))isOK=true;
			  
		  }
		  if(isOK){
			  

	        sqlString=
					"update contacts set online=1 where uid="+uid+" and pass='"+pass+"'";
	        System.out.println(sqlString);
	        DBAccessHelper.getDAO().execute(sqlString);
	        
	        responseObject =
						new ResponseObject(ResponseObject.LOGIN_SUCCESS, 
								null);
		  }
		  else {
			responseObject =
					new ResponseObject(ResponseObject.LOGIN_FAILED, 
							"Log Failed!Check your uid/pass!");
		}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return responseObject;
	}

}
