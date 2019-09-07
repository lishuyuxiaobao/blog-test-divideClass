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
<h1>目前本校已有技术方向</h1>
<table border="1">
<tr>
<s:iterator value="lDirections" var="ld"> 
  <td><s:property value="#ld.direction"/></td>
</s:iterator>
</tr>
</table>
<br><br>
<form action="AddDirectionAction" method="post">
   方向名称：<input type="text" name="direction"><br>
           <input type="submit" value="增加">
</form>

</center>
</body>
</html>