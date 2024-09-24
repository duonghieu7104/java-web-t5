package vn.iotstar.dao;

public interface IUserDao3 {
	 boolean checkUserExists(String username);
	 boolean updatePassword(String username, String newPassword);
}
