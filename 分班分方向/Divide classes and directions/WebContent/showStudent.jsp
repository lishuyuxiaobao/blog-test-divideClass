<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<table>
<tr>
<td>学号</td>
<td>姓名</td>
<td>班级</td>
<td>密码</td>
</tr>
<s:iterator value="students" var="student" status="st">
<tr>
<td>${student.sid}</td>
<td>${student.name}</td>
<td>${student.classes}</td>
<td>${student.password}</td>
<td><a href="findIdStudent?id=${student.id}">更新</a><a href="DeleteStudent?id=${student.id}">删除</a></td>
</tr>
</s:iterator>
</table>
</center>
</body>
</html>