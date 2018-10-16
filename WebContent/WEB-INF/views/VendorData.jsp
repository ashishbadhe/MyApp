<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All Vendor Data</title>
</head>
<body>
	<center>
		<h3>All Vendors details</h3>
		<a href="excelExport">Export To Excel</a> | <a href="pdfExport">Export To PDF</a>
		<table border="1">
			<tr>
				<th>ID</th>
				<th>NAME</th>
				<th>CODE</th>
				<th>TYPE</th>
				<th>ADRESS</th>
				<th>ID</th>
				<th>ID NUM</th>
				<th>NOTE</th>
				<th colspan="2">Operations</th>
			</tr>
			<c:forEach items="${venOb}" var="lists">
				<tr>
					<td><c:out value="${lists.venId}"></c:out></td>
					<td><c:out value="${lists.venName}"></c:out></td>
					<td><c:out value="${lists.venCode}"></c:out></td>
					<td><c:out value="${lists.venType}"></c:out></td>
					<td><c:out value="${lists.addr}"></c:out></td>
					<td><c:out value="${lists.idType}"></c:out></td>
					<td><c:out value="${lists.idNum}"></c:out></td>
					<td><c:out value="${lists.dsc}"></c:out></td>
					<td><a href="editVen?venId=<c:out value="${lists.venId}" />">Edit
							Vendor</a></td>
					<td><a
						href="deleteVen?venId=<c:out value="${lists.venId}" />">Delete
							Vendor</a></td>
				</tr>
			</c:forEach>
		</table>
		<a href="genReport">Generate Report</a>
	</center>
</body>
</html>