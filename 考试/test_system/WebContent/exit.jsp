<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>退出</title>
</head>
<body>
<center>
<h1>你可以先行离开了！谢谢合作</h1>
<%
response.setHeader("refresh", "3;url=index.jsp");
%>
</center>
</body>
</html>