<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>增派方向</title>
</head>
<body>
<br><br><br><br><br><br><br>
<center>
<h1>目前本校已有技术方向的公司</h1>
<table border="1">
<s:iterator value="cList2" var="cl"> 
  <tr><td><s:property value="#cl.direction"/></td><td><s:property value="#cl.company"/></td></tr>
</s:iterator>
</table>
<br><br>
<form action="AddCompanyAction" method="post">
   方向名称：<input type="text" name="direction"><br>
   公司企业：<input type="text" name="company"><br>
           <input type="submit" value="增加">
</form>

</center>
</body>
</html>