<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		String loginId = request.getParameter("loginId");
		String password = request.getParameter("password");
		String userName = request.getParameter("userName");
		String icon = request.getParameter("icon");
		String profile = request.getParameter("profile");
		String message=null;

		out.println("ログインID:" + loginId + "<br>");
		out.println("パスワード:" + password + "<br>");
		out.println("ユーザー名:" + userName + "<br>");
		out.println("アイコン:" + icon + "<br>");
		out.println("コメント:" + profile + "<br>");


	%>
	<form action="./UserAddServlet" method="post">
		<table>
			<tr>
				<%-- ログインID 入力欄の名前は loginId --%>
				<td class="color-main text-left"></td>
				<td class="text-left"><input class="form-control" type="hidden"
					name="loginId" value=<%=loginId %>  /></td>
			</tr>
			<tr>
				<%-- パスワード入力欄の名前は password --%>
				<td class="color-main text-left"></td>
				<td class="text-left"><input class="form-control"
					type="hidden" name="password" value=<%=password %>  /></td>
			</tr>
			<tr>
				<td class="color-main text-left"></td>
				<td class="text-left"><input class="form-control" type="hidden"
					name="userName"  size="20" /></td>
			</tr>
			<tr>
				<td><lavel for="male">
					<input type="hidden" name="icon" id="male"  checked></lavel>
					<lavel for="female">
					<input type="hidden" name="icon" id="female" ></lavel>
				</td>
				</td>
			</tr>
			<tr>
				<td class="color-main text-left"></td>
				<td class="text-left"><input class="form-control" type="hidden"
					name="profile"  size="20" /></td>
			</tr>
			<tr>
				<td colspan="2" class="text-right"><input class="btn"
					type="submit" value="上記の内容で新規登録する" /></td>
			</tr>
		</table>

	</form>

		</table>

	</form>





</body>
</html>