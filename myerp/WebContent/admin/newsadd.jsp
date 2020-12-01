<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" type="text/css" href="../css/comm.css"/>
		
	</head>
	<body>
		<form action="../newsadd" method="post">
			<p class="path">爱车居进销存管理系统/通知中心/发布通知</p>
			<table border="0" cellspacing="0" cellpadding="0" class="tb">
				<tr><td class="lable">标题</td><td><input type="text" name="title" id="title"/></td></tr>
				<tr><td class="lable">类别</td><td><input type="text" name="typeid"/></td></tr>
				<tr><td class="lable">内容</td><td><textarea name="contents"></textarea></td></tr>
				<tr><td class="lable">&nbsp;</td><td><input type="submit" name="btnsave" value="发布" id="btnsave"/></td></tr>
			</table>
		</form>
		
	</body>
</html>