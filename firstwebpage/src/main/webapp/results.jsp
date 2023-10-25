<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Processing Results</title>
</head>
<link rel="stylesheet" type="text/css" href="result.css">
<body>
    <h1> Results</h1>
    <p><strong>Text:</strong></p>
    <p><%= request.getAttribute("paragraph") %></p>
    <p><strong>Total Word Count is:</strong></p>
    <p><%= request.getAttribute("totalWordCount") %></p>
    <p><strong>Remaining Word Counts:</strong></p>
    <ul>
        <c:forEach var="entry" items="${wordCountMap}">
            <li>${entry.key}: ${entry.value}</li>
        </c:forEach>
    </ul>
</body>
</html>