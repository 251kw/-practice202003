<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>検索</title>
<link rel="stylesheet" href="./css/skyblue.css">
<link rel="stylesheet" href="./css/pe-icon-7-stroke.css">
<link rel="stylesheet" href="./css/helper.css">
</head>
<body>
	<%
		String user = request.getParameter("user");
	%>
	<div class="bg-success padding-y-5">
		<div class="container padding-y-5 text-center">
			<h1>
				ユーザー情報検索&nbsp;<span class="icon-speaker"></span>
			</h1>
		</div>
	</div>

	<div class="padding-y-5 text-center">
		<div style="width: 40%" class="container padding-y-5 text-center">
			<form action="./UserDatesearchInput" method="post">
				<table style="width: 400px" class="table">
					<tr>
						<%-- ログインID 入力欄の名前は loginId --%>
						<td class="color-main text-left">ログインID</td>
						<td class="text-left"><input class="form-control" type="text"
							name="loginId" placeholder="shin" value=""></td>
					</tr>
						<tr>
						<td class="color-main text-left">ユーザー名</td>
						<td class="text-left"><input class="form-control" type="text"
							name="userName" placeholder="pass1" value=""></td>
					</tr>
					<tr>
						<td class="color-main text-left">アイコン</td>
						<td>
						<input type="radio" name="icon" id="male" value="male" checked><span>male</span>
						<input type="radio" name="icon" id="female" value="female" ><span>female</span>
						</td>
					</tr>
					<tr>
						<td><input type="hidden" name="user" value=<%=user%> /></td>
					</tr>
					<tr>
						<td colspan="2" class="text-right"><input class="btn"
							type="submit" value="検索" /></td>
							<td class="text-left"><a href="top.jsp" class="btn">戻る</a></td>
					</tr>
					<%-- リクエストスコープに alert があれば --%>
					<c:if
						test="${requestScope.alert != null && requestScope.alert != ''}">
						<tr>
							<%-- リクエストスコープの alert の値を出力 --%>
							<td colspan="2" class="color-error text-left"><c:out
									value="${requestScope.alert}" /></td>
						</tr>
					</c:if>
				</table>
			</form>
		</div>
	</div>
</body>
</html>