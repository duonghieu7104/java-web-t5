package vn.iotstar.sevices;

import vn.iotstar.models.UserModel2;

public interface IUserService2 {

	
	void insert(UserModel2 user);

	boolean checkExistEmail(String email);
	boolean checkExistUsername(String username);
	boolean checkExistPhone(String phone);
	boolean register(String username,String password,String email);
}
