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
<br><br><br><br><br><br>
<center>
<h2>请选择将要分班的方向</h2>
<form action="getnum" method="post">
<select name="direction">
<s:iterator value="directions" var="d">
<option value="${d.direction}">${d.direction}
</option>
</s:iterator>
</select>
<input type="submit" value="提交">
<input type="reset"  value="取消">
</form>
</center>
</body>
</html>