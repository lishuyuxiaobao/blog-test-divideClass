<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>修改页</title>
</head>
<body>
<center>
<form action="UpdateSubjectByIdAction" method="post">
<s:iterator value="lProblems" var="lp">
 题目1<input value="<s:property value="#lp.p_name1"/>" name="p_name1" type="text"> <br>
    正确答案 <input value="<s:property value="#lp.p_answer1"/>" name="p_answer1" type="text"><br>
     错误答案<input value="<s:property value="#lp.p_option1"/>" name="p_option1" type="text"><br>
   题目2<input value="<s:property value="#lp.p_name2"/>" name="p_name2" type="text"><br>
     正确答案<input value="<s:property value="#lp.p_answer2"/>" name="p_answer2" type="text"><br>
   错误答案<input value="<s:property value="#lp.p_option2"/>" name="p_option2" type="text"><br>
    题目3<input value="<s:property value="#lp.p_name3"/>" name="p_name3" type="text"><br>
     正确答案<input value="<s:property value="#lp.p_answer3"/>" name="p_answer3" type="text"> <br>
   题目4<input value="<s:property value="#lp.p_name4"/>" name="p_name4" type="text"><br>
     正确答案<input value="<s:property value="#lp.p_answer4"/>" name="p_answer4" type="text"> <br>
     题目5 <input value="<s:property value="#lp.p_name5"/>" name="p_name5" type="text"><br>
  正确答案 <input value="<s:property value="#lp.p_answer5"/>" name="p_answer5" type="text"><br>
     类型  <input value="<s:property value="#lp.p_type"/>" name="p_type" type="text"><br>
    
</s:iterator>
<input type="submit" value="修改">
</form>
</center>
</body>
</html>