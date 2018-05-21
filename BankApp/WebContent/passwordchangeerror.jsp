<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 style="color:red;">New password & confirm new password mismatch!!Try Again</h1>
<form action="passwordchange">
		<table>
			
			<tr>
				<td><label>Old Password</label></td>
				<td><input type="text" name="opw"/></td>
			</tr>
			<tr>
				<td><label>New Password</label></td>
				<td><input type="text" name="npw"/></td>
			</tr>
		
			<tr>
				<td><label> Confirm New Password</label></td>
				<td><input type="text" name="cnpw"/></td>
			</tr>
			 </table>
			        <button type="submit" style="color:red;">Submit</button>
				
        
     </form>
</body>
</html>