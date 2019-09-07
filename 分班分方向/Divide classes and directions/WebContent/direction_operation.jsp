<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>技术方向的管理</title>
</head>
<body>
<br><br><br><br><br><br><br>
<center>
<table border="1px">
  <tr>
     <th>方向名称</th>
     <th>方向状态</th>
     <th>开放时间</th>
     <th>操作</th>
  </tr>
  <s:iterator value="lDirections" var="ld">
     <tr>
        <td><s:property value="#ld.direction"/></td>
        <td><s:property value="#ld.status"/></td> 
        <td><s:property value="#ld.time"/></td> 
        <td><s:if test="#ld.status==1"><a href="DirectionOperationAction?direction=<s:property value="#ld.direction"/>&status=0">关闭</a></s:if>
            <s:else><form action="DirectionOperationAction?direction=<s:property value="#ld.direction"/>&status=1" method="post">
        输入时间范围：<input type="text" name="time"><br>
        (格式为：xxxx.xx.xx-xxxx.xx.xx)<br>
        <input type="submit" value="开放">
        </form>
              </s:else>
        </td>
     </tr>
     
  </s:iterator>
</table>

</center>
</body>
</html>