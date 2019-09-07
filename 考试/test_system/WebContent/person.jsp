<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>信息</title>
</head>
<body>
<s:if test="lgd.size()==0">你还没考试！</s:if>
<s:else>
		<table border="1" align="center">
		<tr bgcolor="blue">
			<th>试卷类型</th>
			<th>客观成绩</th>
			<th>主观成绩</th>
			<th>总成绩</th>
		</tr>
		<s:iterator value="lgd" var="l" status="st">
			<tr>
				<td>${l.p_type }</td>
				<td>${l.grader1 }</td>
				<td>${l.grader2 }</td>
				<td>${sessionScope.agr }</td>
			</tr>
		</s:iterator>
	</table><br><br>
<table border="1" align="center">

	<s:iterator value="lgd" var="lg">
	
<tr><td>题目一：</td><td><s:property value="#lg.pinfo.p_name1"/></td><td> 我的答案:</td> <td><s:property value="#lg.answer1"/></td> <td>正确答案：</td> <td><s:property value="#lg.pinfo.p_answer1"/></td></tr>
  <tr> <td> 题目二：</td><td><s:property value="#lg.pinfo.p_name2"/></td> <td> 我的答案:</td> <td><s:property value="#lg.answer2"/></td> <td>正确答案：</td> <td><s:property value="#lg.pinfo.p_answer2"/></td></tr>
   <tr> <td>题目三：</td><td><s:property value="#lg.pinfo.p_name3"/></td> <td> 我的答案:</td> <td><s:property value="#lg.answer3"/></td> <td>正确答案：</td> <td><s:property value="#lg.pinfo.p_answer3"/></td></tr>
   <tr> <td>题目四：</td><td><s:property value="#lg.pinfo.p_name4"/></td><td> 我的答案:</td> <td><s:property value="#lg.answer4"/></td> <td>正确答案：</td> <td><s:property value="#lg.pinfo.p_answer4"/></td></tr>
   <tr> <td>题目五：</td><td><s:property value="#lg.pinfo.p_name5"/> </td> <td>我的答案:</td> <td><s:property value="#lg.answer5"/></td> <td>正确答案：</td> <td><s:property value="#lg.pinfo.p_answer5"/> </td></tr> 
	</s:iterator>

</table>
</s:else>
</body>
</html>