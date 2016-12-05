package entity;

import java.io.Serializable;

public class ResponseObject implements Serializable {
public static final int TEST_OK = 999999;
public static final int REG_SUCCESS=1;
public static final int REG_FAIL=-1;
public static final int INIT_RES=2;
public static final int LOGIN_FAILED = -3;
public static final int LOGIN_SUCCESS = 3;
public static final int LOGOFF_RES = 4;
public static final int ININ_MSGS_RES = 5;
public static final int REG_PEER_RES = 6;
private int resType;
private Object resBody;
public int getResType() {
	return resType;
}
public void setResType(int resType) {
	this.resType = resType;
}
public Object getResBody() {
	return resBody;
}
public void setResBody(Object resBody) {
	this.resBody = resBody;
}
public ResponseObject(int resType, Object resBody) {
	super();
	this.resType = resType;
	this.resBody = resBody;
}
@Override
public String toString() {
	return "ResponseObject [resType=" + resType + ", resBody=" + resBody + "]";
}

}
