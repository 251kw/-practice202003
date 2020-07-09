<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./css/skyblue.css">
<link rel="stylesheet" href="./css/pe-icon-7-stroke.css">
<link rel="stylesheet" href="./css/helper.css">
<link rel="stylesheet" href="./css/staylesheet.css">
</head>
<body>
	<%
		String loginId = request.getParameter("loginId");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String profile = request.getParameter("profile");
		String icon = request.getParameter("icon");
	%>
	<div class="bg-success padding-y-5">
		<div class="container padding-y-5 text-center">
			<h1>
				変更確認画面&nbsp;<span class="icon-speaker"></span>
			</h1>
		</div>
	</div>
	<div class="padding-y-5 text-center">
		<div style="width: 40%" class="container padding-y-5 text-center">
			<form action="./UserDateUpdateInput" method="post">
				<table class="table table-striped table-bordered table-hover">
					<thead>
						<tr>
							<th>ログインID</th>
							<th>ユーザー名</th>
							<th>パスワード</th>
							<th>性別</th>
							<th>コメント</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><input class="form-control" type="hidden" name="loginId"
								value=<%=loginId%>><%=loginId%></td>
							<td><input class="form-control" type="hidden"
								name="userName" value=<%=userName%>><%=userName%></td>
							<td><input class="form-control" type="hidden"
								name="password" value=<%=password%>><%=password%></td>
							<td><input type="hidden" name="icon" value=<%=icon%>><%=icon%></td>
							<td><input class="form-control" type="hidden" name="profile"
								value=<%=profile%>><%=profile%></td>
						</tr>
					</tbody>
					<c:if test="${requestScope.alert != null }">
						<tr>
							<%-- リクエストスコープの alert の値を出力 --%>
							<td colspan="2" class="color-error text-left"><c:out
									value="${requestScope.alert}" /></td>
						</tr>
					</c:if>
				</table>
				<input class="btn" type="submit" value="変更する" /> <input class="btn"
					type="submit" name="return" value="戻る" />
			</form>


		</div>
	</div>
</body>
</html>