<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
		String del=request.getParameter("del");
	%>
	<div class="bg-success padding-y-5">
		<div class="container padding-y-5 text-center">
			<h1>
				変更完了r&nbsp;<span class="icon-speaker"></span>
			</h1>
		</div>
	</div>
	<div class="padding-y-5 text-center">
		<div style="width: 40%" class="container padding-y-5 text-center">
			<form action="./UserUpdeta4" method="post">
				<table style="width: 400px" class="table">
					<tr>
						<%-- ログインID 入力欄の名前は loginId --%>
						<td class="color-main text-left">ログインID</td>
						<td class="text-left"><input class="form-control"
							type="hidden" name="loginId" value=<%=loginId%>></td>
					</tr>
					<tr>
						<%-- パスワード入力欄の名前は password --%>
						<td class="color-main text-left">パスワード</td>
						<td class="text-left"><input class="form-control"
							type="hidden" name="password" value=<%=password%>></td>
					</tr>
					<tr>
						<td class="color-main text-left">コメント</td>
						<td class="text-left"><input class="form-control"
							type="hidden" name="profile" value=<%=profile%>></td>
					</tr>
					<tr>
						<td class="color-main text-left">コメント</td>
						<td class="text-left"><input class="form-control"
							type="hidden" name="userName" value=<%=userName%>></td>
					</tr>
								<tr>
						<td class="color-main text-left"></td>
						<td class="text-left"><input class="form-control"
							type="hidden" name="del" value=<%=del %>></td>
					</tr>
					<tr>
						<td colspan="2" class="text-right"><input class="btn"
							type="submit" value="topに戻る" /></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>