<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>开放时间的设定</title>
<style type="text/css"> 
body{
padding: 0;
margin: 0;
}
#num{
width: 200px;
height: 360px;
position: absolute;
left:10px;
top:200px;
}
</style>
</head>
<body>
<center>
 <s:if test="lDirections.size()==0"><h1>未到开放时间请同学耐心等待！</h1></s:if> 
 <s:else>
<table border="1px">
  <tr>
     <th>方向名称</th>
     <th>开放时间</th>
     <th>人数</th>
     <th>操作</th>
  </tr>
  <s:iterator value="lDirections" var="ld">
     <tr>
        <td><font><s:property value="#ld.direction"/></font></td>
        <td><s:property value="#ld.time"/></td> 
        <td><a href="SelectDirectionNumAction?direction=<s:property value="#ld.direction"/> " target="nums">查看已报人数</a></td>
        <td><a href="AddDirectionListAction?sid=<%=session.getValue("sid") %>&direction=<s:property value="#ld.direction"/>" target="nums">报名</a></td>
     </tr>
     
  </s:iterator>
</table>
</center>
<div id="num">
<iframe name="nums" width="200px" height="360px"></iframe>
</div>
</s:else>


</body>
</html>