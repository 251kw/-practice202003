<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content=Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h3>新規登録</h3>
<div class="padding-y-5 text-center">
		<div style="width: 40%" class="container padding-y-5 text-left">
		</div>
	</div>
	<div>
		<div>
			<%-- action 属性にサーブレットを指定 --%>
			<form action="./UserAddServlet" method="post">
				<table >
					<tr>
						<%-- ログインID 入力欄の名前は loginId --%>
						<td class="color-main text-left">ログインID</td>
						<td class="text-left"><input class="form-control" type="text"
							name="loginId" value="" size="20" /></td>
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
						<th>性別</th>
						<td>
						<lavel for="male"><input type="radio" name="icon" id="male" value="male" checked>male</lavel>
						<lavel for="female"><input type="radio" name="icon" id="female" value="female">female</lavel>
						</td>

						</td>
					</tr>
					<tr>
						<td class="color-main text-left">コメント</td>
						<td class="text-left"><input class="form-control"
							type="text" name="profile" value="" size="20" /></td>
					</tr>
					<tr>
						<td colspan="2" class="text-right"><input class="btn"
							type="submit" value="次へ" /></td>
					</tr>

					</table>

					</form>
					<form action="" >
						<input class="btn" type="submit" value="キャンセル"/>
					</form>
					</div>
					</div>

</body>
</html>