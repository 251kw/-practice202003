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
String loginId = (String) request.getAttribute("loginId");
String userName = (String) request.getAttribute("userName");
String password = (String) request.getAttribute("password");
String profile = (String) request.getAttribute("profile");
String icon = (String) request.getAttribute("icon");
%>
	<div class="bg-success padding-y-5">
		<div class="container padding-y-5 text-center">
			<h1>
				新規登録結果&nbsp;<span class="icon-speaker"></span>
			</h1>
		</div>
	</div>
	<div class="padding-y-5 text-center">
		<div style="width: 40%" class="container padding-y-5 text-center">
			<form action="index.jsp">
			<table style="width: 600px" class="table">
					<tr>
						<td class="color-main text-left">ログインID</td>
						<td class="text-left"><%=loginId %></td>
					</tr>
					<tr>
						<td class="color-main text-left">パスワード</td>
						<td class="text-left"><%=password %></td>
					</tr>
					<tr>
						<td class="color-main text-left">名前</td>
						<td class="text-left"><%=userName %></td>
					</tr>
					<tr>
						<td class="color-main text-left">性別</td>
						<td class="text-left"><%=icon %></td>
					</tr>
					<tr>
						<td class="color-main text-left">コメント</td>
						<td class="text-left"><%=profile %></td>
					</tr>
				</table>
				<input class="btn"
						type="submit" value="登録完了" />
			</form>
		</div>
	</div>
</body>

</html>