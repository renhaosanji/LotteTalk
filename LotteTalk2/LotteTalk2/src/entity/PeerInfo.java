package entity;

import java.io.Serializable;
import java.net.InetAddress;

public class PeerInfo implements Serializable {
	private InetAddress peerIp;
	private int peerPort;
	private int uid;
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public InetAddress getPeerIp() {
		return peerIp;
	}
	public void setPeerIp(InetAddress peerIp) {
		this.peerIp = peerIp;
	}
	public int getPeerPort() {
		return peerPort;
	}
	public void setPeerPort(int peerPort) {
		this.peerPort = peerPort;
	}
	@Override
	public String toString() {
		return "PeerInfo [peerIp=" + peerIp + ", peerPort=" + peerPort
				+ ", uid=" + uid + "]";
	}


	
}
