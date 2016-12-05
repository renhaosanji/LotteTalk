package entity;

import java.io.Serializable;

public class Contact implements Serializable {

	
		private String uname;
		private String email;
		private int age;
		private int uid;
		private int online;
		private boolean isSender;
		private String peerIp;
		private  int peerPort;
		
		public String getPeerIp() {
			return peerIp;
		}
		public void setPeerIp(String peerIp) {
			this.peerIp = peerIp;
		}
		public int getPeerPort() {
			return peerPort;
		}
		public void setPeerPort(int peerPort) {
			this.peerPort = peerPort;
		}
		public boolean isSender() {
			return isSender;
		}
		public void setSender(boolean isSender) {
			this.isSender = isSender;
		}
		public String getUname() {
			return uname;
		}
		public void setUname(String uname) {
			this.uname = uname;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public int getUid() {
			return uid;
		}
		public void setUid(int uid) {
			this.uid = uid;
		}
		public int getOnline() {
			return online;
		}
		public void setOnline(int online) {
			this.online = online;
		}
	
		@Override
		public String toString() {
			return "Contact [uname=" + uname + ", email=" + email + ", age="
					+ age + ", uid=" + uid + ", online=" + online
					+ ", isSender=" + isSender + ", peerIp=" + peerIp
					+ ", peerPort=" + peerPort + "]";
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + uid;
			return result;
		}
		@Override
		//uid chack
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Contact other = (Contact) obj;
			if (uid != other.uid)
				return false;
			return true;
		}
		
}
