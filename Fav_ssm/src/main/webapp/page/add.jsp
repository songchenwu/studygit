<%@ page contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html >
<html>
<head>
<base href="/Fav_ssm/">
<meta charset="utf-8">
<title>添加书签</title>
<link rel="stylesheet" type="text/css" href="css/styles.css">
</head>
<body>
	<form action="favorite_add" method="post" style="width:440px; margin:0px auto;">
		<div class="banner">搜藏</div>
		<table class="input_table">
			<tr>
				<td>名称:</td>
				<td><input name="label" size="40" /><br />
			</tr>
			<tr>
				<td>链接:</td>
				<td><input name="url" size="40" /><br />
			</tr>
			<tr>
				<td>Tag:</td>
				<td><input name="tags" size="40" /><br /> <span
					style="font-size: 12px; color: green;">可以多个，用“,”隔开</span></td>
			</tr>
			<tr>
				<td>描述:</td>
				<td><textarea name="desc" rows="4" cols="39"></textarea></td>
			</tr>
			<tr>
				<td colspan="2" align="right">
					<button onclick="window.close();">&nbsp;&nbsp;取
						消&nbsp;&nbsp;</button>&nbsp;&nbsp; <button>&nbsp;&nbsp;提
					交&nbsp;&nbsp;</button>&nbsp;
				</td>
			</tr>
		</table>
	</form>
</body>
</html>
