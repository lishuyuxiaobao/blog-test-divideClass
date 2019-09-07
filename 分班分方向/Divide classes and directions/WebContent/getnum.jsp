<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>分班管理</title>
</head>
<body>

<br><br><br><br><br>
<center>
<h1>该方向人数为“<font color="yellow"><s:property value="dList.size()"/></font>”人</h1>

<br><br>

<h2>请合理选择多少人为一个班</h2>
<h3>如:(0,1,2,5) 第一个人为1班，第二个人为2班，第三四五个人为3班</h3>
<form action="direction2?direction=<%=session.getValue("direction") %>" method="post">
分班：<input type="text"  value="" name="num">
<input type="submit" value="分班">
</form>
</center>
</body>
</html>