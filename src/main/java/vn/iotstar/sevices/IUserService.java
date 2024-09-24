package vn.iotstar.sevices;

import vn.iotstar.models.UserModel1;


public interface IUserService {
	UserModel1 login(String username,String password);
	
	UserModel1 FindByUserName(String username);
	
	
	
	
}
