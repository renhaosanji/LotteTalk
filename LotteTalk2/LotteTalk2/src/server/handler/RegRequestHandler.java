package server.handler;

import java.sql.ResultSet;
import server.helper.DBAccessHelper;
import entity.RegInfo;
import entity.RequestObject;
import entity.ResponseObject;

public class RegRequestHandler implements RequestHandler {

	@Override
	public ResponseObject handleRequest(RequestObject requestObject) {
		// TODO Auto-generated method stub
		ResponseObject responseObject=null;
		try {
			
			//0. get RegInfo
			RegInfo regInfo=
					(RegInfo)requestObject.getReqBody();
			//1.validate
			if(!validated(regInfo.getEmail())){
				
				responseObject=
				new ResponseObject(
				ResponseObject.REG_FAIL,
					"FAIL:duplicated!!!");
				return responseObject;
			}
			//2.assignid
			int uid=assignUID();
			
			//3.insert
			insertNew(uid,regInfo);
			
			//4.responseObject
			responseObject=
					new ResponseObject(
					ResponseObject.REG_SUCCESS,
						""+uid);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return responseObject;
	}

	private boolean validated(String email) {
		// TODO Auto-generated method stub
		boolean isValid=false;
		try {
			String sqlString="select count(0) from contacts "
					+" where email='"+email+"'";
			System.out.println(sqlString);
			ResultSet rs=
					DBAccessHelper.getDAO().executeQuery(sqlString);
			int count=0;
			if(rs.next())
				count=rs.getInt(1);
			if(count==0)
				isValid=true;
			} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return isValid;
		}	
	
	    private void insertNew(int uid,RegInfo regInfo) {
		// TODO Auto-generated method stub
		String sqlString=	"insert into contacts "+
				"(uid,uname,age,email,pass,online) "+
				"values("+uid+",'"+regInfo.getUname()+
				"',"+regInfo.getAge()+
				",'"+regInfo.getEmail()+
				"','"+regInfo.getPassword()+"',0)";
		System.out.println(sqlString);
		DBAccessHelper.getDAO().execute(sqlString);
	}


		private int assignUID() { 
			// TODO Auto-generated method stub
			
			int uid=10000;
			try {
				
				String sqlString="select max(uid) from  contacts";
				ResultSet rs=DBAccessHelper.getDAO().executeQuery(sqlString);
				if(rs.next()){
					int maxid=rs.getInt(1);
					if(maxid>uid)uid=maxid;
				}
				uid++;
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return uid;
			}
		}
