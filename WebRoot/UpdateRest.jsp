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
	              <script type="text/javascript" src="<%=pathx %>/javaScript/calendar.js"></script>
	              
	              <%
	         
	           Rest rest=(Rest)request.getAttribute("rest");
	               %>
	              <form action="RestServlet" method="get">
	              <input type="hidden" name="operate" value="update"/>
							<table border="0" width="94%" rules="none" cellspacing="0"
								cellpadding="8" style="margin-top:8px; border:1px dashed #666;">
								<tr><td>ID：</td>
	          		                <td><input type="text" name="id" value="<%=rest.getId()%>"readonly/></td></tr>
	          		                <tr><td>请假时间：</td>
	          		                <td><input type="text" name="restDate" value="<%=rest.getRestDate()%>" size="15" onclick="calendar.show(this);" /></tr>
								<tr><td>备注：</td>
	          		                <td><input type="text" name="note"value="<%=rest.getNote() %>"/></td></tr>
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

