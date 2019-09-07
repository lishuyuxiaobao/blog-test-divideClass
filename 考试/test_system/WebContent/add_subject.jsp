<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>出题</title>
</head>
<body>
<center>
  <h1>出题</h1>
  <form action="AddSubjectAction" method="post">
       选择问题：<input type="text" name="p_name1">&nbsp;&nbsp;正确答案：<input type="text" name="p_answer1">&nbsp;&nbsp;错误答案：<input type="text" name="p_option1"><br>
       选择问题：<input type="text" name="p_name2">&nbsp;&nbsp;正确答案：<input type="text" name="p_answer2">&nbsp;&nbsp;错误答案：<input type="text" name="p_option2"><br>
       填空问题：<input type="text" name="p_name3">&nbsp;&nbsp;答案：<input type="text" name="p_answer3"><br>
       填空问题：<input type="text" name="p_name4">&nbsp;&nbsp;答案：<input type="text" name="p_answer4"><br> 
     简单问题： <input type="text" name="p_name5">&nbsp;&nbsp;答案：<input type="text" name="p_answer5"><br> 
       试卷类型:<select name="p_type">
         <option value="A">A</option>
         <option value="B">B</option>
         <option value="C">C</option>
         <option value="D">D</option>
       </select>
 <input type="submit" value="提交">
  </form>
</center>
</body>
</html>