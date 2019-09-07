<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>博客一览</title>
<link rel="stylesheet" href="css/NewFile1.css">
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
<div id="type">
      <a href="ListBlogAction?id=<%=session.getValue("id") %>" target="blog">全部篇</a>&nbsp;&nbsp;
      <a href="ListBlogTypeAction?type=实时篇" target="blog">实时篇</a>&nbsp;&nbsp;
      <a href="ListBlogTypeAction?type=心情篇" target="blog">心情篇</a>&nbsp;&nbsp;
      <a href="ListBlogTypeAction?type=趣事篇" target="blog">趣事篇</a>&nbsp;&nbsp;
      <a href="ListBlogTypeAction?type=文采篇" target="blog">文采篇</a>&nbsp;&nbsp;
      <a href="ListBlogTypeAction?type=奇幻篇" target="blog">奇幻篇</a>
</div>
<div id="container">
<s:iterator value="listblogs" var="lb">
<ul>
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
       <s:if test="#lb.id==#session.id"><a href="DeleteBlogAction?time=<s:property value="#lb.time"/>">删除</a></s:if>
       
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
</ul>
</s:iterator>
<hr id="hei">
</div>
</body>
</html>