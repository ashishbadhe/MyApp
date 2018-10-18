<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register customer</title>
</head>
<body>
<center>
	<h3>Welcome to Customer Register Page!!</h3>
	<form action="insertCustomer" method="post">
		<table align="center">
			<tr>
				<td>ID</td><td>:</td>
				<td><input type="text" name="custId" /></td>
			</tr>
			<tr>
				<td>NAME</td><td>:</td>
				<td><input type="text" name="custName" /></td>
			</tr>
			<tr>
				<td>Email</td><td>:</td>
				<td><input type="text" name="custEmail" /></td>
			</tr>
			<tr>
				<td>TYPE</td>
				<td>:</td>
				<td><select name="custType">
  						<option value="CONSUMER">CONSUMER</option>
  						<option value="SELLER">SELLER</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>ADDRESS</td><td>:</td>
				<td><textarea name="custAddr"></textarea></td>
			</tr>
			<tr>
				<td><input type="submit" value="SUBMIT"></td>
			</tr>
		</table>
	</form>
	${msg}
	</br>
	<a href="viewAllCusts">ViewAll</a>
</center>
</body>
</html>