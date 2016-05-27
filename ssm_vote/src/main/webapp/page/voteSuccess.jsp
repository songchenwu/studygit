<%@ page contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" isELIgnored="false"%>
<!DOCTYPE html >
<html>
<head>
<meta charset="utf-8" />
<title></title>
<link type="text/css" rel="stylesheet" href="./css/style.css" />
</head>
<body>
<div id="header" class="wrap">
	<img src="./images/logo.gif" />
</div>
<div id="navbar" class="wrap">
	<div class="search">
		<form method="get" action="index.html">
			<input type="text" name="keywords" class="input-text" /><input type="submit" class="input-button" value="" />
		</form>
	</div>
</div>
<div id="message" class="box">
	<h2>提示信息</h2>
	<div class="content">
		<p>恭喜：${sessionscope.loginUser.vuUsername}投票成功！<a href="vote_list.action">进入投票首页&gt;&gt;</a></p><!-- Subject!list.action -->
	</div>
</div>
<div id="footer" class="wrap">
	源辰信息 &copy; 版权所有
</div>
</body>
</html>
