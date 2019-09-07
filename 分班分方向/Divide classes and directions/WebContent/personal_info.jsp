<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>个人信息</title>
</head>
<body>
<center>
  <h1>个人信息展示</h1>
<table>
   <s:iterator value="lStudents" var="ls">
       学号：<s:property value="#ls.sid"/><br>
      班级： <s:property value="#ls.classes"/><br>
      姓名： <s:property value="#ls.name"/><br>
       <s:iterator value="#ls.listd" var="ld">
         已报方向：  <s:property value="#ld.direction"/><br>
        已经分配到 ：  <s:property value="#ld.classname"/><br>
        所授课的公司为：   <s:property value="#ld.company"/><br>
       </s:iterator>
   
   </s:iterator>
</table>
</center>
</body>
</html>