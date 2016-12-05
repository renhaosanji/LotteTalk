package entity;
import java.io.Serializable;

public class RequestObject implements Serializable {
public static final int TEST = 999999;
public static final int REG_REQ = 0;
public static final int INIT_REQ=2;
public static final int LOGIN_REQ = 3;
public static final int LOGOFF_REQ = 4;
public static final int OFF_CHAT = 5;
public static  final int INIT_MSGS_REQ=6;
public static final int REG_PEER_REQ = 7;
private int reqType;
private Object reqBody;

public RequestObject(int reqType, Object reqBody) {
	super();
	this.reqType = reqType;
	this.reqBody = reqBody;
}
public int getReqType() {
	return reqType;
}
public void setReqType(int reqType) {
	this.reqType = reqType;
}
public Object getReqBody() {
	return reqBody;
}
public void setReqBody(Object reqBody) {
	this.reqBody = reqBody;
}
@Override
public String toString() {
	return "RequestObject [reqType=" + reqType + ", reqBody=" + reqBody + "]";
}

}

