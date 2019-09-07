<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>学生</title>
</head>
<body>
<center>
<s:if test="dList.size()==0"><h1>该企业未参与今年的授课</h1></s:if> 
 <s:else> 
   <h1>管理的信息</h1>
<table border="1">
<tr>
  <td>学号</td>
  <td>方向</td>
  <td>班级</td>
  <td>公司</td>
</tr>
<s:iterator value="dList" var="dl">
 <tr>
 <td><s:property value="#dl.sid"/></td> 
 <td><s:property value="#dl.direction"/></td> 
 <td><s:property value="#dl.classname"/></td> 
 <td><s:property value="#dl.company"/></td> 
 </tr>  
</s:iterator>

</table>
</s:else> 
</center>
</body>
</html>