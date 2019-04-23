<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<html>
	<head>
		<title>系统后台首页</title>
	</head>
	<body> 
	    <center>
	        <table width="777" border="0" cellspacing="0" cellpadding="0" bgcolor="#FFFFFF" style="word-break:break-all">
	            <tr><td colspan="2"><%@ include file="top.jsp" %></td></tr>
	            <tr>
	              <td width="180" valign="top"><%@ include file="left.jsp" %></td>
	              <td width="597" align="left" valign="top" bgcolor="#FFFFFW">
	              <form action="EmployeeServlet" method="get">
	              <input type="hidden" name="operate" value="add"/>
							<table border="0" width="94%" rules="none" cellspacing="0"
								cellpadding="8" style="margin-top:8px; border:1px dashed #666;">
								<tr><td>用户ID：</td>
	          		                <td><input type="text" name="id"/></td></tr>
								<tr><td>姓名：</td>
	          		                <td><input type="text" name="name"/></td></tr>
	          		            <tr><td>性别：</td>
	          		                <td><input type="radio" name="sex" value="男"/>男&nbsp;&nbsp;&nbsp;
	          		                    <input type="radio" name="sex" value="女"/>女
	          		                </td></tr>
	          		                <tr><td>学历：</td>
	          		                <td><input type="text" name="degree"/></td></tr>
	          		                <tr><td>所属部门：</td>
	          		                <td><input type="text" name="deptName"/></td></tr>
	          		                 <tr><td>职位编号：</td>
	          		                <td><input type="text" name="posID"/></td></tr>
	          		                 <tr><td>联系方式：</td>
	          		                <td><input type="text" name="tel"/></td></tr>
								    <td><input type="submit" value="添加"></td>
							</table>
				  </form> 
	              </td>
	            </tr> 
	            <tr><td colspan="2"><%@ include file="end.jsp" %></td></tr>
	        </table>
	    </center>
	</body>
</html>
