<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<center>
<p>请选择要导入的excel文件： </p>
<s:form action="InsertStudent" enctype="multipart/form-data" method="post">
 <s:file name="upload" label="上传文件" ></s:file>
<s:textfield name="class2" label="班级"></s:textfield>
<结束行数：0表示到Excel表的最后一行>
<s:textfield name="min" label="开始行数"></s:textfield>
<s:textfield name="max" label="结束行数"></s:textfield>
 <s:submit value="确定"></s:submit>
</s:form>
</center>
</body>
</html>