<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登录界面</title>
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/font-awesome.min.css">
        <link rel="stylesheet" href="css/style.css">  
        <script type="text/javascript"  src="js/jquery.min.js"></script>
        <script type="text/javascript" src="js/bootstrap.min.js"></script>
    </head>
    <body> 
            <div class="page-heading">
                <div class="container">
                    <div class="row">
                        <div class="col-sm-12 text-center">
                            <h1 class="title"><span>Login/Register</span></h1>
                            <div class="breadcrumb">
                                <span class="current">Login/Register</span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- End Breadcrumb -->
            
            
            <section class="main-contain bg-gray">
                <div class="container">
    <div class="login-area">
                    <div class="login-header">
                                <div class="login-details">
                                    <ul class="nav nav-tabs navbar-right">
                                        <li><a data-toggle="tab" href="#register">Register</a></li>
                                        <li class="active"><a data-toggle="tab" href="#login">Login</a></li>
                                        <li><a data-toggle="tab" href="#register"><s:fielderror value="error"></s:fielderror></a></li>
                                    </ul>
                                </div>
                        </div>

                    <div class="tab-content">
                        <div id="register" class="tab-pane">
                           <div class="login-inner">
                                <div class="title">
                                    <h1>Welcome to <span>Register</span></h1>
                                </div>
                                <div class="login-form">
                                    <form action="head_portrait.jsp" method="post">
                                        <div class="form-details">
                                            <label class="user">
                                                <input type="text" name="id" placeholder="ID" id="username">
                                            </label>
                                            <label class="mail">
                                                <input type="email" name="email" placeholder="Email Address" id="mail">
                                            </label>
                                            <label class="pass">
                                                <input type="password" name="password" placeholder="Password" id="password">
                                            </label>
                                            <label class="pass">
                                                <input type="text" name="username" placeholder="Full Name" id="password">
                                            </label>                                          
                               
                                        </div>
                                        <button type="submit" class="form-btn" onsubmit="">Register</button>
                                    </form>
                                </div>
                            </div>
                        </div>
                        <div id="login" class="tab-pane fade in active">
                            <div class="login-inner">
                                  <div class="title">
                                    <h1>Welcome to <span>Login</span></h1>
                                </div>
                                <div class="login-form">
                                    <form action="LoginAction" method="post">
                                        <div class="form-details">
                                            <label class="user">
                                                <input type="text" name="id" placeholder="ID" id="username">
                                            </label>
                                            <label class="pass">
                                                <input type="password" name="password" placeholder="Password" id="password">
                                            </label>
                                        </div>
                                        <button type="submit" class="form-btn" onsubmit="">Login</button>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>

        </div>
                </div>
            </section>

</body>
</html>