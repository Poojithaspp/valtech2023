<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Text Processing</title>
</head>
<link rel="stylesheet" type="text/css" href="document.css">
<body>
    <h1>Text Processing</h1>
    <div class="txt">
    <form action="DocumentServlet" method="post">
        <label for="paragraph">Enter a paragraph:</label><br>
        <textarea id="paragraph" name="paragraph" rows="10" cols="50"></textarea><br>
        <div class="btn">
        <input type="submit" value="GO"></div>
        </div>
    </form>
</body>
</html>
    