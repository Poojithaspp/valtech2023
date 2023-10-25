
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f2f5;
        }
        .container {
            text-align: center;
            margin: 100px auto;
            position:relative;
            max-width: 400px;
            background-color: #fff;
            padding: 10px;
            border-radius: 5px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }
        .logo {
            margin-bottom: 20px;
        }
        .form-control {
            width: 90%;
            padding: 10px;
            margin: 10px 0;
            border: 1px solid #ccc;
            border-radius: 3px;
        }
        .forgot-password {
            text-align: center;
        }
        h1{
        color: blue;
        }
        .newAC{
        text-decoration: blink;
        color: green;
        }
        .btn{
        backgroundcolor:#1877f2;}
        .img{text-align:center;
        }
    </style>
</head>
<body>
<div class="img">
<img src="facebook.png" alt="Facebook Logo" width="200">

</div>
    <div class="container">
        <div class="logo">
         
            <h3 >Log in to facebook</h3>
        </div>
        <form action="facebooklogin" method="post">
            <input type="text" class="form-control" name="username" placeholder="Email address or phone number" required>
            <input type="password" class="form-control" name="password" placeholder="Password" required>
            <div class="btn">
            <button type="submit" class="form-control">Log In</button></div>
        </form>
        <div class="forgot-password">
            <a href="forgot-password.jsp">Forgot Password?</a>
        </div>
        <hr>
        <div>
        <button type="reset" class=" newAC" >Create New Account</button>
        </div>
    </div>
</body>
</html>



















