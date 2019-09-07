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
<center>
<s:form action="HInsertStudent" method="post">
 <s:textfield name="sid" label="学号" ></s:textfield>
<s:textfield name="name" label="姓名" ></s:textfield>
<s:textfield name="classes" label="班级" ></s:textfield>
<s:textfield name="password" label="密码" ></s:textfield>
 <s:submit value="确定"></s:submit>
</s:form>
</center>
</body>
</html>