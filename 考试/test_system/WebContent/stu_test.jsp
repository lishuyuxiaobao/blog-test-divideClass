<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>简答题</title>
</head>
<body>
<center>

<s:iterator value="graders" var="gd">
<form action="UpdateGrade2Action?s_id=<s:property value="#gd.s_id"/>&t_name=<%=session.getValue("t_name") %>&t_class=<%=session.getValue("t_class") %>" method="post">
   <h1>题目类型为：<s:property value="#gd.p_type"/></h1>
   <h3>该题目为</h3>
   <s:property value="#gd.pinfo.p_name5"/>
   <h3>该题的正确答案为</h3>
   <s:property value="#gd.pinfo.p_answer5"/>
   <h2>该生作答为</h2>
   <s:property value="#gd.answer5"/><br>
   打分：<input type="text" name="grader2">(满分60分)<br>
   <input type="submit" value="确定">
   </form>
</s:iterator>

</center>
</body>
</html>