package vn.iotstar.dao;

import vn.iotstar.models.UserModel2;

public interface IUserDao2 {
	void insert(UserModel2 user);

	boolean checkExistEmail(String email);
	boolean checkExistUsername(String username);
	boolean checkExistPhone(String phone);

}
