package vn.iotstar.sevices.impl;


import vn.iotstar.dao.IUserDao4;
import vn.iotstar.dao.impl.UserDaoImpl4;
import vn.iotstar.models.UserModel1;

import vn.iotstar.sevices.IUserService4;

public class UserService4 implements IUserService4 {
    IUserDao4 userDao4 = new UserDaoImpl4();

    // Phương thức cập nhật thông tin người dùng
    @Override
    public void update(UserModel1 user) {
        userDao4.update(user); // Gọi phương thức update từ DAO với đối tượng user
    }

    // Phương thức tìm người dùng theo ID
    @Override
    public UserModel1 FindById(int id) {
        return userDao4.findById(id); // Gọi phương thức findById từ DAO và trả về đối tượng UserModel4
    }

    // Phương thức tìm người dùng theo tên đăng nhập (username)
    @Override
    public UserModel1 FindByUserName(String username) {
        return userDao4.findByUserName(username); // Gọi phương thức findByUserName từ DAO với tham số username
    }

	
	
}
