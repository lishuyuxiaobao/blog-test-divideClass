<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>显示</title>
</head>
<body>
<center>
<table>
<tr>
   <td>题目1</td>
   <td>正确答案</td>
   <td>错误答案</td>
   <td>题目2</td>
   <td>正确答案</td>
   <td>错误答案</td>
   <td>题目3</td>
   <td>正确答案</td>
   <td>题目4</td>
   <td>正确答案</td>
   <td>题目5</td>
   <td>正确答案</td>
   <td>类型</td>
   <td>操作</td>
</tr>
<s:iterator value="lProblems" var="lp">
   <tr>
   <td><s:property value="#lp.p_name1"/></td>
   <td><s:property value="#lp.p_answer1"/></td>
   <td><s:property value="#lp.p_option1"/></td>
   <td><s:property value="#lp.p_name2"/></td>
   <td><s:property value="#lp.p_answer2"/></td>
   <td><s:property value="#lp.p_option2"/></td>
   <td><s:property value="#lp.p_name3"/></td>
   <td><s:property value="#lp.p_answer3"/></td>
   <td><s:property value="#lp.p_name4"/></td>
   <td><s:property value="#lp.p_answer4"/></td>
   <td><s:property value="#lp.p_name5"/></td>
   <td><s:property value="#lp.p_answer5"/></td>
   <td><s:property value="#lp.p_type"/></td>
   <td><a href="ListSubjectByIdAction?p_name1=<s:property value="#lp.p_name1"/>">修改</a><a href="DeleteSubjectAction?p_name1=<s:property value="#lp.p_name1"/>">删除</a></td>
   </tr>
</s:iterator>
</table>
</center>
</body>
</html>