<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./css/skyblue.css">
<link rel="stylesheet" href="./css/pe-icon-7-stroke.css">
<link rel="stylesheet" href="./css/helper.css">
</head>
<body>
	<%
		String userloginId = request.getParameter("userloginId");
		String password = request.getParameter("password");
		String profile = request.getParameter("profile");
		String loginId = request.getParameter("loginId");
		String delete = request.getParameter("delete");
		String usere = request.getParameter("usere");
		String user = request.getParameter("usero");
	%>
	<div class="bg-success padding-y-5">
		<div class="container padding-y-5 text-center">
			<h1>
				削除確認画面&nbsp;<span class="icon-speaker"></span>
			</h1>
		</div>
	</div>
	<div class="padding-y-5 text-center">
		<div style="width: 40%" class="container padding-y-5 text-center">
		<jsp:useBean id="lists" scope="session"
				type="java.util.ArrayList<dto.UserDTO>" />
			<form action="./UserDateDeleteInput" method="post">
				<table class="table table-striped table-bordered table-hover">
					<thead>
						<tr>
							<th>ログインID</th>
							<th>パスワード</th>
							<th>性別</th>
							<th>プロフィール</th>
						</tr>
					</thead>
					<c:forEach var="users" items="${lists}">
						<tbody>
							<tr>
								<td>${users.loginId }<input type="hidden" name="del" value=${del }>
									<input type="hidden" name="user" value=${users }></td>
									<td>${users.password }</td>
									<td>${users.icon }</td>
									<td>${users.profile }</td>
							</tr>
					</c:forEach>
				</table>
				<input class="btn" type="submit" value="削除する" /> <input class="btn"
					type="submit" name="re" value="戻る" />
			</form>
		</div>
	</div>
</body>
</html>