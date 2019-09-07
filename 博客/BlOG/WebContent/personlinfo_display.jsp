<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>个人信息一览</title>
<style type="text/css">
.display_hportrait img{
border-radius: 30px;
}
.blogcontent ul li{
list-style: none;
margin: 10px 10px;
float: left;
}
.blogcontent ul li .display{
width:500px;
border: 1px solid #ccc;
position: relative;
border-radius: 10px;
}
.blogcontent ul li .comment{
width:500px;
border: 1px solid #ccc;
position: relative;
border-radius: 10px;
display: none;
}
.blogcontent ul li .reply{
width:500px;
border: 1px solid #ccc;
position: relative;
border-radius: 10px;
display: none;
}
.display .display_username{
position: absolute;
left:100px;
top:10px;
}
.display .display_attention{
position: absolute;
left:400px;
top:5px;

}
.display .display_username .display_username_time{
opacity:0.4;
}
.display .display_type{
position: absolute;
left:20px;
top:80px;
width:20px;
font-size: 28px;
opacity:0.6;
bottom: 10px;
}
.display .display_content{
margin: 5px auto;
padding-left: 100px;
}
.display .display_photo{
margin: 5px auto;
padding-left: 100px;
}
.display .display_comment{
position:absolute;
bottom:10px;
left:380px;
}
.comment input[type="text"] {
  outline: none;
  font-size: 15px;
  font-weight: 500;
  color: #818181;
  padding: 10px 20px;
  background: #CCCCFF;
  border: 1px solid #ccc;
  border-radius:25px;
  margin: 0px 0px 5px 0px;
  width: 70%;
  -webkit-appearance: none;
}
.comment input[type="submit"] {
  outline: none;
  font-size: 15px;
  font-weight: 500;
  color: #818181;
  padding: 10px 0; 
  background: #CACACA;
  border: 1px solid #ccc;
  border-radius:25px;
  margin: 0px 0px 5px 0px;
  width: 10%;
  -webkit-appearance: none;
}
.comment input[type="reset"] {
  outline: none;
  font-size: 15px;
  font-weight: 500;
  color: #818181;
  padding: 10px 0; 
  background: #CACACA;
  border: 1px solid #ccc;
  border-radius:25px;
  margin: 0px 0px 5px 0px;
  width: 10%;
  -webkit-appearance: none;
}
.personalinfo_title img{
width:60px;
height: 60px;
border-radius: 30px;
}
.attention img{
width:60px;
height: 60px;
border-radius: 30px;
margin: 0 10px;
}
.fans img{
width:60px;
height: 60px;
border-radius: 30px;
margin: 0 10px;
}
.personalinfo_title font{
position: absolute;
left:80px;
}
.personalinfo_title .personalinfo_title_update{
position: absolute;
left:80px;
top:10px;
z-index: 1;
display: none;
background-color: #ccc;
}
.personalinfo_title a:hover .personalinfo_title_update{
display: block;
}
.attention_infomation{
width:300px;
}
.attention li{
float: left;
list-style: none;
}
.fans{
position: absolute;
top:280px;
left: 0;
}
#blog_title_content{
position: absolute;
top:430px;
left: 0;
}
.fans li{
float: left;
list-style: none;
}
</style>
<%-- <script type="text/javascript">

function test(){	
	window.scroll(0,document.body.scrollHeight)
}


</script> --%>
 <script type="text/javascript">
window.onload=function(){
var but2 = document.getElementsByClassName('but2');
var but1 = document.getElementsByClassName('but1');
var but3 = document.getElementsByClassName('but3');
var but4 = document.getElementsByClassName('but4');

var comments = document.getElementsByClassName('comment');
var replys = document.getElementsByClassName('reply');

for(var i=0;i<but2.length;i++){
	but2[i].index=i;
	but2[i].onclick=function(){
		for(var i=0;i<but2.length;i++){
			replys[i].style.display='none';
			comments[i].style.display='none';
		}
		comments[this.index].style.display='block';
	}
}
for(var i=0;i<but1.length;i++){
	but1[i].index=i;
	but1[i].onclick=function(){
		for(var i=0;i<but1.length;i++){
			replys[i].style.display='none';
			comments[i].style.display='none';
		}
		replys[this.index].style.display='block';
	}
}
for(var i=0;i<but4.length;i++){
	but4[i].index=i;
	but4[i].onclick=function(){
		for(var i=0;i<but4.length;i++){
			replys[i].style.display='none';
			comments[i].style.display='none';
		}
	}
}
for(var i=0;i<but3.length;i++){
	but3[i].index=i;
	but3[i].onclick=function(){
		for(var i=0;i<but3.length;i++){
			replys[i].style.display='none';
			comments[i].style.display='none';
		}
	}
}
}
</script> 
</head>
<body>
<div id="personalinfo">
<s:iterator value="listusers" var="lu">
<div class="personalinfo_title">
<s:if test="#lu.id==#session.id">
<a href="UpdateRegistAction?id=<s:property value="#lu.id"/>"><img class="hp" src="<s:property value="#lu.hportrait"/>"><div class="personalinfo_title_update">
          <h1>点我修改信息</h1>
     </div></a><font><h1>个人信息:</h1></font>
