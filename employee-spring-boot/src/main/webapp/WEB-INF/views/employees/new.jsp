<%@page import="com.valtech.training.employeespringboot.models.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create New Employee</title>
<style>
    body {
      font-family: Arial, sans-serif;
      margin: 0;
      padding: 20px;
      background-color: #f7f7f7;
    }
    form {
      background-color: #fff;
      padding: 20px;
      border-radius: 8px;
      box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }
    table {
      width: 100%;
    }
    td {
      padding: 8px;
    }
    input[type="text"] {
      width: 100%;
      padding: 6px;
      border-radius: 4px;
      border: 1px solid #ccc;
    }
    input[type="submit"] {
      padding: 8px 16px;
      border: none;
      border-radius: 4px;
      background-color: #4caf50;
      color: white;
      cursor: pointer;
      margin-right: 10px;
    }
    input[type="submit"]:hover {
      background-color: #45a049;
    }
    input[type="submit"][name="cancel"] {
      background-color: #f44336;
    }
    input[type="submit"][name="cancel"]:hover {
      background-color: #d32f2f;
    }
  </style>
</head>
<body>
<form method="post" action="save">
	<table>
		<tr>
			<td>Employee_ID</td>
			<td><input type="text" disabled="disabled" name="id"/></td>
		</tr>
		<tr>
			<td>Employee_Name</td>
			<td><input type="text" name="name"/></td>
		</tr>
		<tr>
			<td>Age</td>
			<td><input type="text" name="age"/></td>
		</tr>
		<tr>
			<td>Experience</td>
			<td><input type="text" name="experience"/></td>
		</tr>
		<tr>
			<td>Seniority</td>
			<td><input type="text" name="seniority"/></td>
		</tr>
		<tr>
			<td>Salary</td>
			<td><input type="text" name="salary"/></td>
		</tr>
		<tr>
			<td>Department_ID</td>
			<td><input type="text" name="department"/></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" name="submit" value="Create"/>
				<input type="submit" name ="cancel" value="Cancel"/>
			</td>
		</tr>
	</table>
</form>
</body>
</html>