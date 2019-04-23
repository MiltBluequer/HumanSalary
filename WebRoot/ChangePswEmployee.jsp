<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<html>
	<head>
		<title>系统后台首页</title>
	</head>
	<body> 
	    <center>
	    
	   <%
      String mess1 = (String)request.getAttribute("mess1");
      String mess2 = (String)request.getAttribute("mess2");
      if(mess1!=null)
      {%>
      <h5><%=mess1 %></h5>
      <%} %>
      <% if(mess2!=null)
      {%>
      <h5><%=mess2 %></h5>
      <%} %>
   
	        <table width="777" border="0" cellspacing="0" cellpadding="0" bgcolor="#FFFFFF" style="word-break:break-all">
	            <tr><td colspan="2"><%@ include file="top2.jsp" %></td></tr>
	            <tr>
	              <td width="180" valign="top"><%@ include file="left2.jsp" %></td>
	              <td width="597" align="left" valign="top" bgcolor="#FFFFFW">
	              
	              <form action="UserServlet" method="get">
	              <input type="hidden" name="operate" value="ChangePswEmployee"/>
							<table border="0" width="94%" rules="none" cellspacing="0"
								cellpadding="8" style="margin-top:8px; border:1px dashed #666;">
								<tr><td>ID：</td>
	          		                <td><input type="text" name="id" /></td></tr>
	          		                <tr><td>原密码：</td>
	          		                <td><input type="text" name="psw" /></tr>
								<tr><td>新密码：</td>
	          		                <td><input type="text" name="psw1"/></td></tr>
	          		                <tr><td>确认新密码：</td>
	          		                <td><input type="text" name="psw2"/></td></tr>
								    <tr><td><input type="submit" value="确认"></td>
								    <td><input type="reset" value="重置"></td>
								    </tr>
							</table>
				  </form> 
	              </td>
	            </tr> 
	            <tr><td colspan="2"><%@ include file="end.jsp" %></td></tr>
	        </table>
	    </center>
	</body>
</html>