<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<title>增加教师</title>
<style type="text/css">

#container{
width:300px;
margin: 300px auto;
}
</style>
</head>
<body background="3.jpg">
<div id="container">
	<s:form action="addTeaAction" method="post">
		<s:textfield name="t_id" label="教职工号"/>
		<s:textfield name="t_name" label="姓名"/>
		<s:password name="t_pass" label="密码"/>
		<s:textfield name="t_class" label="负责班级"/>
		<s:submit value="增加"></s:submit>
		<s:reset value="重新输入"/>
	</s:form>
	</div>
</body>
</html>