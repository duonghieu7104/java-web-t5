package vn.iotstar.sevices.impl;

import vn.iotstar.dao.IUserDao3;
import vn.iotstar.dao.impl.UserDaoImpl3;
import vn.iotstar.sevices.IUserService3;

public class UserService3 implements IUserService3{
	  IUserDao3 userDao2 = new UserDaoImpl3();
	@Override
	public String resetPassword(String username, String newPassword, String confirmNewPassword) {
		if (!newPassword.equals(confirmNewPassword)) {
            return "Mật khẩu không khớp!";
        }

        // Kiểm tra username có tồn tại không
        if (!userDao2.checkUserExists(username)) {
            return "Tài khoản không tồn tại!";
        }

        // Thực hiện đổi mật khẩu
        boolean success = userDao2.updatePassword(username, newPassword);
        if (success) {
            return "Đổi mật khẩu thành công!";
        } else {
            return "Có lỗi xảy ra khi đổi mật khẩu!";
        }
    }
	

}
