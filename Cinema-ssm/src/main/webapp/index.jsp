<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=utf-8"%>
<!DOCTYPE HTML>
<html>
<head>
<title>影院信息查询</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<meta charset="utf-8">
<link rel="stylesheet" type="text/css" href="/Cinema/css/form.css">
<script type='text/javascript' src="/Cinema/js/jquery-1.11.0.min.js"></script>
<script type="text/javascript" src="/Cinema/js/ajaxType.js"></script>
</head>
<body>
	<form action="search.action" method="post">
		<table>
			<tr>
				<td>电影名称：</td>
				<td><input name="filmname" type="text" /></td>
			</tr>
			<tr>
				<td>电影类型：</td>
				<td><select id="typeId" name="typeid"><option value="">全部</option></select></td>
			</tr>
			<tr>
				<td>主&nbsp;&nbsp;&nbsp;&nbsp;演：</td>
				<td><input name="actor" type="text" /></td>
			</tr>
			<tr>
				<td>导&nbsp;&nbsp;&nbsp;&nbsp;演：</td>
				<td><input name="director" type="text" /></td>
			</tr>
			<tr>
				<td>价&nbsp;&nbsp;&nbsp;&nbsp;格：</td>
				<td><input name="minprice" type="text" class="priceTxt" />至<input name="maxprice" type="text" class="priceTxt" /></td>
			</tr>
			<tr>
				<td colspan="2" style="text-align:center; font-size:20pt;">
				<input value="查询电影 " type="submit" class="btnTxt" />&nbsp;&nbsp;&nbsp;
				<input value="发布电影 " type="button" class="btnTxt" onclick="javascript:location.href='/Cinema/page/add.jsp';" /></td>
			</tr>
		</table>
	</form>
</body>
</html>
