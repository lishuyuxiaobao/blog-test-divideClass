<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>查找学生</title>
</head>
<body>
<center>
   <h1>请选择要看的公司名单</h1>

<form action="ListStudentAction" method="post" target="stu">

<select name="companys">
<s:iterator value="cList2" var="c">
 <option value="<s:property value="#c.company"/>"><s:property value="#c.company"/>  </option>
</s:iterator>
</select><br>
<input type="submit" value="确定">
</form>
<iframe name="stu" width="600px" height="300px"></iframe>
</center>
</body>
</html>