<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Fund Transfer</title>
</head>
<body>

<form action="Transfer">
		<table>
			
			<tr>
				<td><label>Third party acc no</label></td>
				<td><input type="text" name="tpaccno"></td>
			</tr>
			<tr>
				<td><label>Amount</label></td>
				<td><input type="text" name="amttransf"></td>
			</tr>
			 </table>
			        <button type="submit" style="color:red;">Submit</button>
				
        
     </form>

</body>
</html>