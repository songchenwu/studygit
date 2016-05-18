<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML>
<html>
<head>
<title>发布电影信息</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<meta charset="utf-8">
<link rel="stylesheet" type="text/css" href="/Cinema/css/form.css">
<script type='text/javascript' src="/Cinema/js/jquery-1.11.0.min.js"></script>
<script type="text/javascript" src="/Cinema/js/ajaxType.js"></script>

<script type="text/javascript">
	function validate()
	{
		if ($('filmname').value == null || $('filmname').value == "")
		{
			$('fnmessage').style.display = "block";
			$('fnmessage').innerHTML = "<font color='red'>电影名称不能为空</font>";
			return false;
		}
		else
		{
			$('fnmessage').style.display = "none";
		}
		if ($('typeid').value == null || $('typeid').value == "")
		{
			$('timessage').style.display = "block";
			$('timessage').innerHTML = "<font color='red'>类型不能为空</font>";
			return false;
		}
		else
		{
			$('timessage').style.display = "none";
		}
		if ($('ticketprice').value == null || $('ticketprice').value == "")
		{
			$('tpmessage').style.display = "block";
			$('tpmessage').innerHTML = "<font color='red'>价格不能为空</font>";
			return false;
		}
		else
		{
			$('tpmessage').style.display = "none";
		}
		if (isNaN($('ticketprice').value))
		{
			$('tpmessage').style.display = "block";
			$('tpmessage').innerHTML = "<font color='red'>价格必须是数字</font>";
			return false;
		}
		else
		{
			if (parseFloat($('ticketprice').value) < 50)
			{
				$('tpmessage').style.display = "block";
				$('tpmessage').innerHTML = "<font color='red'>价格必须大于50</font>";
				return false;
			}
		}
		return true;
	}
</script>
</head>

<body>
	<form action="Film_add" method="post" onsubmit="return validate()">
		<table>
			<tr>
				<td colspan="3"><div><s:property value="message"/></div></td>
			</tr>
			<tr>
				<td>电影名称：</td>
				<td><input name="filmname" type="text" /></td>
				<td><div id="fnmessage" style="display:none"></div></td>
			</tr>
			<tr>
				<td>电影类型：</td>
				<td><select id="typeId" name="typeid">
				</select></td>
				<td><div id="timessage" style="display:none"></div></td>
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
				<td><input name="ticketprice" type="text" /></td>
				<td><div id="tpmessage" style="display:none"></div></td>
			</tr>
			<tr>
				<td colspan="2" style="text-align:center;"><input name="submit" value="发布电影" type="submit" class="btnTxt"/>
				&nbsp;&nbsp;&nbsp;<input value="返    回 " type="button" class="btnTxt" onclick="javascript:location.href='/Cinema/index.jsp';" /></td>
			</tr>
		</table>
	</form>
</body>
</html>