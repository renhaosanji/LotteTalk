package entity;

import java.io.Serializable;

//在线消息发送 实体notifyObject

public class NotifyObject implements Serializable {
	public static final int TEXT_MSG = 1;
	private int notifyType;
	private Object notifyBody;
	private String sourceIp;
	private int sourcePort;
	private String destIp;     //发送信息的ip、port
	private int destPort;
	public int getNotifyType() {
		return notifyType;
	}
	public void setNotifyType(int notifyType) {
		this.notifyType = notifyType;
	}
	public Object getNotifyBody() {
		return notifyBody;
	}
	public void setNotifyBody(Object notifyBody) {
		this.notifyBody = notifyBody;
	}
	public String getSourceIp() {
		return sourceIp;
	}
	public void setSourceIp(String sourceIp) {
		this.sourceIp = sourceIp;
	}
	public int getSourcePort() {
		return sourcePort;
	}
	public void setSourcePort(int sourcePort) {
		this.sourcePort = sourcePort;
	}
	public String getDestIp() {
		return destIp;
	}
	public void setDestIp(String destIp) {
		this.destIp = destIp;
	}
	public int getDestPort() {
		return destPort;
	}
	public void setDestPort(int destPort) {
		this.destPort = destPort;
	}
	@Override
	public String toString() {
		return "NotityObject [notifyType=" + notifyType + ", notifyBody="
				+ notifyBody + ", sourceIp=" + sourceIp + ", sourcePort="
				+ sourcePort + ", destIp=" + destIp + ", destPort=" + destPort
				+ "]";
	}
}
