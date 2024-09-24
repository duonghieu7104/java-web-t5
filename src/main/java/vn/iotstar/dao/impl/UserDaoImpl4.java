package vn.iotstar.dao.impl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import vn.iotstar.configs.DBConnectSQL;
import vn.iotstar.dao.IUserDao4;
import vn.iotstar.models.UserModel1;


public class UserDaoImpl4 extends DBConnectSQL implements IUserDao4 {
    public Connection conn = null;
    public PreparedStatement ps = null;
    public ResultSet rs = null;

    // Phương thức tìm người dùng dựa trên ID
    @Override
    public UserModel1 findById(int id) {
        String sql = "SELECT * FROM users WHERE id = ?";
        UserModel1 user = new UserModel1();

        try {
            conn = this.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id); // Truyền ID người dùng vào câu SQL

            rs = ps.executeQuery();

            if (rs.next()) {
                
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setFullname(rs.getString("fullname"));
                user.setImages(rs.getString("images"));
                user.setPhone(rs.getString("phone"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return user; // Trả về đối tượng UserModel4 đã tìm thấy
    }

    // Phương thức cập nhật thông tin người dùng
    @Override
    public void update(UserModel1 user) {
        String sql = "UPDATE users SET username = ?, email = ?, fullname = ?, phone = ?, images = ? WHERE id = ?";
        
        try {
            conn = this.getConnection();
            ps = conn.prepareStatement(sql);

            ps.setString(1, user.getUsername());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getFullname());
            ps.setString(4, user.getPhone());
            ps.setString(5, user.getImages());
            ps.setInt(6, user.getId());

            ps.executeUpdate(); // Thực hiện cập nhật dữ liệu

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

	@Override
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
		
		user.setPhone(rs.getString("phone"));
		
		return user;}
		} catch (Exception e) {e.printStackTrace();}
		return null;
	}
}
