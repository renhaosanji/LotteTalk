package server.handler;


import java.sql.ResultSet;
import java.util.Vector;
import server.helper.DBAccessHelper;
import entity.Contact;
import entity.RequestObject;
import entity.ResponseObject;

public class InitRequestHandler implements RequestHandler {

	@Override
	public ResponseObject handleRequest(RequestObject requestObject) {
		// TODO Auto-generated method stub
		ResponseObject responseObject=null;
		try {
			//1.select *from contacts
			//2. while rs.next
			//3.create a new contact,prt into vector
			//4.responseObject			
			String sqlString="select uid, uname,age,email,online,peerip,peerport from contacts";
			
			System.out.println(sqlString);
			ResultSet rs =DBAccessHelper.getDAO().executeQuery(sqlString);
			Contact contact=null;
			// DB에서 가져온내용을 ui에서 넣어
			Vector<Contact>allContacts=new Vector<Contact>();
			while(rs.next()){
				contact =new Contact();				
				contact.setUid(rs.getInt(1));
				contact.setUname(rs.getString(2));
				contact.setAge(rs.getInt(3));
				contact.setEmail(rs.getString(4));
				contact.setOnline(rs.getInt(5));  //////////////////////////////
				//contactм ip,port
				contact.setPeerIp(rs.getString(6));
			   contact.setPeerPort(rs.getInt(7));
			   System.out.println(contact);
			   allContacts.add(contact);
			   }
			   				/////////////26_14:49//////////////////////

			responseObject=new ResponseObject(ResponseObject.INIT_RES,allContacts);
			} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}		
		return responseObject;
	}

}
