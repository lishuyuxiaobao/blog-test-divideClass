<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>修改信息</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/font-awesome.min.css">
        <link rel="stylesheet" href="css/style.css">  
</head>
<body>
<s:iterator value="listusers" var="lu">
<div id="register" class="tab-pane">
                           <div class="login-inner">
                                <div class="title">
                                    <h1>Welcome to Update<span>Register</span></h1>
                                </div>
                                <div class="login-form">
                                    <form action="UpdateRegistUserAction?id=<s:property value="#lu.id"/>" method="post">
                                        <div class="form-details">
                                            <label class="mail">
                                              <label class="pass">
                                                <input type="text" name="username" value="<s:property value="#lu.username"/>" id="password">
                                            </label>
                                                 <label class="pass">
                                                <input type="password" name="password" value="<s:property value="#lu.password"/>" id="password">
                                            </label>
                                                <input type="email" name="email" value="<s:property value="#lu.email"/>" id="mail">
                                            </label>   
                                        </div>
                                        <button type="submit" class="form-btn" onsubmit="">Update</button>
                                    </form>
                                </div>
                            </div>
                        </div>
 </s:iterator> 
</body>
</html>