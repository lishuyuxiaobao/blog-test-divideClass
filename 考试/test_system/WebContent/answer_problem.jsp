<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>作答</title>
<center><span id="clock" style="font-size: 3em">00:00:20:00</span></center><!-- 作答时间 -->
<script type="text/javascript">
    var oclock=document.getElementById("clock");
    var start1 = oclock.innerHTML;
    var finish = "00:00:00:00";
    var timer = null;
    run();
    function run() {  //定义时间函数，让秒表每100ms变化一次
        timer =setInterval("onTimer()", 100);//100ms的定时器
        
    }
    function onTimer()
    {
        if (start1 == finish)//如果倒计时结束清除时间函数
        {
            clearInterval(timer);
            start1="00:00:00:10";//(清除时间函数后还是会执行一次 所以多给一个10ms再动态赋值)
            alert("考试结束！")
            document.getElementById("Form").submit();
        }
        var hms = new String(start1).split(":");//以:作为分隔符号取字符串内的数据
        var ms = new Number(hms[3]);//给每个数据定义对象
        var s = new Number(hms[2]);
        var m = new Number(hms[1]);
        var h = new Number(hms[0]);
        ms -= 10;//每次执行ms减10
        if (ms < 0)//判断时间并进行变化
        {
            ms = 90;
            s -= 1;
            if (s < 0)
            {
                s = 59;
                m -= 1;
            }
            if (m < 0)
            {
                m = 59;
                h -= 1;
            }
        }
        var ms = ms < 10 ? ("0" + ms) : ms;//如果出现个位数给个位数前面添加0
        var ss = s < 10 ? ("0" + s) : s;
        var sm = m < 10 ? ("0" + m) : m;
        var sh = h < 10 ? ("0" + h) : h;
        start1 = sh + ":" + sm + ":" + ss + ":" + ms;
        oclock.innerHTML = start1;//重新给oclock赋值
    }
</script>
</head>
<body>

<center>

<h1>欢迎同学《<%=session.getValue("s_name") %>》作答</h1>
<form id="Form" action="AddGradeAction?s_id=<%=session.getValue("s_id") %>&p_type=<%=session.getValue("p_type") %>" method="post">
<s:iterator value="lProblems" var="lp">
      <h2>你作答的试卷为：<s:property value="#lp.p_type"/> </h2>
                    <h3>客观题目</h3>
                    <h4>单选</h4>
                    <s:property value="#lp.p_name1"/> <input type="radio" name="answer1" value="<s:property value="#lp.p_option1"/>"> <s:property value="#lp.p_option1"/><input type="radio" name="answer1" value="<s:property value="#lp.p_answer1"/>"><s:property value="#lp.p_answer1"/><br>
                    <s:property value="#lp.p_name2"/> <input type="radio" name="answer2" value="<s:property value="#lp.p_option2"/>"><s:property value="#lp.p_option2"/><input type="radio" name="answer2" value="<s:property value="#lp.p_answer2"/>"><s:property value="#lp.p_answer2"/><br>
                    <h4>填空</h4>
                    <s:property value="#lp.p_name3"/>? <input type="text" name="answer3"><br>
                    <s:property value="#lp.p_name4"/>?<input type="text" name="answer4"><br>
                    <h3>主观题</h3>
                    <s:property value="#lp.p_name5"/>?<br><input type="text" name="answer5"><br>
                    <input type="submit" value="提交">
                    
</s:iterator>
</form>
</center>
</body>
</html>