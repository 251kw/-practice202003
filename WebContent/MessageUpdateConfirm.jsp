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
				コメント変更確認画面&nbsp;<span class="icon-speaker"></span>
			</h1>
		</div>
	</div>
	<div class="padding-y-5 text-center">
		<div style="width: 40%" class="container padding-y-5 text-left">
		<form action="./MessageUpdateConfirm" method="post">
		<table style="width: 600px" class="table">
					<tr>
						<td class="color-main text-left">コメント</td>
						<td><%=writing %><input class="form-control" type="hidden"
							name="writing" value=<%=writing %>><input class="form-control" type="hidden"
							name="number" value=<%=number %>></td>
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
						<td><%=icon %><input class="form-control" type="hidden"
							name="icon" value=<%=icon %>></td>
					</tr>
					<c:if
						test="${requestScope.alert != null }">
						<tr>
							<%-- リクエストスコープの alert の値を出力 --%>
							<td colspan="2" class="color-error text-left"><c:out
									value="${requestScope.alert}" /></td>
						</tr>
					</c:if>
					</table>
					<input class="btn"
							type="submit" value="変更する" />
							<input class="btn"
							type="submit" name="back" value="戻る" />
							</form>
		</div>
		</div>>
</body>
</html>