</s:if>
<s:else><a><img class="hp" src="<s:property value="#lu.hportrait"/>">
     </a><font><h1>个人信息:</h1></font></div></s:else>
     
</div><br><br>
<div class="personalinfo_content">
     
      ID: <s:property value="#lu.id"/>&nbsp;&nbsp;&nbsp;&nbsp;
      用户名：<s:property value="#lu.username"/>&nbsp;&nbsp;&nbsp;&nbsp;
      我的邮箱：<s:property value="#lu.email"/>

</div>
</s:iterator>
</div>
<div id="attention_fans">
<div class="attention">
     <font><h1>关注<s:property value="listattentions.size()"/>：</h1></font>
     <ul>
     <s:iterator value="listhortrait" var="lh">
         <li>   <a href="RBCAttentionAction?id=<s:property value="#lh.registinfo.id"/>"><img src="${lh.registinfo.hportrait}"></a></li>
         <li>   <div class="attention_infomation"> 
                     ID: <s:property value="#lh.registinfo.id"/><br>
                                            用户名：<s:property value="#lh.registinfo.username"/><br>
                                            他的邮箱：<s:property value="#lh.registinfo.email"/>
                </div>
         </li>
     </s:iterator>
     </ul>
</div>
<div class="fans">
     <font><h1>粉丝<s:property value="listattentionsuserid.size()"/>：</h1></font>
     <ul>
      <s:iterator value="listattentionhortrait" var="lah">
       <li>  <a href="RBCAttentionAction?id=<s:property value="#lah.registinfo.id"/>"><img src="${lah.registinfo.hportrait}"></a></li>
       <li>   <div class="attention_infomation"> 
                     ID: <s:property value="#lah.registinfo.id"/><br>
                                            用户名：<s:property value="#lah.registinfo.username"/><br>
                                            他的邮箱：<s:property value="#lah.registinfo.email"/>
                </div>
         </li>
     </s:iterator>
     </ul>
</div>
</div>
<div id="blog_title_content">
<div class="blogtitle">
  <font><h1>我的博客内容:</h1></font>
</div>
<div class="blogcontent">
<ul>
<s:iterator value="listblogs" var="lb">

<li>
<div class="display">
<div class="display_hportrait">
<img alt="出错了" src="${lb.registinfo.hportrait}" width="60px" height="60px">
</div>
<div class="display_username">
<img alt="出错了" src="images/user.jpg" width="16px" height="16px"><font style="font-weight: bold;">用户：&nbsp;&nbsp;&nbsp;<s:property value="#lb.registinfo.username"/></font><br>
<div class="display_username_time">时间:&nbsp;&nbsp;&nbsp;<s:property value="#lb.time"/></div>
</div>
<div class="display_type">
<s:property value="#lb.type"/>
</div>
<div class="display_content">
<s:property value="#lb.content"/>
</div>
<div class="display_photo">
<img src="${lb.photo}" width="80px" height="100px">
</div>
<div class="display_attention">

   <s:if test="#lb.attentioninfo.attention=='2.jpg'"><a href="DeleteAttentionAction?id=<%=session.getValue("id") %>&userid=<s:property value="#lb.id"/>"> <img src="hportrait/${lb.attentioninfo.attention}"> </a></s:if> 
   <s:elseif test="#lb.id==#session.id"><img src="hportrait/3.jpg" width="60px" height="60px"></s:elseif>
   <s:else><a href="AddAttentionAction?id=<%=session.getValue("id") %>&userid=<s:property value="#lb.id"/>"><img src="hportrait/1.png"></a></s:else>
</div>
<div class="display_comment">
       <input class="but1" type="button" value="查看">
       <input class="but2" type="button" value="评论">
</div>
</div>
<div class="comment">
         <form action="AddCommentAction?id=<%=session.getValue("id") %>&userid=<s:property value="#lb.id"/>&time=<s:property value="#lb.time"/>" method="post">
                  <input type="text" name="content">
                  <input type="submit" value="提交"><input class="but3" type="reset" value="取消">
         </form>
                  
</div>
<div class="reply">
 <s:if test="#lb.commentinfo.content==null">该博客还未被评论哦！<input class="but4" type="button" value="关闭"></s:if>
<s:else>
<s:iterator value="#lb.comments" var="lbc">
博客号为&nbsp;<s:property value="#lbc.id"/>&nbsp;网友说: &nbsp;&nbsp;&nbsp;&nbsp;
<s:property value="#lbc.content"/>&nbsp;&nbsp;
<s:if test="#lbc.userid==#session.id"><a href="DeleteCommentAction?commenttime=<s:property value="#lbc.commenttime"/>">删除该评论</a></s:if><br>
</s:iterator>
<input class="but4" type="button" value="关闭">
</s:else>   
</div>
</li>

</s:iterator>
</ul>
</div>
</div>
</body>
</html>