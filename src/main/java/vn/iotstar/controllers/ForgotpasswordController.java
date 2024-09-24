package vn.iotstar.controllers;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.iotstar.sevices.impl.UserService2;
import vn.iotstar.sevices.impl.UserService3;

@WebServlet(urlPatterns = "/forgotpassword")
public class ForgotpasswordController extends HttpServlet{

	
	private static final long serialVersionUID = 1L;
    
	 private UserService3 userService3;

	    public ForgotpasswordController() {
	        // Khởi tạo UserService2
	        userService3 = new UserService3();
	    }
	    @Override
	    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    	String username = req.getParameter("uname");
	        String newPassword = req.getParameter("newpass");
	        String confirmNewPassword = req.getParameter("confirmnewpass");

	        // Gọi UserService để thực hiện đổi mật khẩu
	        String resultMessage = userService3.resetPassword(username, newPassword, confirmNewPassword);

	        if (resultMessage.equals("Đổi mật khẩu thành công!")) {
	        	 req.setAttribute("alert", "Đổi mật khẩu thành công!");
	             resp.sendRedirect(req.getContextPath() + "/login");
	        } else {
	            // Nếu có lỗi, hiển thị thông báo lỗi trên trang forgotpassword
	            req.setAttribute("alert", resultMessage);
	            req.getRequestDispatcher("/view/forgotpassword.jsp").forward(req, resp);
	        }
	    }
}
