<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>上传头像</title>
<style type="text/css">
body{
margin: 0;
padding: 0;
}
#form{
width:200px;
margin: 500px auto;
}
#form input[type="file"] {
  outline: none;
  font-size: 15px;
  font-weight: 1000;
  color: #818181;
  padding: 10px 20px;
  background: #CACACA;
  border: 1px solid #ccc;
  border-radius:25px;
  margin: 0px 0px 5px 0px;
  width: 100%;
  -webkit-appearance: none;
}
#form input[type="submit"] {
  outline: none;
  font-size: 15px;
  font-weight: 500;
  color: #818181;
  padding: 10px 20px;
  background: #CACACA;
  border: 1px solid #ccc;
  border-radius:25px;
  margin: 0px 0px 10px 20px;
  width: 92%;
  -webkit-appearance: none;
}
</style>
</head>
<body style="background:url(images/hportrait.jpg);">
<div id="form">
<form action="RegistAction?id=<%=request.getParameter("id") %>&email=<%=request.getParameter("email") %>&password=<%=request.getParameter("password") %>&username=<%=request.getParameter("username") %>" method="post" enctype="multipart/form-data">
<input type="file" name="file">
  <br>
  <input type="submit" value="上传头像">
</form>
</div>
</body>
</html>