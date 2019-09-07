<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>教师登录</title>
<style type="text/css">

#container{
width:300px;
margin: 300px auto;
}
</style>
</head>
<body background="2.jpg">
<div id="container">
<s:fielderror/>
<s:fielderror></s:fielderror>
	<table>
		<s:form action="teaLoginAction" method="post">
		<tr><s:textfield name="t_id" label="教职工号"/></tr>
		<tr><s:password name="t_pass" label="密码"/></tr>
		<s:submit value="登录"></s:submit>
	<s:reset value="重新输入"/>
</s:form>
</table>
</div>
</body>
</html>