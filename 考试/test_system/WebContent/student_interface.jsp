<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>学生界面</title>
<style type="text/css">
#container{
padding: 0;
margin: 0;
}
.container_head{
height:50px;
width: 100%;
text-align: center;
line-height: 50px;
background-color: blue;
}
.container_display_left{
width: 300px;
background-color: #ccc;
float: left;
}
.container_display_right{
width: 1300px;
height:600px;
float: left;
margin-left: 130px;
}
.container_display_left ul li{
text-decoration: none;
margin-top: 40px;
font-size: 25px;
text-align: center;
}
a{
text-decoration: none;
}
</style>
<script language="javascript"> 
	function test(){ 
	alert("请注意！开始考试自动倒计时，试卷类型随机，结束试卷自动提交!"); 
	window.location.href="FindProblemAction?s_name=${sessionScope.user.s_name }&s_id=${sessionScope.user.s_id }"
	} 
</script>
</head>
<body>
<div id="container">
    <div class="container_head"><h2>欢迎学生"${sessionScope.user.s_name}"登录&nbsp;&nbsp;&nbsp;
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <a href="login.jsp">退出</a></h2></div>
    <div class="container_display">
        <div class="container_display_left">
        
          <ul>
             <li><a href="PersonalAction?id=${sessionScope.user.s_id}" target="displayinfo">个人信息</a></li>
             <li><a target="displayinfo" href="javascript:location.href=encodeURI('update_stu.jsp?s_id=${sessionScope.user.s_id}&s_name=${sessionScope.user.s_name}&s_pass=${sessionScope.user.s_pass}&s_class=${sessionScope.user.s_class}')">修改信息</a></li>
             <li><input type="button" value="开始考试" onclick="test()"></li>        
          </ul>
        </div>
        <div class="container_display_right">
             <iframe name="displayinfo" width="100%" height="100%"></iframe>
        </div>
    </div>
</div>
</body>
</html>