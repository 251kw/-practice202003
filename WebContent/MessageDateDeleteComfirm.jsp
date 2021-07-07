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
</head>
<body>
	<div class="bg-success padding-y-5">
		<div class="container padding-y-5 text-center">
			<h1>
				コメント削除確認画面&nbsp;<span class="icon-speaker"></span>
			</h1>
		</div>
	</div>
	<div class="padding-y-5 text-center">
		<div style="width: 60%" class="container padding-y-5 text-center">
			<jsp:useBean id="list" scope="session"
				type="java.util.ArrayList<dto.ShoutDTO>" />
		</div>
	</div>
	<c:if test="${requestScope.alert != null && requestScope.alert != ''}">
		<tr>
			<%-- リクエストスコープの alert の値を出力 --%>
			<td colspan="2" class="color-error text-left"><c:out
					value="${requestScope.alert}" /></td>
		</tr>
	</c:if>
	<form action="./MessageDeleteInput" method="post">
		<table class="table table-striped table-bordered table-hover">
			<thead>
				<tr>
					<th>コメント</th>
					<th>性別</th>
					<th>日付</th>
					<th>ユーザー名</th>
				</tr>
			</thead>
			<c:forEach var="shout" items="${list}">
				<tbody>
					<tr>
						<td>${shout.writing }<input name="number" type="hidden"
							value=${shout.shout_id }></td>
						<td>${shout.icon }</td>
						<td>${shout.date }</td>
						<td>${shout.userName }</td>
					</tr>
				</tbody>
			</c:forEach>
		</table>
		<input class="btn" style="float: right;" type="submit" name="delete"
			value="削除する" /> <input class="btn" style="float: center;"
			type="submit" name="return" value="戻る" />
	</form>
</body>
</html>