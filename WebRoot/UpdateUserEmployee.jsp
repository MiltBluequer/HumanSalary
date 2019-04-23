<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.ArrayList,nepu.edu.model.*"%>
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
	              
	              <%
	         UserAdmin userAdmin=(UserAdmin)request.getAttribute("userAdmin");
	               %>
	              <form action="UserServlet" method="get">
	              <input type="hidden" name="operate" value="updateEmployee"/>
							<table border="0" width="94%" rules="none" cellspacing="0"
								cellpadding="8" style="margin-top:8px; border:1px dashed #666;">
								<tr><td>ID：</td>
	          		                <td><input type="text" name="id" value="<%=userAdmin.getId() %>"readonly/></td></tr>
								<tr><td>密码：</td>
	          		                <td><input type="password" name="psw" value="<%=userAdmin.getPsw() %>" readonly/></td></tr>
	          		            <tr><td>姓名：</td>
	          		                <td><input type="text" name="name" value="<%=userAdmin.getName()%>"/></td></tr>
	          		                <tr><td>年龄：</td>
	          		                <td><input type="text" name="age" value="<%=userAdmin.getAge()%>"/></td></tr>
	          		                <tr><td>地址：</td>
	          		                <td><input type="text" name="address" value="<%=userAdmin.getAddress()%>"/></td></tr>
	          		                 <tr><td>邮箱：</td>
	          		                <td><input type="text" name="mail" value="<%=userAdmin.getMail()%>"/></td></tr>
	          		                
								      <td><input type="submit" value="修改"></td>
							</table>
				  </form> 
	              </td>
	            </tr> 
	            <tr><td colspan="2"><%@ include file="end.jsp" %></td></tr>
	        </table>
	    </center>
	</body>
</html>
