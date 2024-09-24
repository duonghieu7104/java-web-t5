<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update Profile</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        .profile-image {
            width: 120px; /* Kích thước mong muốn */
            height: 120px;
            border-radius: 50%; /* Tạo hình tròn */
            object-fit: cover; /* Cắt ảnh cho vừa khung */
            border: 2px solid #007BFF; /* Đường viền */
            margin-bottom: 20px;
        }
        input[type="file"] {
            display: none; /* Ẩn ô input */
        }
        .profile-pic-container {
            position: relative;
            display: inline-block;
        }
        .profile-pic-label {
            cursor: pointer; /* Con trỏ khi hover */
        }
    </style>
</head>
<body>
    <h1>Welcome, <%= request.getAttribute("username") != null ? request.getAttribute("username") : "Guest" %>!</h1>
    <div class="container">
        <h2>Update Profile</h2>
        
        <% if (request.getAttribute("error") != null) { %>
            <div class="alert alert-danger"><%= request.getAttribute("error") %></div>
        <% } %>

        <form action="<%=request.getContextPath()%>/admin/updateprofile" method="post" enctype="multipart/form-data">
            <input type="hidden" name="id" value="<%= request.getAttribute("id") %>">

           <div class="profile-pic-container">
    <label for="images" class="profile-pic-label">
        <!-- Hiển thị ảnh đã lưu trong CSDL, hoặc một ảnh mặc định nếu chưa có -->
        <img src="<%= request.getContextPath() + "/" + request.getAttribute("images") %>" alt="Profile Image" class="profile-image"/>

    </label>
    <input type="file" id="images" name="images" class="form-control-file" onchange="previewImage(event)">
    
</div>

            <div class="form-group">
                <label for="username">Username:</label>
                <input type="text" id="username" name="username" value="<%= request.getAttribute("username") %>" class="form-control">
            </div>

            <div class="form-group">
                <label for="email">Email:</label>
                <input type="email" id="email" name="email" value="<%= request.getAttribute("email") %>" class="form-control">
            </div>

            <div class="form-group">
                <label for="fullname">Full Name:</label>
                <input type="text" id="fullname" name="fullname" value="<%= request.getAttribute("fullname") %>" class="form-control">
            </div>

            <div class="form-group">
                <label for="phone">Phone:</label>
                <input type="text" id="phone" name="phone" value="<%= request.getAttribute("phone") %>" class="form-control">
            </div>

            <button type="submit" class="btn btn-primary">Update Profile</button>
        </form>
    </div>

    <script>
        function previewImage(event) {
            const file = event.target.files[0];
            const reader = new FileReader();
            reader.onload = function(e) {
                const img = document.querySelector('.profile-image');
                img.src = e.target.result;
            }
            reader.readAsDataURL(file);
        }
    </script>
</body>
</html>
