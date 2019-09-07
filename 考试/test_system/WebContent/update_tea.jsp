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
<%	
	String id = request.getParameter("t_id");
	String result1 = java.net.URLDecoder.decode(id,"UTF-8"); request.setAttribute("res1", result1);
	String store = request.getParameter("t_name");
	String result2 = java.net.URLDecoder.decode(store,"UTF-8"); request.setAttribute("res2", result2);
	String content = request.getParameter("t_pass");
	String result3 = java.net.URLDecoder.decode(content,"UTF-8"); request.setAttribute("res3", result3);
	String content4 = request.getParameter("t_class");
	String result4 = java.net.URLDecoder.decode(content4,"UTF-8"); request.setAttribute("res4", result4);
	
%>

<s:fielderror></s:fielderror>
<s:form action="updateTeaAction" method="post">
		<s:hidden name="t_id" value="%{#request.res1}"></s:hidden>
		<s:textfield name="t_name" label="姓名" value="%{#request.res2}"/>
		<s:textfield name="t_pass" label="密码" value="%{#request.res3}"/>
		<s:textfield name="t_class" label="班级" value="%{#request.res4}"/>
		<s:submit value="修改"></s:submit>
	</s:form>
</body>
</html>