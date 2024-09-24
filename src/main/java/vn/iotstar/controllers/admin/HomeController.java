package vn.iotstar.controllers.admin;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.iotstar.models.UserModel1;

@WebServlet(urlPatterns = {"/admin/home"})
public class HomeController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false); // Không tạo session mới nếu không có
        if (session != null && session.getAttribute("account") != null) {
            UserModel1 user = (UserModel1) session.getAttribute("account");
            
            // Kiểm tra vai trò người dùng
            if (user.getRoleid() == 2) {
                // Chỉ cần đảm bảo là người dùng có quyền truy cập
                req.setAttribute("username", user.getUsername()); // Đưa username vào request để sử dụng trong JSP
                req.getRequestDispatcher("/view/admin/home.jsp").forward(req, resp);
            } else {
                // Nếu người dùng không có quyền truy cập, có thể chuyển hướng về trang khác
                resp.sendRedirect(req.getContextPath() + "/home"); // Hoặc trang khác tùy ý
            }
        } else {
            // Nếu không có session, chuyển hướng về trang login
            resp.sendRedirect(req.getContextPath() + "/login");
        }
    }
}
