<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Quên mật khẩu</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            background-color: #f8f9fa;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        .container {
            background-color: white;
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            width: 100%;
            max-width: 400px;
        }
        .container h2 {
            margin-bottom: 20px;
        }
        .form-group {
            margin-bottom: 15px;
        }
        .form-control {
            border-radius: 4px;
        }
        .btn-block {
            width: 100%;
        }
    </style>
</head>
<body>
    <div class="container">
        <form action="/ltwebb3/forgotpassword" method="post">
            <h2 class="text-center">Quên mật khẩu</h2>

            <!-- Hiển thị thông báo nếu có alert -->
            <c:if test="${not empty alert}">
                <div class="alert alert-danger">${alert}</div>
            </c:if>

            <!-- Tên tài khoản -->
            <div class="form-group">
                <label for="uname">Tên tài khoản</label>
                <input type="text" id="uname" name="uname" class="form-control" placeholder="Tên tài khoản" required>
            </div>

            <!-- Mật khẩu mới -->
            <div class="form-group">
                <label for="newpass">Mật khẩu mới</label>
                <input type="password" id="newpass" name="newpass" class="form-control" placeholder="Nhập mật khẩu mới" required>
            </div>

            <!-- Nhập lại mật khẩu -->
            <div class="form-group">
                <label for="confirmnewpass">Nhập lại mật khẩu</label>
                <input type="password" id="confirmnewpass" name="confirmnewpass" class="form-control" placeholder="Nhập lại mật khẩu" required>
            </div>

            <!-- Đổi mật khẩu -->
            <button type="submit" class="btn btn-primary btn-block">Đổi mật khẩu</button>
        </form>
    </div>

    <!-- Bootstrap JS and dependencies -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
