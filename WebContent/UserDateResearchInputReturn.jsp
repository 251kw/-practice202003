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
<script src="js/jquery-3.3.1.min.js"></script>
</head>
<body>
	<%
		String icon = request.getParameter("icon");
		String loginId = request.getParameter("loginId");
		String usere = request.getParameter("usere");
		String userName = request.getParameter("userName");
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
			<c:set var="icon" value="<%=icon%>" />
			<c:set var="userName" value="<%=userName%>" />
			<c:set var="loginId" value="<%=loginId%>" />
			<form action="./UserDatesearchInput" method="post">
				<table style="width: 400px" class="table">
					<tr>
						<%-- ログインID 入力欄の名前は loginId --%>
						<td class="color-main text-left">ログインID</td>
						<td class="text-left"><c:if test="${loginId == ''}">
								<input class="form-control" type="text" name="loginId" value="">
							</c:if> <c:if test="${loginId != ''}">
								<input class="form-control" type="text" name="loginId"
									value=<%=loginId%>>
							</c:if> <input type="hidden" name="usere" value=<%=usere%>></td>
					</tr>
					<tr>
						<td class="color-main text-left">ユーザー名</td>
						<c:if test="${userName == ''}">
							<td class="text-left"><input class="form-control"
								type="text" name="userName" value=""></td>
						</c:if>
						<c:if test="${userName != ''}">
							<td class="text-left"><input class="form-control"
								type="text" name="userName" value=<%=userName%>></td>
						</c:if>
					</tr>
					<tr>
						<td class="color-main text-left">アイコン</td>

						<c:if test="${icon == 'male'}">
							<td><input type="radio" name="icon" id="male" value="male"
								checked><span>male</span></td>
						</c:if>
						<c:if test="${icon != 'male'}">
							<td><input type="radio" name="icon" id="male" value="male"><span>male</span></td>
						</c:if>
						<c:if test="${icon == 'female'}">
							<td><input type="radio" name="icon" id="female"
								value="female" checked><span>female</span></td>
						</c:if>
						<c:if test="${icon != 'female'}">
							<td><input type="radio" name="icon" id="female"
								value="female"><span>female</span></td>
						</c:if>
					</tr>
					<tr>
						<td colspan="2" class="text-right"><input class="btn"
							type="submit" value="検索" /></td>
						<td class="text-left"><a href="top.jsp" class="btn">戻る</a></td>
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