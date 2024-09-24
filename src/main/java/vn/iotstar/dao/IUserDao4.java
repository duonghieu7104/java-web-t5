package vn.iotstar.dao;


import vn.iotstar.models.UserModel1;


public interface IUserDao4 {

	
	UserModel1 findById(int id);
	void update(UserModel1 user);
	UserModel1 findByUserName(String username);
}
