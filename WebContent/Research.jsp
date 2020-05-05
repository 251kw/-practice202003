<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<link rel="stylesheet" href="./css/skyblue.css">
<link rel="stylesheet" href="./css/pe-icon-7-stroke.css">
<link rel="stylesheet" href="./css/helper.css">
<title>Insert title here</title>
</head>
<body>
	<%
		String delete = request.getParameter("return");
	%>
	<div class="bg-success padding-y-5">
		<div class="container padding-y-5 text-center">
			<h1>
				検索画面r&nbsp;<span class="icon-speaker"></span>
			</h1>
		</div>
	</div>

	<div class="padding-y-5 text-center">
		<div style="width: 40%" class="container padding-y-5 text-center">
			<jsp:useBean id="list" scope="session"
				type="java.util.ArrayList<dto.UserDTO>" />
			<c:forEach var="users" items="${list}">
			<div style="display:inline-flex">
			<P><font size="5" color="#2196F3">ユーザー名:${users.userName}</font></P>
			<form action="NewFile.jsp">
					<table>
						<tr>
							<td class="text-left"><input class="form-control"
								type="hidden" name="userName" value=${users.userName } size="20" /></td>
						</tr>

						<tr>
							<td colspan="2" class="text-right"><input class="btn"
								style="float: right;" type="submit" value="変更する" /></td>
						</tr>
					</table>
				</form>
			<form action="Delete.jsp" method="post">
					<table>
						<tr>
							<td class="color-main text-left"></td>
							<td class="text-left"><input class="form-control"
								type="hidden" name="userName" value=${users.userName } size="20" /></td>
						</tr>
						<tr>
							<td class="color-main text-left"></td>
							<td class="text-left"><input class="form-control"
								type="hidden" name="password" value=${users.password } size="20" /></td>
						</tr>
						<tr>
							<td class="color-main text-left"></td>
							<td class="text-left"><input class="form-control"
								type="hidden" name="profile" value=${users.profile } size="20" /></td>
						</tr>
						<tr>
							<td class="color-main text-left"></td>
							<td class="text-left"><input class="form-control"
								type="hidden" name="del" value=${del } size="20" /></td>
						</tr>
						<tr>
							<td class="color-main text-left"></td>
							<td class="text-left"><input class="form-control"
								type="hidden" name="loginId" value=${users.loginId } /></td>
						</tr>
						<tr>
							<td class="color-main text-left"></td>
							<td class="text-left"><input class="form-control"
								type="hidden" name="delete" value=<%=delete %> /></td>
						</tr>
						<tr>
							<td colspan="2" class="text-right"><input class="btn"
								type="submit" value="削除する" /></td>
						</tr>
					</table>
				</form>
				</div>
			</c:forEach>
			</div>
			</div>
</body>
</html>