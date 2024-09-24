package vn.iostart.models;

import java.io.Serializable;
import java.sql.Date;

public class UserModel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String fullname;
	private String mail;
	private String username;
	private String password;
	private String avatar;
	private String phone;
	private int roleid;
	private Date createdDate;

	public UserModel() {
		super();
	}

	public UserModel(int id, String fullname, String mail, String username, String password, String avatar,
			String phone, int roleid, Date createdDate) {
		super();
		this.id = id;
		this.fullname = fullname;
		this.mail = mail;
		this.username = username;
		this.password = password;
		this.avatar = avatar;
		this.phone = phone;
		this.roleid = roleid;
		this.createdDate = createdDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
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

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getRoleid() {
		return roleid;
	}

	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Override
	public String toString() {
		return "UserModel [id=" + id + ", fullname=" + fullname + ", mail=" + mail + ", username=" + username
				+ ", password=" + password + ", avatar=" + avatar + ", phone=" + phone + ", roleid=" + roleid
				+ ", createdDate=" + createdDate + "]";
	}

}
