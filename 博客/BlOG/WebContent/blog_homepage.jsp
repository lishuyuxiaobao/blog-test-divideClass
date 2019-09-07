<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>你好，博客</title>
<link rel="stylesheet" href="css/NewFile2.css">

<script type="text/javascript">
window.onload=function(){
  var abc = document.getElementById('abc');
  var a = document.getElementById('a');
  var b = document.getElementById('b');
  var k=null;
  abc.onclick=function(){
	  k = setInterval(function(){
		  a.value='';
		  b.value='';
	  }	, 1000);	 
  }
  a.onclick=b.onclick=function(){
	  clearInterval(k);
  }
/*   var goinblog = document.getElementsByClassName('goinblog');
  var Type = document.getElementsByClassName('type');
  goinblog.onclick=function(){
	  Type.style.display='block';
  } */
}
</script>

</head>
<body>

 <div id="ad">

<div id="info">
      
</div>
<div id="info_photo">
<s:iterator value="listusers" var="lu">
       <a href="RBCAttentionAction?id=<%=session.getValue("id") %>"><img class="hp" src="<s:property value="#lu.hportrait"/>"></a>
</s:iterator>
</div>

<div id="info_attention">
      <div class="info_attention_left">关注<s:property value="listattentions.size()"/></div>
      <div class="info_attention_left">粉丝<s:property value="listattentionsuserid.size()"/></div>
</div>
<a class="goinblog" href="ListBlogAction?id=<%=session.getValue("id") %>#hei" target="blog"><font class="goinblog_font" color="red">进入博客</font></a>
<%-- <div class="type">
      <a href="ListBlogAction?id=<%=session.getValue("id") %>" target="blog">全部篇</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      <a href="ListBlogTypeAction?id=<%=session.getValue("id") %>&type=实时篇" target="blog">实时篇</a>
      <br><br>
      <a href="ListBlogTypeAction?id=<%=session.getValue("id") %>&type=心情篇" target="blog">心情篇</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      <a href="ListBlogTypeAction?id=<%=session.getValue("id") %>&type=趣事篇" target="blog">趣事篇</a>
       <br><br>
      <a href="ListBlogTypeAction?id=<%=session.getValue("id") %>&type=文采篇" target="blog">文采篇</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      <a href="ListBlogTypeAction?id=<%=session.getValue("id") %>&type=奇幻篇" target="blog">奇幻篇</a>
</div> --%>
<div class="backhomepage">
  <a href="UserLogin.jsp">重新登录</a>
</div>
</div> 

<div id="content">
<iframe onload="test()" name="blog" width="600px" height="700px"> </iframe>
</div>
<div id="send">
<form action="BlogAction?id=<%=session.getValue("id") %>" method="post" enctype="multipart/form-data" target="blog">
<input id="a" type="text" name="content" placeholder="我也要发博客了。。。"><input id="b" type="file" name="file"><br>
      <select name="type">
          <option value="实时篇">实时篇</option>
          <option value="心情篇">心情篇</option>
          <option value="趣事篇">趣事篇</option>
          <option value="文采篇">文采篇</option>
          <option value="奇幻篇">奇幻篇</option>
      </select><br>
      <input id="abc" type="submit" value="发送">
</form>
</div>
</body>
</html>