<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="UpdateStudent" method="post">
<s:iterator value="s" var="student" status="st">
学号：<input type="text"name="sid"  value="${student.sid}"><br>
姓名：<input type="text" name="name"  value="${student.name}"><br>
班级：<input type="text" name="classes"  value="${student.classes}"><br>
<input type="hidden" name="id" value="${student.id}">
密码：<input type="text" name="password"  value="${student.password}"><br>
 <input type="submit" value="确定">
</s:iterator>
<form>
</body>
</html>