<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
		String loginId = request.getParameter("loginId");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String profile = request.getParameter("profile");
		String icon=request.getParameter("icon");
		String del = request.getParameter("del");
	%>
	<div class="bg-success padding-y-5">
		<div class="container padding-y-5 text-center">
			<h1>
				変更完了画面&nbsp;<span class="icon-speaker"></span>
			</h1>
		</div>
	</div>
	<div class="padding-y-5 text-center">
		<div style="width: 40%" class="container padding-y-5 text-center">
		<form action="./UserDateUpdateResultCheck" method="post">
			<table style="width: 600px" class="table">
					<tr>
						<td class="color-main text-left">ログインID</td>
						<td class="text-left"><%=loginId %><input class="form-control" type="hidden"
							name="loginId" value=<%=loginId%>></td>
					</tr>
					<tr>
						<td class="color-main text-left">パスワード</td>
						<td class="text-left"><%=password %><input class="form-control" type="hidden"
							name="password" value=<%=password%>></td>
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
						type="submit" value="変更完了" />
			</form>
		</div>
	</div>
</body>
</html>