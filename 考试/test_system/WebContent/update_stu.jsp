<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<style type="text/css">

#container{
width:300px;
margin: 300px auto;
}
</style>
<title>Insert title here</title>
</head>
<body>
<!-- 接收加转码  放在request域    解决传参中文乱码问题 -->
<%	
	String id = request.getParameter("s_id");
	String result1 = java.net.URLDecoder.decode(id,"UTF-8"); request.setAttribute("res1", result1);
	String store = request.getParameter("s_name");
	String result2 = java.net.URLDecoder.decode(store,"UTF-8"); request.setAttribute("res2", result2);
	String content = request.getParameter("s_pass");
	String result3 = java.net.URLDecoder.decode(content,"UTF-8"); request.setAttribute("res3", result3);
	String req = request.getParameter("s_class");
	String result4 = java.net.URLDecoder.decode(req,"UTF-8"); request.setAttribute("res4", result4);
%>
<div id="container">
<s:form action="updateStuAction" method="post">
		<s:hidden name="s_id" value="%{#request.res1}"></s:hidden>
		<s:textfield name="s_name" label="姓名" value="%{#request.res2}"/>
		<s:textfield name="s_pass" label="密码" value="%{#request.res3}"/>
		<s:textfield name="s_class" label="所在班级" value="%{#request.res4}"/>
		<s:submit value="修改"></s:submit>
	</s:form>
</div>
</body>
</html>