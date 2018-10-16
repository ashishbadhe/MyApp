<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>update Vendor</title>
</head>
<body>
	<h3>Update Vendor Here</h3>
	<form action="updateVen" method="post">
		<table>
			<tr>
				<td>ID</td>
				<td><input type="text" name="venId" value="${ven.venId }" readonly="readonly"></td>
			</tr>
			<tr>
				<td>Code</td>
				<td><input type="text" name="venCode" value="${ven.venCode }"></td>
			</tr>
			<tr>
				<td>Name</td>
				<td><input type="text" name="venName" value="${ven.venName }"></td>
			</tr>
			<tr>
				<td>TYPE</td>
				<c:forEach items="${venType}" var="typeList">
					<c:choose>
						<c:when test="${ven.venType eq typeList }">
							<td><input type="radio" name="venType" value="${typeList}"
								checked="checked">${typeList}</td>
						</c:when>
						<c:otherwise>
							<td><input type="radio" name="venType" value="${typeList}">${typeList}</td>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</tr>

			<tr>
				<td>ID PROOF</td>
				<td><select name="idtype">
						<c:forEach items="${venIdType}" var="idType">
							<c:choose>
								<c:when test="${ven.venType eq idType}">
									<option value="${idType}" selected="selected">${idType}</option>
								</c:when>
								<c:otherwise>
									<option value="${idType}">${idType}</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td>ID NUM</td>
				<td><input type="text" name="idNum" value="${ven.idNum}"></td>
			</tr>
			<tr>
				<td>Address</td>
				<td><textarea name="addr">${ven.addr}</textarea></td>
			</tr>
			<tr>
				<td>NOTE</td>
				<td><textarea name="dsc">${ven.dsc}</textarea></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Update" /></td>
			</tr>
		</table>

	</form>
</body>
</html>