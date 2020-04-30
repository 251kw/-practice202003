<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html lang="ja">
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
		String userName = request.getParameter("userName");
		String dels = request.getParameter("dels");
	%>


	<form action="./Updeta" method="post">
		<table style="width: 400px" class="table">
			<tr>
				<%-- ログインID 入力欄の名前は loginId --%>
				<td class="color-main text-left">ログインID</td>
				<td class="text-left"><input class="form-control" type="text"
					name="loginId" value="" size="20" /></td>
			</tr>
			<tr>
				<%-- パスワード入力欄の名前は password --%>
				<td class="color-main text-left">パスワード</td>
				<td class="text-left"><input class="form-control"
					type="password" name="password" value="" size="20" /></td>
			</tr>
			<tr>
				<td class="color-main text-left">コメント</td>
				<td class="text-left"><input class="form-control"
					type="text" name="profile" value="" size="20" /></td>
			</tr>
			<tr>
				<td class="color-main text-left">性別</td>
				<td><input type="radio" name="icon" id="male" value="male"
					checked><span>male</span> <input type="radio" name="icon"
					id="female" value="female" checked><span>male</span></td>
			</tr>
			<tr>
				<td class="color-main text-left"></td>
				<td class="text-left"><input class="form-control" type="hidden"
					name="userName" value=<%=userName%> size="20" /></td>

			<tr>
				<td colspan="2" class="text-right"><input class="btn"
					type="submit" value="変更する" /></td>
			</tr>
		</table>
	</form>

</body>
</html>
