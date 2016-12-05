package entity;

import java.io.Serializable;

public class Loginfo implements Serializable {
	
	private int uid;
	private String password;
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Loginfo [uid=" + uid + ", password=" + password + "]";
	}
	
	
}
