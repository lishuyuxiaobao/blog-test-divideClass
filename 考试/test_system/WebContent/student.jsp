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
<script language="javascript"> 
	function test(){ 
	alert("请注意！开始考试自动倒计时，试卷类型随机，结束试卷自动提交!"); 
	window.location.href="test.jsp"
	} 
</script>
	<s:fielderror></s:fielderror>
	欢迎 ${sessionScope.user.s_name}登录<br>
	<a href="javascript:location.href=encodeURI('update_stu.jsp?s_id=${sessionScope.user.s_id}&s_name=${sessionScope.user.s_name}&s_pass=${sessionScope.user.s_pass}&s_class=${sessionScope.user.s_class}')">修改信息</a>
<br>
<input type="button" onclick="test()" value="开始考试"/>
</body>
</html>
