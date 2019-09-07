<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
		<table border="1" align="center">
		<tr bgcolor="blue">
			<th>学号</th>
			<th>姓名</th>
			<th>班级</th>
			<th>操作</th>
		</tr>
		<s:iterator value="ls" var="l" status="st">
			<tr>
				<td>${l.s_id}</td>
				<td>${l.s_name}</td>
				<td>${l.s_class}</td>
				<td><a href="FindgradeAction?s_id=${l.s_id}&t_name=<%=session.getValue("t_name")%>&t_class=<%=session.getValue("t_class")%>"><input type="button" value="开始阅卷"></a></td>
			
			</tr>
		</s:iterator>
	</table>
</body>
</html>