<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<div class="bg-success padding-y-5">
		<div class="container padding-y-5 text-center">
			<h1>
				新規登録&nbsp;
			</h1>
		</div>
	</div>

	<%
		String loginId = request.getParameter("loginId");
		String password = request.getParameter("password");
		String userName = request.getParameter("userName");
		String icon = request.getParameter("icon");
		String profile = request.getParameter("profile");
		RequestDispatcher dispatcher = null;
		int i=9;
				if(loginId.equals("")||password.equals("")) {
			String message = "ログインIDとパスワードは必須入力です";

			// エラーメッセージをリクエストオブジェクトに保存
			request.setAttribute("alert", message);
			dispatcher = request.getRequestDispatcher("NewFile2.jsp");
			dispatcher.forward(request, response);
		}else if(loginId.length()>i) {
			String message = "ログインIDは8文字以下で入力してください";

			// エラーメッセージをリクエストオブジェクトに保存
			request.setAttribute("alert", message);

			// index.jsp に処理を転送
			dispatcher = request.getRequestDispatcher("NewFile2.jsp");
			dispatcher.forward(request, response);
		}
		else if(!loginId.matches("^[-@+*;:#$%&\\w]+$")) {
			String message = "半角英数記号で入力してください";

			// エラーメッセージをリクエストオブジェクトに保存
			request.setAttribute("alert", message);

			// index.jsp に処理を転送
			dispatcher = request.getRequestDispatcher("NewFile2.jsp");
			dispatcher.forward(request, response);

		}
	%>
	<div class="padding-y-5 text-center">
		<div style="width: 40%" class="container padding-y-5 text-center" >
<div class="color-main" >
<font size=5>
<table style="width: 600px" class="table">
<tr>
<td>
<%
out.println("ログインID:" + loginId + "<br>");
%>
</td>
</tr>
<tr>
<td>
<%
out.println("パスワード:" + password + "<br>");
%>
</td>
</tr>
<tr>
<td>
<%
out.println("ユーザー名:" + userName + "<br>");
%>
</td>
</tr>
<tr>
<td>
<%
out.println("アイコン:" + icon + "<br>");
%>
</td>
</tr>
<tr>
<td>
<%
out.println("コメント:" + profile + "<br>");
%>
</td>
</tr>
<tr>


</table>
</font>
</div>
<form action="./UserAddServlet" method="post">
		<table>
			<tr>
				<%-- ログインID 入力欄の名前は loginId --%>
				<td class="color-main text-left"></td>
				<td class="text-left"><input class="form-control" type="hidden"
					name="loginId" value=<%=loginId %> ></td>
			</tr>
			<tr>
				<%-- パスワード入力欄の名前は password --%>
				<td class="color-main text-left"></td>
				<td class="text-left"><input class="form-control"
					type="hidden" name="password" value=<%=password %> ></td>
			</tr>
			<tr>
				<td class="color-main text-left"></td>
				<td class="text-left"><input class="form-control" type="hidden"
					name="userName" value=<%=userName %> /></td>
			</tr>
			<tr>
				<td>
					<input type="hidden" name="icon" id="male" value=<%=icon %>　checked>

					<input type="hidden" name="icon" id="female" value=<%=icon %>  checked>
				</td>
				</td>
			</tr>
			<tr>
				<td class="color-main text-left"></td>
				<td class="text-left"><input class="form-control" type="hidden"
					name="profile" value=<%=profile %>  /></td>
			</tr>
			<tr>
				<td colspan="2" class="text-center"><input class="btn"
					type="submit" value="新規登録する" /></td>
			</tr>
		</table>

	</form>
<form action="NewFile2.jsp">
		<table>
			<tr>
				<%-- ログインID 入力欄の名前は loginId --%>
				<td class="color-main text-left"></td>
				<td class="text-left"><input class="form-control" type="hidden"
					name="loginId" value="<%=loginId %>"  ></td>
			</tr>
			<tr>
				<%-- パスワード入力欄の名前は password --%>
				<td class="color-main text-left"></td>
				<td class="text-left"><input class="form-control"
					type="hidden" name="password" value=<%=password %> ></td>
			</tr>
			<tr>
				<td class="color-main text-left"></td>
				<td class="text-left"><input class="form-control" type="hidden"
					name="userName" value="<%=userName %>"  size="20" /></td>
			</tr>
			<tr>
				<td><lavel for="male">
					<input type="hidden" name="icon" id="male"　value=<%=icon %>  checked></lavel>
					<lavel for="female">
					<input type="hidden" name="icon" id="female" value=<%=icon %> ></lavel>
				</td>
				</td>
			</tr>
			<tr>
				<td class="color-main text-left"></td>
				<td class="text-left"><input class="form-control" type="hidden"
					name="profile" value=<%=profile %> size="20" /></td>
			</tr>
			<tr>
				<td colspan="2" class="text-center"><input class="btn"
					type="submit" value="戻る" /></td>
			</tr>
		</table>
		</form>

</div>
</div>







</body>
</html>