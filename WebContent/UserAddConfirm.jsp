<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content=Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./css/skyblue.css">
<link rel="stylesheet" href="./css/pe-icon-7-stroke.css">
<link rel="stylesheet" href="./css/helper.css">
</head>
<body>
	<div class="bg-success padding-y-5">
		<div class="container padding-y-5 text-center">
			<h1>新規登録&nbsp;</h1>
		</div>
	</div>
	<%
	String loginId = (String) request.getParameter("loginId");
	String userName = (String) request.getParameter("userName");
	String password = (String) request.getAttribute("password");
	String profile = (String) request.getAttribute("profile");
	String icon = (String) request.getAttribute("icon");
	%>
	<div class="padding-y-5 text-center">
		<div style="width: 40%" class="container padding-y-5 text-center">
			<div class="color-main">
			<form action="./UserAddServletResult" method="post">
				<table style="width: 600px" class="table">
					<tr>
						<td class="color-main text-left">ログインID</td>
						<td class="text-left"><%=loginId %><input class="form-control"
							type="hidden" name="loginId" value=<%=loginId%>></td>
					</tr>
					<tr>
						<td class="color-main text-left">パスワード</td>
						<td class="text-left"><%=password %><input class="form-control"
							type="hidden" name="password" value=<%=password%>></td>
					</tr>
					<tr>
						<td class="color-main text-left">名前</td>
						<td class="text-left"><%=userName %><input class="form-control"
							type="hidden" name="userName" value=<%=userName%>></td>
					</tr>
					<tr>
						<td class="color-main text-left">性別</td>
						<td class="text-left"><%=icon %><input class="form-control"
							type="hidden" name="icon" value=<%=icon%>></td>
					</tr>
					<tr>
						<td class="color-main text-left">コメント</td>
						<td class="text-left"><%=profile %><input class="form-control"
							type="hidden" name="profile" value=<%=profile%>></td>
					</tr>
				</table>
							<input class="btn"
							type="submit" value="新規登録する" />
				<input class="btn"
							type="submit" name="return" value="戻る" />
			</form>
			</div>
		</div>
	</div>
</body>
</html>