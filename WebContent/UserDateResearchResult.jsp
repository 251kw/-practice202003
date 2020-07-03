<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
		String delete = request.getParameter("return");
		String deleter = request.getParameter("deleter");
	%>
	<div class="bg-success padding-y-5">
		<div class="container padding-y-5 text-center">
			<h1>
				検索画面&nbsp;<span class="icon-speaker"></span>
			</h1>
		</div>
	</div>
	<div class="padding-y-5 text-center">
		<div style="width: 60%" class="container padding-y-5 text-center">
			<jsp:useBean id="list" scope="session"
				type="java.util.ArrayList<dto.UserDTO>" />
		</div>
	</div>
	<c:if test="${requestScope.alert != null && requestScope.alert != ''}">
		<tr>
			<%-- リクエストスコープの alert の値を出力 --%>
			<td colspan="2" class="color-error text-left"><c:out
					value="${requestScope.alert}" /></td>
		</tr>
	</c:if>
	<form action="./UserDateSearchResult" method="post">
		<table class="table table-striped table-bordered table-hover">
			<thead>
				<tr>
					<th>選択</th>
					<th>ログインID</th>
					<th>性別</th>
					<th>コメント</th>
				</tr>
			</thead>
			<c:forEach var="users" items="${list}">
				<tbody>
					<tr>
						<c:if test="${deleter != null}">
							<td><label><input type="checkbox" name="userloginId"
									value=${users.loginId } checked></label></td>
						</c:if>
						<c:if test="${deleter == null}">
							<td><label><input type="checkbox" name="userloginId"
									value=${users.loginId }></label></td>
						</c:if>
						<td>${users.loginId }<input type="hidden" name="del"
							id="female" value=${userw }></td>
						<td>${users.icon }</td>
						<td>${users.profile }</td>
					</tr>
				</tbody>
			</c:forEach>
		</table>
		<input class="btn" style="float: right;" type="submit" name="delete"
			value="削除する" /> <input class="btn" style="float: right;"
			type="submit" name="updata" value="変更する" /> <input class="btn"
			style="float: center;" type="submit" name="deleter" value="全選択する" />
			<input class="btn"
			style="float: center;" type="submit" name="clear" value="解除" />
		<input class="btn" style="float: center;" type="submit" name="return"
			value="戻る" />

	</form>
</body>
</html>