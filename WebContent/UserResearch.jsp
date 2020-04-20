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
</head>
<body>
	<div class="bg-success padding-y-5">
		<div class="container padding-y-5 text-center">
			<h1>
				検索&nbsp;<span class="icon-speaker"></span>
			</h1>
		</div>
	</div>
	<form action="./DBResearch" method="post">
		<table style="width: 400px" class="table">
			<tr>
				<%-- ログインID 入力欄の名前は loginId --%>
				<td class="color-main text-left">検索したいログインIDを入力してください</td>
				<td class="text-left"><input class="form-control" type="text"
					name="loginId" value="" size="20" /></td>
			</tr>
			<tr>
			<tr>
				<td colspan="2" class="text-right"><input class="btn"
					type="submit" value="検索" /></td>
			</tr>
		</table>
	</form>
</body>
</html>