<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登录</title>
<style type="text/css">
#container{
	padding:0;
	margin: 0;
	position: relative;
}
#login{
	position:absolute;
	overflow:hidden;
	background:url("login.png") no-repeat;
	width:500px;
	height:400px;
	z-index: 5;
	left:650px;
	top:200px;
	border-radius:20px;
}
#login table{
	border-style:none;
	top:600px auto 0;
	width:300px;
	height:300px;
	border-radius:10px;
	}
#login table input{
	border-style:none;
	width:100px;
	height:40px;
	border-radius:10px;
	cursor:pointer;
	}
#login table select{
	border-style:none;
	width:100px;
	height:40px;
	border-radius:10px;
	cursor:pointer;

	}
</style>
</head>
<body>
<div id="container">
<center>
<h1>欢迎使用中北分方向分班系统</h1>
</center>
   <div id="login">
        <center>
<form action="LoginAction" method="post">
<br />
<table>
<tr><td align="center"><font size="+3">用户名：</font></td><td align="center"><input type="text" name="sid"/></td></tr>
<tr><td align="center"><font size="+3">密&nbsp;&nbsp;&nbsp;码：</font></td><td align="center"><input type="text" name="password"/></td></tr>
<tr><td align="center"><font size="+3">类&nbsp;&nbsp;&nbsp;型：</font></td><td align="center">
<select name="type">
   <option value="管理员">管理员</option>
   <option value="学生">学生</option>
</select></td></tr>
<tr><td align="center"><input id="loginBtn" type="submit" value="Login" /></td><td align="center"><input id="resetBtn" type="reset" value="Reset" /></td></tr>
</table>
</form>
</center>
   </div>
   </div>
</body>
</html>