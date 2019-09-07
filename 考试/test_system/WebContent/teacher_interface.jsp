<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>教师页</title>
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
</head>
<body>
<div id="container">
    <div class="container_head"><h2>欢迎教师"${sessionScope.user.t_name }"登录阅卷&nbsp;&nbsp;&nbsp;
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <a href="login.jsp">退出</a></h2></div>
    <div class="container_display">
        <div class="container_display_left">
          <ul>
             <li><a href="add_subject.jsp" target="displayinfo">添加题目</a></li>
             <li><a href="ListSubjectAction" target="displayinfo">管理题目</a></li>
             <li><a href="findAllStuAction?t_class=${sessionScope.user.t_class}&t_name=${sessionScope.user.t_name}" target="displayinfo">查看班级信息</a></li>
             <li><a href="javascript:location.href=encodeURI('update_tea.jsp?t_id=${sessionScope.user.t_id}&t_name=${sessionScope.user.t_name}&t_pass=${sessionScope.user.t_pass}&t_class=${sessionScope.user.t_class}')" target="displayinfo">修改信息</a></li>
          </ul>
        </div>
        <div class="container_display_right">
             <iframe name="displayinfo" width="100%" height="100%"></iframe>
        </div>
    </div>
</div>
</body>
</html>