<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>成功页</title>
</head>
<body>
<center>
<h1>客观卷得分详情</h1>
<form action="UpdateGradeAction?s_id=<%=session.getValue("s_id") %>" method="post">
<s:iterator value="lGraders" var="lg">
    试卷类型为：<s:property value="#lg.p_type"/>
    题目一：<s:property value="#lg.pinfo.p_name1"/>&nbsp;&nbsp;&nbsp;<s:if test="#lg.answer1==#lg.pinfo.p_answer1"><input type="hidden" name="gradess">回答正确</s:if>&nbsp;&nbsp;&nbsp;<s:else>回答错误</s:else> &nbsp;&nbsp;&nbsp; 我的答案:<s:property value="#lg.answer1"/>&nbsp;&nbsp;&nbsp; 正确答案：<s:property value="#lg.pinfo.p_answer1"/><br>
    题目二：<s:property value="#lg.pinfo.p_name2"/> &nbsp;&nbsp;&nbsp;<s:if test="#lg.answer2==#lg.pinfo.p_answer2"><input type="hidden" name="gradess">回答正确</s:if>&nbsp;&nbsp;&nbsp;<s:else>回答错误</s:else>&nbsp;&nbsp;&nbsp;  我的答案:<s:property value="#lg.answer2"/>&nbsp;&nbsp;&nbsp;正确答案：<s:property value="#lg.pinfo.p_answer2"/><br>
    题目三：<s:property value="#lg.pinfo.p_name3"/>&nbsp;&nbsp;&nbsp; <s:if test="#lg.answer3==#lg.pinfo.p_answer3"><input type="hidden" name="gradess">回答正确</s:if>&nbsp;&nbsp;&nbsp;<s:else>回答错误</s:else>&nbsp;&nbsp;&nbsp;  我的答案:<s:property value="#lg.answer3"/>&nbsp;&nbsp;&nbsp;正确答案：<s:property value="#lg.pinfo.p_answer3"/><br>
    题目四：<s:property value="#lg.pinfo.p_name4"/>&nbsp;&nbsp;&nbsp; <s:if test="#lg.answer4==#lg.pinfo.p_answer4"><input type="hidden" name="gradess">回答正确</s:if>&nbsp;&nbsp;&nbsp;<s:else>回答错误</s:else> &nbsp;&nbsp;&nbsp; 我的答案:<s:property value="#lg.answer4"/>&nbsp;&nbsp;&nbsp;正确答案：<s:property value="#lg.pinfo.p_answer4"/><br>
    题目五：<s:property value="#lg.pinfo.p_name5"/> &nbsp;&nbsp;&nbsp; 我的答案:<s:property value="#lg.answer5"/>&nbsp;&nbsp;&nbsp;正确答案：<s:property value="#lg.pinfo.p_answer5"/>  <br>
    
    <h2>主观题等待老师打分 ，总成绩将在个人信息中查看！</h2>
    
</s:iterator><br>
<input type="submit" value="确定">
 </form>
</center>
</body>
</html>