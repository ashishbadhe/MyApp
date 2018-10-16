<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>
		<form action="insertVendor" method="post">
			<table>
				<tr>
					<td>Code</td>
					<td><input type="text" name="venCode"></td>
				</tr>
				<tr>
					<td>Name</td>
					<td><input type="text" name="venName"></td>
				</tr>
				<tr>
					<td>TYPE</td>
					<td><input type="radio" name="venType" value="CONTRACT">CONTRACT</td>
				</tr>
				<tr>
					<td></td>
					<td><input type="radio" name="venType" value="FULLTIME">FULLTIME</td>
				</tr>
				<tr>
					<td></td>
					<td><input type="radio" name="venType" value="PARTTIME">PARTTIME</td>
				</tr>
				<tr>
					<td>Address</td>
					<td><textarea name="addr" /></td>
				</tr>
				<tr>
					<td>ID PROOF</td>
					<td><select name="idtype">
							<option>----Select----</option>
							<option value="PAN">PAN</option>
							<option value="AADHAR">AADHAR</option>
							<option value="VOTERID">VOTER ID</option>
					</select></td>
				</tr>
				<tr>
					<td>ID NUM</td>
					<td><input type="text" name="idNum"></td>
				</tr>
				<tr>
					<td>Address</td>
					<td><textarea name="addr" /></td>
				</tr>
				<tr>
					<td>NOTE</td>
					<td><textarea name="dsc" /></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Register" /></td>
				</tr>
			</table>
		</form>
		${msg}
	</center>
</body>
</html>