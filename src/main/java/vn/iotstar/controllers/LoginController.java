package vn.iotstar.controllers;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.iotstar.models.UserModel1;
import vn.iotstar.sevices.IUserService;
import vn.iotstar.sevices.impl.UserService;
import vn.iotstar.utils.Constant;

@WebServlet(urlPatterns = {"/login"})
public class LoginController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	IUserService service = new UserService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/view/login.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");

		String username = req.getParameter("uname");
		String password = req.getParameter("psw");
		String remember = req.getParameter("remember");

		boolean isRememberMe = "on".equals(remember);
		String alertMsg = "";

		// Kiểm tra trường hợp username hoặc password bị rỗng
		if (username.isEmpty() || password.isEmpty()) {
			alertMsg = "Tài khoản hoặc mật khẩu không được rỗng";
			req.setAttribute("alert", alertMsg);
			req.getRequestDispatcher("/view/login.jsp").forward(req, resp);
			return; // Dừng lại, không tiếp tục xử lý nữa
		}

		UserModel1 user = service.login(username, password);

		if (user != null) {
			// Đăng nhập thành công
			HttpSession session = req.getSession(true);
			session.setAttribute("account", user);
			session.setAttribute("username", user.getUsername());
			
			// Nếu chọn Remember Me thì lưu cookie
			if (isRememberMe) {
				saveRemeberMe(resp, username);
			}
			
			// Redirect đến trang "waiting"
			resp.sendRedirect(req.getContextPath() + "/waiting");
		} else {
			// Đăng nhập thất bại
			alertMsg = "Tài khoản hoặc mật khẩu không đúng";
			req.setAttribute("alert", alertMsg);
			req.getRequestDispatcher("/view/login.jsp").forward(req, resp);
		}
	}

	private void saveRemeberMe(HttpServletResponse resp, String username) {
		Cookie cookie = new Cookie(Constant.COOKIE_REMEMBER, username);
		cookie.setMaxAge(30 * 60); // Cookie tồn tại trong 30 phút
		resp.addCookie(cookie);
	}
}



