package vn.iotstar.controllers.admin;


import java.io.IOException;
import java.nio.file.Paths;
import java.io.File;


import javax.servlet.http.HttpSession;
import jakarta.servlet.http.Part;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.iotstar.models.UserModel1;
import vn.iotstar.sevices.IUserService4;
import vn.iotstar.sevices.impl.UserService4;


@MultipartConfig
@WebServlet(urlPatterns = {"/admin/updateprofile"})
public class UpdateprofileController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    IUserService4 userService = new UserService4();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	
    	

        String username = (String) req.getSession().getAttribute("username");
        if (username != null) {
            UserModel1 user = userService.FindByUserName(username);
            if (user != null) {
                req.setAttribute("id", user.getId());
                req.setAttribute("username", user.getUsername());
                req.setAttribute("email", user.getEmail());
                req.setAttribute("fullname", user.getFullname());
                req.setAttribute("phone", user.getPhone());
                req.setAttribute("images", user.getImages());
            } else {
                req.setAttribute("errorMessage", "User not found");
            }
        } else {
            req.setAttribute("errorMessage", "User is not logged in");
        }
        RequestDispatcher dispatcher = req.getRequestDispatcher("/view/admin/updateprofile.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	
    	
    	 try {
             int id = Integer.parseInt(req.getParameter("id"));
             String username = req.getParameter("username");
             String email = req.getParameter("email");
             String fullname = req.getParameter("fullname");
             String phone = req.getParameter("phone");

             // Xử lý file ảnh
             Part imagesPart = req.getPart("images");
             String images = null;

             if (imagesPart != null && imagesPart.getSize() > 0) {
                 String fileName = Paths.get(imagesPart.getSubmittedFileName()).getFileName().toString();
                 File uploadDir = new File(getServletContext().getRealPath("/uploads"));
                 if (!uploadDir.exists()) {
                     uploadDir.mkdirs();
                 }

                 String uploadPath = uploadDir.getAbsolutePath() + File.separator + fileName;
                 imagesPart.write(uploadPath);

                 // Đường dẫn ảnh sẽ được lưu trong CSDL (tương đối đến thư mục gốc của ứng dụng)
                 images = "/uploads/" + fileName;

                 // In ra để kiểm tra đường dẫn ảnh
                 System.out.println("File uploaded to: " + uploadPath);
             }

             // Tạo đối tượng người dùng để lưu vào CSDL
             UserModel1 user = new UserModel1();
             user.setId(id);
             user.setUsername(username);
             user.setEmail(email);
             user.setFullname(fullname);
             user.setPhone(phone);
             user.setImages(images); // Lưu đường dẫn ảnh

             // Cập nhật người dùng
             userService.update(user);

             // Điều hướng lại trang
             resp.sendRedirect(req.getContextPath() + "/admin/home");
         } catch (Exception e) {
             req.setAttribute("errorMessage", "An error occurred: " + e.getMessage());
             req.getRequestDispatcher("/view/admin/updateprofile.jsp").forward(req, resp);
         }
     }
    
}
