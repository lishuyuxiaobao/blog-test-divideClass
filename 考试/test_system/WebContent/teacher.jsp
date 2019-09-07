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
<s:fielderror/>
欢迎：${sessionScope.user.t_name}老师<br>
您的id为：${sessionScope.user.t_id}<br>
您的班级号为：${sessionScope.user.t_class}
<a href="javascript:location.href=encodeURI('update_tea.jsp?t_id=${sessionScope.user.t_id}&t_name=${sessionScope.user.t_name}&t_pass=${sessionScope.user.t_pass}&t_class=${sessionScope.user.t_class}')">修改信息</a>
<br>
----
<hr>
	<a href="findAllStuAction?t_class=${sessionScope.user.t_class}" target="kk"><input type="button" value="查询您班级下所有学生"></a>&nbsp;
	<a href="regist1.jsp" target="kk"><input type="button" value="新增老师"></a>&nbsp;
	<a href="" target="kk"><input type="button" value="新增题目"></a>&nbsp;
	<a href="" target="kk"><input type="button" value="查看题库信息"></a>
	<iframe name="kk" scrolling="auto" width="100%"></iframe>
</body>
</html>