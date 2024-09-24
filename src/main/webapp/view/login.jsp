<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login Page</title>
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
            background-color: #fff;
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            width: 100%;
            max-width: 400px;
        }
        .container h3 {
            margin-bottom: 20px;
        }
        .container .form-group {
            margin-bottom: 15px;
        }
        .container .form-control {
            border-radius: 4px;
        }
        .container button {
            width: 100%;
            padding: 10px;
            border-radius: 4px;
        }
        .register-link {
            text-align: center;
            margin-top: 20px;
        }
        .alert {
            margin-bottom: 20px;
        }
    </style>
</head>
<body>
    <div class="container">
        <form action="/ltwebb3/login" method="post">
            <c:if test="${alert != null}">
                <div class="alert alert-danger">${alert}</div>
            </c:if>
            <h2 class="text-center">Login</h2>

            <!-- Username -->
            <div class="form-group">
                <label for="uname"><b>Username</b></label>
                <input type="text" id="uname" name="uname" class="form-control" placeholder="Enter Username" required>
            </div>

            <!-- Password -->
            <div class="form-group">
                <label for="psw"><b>Password</b></label>
                <input type="password" id="psw" name="psw" class="form-control" placeholder="Enter Password" required>
            </div>

            <!-- Remember me -->
            <div class="form-group">
                <label>
                    <input type="checkbox" id="remember" name="remember" checked="checked">
                    <span>Remember me</span>
                </label>
                <a href="/ltwebb3/view/forgotpassword.jsp" class="forgotpassword-link">Forgot Password?</a>
            </div>

            <!-- Login button -->
            <button type="submit" class="btn btn-primary">Login</button>

            <!-- Register link -->
            <div class="register-link">
                <button type="button" class="btn btn-secondary" onclick="window.location.href='/ltwebb3/view/register.jsp'">Register</button>
            </div>
            

            
        </form>
    </div>

    <!-- Bootstrap JS and dependencies -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
