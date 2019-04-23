<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.ArrayList" %>

<html>
	<head>
		<title>系统后台首页</title>
	</head>
	<body> 
	    <center>
	       <%
	       String id=(String)session.getAttribute("id");
	        %>
	        <table width="777" border="0" cellspacing="0" cellpadding="0" bgcolor="#FFFFFW" style="word-break:break-all">
	            <tr><td colspan="2"><%@ include file="top2.jsp" %></td></tr>
	            <tr>
	                <td width="180" valign="top"><%@ include file="left2.jsp" %></td>
	                <td align="center" valign="top" bgcolor="#FFFFFW"><font size="3"><b>尊敬的<%=id %>，欢迎回来！</b></font></td>
	            </tr>
	            <tr><td colspan="2"><%@ include file="end.jsp" %></td></tr>
	        </table>
	    </center>
	</body>
</html>