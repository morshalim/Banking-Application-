<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Password not Matched</title>
</head>
<body>
<h1 style="color:blue;">New password & Confirm new password do not match. Try again!!! </h1>
<form action="newpassword">
<table>
	<tr>
		<td><label>New Password</label></td>
		<td><input type="text" name="npw"></td>
	</tr>
	<tr>
		<td><label>Confirm new Password</label></td>
		<td><input type="text" name="cnpw"></td>
	</tr>
</table>
<button type="submit" style="color:red;">Submit</button>
</form>
</body>
</html>