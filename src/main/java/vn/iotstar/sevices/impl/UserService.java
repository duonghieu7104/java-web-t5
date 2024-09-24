package vn.iotstar.sevices.impl;

import java.time.LocalDate;

import org.mindrot.jbcrypt.BCrypt;

import vn.iotstar.dao.IUserDao;
import vn.iotstar.dao.impl.UserDaoImpl;
import vn.iotstar.models.UserModel1;

import vn.iotstar.sevices.IUserService;



public class UserService implements IUserService {
     IUserDao userDao = new UserDaoImpl();
	@Override
	public UserModel1 login(String username, String password) {
		UserModel1 user = this.FindByUserName(username);
		if (user != null && password.equals(user.getPassword())) {
		return user;
		}
		return null;
	}

	@Override
	public UserModel1 FindByUserName(String username) {
		return userDao.findByUserName(username);
	}

	


   
}
