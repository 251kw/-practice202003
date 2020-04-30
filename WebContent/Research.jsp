<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="./css/skyblue.css">
<link rel="stylesheet" href="./css/pe-icon-7-stroke.css">
<link rel="stylesheet" href="./css/helper.css">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String del = request.getParameter("del");
	%>

	<jsp:useBean id="user" scope="session"
		type="java.util.ArrayList<dto.UserDTO>" />
	<c:forEach var="users" items="${user}">
			${del}
　			${users.userName}<br>


		<form action="NewFile.jsp">
			<td><input class="form-control" type="hidden" name="userName"
				value=${users.userName } /></td>


			<tr>
				<td colspan="2" class="text-right"><input class="btn"
					type="submit" value="変更する" /></td>
			</tr>
		</form>
		<form action="./UserDelete" method="post">
			<tr>
				<td class="color-main text-left"></td>
				<td class="text-left"><input class="form-control" type="hidden"
					name="userName" value=${users.userName } size="20" /></td>
			</tr>
			<tr>
				<td class="color-main text-left"></td>
				<td class="text-left"><input class="form-control" type="hidden"
					name="password" value=${users.password } size="20" /></td>
			</tr>
			<tr>
				<td class="color-main text-left"></td>
				<td class="text-left"><input class="form-control" type="hidden"
					name="profile" value=${users.profile } size="20" /></td>
			</tr>
			<tr>
				<td colspan="2" class="text-right"><input class="btn"
					type="submit" value="削除する" /></td>
			</tr>

		</form>


	</c:forEach>
</body>
</html>