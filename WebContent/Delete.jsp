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
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String profile = request.getParameter("profile");
		String dele = request.getParameter("del");
		String loginId = request.getParameter("loginId");
		String delete=request.getParameter("delete");
	%>
	<div class="bg-success padding-y-5">
		<div class="container padding-y-5 text-center">
			<h1>
				確認画面&nbsp;<span class="icon-speaker"></span>
			</h1>
		</div>
	</div>
	<div class="padding-y-5 text-center">
		<div style="width: 40%" class="container padding-y-5 text-center">
			<form action="./UserDelete" method="post">
				<table>
					<tr>
						<td class="color-main text-left">ユーザー名</td>
						<td class="text-left"><input class="form-control" type="text"
							name="userName" value=<%=userName%>></td>
					</tr>
					<tr>
						<td class="color-main text-left">パスワード</td>
						<td class="text-left"><input class="form-control" type="text"
							name="password" value=<%=password%>></td>
					</tr>
					<tr>
						<td class="color-main text-left">ログインID</td>
						<td class="text-left"><input class="form-control" type="text"
							name="loginId" value=<%=loginId%>></td>
					</tr>
					<tr>
						<td class="color-main text-left">コメント</td>
						<td class="text-left"><input class="form-control" type="text"
							name="profile" value=<%=profile%>></td>
					</tr>
					<tr>
						<td class="color-main text-left"></td>
						<td class="text-left"><input class="form-control"
							type="hidden" name="del" value=<%=dele %>></td>
					</tr>
						<tr>
						<td class="color-main text-left"></td>
						<td class="text-left"><input class="form-control"
							type="hidden" name="delete" value=<%=delete %>></td>
					</tr>
					<tr>
						<td colspan="2" class="text-right"><input class="btn"
							type="submit" value="削除する" /></td>
					</tr>
				</table>
			</form>
			<form action="Research.jsp" method="post">
				<table>
					<tr>
						<td class="color-main text-left"></td>
						<td class="text-left"><input class="form-control"
							type="hidden" name="return" value=<%=dele %>></td>
					</tr>
					<tr>
						<td colspan="2" class="text-right"><input class="btn"
							type="submit" value="戻る" /></td>
					</tr>
				</table>
			</form>

		</div>
	</div>
</body>
</html>