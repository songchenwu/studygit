<%@ page contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html >
<html>
<head>
<base href="/Fav_ssm/">
<meta charset="utf-8">
<title>搜藏</title>
<link rel="stylesheet" type="text/css" href="css/styles.css">
<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>
<script type="text/javascript" src="js/list.js"></script>
</head>
<body>
	<form name="favForm" method="post"
		action="">
		<input type="hidden" name="op" value="toList" />
		<div class="banner">搜藏</div>
		<table>
			<tr>
				<td style="text-align: right;" valign="top">
					<!-- 左边Tag列表 -->
					<div class="left_labels">
						<table class="labels_table">
							<tr>
								<td><a href="javascript:void(0)" onclick="add();" style="font-weight: bold;">添加书签</a></td>
							</tr>
							<tr>
								<td class="selected_label"><a
									href="fav.do?op=toList&type=-1">全部</a></td>
							</tr>
							<tr>
								<td><a href="fav.do?op=toList&type=0">未分类</a></td>
							</tr>
							<!-- 显示所有书签 -->
							<c:forEach items="${sessionScope.tags}" var="tag">
							<tr>
								<td><a href="javascript:void(0)" onClick="listFavoritesByTag('${tag.tname}')">${tag.tname} (${tag.tcount})</a></td>
							</tr>
							</c:forEach>
							<tr>
								<td><a style="font-weight: bold;" href="fav.do?op=toCloud">云图</a>
								</td>
							</tr>
						</table>
					</div>
				</td>
				<td>
					<!-- 右边fav内容 -->
					<div class="content_links" id="clinks">
						<h1></h1>
						<c:forEach items="${sessionScope.favotites}" var="favorite">
						<div style="padding: 6px 10px;">
							<div>
								<a href="${favorite.furl}"
									style="color: blue; font-size: 18px;" target="_blank">${favorite.flabel}</a>
							</div>
							<div style="color: black; font-size: 16px;">${favorite.fdesc }</div>
							<div style="color: green; font-size: 14px;">${favorite.furl }</div>
						</div>
						</c:forEach>
					</div>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>