<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content=Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./css/skyblue.css">
<link rel="stylesheet" href="./css/pe-icon-7-stroke.css">
<link rel="stylesheet" href="./css/helper.css">
</head>
<body>
<%
	String loginId = request.getParameter("loginId");
	String password = request.getParameter("password");
	String userName = request.getParameter("userName");
	String icon = request.getParameter("icon");
	String profile = request.getParameter("profile");
%>
<div class="bg-success padding-y-5">
		<div class="container padding-y-5 text-center">
			<h1>
				新規登録&nbsp;
			</h1>
		</div>
	</div>
	<div class="padding-y-5 text-center">
		<div style="width: 40%" class="container padding-y-10 text-left">
			<strong class="color-main">入力してください</strong>
		</div>
		</div>
	<div class="padding-y-5 text-center">
		<div style="width: 40%" class="container padding-y-5 text-center">

			<%-- action 属性にサーブレットを指定 --%>
			<form action="UserAddInput.jsp" >
				<table style="width: 600px" class="table">
					<tr>
						<td class="color-main text-left">ログインID(半角英数文字、文字数は8文字以下)</td>
						<td class="text-left"><input class="form-control" type="text"
							name="loginId" value=""  size="20" /></td>
					</tr>

					<tr>

						<%-- パスワード入力欄の名前は password --%>
						<td class="color-main text-left">パスワード</td>
						<td class="text-left"><input class="form-control"
							type="password" name="password" value="" size="20" /></td>
					</tr>
					<tr>
						<td class="color-main text-left">名前</td>
						<td class="text-left"><input class="form-control" type="text"
							name="userName" value="" size="20" /></td>
					</tr>
					<tr>
						<td class="color-main text-left">性格</td>
						<td>
						<lavel for="male"><input type="radio" name="icon" id="male" value="male" cheked>male</lavel>
						<lavel for="female"><input type="radio" name="icon" id="female" value="female">female</lavel>
						</td>
						</td>
					</tr>
					<tr>
						<td class="color-main text-left">コメント</td>
						<td class="text-left"><input class="form-control"
							type="text" name="profile" value=""  size="20" /></td>
					</tr>
					<tr>
						<td colspan="2" class="text-right"><input class="btn"
							type="submit" value="次へ" /></td>
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
					</form>
					</div>
					</div>




</body>
</html>