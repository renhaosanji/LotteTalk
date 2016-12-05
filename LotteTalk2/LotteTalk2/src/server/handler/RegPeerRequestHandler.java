package server.handler;

import java.net.InetAddress;
import server.helper.DBAccessHelper;
import entity.PeerInfo;
import entity.RequestObject;
import entity.ResponseObject;


////////////////OK_26
public class RegPeerRequestHandler implements RequestHandler {

	@Override
	public ResponseObject handleRequest(RequestObject requestObject) {
		// TODO Auto-generated method stub
		ResponseObject responseObject=null;
		
		try {
			PeerInfo peerInfo =(PeerInfo)requestObject.getReqBody();
			
			int uid =peerInfo.getUid();
			InetAddress peerIp=peerInfo.getPeerIp();
			int peerPort=peerInfo.getPeerPort();
			
			String sqlString=
					"update contacts set "+
					"peerip='"+peerIp.toString()+
					"',peerport="+peerPort+
					" where uid="+uid;
			System.out.println(sqlString);
			DBAccessHelper.getDAO().execute(sqlString);
	        responseObject=new ResponseObject(ResponseObject.REG_PEER_RES, null);
		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return responseObject;
	}

}
