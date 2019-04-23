<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<html>
	<head>
		<title>系统后台首页</title>
	</head>
	<body> 
	    <center>
	    <%
      String mess = (String)request.getAttribute("mess");
      if(mess!=null)
      {
   %>
   <h5><%=mess %></h5>
   <%} %>
	        <table width="777" border="0" cellspacing="0" cellpadding="0" bgcolor="#FFFFFF" style="word-break:break-all">
	            <tr><td colspan="2"><%@ include file="top.jsp" %></td></tr>
	            <tr>
	              <td width="180" valign="top"><%@ include file="left.jsp" %></td>
	              <td width="597" align="left" valign="top" bgcolor="#FFFFFW">
	              <form action="SalaryServlet" method="get">
	              <input type="hidden" name="operate" value="addfine"/>
							<table border="0" width="94%" rules="none" cellspacing="0"
								cellpadding="8" style="margin-top:8px; border:1px dashed #666;">
								<tr><td>ID：</td>
	          		                <td><input type="text" name="id"/></td></tr>
	          		                <tr><td>月份：</td>
	          		                <td><input type="text" name="monthTime"/></tr>
								<tr><td>金额：</td>
	          		                <td><input type="text" name="fine"/></td></tr>
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
