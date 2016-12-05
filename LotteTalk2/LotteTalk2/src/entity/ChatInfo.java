package entity;

import java.io.Serializable;

public class ChatInfo implements Serializable {
	private int senderId;
	private int receiverid;
	
	//********************sendTime
	private String sendTime;
	private String content;
	public int getSenderId() {
		return senderId;
	}
	public void setSenderId(int senderId) {
		this.senderId = senderId;
	}
	public int getReceiverid() {
		return receiverid;
	}
	public void setReceiverid(int receiverid) {
		this.receiverid = receiverid;
	}
	public String getSendTime() {
		return sendTime;
	}
	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "chatInfo [senderId=" + senderId + ", receiverid=" + receiverid
				+ ", sendTime=" + sendTime + ", content=" + content + "]";
	}
	

}
