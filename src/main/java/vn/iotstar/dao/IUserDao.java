package vn.iotstar.dao;

import java.util.List;

import vn.iotstar.models.UserModel1;
import vn.iotstar.models.UserModel2;

public interface IUserDao {
	List<UserModel1> findAll();
	
	UserModel1 findById(int id);
	
	UserModel1 findByUserName(String username);
	
	
	
}
