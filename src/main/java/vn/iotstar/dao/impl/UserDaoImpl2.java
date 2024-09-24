package vn.iotstar.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import vn.iotstar.configs.DBConnectSQL;
import vn.iotstar.dao.IUserDao2;
import vn.iotstar.models.UserModel2;

public class UserDaoImpl2 extends DBConnectSQL implements IUserDao2 {
	public Connection conn = null;
	public PreparedStatement ps=null;
	public ResultSet rs = null;
	@Override
	public void insert(UserModel2 user) {
		String sql = "INSERT INTO users(username,password,email) VALUES (?,?,?)";
		try {
		conn = new DBConnectSQL().getConnection();
		ps = conn.prepareStatement(sql);
		ps.setString(1, user.getUsername());
		ps.setString(2, user.getPassword());
		ps.setString(3, user.getEmail());
		
		System.out.println("Inserting into users table: " + user.getUsername() + ", " + user.getPassword() + ", " + user.getEmail());

		ps.executeUpdate();
		} catch (Exception e) {e.printStackTrace();}
		
	}

	@Override
	public boolean checkExistEmail(String email) {
		boolean duplicate = false;
		String sql = "select * from users where email = ?";
		try {
		conn = new DBConnectSQL().getConnection();
		ps = conn.prepareStatement(sql);
		ps.setString(1, email);
		rs = ps.executeQuery();
		if (rs.next()) {
		duplicate = true;
		}
		ps.close();
		conn.close();
		} catch (Exception ex) {}
		return duplicate;

	}

	@Override
	public boolean checkExistUsername(String username) {
		boolean duplicate = false;
		String sql = "select * from users where username = ?";
		try {
		conn = new DBConnectSQL().getConnection();
		ps = conn.prepareStatement(sql);
		ps.setString(1, username);
		rs = ps.executeQuery();
		if (rs.next()) {
		duplicate = true;
		}
		ps.close();
		conn.close();
		} catch (Exception ex) {}
		return duplicate;

	}

	@Override
	public boolean checkExistPhone(String phone) {
		// TODO Auto-generated method stub
		return false;
	}

}
