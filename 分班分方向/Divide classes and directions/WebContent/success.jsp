<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>成功后的跳转</title>
</head>
<body>
<center>
<s:if test="#session.num<3">
<h1>${sessionScope.info }</h1>
目前人数为<font size="+6">${sessionScope.num }</font>人，不能正常开班！
</s:if>
<s:else>
<h1>${sessionScope.info }</h1>
目前人数为<font size="+6">${sessionScope.num }</font>人，可以正常开班，注意查看个人信息！
</s:else>
</center>
</body>
</html>