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
<%
String writing = (String)session.getAttribute("writing");
%>

	<div class="bg-success padding-y-5">
		<div class="container padding-y-5 text-center">
			<h1>
				叫ぶ変更画面&nbsp;<span class="icon-speaker"></span>
			</h1>
		</div>
	</div>
	<div class="padding-y-5 text-center">
		<div style="width: 60%" class="container padding-y-5 text-center">
			<form action="./messageupdate" method="post">
				<table style="width: 600px" class="table">
					<c:if test="${requestScope.alert != null }">
						<%-- リクエストスコープの alert の値を出力 --%>
						<td colspan="2" class="color-error text-left"><c:out
								value="${requestScope.alert}" /></td>
					</c:if>
					<tr>
						<td class="color-main text-left">コメント</td>
						<td class="text-left"><input class="form-control" type="text"
							name="writing" value=<%=writing %>></td>
						<td><input class="form-control" type="hidden" name="number"
							value="${up.shout }"></td>
					</tr>
					<tr>
						<td class="color-main text-left">ユーザー名</td>
						<td>${up.userName}<input class="form-control" type="hidden"
							name="userName" value="${up.userName }"></td>
					</tr>
					<tr>
						<td class="color-main text-left">時間</td>
						<td>${up.date}<input class="form-control" type="hidden"
							name="date" value="${up.date }"></td>
					</tr>
					<tr>
						<td class="color-main text-left">性別</td>
						<td>${up.icon}<input class="form-control" type="hidden"
							name="icon" value="${up.icon }"></td>
					</tr>
				</table>
				<input class="btn" type="submit" value="変更する" /> <input class="btn"
					type="submit" name="back" value="戻る" />
			</form>
		</div>
	</div>
</body>
</html>