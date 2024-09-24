package vn.iotstar.sevices;


import vn.iotstar.models.UserModel1;


public interface IUserService4 {
     
	void update(UserModel1 user);
	UserModel1 FindById(int id);
	UserModel1 FindByUserName(String username);
	
}
