<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>Shouter - みんなの心の叫び -</title>
<link rel="stylesheet" href="./css/skyblue.css">
<link rel="stylesheet" href="./css/pe-icon-7-stroke.css">
<link rel="stylesheet" href="./css/helper.css">
<script src="jquery-3.5.1.min.js"></script>
</head>
<body>
<%
String full=request.getParameter("full");
%>
	<div class="bg-success padding-y-5">
		<div class="container padding-y-5 text-center">
			<h1>
				Shouter&nbsp;<span class="icon-speaker"></span>
			</h1>
		</div>
	</div>
	<div class="padding-y-5 text-center">
		<div style="width: 40%" class="container padding-y-5 text-left">
			<strong class="color-main">ログインユーザー情報</strong>
		</div>
	</div>
	<%-- セッションスコープにある UserDTO 型のオブジェクトを参照 --%>
	<div class="padding-y-5">
		<div style="width: 40%" class="container padding-y-5">
			<form action="./logout" method="post">
				<table class="table table-bordered">
					<tr>
						<td rowspan="2" class="text-center"><span
							class="${user.icon} pe-3x pe-va"></span>${user.icon}</td>
						<td width="256">${user.userName}</td>
						<td><input class="btn btn-light" type="submit" value="ログアウト" /></td>
					</tr>
					<tr>
						<td colspan="2">${user.profile}</td>
					</tr>
				</table>
			</form>
			<form action="UserDateResearchInput.jsp">
			<table>
				<tr><td><input class="form-control" type="hidden"
					name="user" value=${user.loginId } /></td></tr>

				<tr>
					<td colspan="2" class="text-right"><input class="btn"
						type="submit" value="変更する" /></td>
				</tr>
				</table>
			</form>
		</div>
	</div>
	<div class="padding-y-5 text-center">
		<div style="width: 40%" class="container padding-y-5 text-left">
			<div class="box"><strong class="color-main">今の気持ちを叫ぼう</strong></div>
		</div>
		<p id="fadeout" class="color-main">リストを非表示にする</p>
		<p id="fadein" class="color-main">メッセージを表示する</p>
	</div>
	<div class="padding-y-5 text-center">
		<div style="width: 40%" class="container padding-y-5 text-center">
			<%-- action 属性にサーブレットを指定 --%>
			<form action="./bbs" method="post">
			<div class="box">
				<table class="table">
					<tr>
						<%-- 今の気持ち入力欄の名前は shout --%>
						<td><input class="form-control" type="text" placeholder="hello" name="shout"
							value="" size="60" /></td>
						<td><input class="btn" type="submit" value="叫ぶ" /></td>
					</tr>
				</table>
				</div>
			</form>
		</div>
	</div>
	<div class="padding-y-5 text-center">

		<div style="width: 40%" class="container padding-y-5 text-left">
			<div class="box"><strong class="color-main">みんなの叫び</strong></div>
		</div>

	</div>
	<%-- セッションスコープにある ArrayList 型のオブジェクトを参照 --%>
	<jsp:useBean id="shouts" scope="session"
		type="java.util.ArrayList<dto.ShoutDTO>" />
	<div class="padding-y-5">
		<div style="width: 40%" class="container padding-y-5">
			<%-- リストにある要素の数だけ繰り返し --%>

			<form action="./MessageSearchInput" method="post">
			<div class="box">
					<c:if
						test="${requestScope.alert != null }">
						<tr>
							<%-- リクエストスコープの alert の値を出力 --%>
							<td colspan="2" class="color-error text-left"><c:out
									value="${requestScope.alert}" /></td>
						</tr>
					</c:if>
					</div>
			<c:forEach var="shout" items="${shouts}">
			<div class="box">
				<table class="table table-striped table-bordered">
				<tr>
					<c:if test="${full!=null}">
								<td rowspan="2" class="text-center"><label><input type="checkbox" name="number"
									value=${shout.shout } checked></label></td>
						<td>${shout.userName}</td>
						</c:if>
							<c:if test="${full==null}">
								<td rowspan="2" class="text-center"><label><input type="checkbox" name="number"
									value=${shout.shout } ></label></td>
						<td>${shout.userName}</td>
						</c:if>
						</tr>
					<tr>
						<td>${shout.date}</td>
					</tr>
					<tr>
						<td colspan="2"><textarea rows="5" class="form-control">${shout.writing}</textarea>
						</td>
					</tr>
				</table>
				</div>
			</c:forEach>
			<div class="box">
			<input class="btn" type="submit" name="update" value="編集" />
			<input class="btn" type="submit" name="delete" value="削除" />
			<input class="btn"
			style="float: center;" type="submit" name="full" value="全選択する" />
			<input class="btn"
			style="float: center;" type="submit" name="clear" value="解除" />
			</div>
				</form>

				</div>
		</div>
<script >
$('#fadeout').on('click',function(){
	$('.box').fadeOut(1000);
	$('#fadeout').fadeOut(1000);
})
$('#fadein').on('click',function(){
	$('.box').fadeIn(1000);
	$('#fadeout').fadeIn(1000);
})
</script>

</body>
</html>
