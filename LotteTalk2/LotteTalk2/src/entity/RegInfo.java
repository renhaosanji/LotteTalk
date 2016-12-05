package entity;

import java.io.Serializable;

public class RegInfo implements Serializable {
	
	private int age;
	private String uname;
	private String email;
	private String password;

	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "RegInfo [age=" + age + ", uname=" + uname + ", email=" + email
				+ ", password=" + password + "]";
	}
	
}

