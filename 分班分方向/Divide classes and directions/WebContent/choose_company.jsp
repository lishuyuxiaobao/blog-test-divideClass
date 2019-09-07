<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>分公司</title>
</head>
<body>
<br><br><br><br>
<center>
<table border="1">
<form action="MutilDivideCompanyAction" method="post">
<input type="submit" value="分派">
<s:iterator value="cList" var="c">
<tr>
 <td>方向名称：</td><td><s:property value="#c.direction"/></td>
 <td>该方向所分班级：</td><td><input type="text" name="classnames" value="<s:property value="#c.classname"/>" readonly="readonly"></td>
 <td>授课公司：</td><td><select name="companys">
                            <s:iterator value="#c.companylist" var="cl">
                                <option><s:property value="#cl.company"/></option>
                            </s:iterator>
                       </select></td>
 </tr>
</s:iterator>
</form>
</table>
</center>
</body>
</html>