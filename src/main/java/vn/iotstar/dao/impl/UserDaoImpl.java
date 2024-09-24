package vn.iotstar.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import vn.iotstar.configs.DBConnectSQL;
import vn.iotstar.dao.IUserDao;
import vn.iotstar.models.UserModel1;
import vn.iotstar.models.UserModel2;


public class UserDaoImpl extends DBConnectSQL implements IUserDao{
	
	public Connection conn = null;
	public PreparedStatement ps=null;
	public ResultSet rs = null;
	@Override
	public List<UserModel1> findAll() {
		String sql = "SELECT * FROM users  ";
		List<UserModel1> list = new ArrayList<UserModel1>();
		try {
		conn = new DBConnectSQL().getConnection();
		ps = conn.prepareStatement(sql);
		rs = ps.executeQuery();
		while (rs.next()) {
		list.add(new UserModel1(
		rs.getInt("id"),
		rs.getString("username"),
		rs.getString("email"),
		rs.getString("password"),
		rs.getString("fullname"),
		rs.getString("images"),
		rs.getString("phone"),
		rs.getInt("roleid"),
		rs.getDate("createDate")));
		return list;}
		} catch (Exception e) {e.printStackTrace();}
		return null;
	}

	
	public UserModel1 findByUserName(String username) {
		String sql = "SELECT * FROM users WHERE username = ? ";
		try {
		conn = new DBConnectSQL().getConnection();
		ps = conn.prepareStatement(sql);
		ps.setString(1, username);
		rs = ps.executeQuery();
		while (rs.next()) {
		UserModel1 user = new UserModel1();
		user.setId(rs.getInt("id"));
		user.setEmail(rs.getString("email"));
		user.setUsername(rs.getString("username"));
		user.setFullname(rs.getString("fullname"));
		user.setPassword(rs.getString("password"));
		user.setImages(rs.getString("images"));
		user.setRoleid(Integer.parseInt(rs.getString("roleid")));
		user.setPhone(rs.getString("phone"));
		user.setCreateDate(rs.getDate("createDate"));
		return user;}
		} catch (Exception e) {e.printStackTrace();}
		return null;
	}

	
		
		
	
	@Override
	public UserModel1 findById(int id) {
		String sql = "SELECT * FROM users WHERE id = ? ";
		try {
		conn = new DBConnectSQL().getConnection();
		ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		rs = ps.executeQuery();
		while (rs.next()) {
		UserModel1 user = new UserModel1();
		user.setId(rs.getInt("id"));
		user.setEmail(rs.getString("email"));
		user.setUsername(rs.getString("username"));
		user.setFullname(rs.getString("fullname"));
		user.setPassword(rs.getString("password"));
		user.setImages(rs.getString("images"));
		user.setRoleid(Integer.parseInt(rs.getString("roleid")));
		user.setPhone(rs.getString("phone"));
		user.setCreateDate(rs.getDate("createDate"));
		return user;}
		} catch (Exception e) {e.printStackTrace();}
		return null;
	}
	public static void main(String[] args) {
		try {
			IUserDao userDao = new UserDaoImpl();
			System.out.println(userDao.findAll());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	


}
