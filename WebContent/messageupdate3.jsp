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
String writing = (String)session.getAttribute("writing");
String userName = (String)session.getAttribute("userName");
String icon = (String)session.getAttribute("icon");
String date = (String)session.getAttribute("date");
String number=(String)session.getAttribute("number");
%>
	<div class="bg-success padding-y-5">
		<div class="container padding-y-5 text-center">
			<h1>
				内容確認画面&nbsp;<span class="icon-speaker"></span>
			</h1>
		</div>
	</div>
	<div class="padding-y-5 text-center">
		<div style="width: 40%" class="container padding-y-5 text-left">
		<form action="./messageupdate3" method="post">
		<table style="width: 600px" class="table">
					<tr>
						<td class="color-main text-left">コメント</td>
						<td><%=writing %><input class="form-control" type="hidden"
							name="writing" value=<%=writing %>></td>
					</tr>
					<tr>
						<td class="color-main text-left">ユーザー名</td>
						<td><%=userName %><input class="form-control" type="hidden"
							name="userName" value=<%=userName %>></td>
					</tr>
					<tr>
						<td class="color-main text-left">時間</td>
						<td><%=date %><input class="form-control" type="hidden"
							name="date" value=<%=date %>></td>
					</tr>
					<tr>
						<td class="color-main text-left">性別</td>
						<td><%=icon %></td>
					</tr>
					</table>
					<input class="btn"
							type="submit" value="次へ" />
							</form>
		</div>
		</div>
</body>
</html>