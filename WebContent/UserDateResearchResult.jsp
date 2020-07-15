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

	<%!
	//checkbox checked or "" 処理
	public static String checkBox(String item, String[] select) {

		if (select == null) { //初回
			return "";
		}

		for (String i : select) { //配列に入っていたらチェック
			if (i.equals(item)) {
				return "checked";
			}
		}

		return ""; //入っていなかったので何も書かない
	}%>
	<%
		String delete = request.getParameter("return");
		String deleter = (String) request.getAttribute("deleter");
		String clear = (String) request.getAttribute("clear");
		String[] userloginId = (String[]) request.getAttribute("userloginId");
		//解除ボタンをプッシュされた場合の処理
		if (clear != null) {
			deleter = null;
			userloginId = null;
		}
	%>
	<div class="bg-success padding-y-5">
		<div class="container padding-y-5 text-center">
			<h1>
				ユーザー情報検索結果画面&nbsp;<span class="icon-speaker"></span>
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
				<c:set var="userloginIds" value="${users.loginId }" />
				<c:set var="deleter" value="<%=deleter%>" />
				<%
					// (2) スクリプトレットでpageスコープのpageContextにアクセスし変数を取得.
						String check = (String) pageContext.findAttribute("userloginIds");
				%>
				<tbody>
					<tr>
						<td><c:if test="${deleter == null}">
								<label><input type="checkbox" name="userloginId"
									value=${users.loginId } <%= checkBox(check,userloginId) %>></label>
							</c:if> <c:if test="${deleter != null}">
								<label><input type="checkbox" name="userloginId"
									value=${users.loginId } checked></label>
							</c:if></td>

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
		<input class="btn" style="float: center;" type="submit" name="clear"
			value="解除" /> <input class="btn" style="float: center;"
			type="submit" name="return" value="戻る" />

	</form>
</body>
</html>