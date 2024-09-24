package vn.iotstar.models;

import java.io.Serializable;
import java.sql.Date;

public class UserModel1 implements Serializable {
     
	
	private static final long serialVersionUID = 1L;
	private int id;
	private String username;
	private String email;
	private String password;
	private String fullname;
	private String images;
	private String phone;
	private int roleid;
	private Date createDate;
	public UserModel1() {
		super();
	}
	public UserModel1(int id, String username, String email, String password, String fullname, String images,
			String phone, int roleid, Date createDate) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.fullname = fullname;
		this.images = images;
		this.phone = phone;
		this.roleid = roleid;
		this.createDate = createDate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getImages() {
		return images;
	}
	public void setImages(String images) {
		this.images = images;
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
	public void setRoleid(int i) {
		this.roleid = i;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	@Override
	public String toString() {
		return "UserModel1 [id=" + id + ", username=" + username + ", email=" + email + ", password=" + password
				+ ", fullname=" + fullname + ", images=" + images + ", phone=" + phone + ", roleid=" + roleid
				+ ", createDate=" + createDate + "]";
	}
	
	
	
	
}
