package vn.iotstar.controllers;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.iotstar.sevices.impl.UserService2;
import vn.iotstar.utils.Constant;

@WebServlet(urlPatterns = "/register")
public class RegisterController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    
    private UserService2 userService2;

    public RegisterController() {
        // Khởi tạo UserService2
        userService2 = new UserService2();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        HttpSession session = req.getSession(false);

        if (session != null && session.getAttribute("username") != null) {
            // Nếu người dùng đã đăng nhập, chuyển hướng tới trang admin
            resp.sendRedirect(req.getContextPath() + "/admin");
            return;
        }

        // Kiểm tra cookie để tự động đăng nhập nếu có cookie "username"
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("username")) {
                    session = req.getSession(true);
                    session.setAttribute("username", cookie.getValue());
                    resp.sendRedirect(req.getContextPath() + "/admin");
                    return;
                }
            }
        }

        // Chuyển đến trang đăng ký nếu không có phiên làm việc hoặc cookie
        req.getRequestDispatcher(Constant.REGISTER).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        // Lấy dữ liệu từ form
        String username = req.getParameter("uname");
        String password = req.getParameter("psw");
        String email = req.getParameter("email");

        String alertMsg = "";
       


        // Kiểm tra sự tồn tại của email và username thông qua đối tượng userService2
        if (userService2.checkExistEmail(email)) {
            alertMsg = "Email đã tồn tại!";
            req.setAttribute("alert", alertMsg);
            req.getRequestDispatcher(Constant.REGISTER).forward(req, resp);
            return;
        }

        if (userService2.checkExistUsername(username)) {
            alertMsg = "Tài khoản đã tồn tại!";
            req.setAttribute("alert", alertMsg);
            req.getRequestDispatcher(Constant.REGISTER).forward(req, resp);
            return;
        }

        // Thêm người dùng mới vào cơ sở dữ liệu qua userService2
        boolean isSuccess = userService2.register(username,password,email); // Gọi hàm register từ userService2

        if (isSuccess) {
            // Đăng ký thành công
            req.setAttribute("alert", "Đăng ký thành công!");
            resp.sendRedirect(req.getContextPath() + "/login"); // Chuyển hướng tới trang đăng nhập
        } else {
            // Đăng ký thất bại
            alertMsg = "Đã xảy ra lỗi trong quá trình lưu!";
            req.setAttribute("alert", alertMsg);
            req.getRequestDispatcher(Constant.REGISTER).forward(req, resp);
        }
    }
}
