<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<style type="text/css">

#container{
width:300px;
margin: 300px auto;
}
</style>
<script type="text/javascript">  
    function refresh() {  
        //IE存在缓存,需要new Date()实现更换路径的作用  
        document.getElementById("image").src="createImageAction?Math.random()"+new Date();  
    }  
</script> 

<title>学生登录页面</title>
</head>
<body background="2.jpg">
<div id="container">
	<s:fielderror></s:fielderror>
	<s:actionerror/>
	<table>
		<s:form action="stuLoginAction" method="post">
		<tr><s:textfield name="s_id" label="学号"/></tr>
		<tr><s:password name="s_pass" label="密码"/></tr>
		<tr><td>验证图&nbsp;&nbsp;<img id="image" onclick="refresh()" src="createImageAction" title="看不清，换一张"></td></tr>
		<tr><s:textfield name="checkCode" label="验证码"/></tr>
		<s:submit value="登录"></s:submit>
</s:form>
</table>
如果您还未注册，请先注册<a href="regist.jsp">注册点我</a>
</div>
</body>
</html>