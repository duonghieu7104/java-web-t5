package vn.iotstar.models;

import java.io.Serializable;

public class UserModel3 implements Serializable {

	
	private static final long serialVersionUID = 1L;
	 
	private String username;
	private String password;
	public UserModel3() {
		super();
	}
	public UserModel3(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "UserModel3 [username=" + username + ", password=" + password + "]";
	}
	
}
