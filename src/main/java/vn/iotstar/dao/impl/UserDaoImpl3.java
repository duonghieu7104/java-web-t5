package vn.iotstar.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import vn.iotstar.configs.DBConnectSQL;
import vn.iotstar.dao.IUserDao3;

public class UserDaoImpl3 extends DBConnectSQL implements IUserDao3{
	public Connection conn = null;
	public PreparedStatement ps=null;
	public ResultSet rs = null;
	@Override
	public boolean checkUserExists(String username) {
		 String sql = "SELECT username FROM users WHERE username = ?";
	        try (Connection conn = new DBConnectSQL().getConnection();
	             PreparedStatement ps = conn.prepareStatement(sql)) {

	            ps.setString(1, username);
	            ResultSet rs = ps.executeQuery();
	            return rs.next();  // Trả về true nếu username tồn tại
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return false;  // Trả về false nếu có lỗi xảy ra
	    
	        
	}

	@Override
	public boolean updatePassword(String username, String newPassword) {
		String sql = "UPDATE users SET password = ? WHERE username = ?";
        try ( Connection conn = new DBConnectSQL().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, newPassword);  // Hash password nếu cần
            ps.setString(2, username);
            int rowsUpdated = ps.executeUpdate();
            return rowsUpdated > 0;  // Trả về true nếu đổi mật khẩu thành công
        } catch (Exception  e) {
            e.printStackTrace();
        }
        return false;
    }
	

}
