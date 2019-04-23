<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<html>
	<head>
		<title>系统后台首页</title>
		
	</head>
	<body> 
	    <center>
	        <table width="777" border="0" cellspacing="0" cellpadding="0" bgcolor="#FFFFFF" style="word-break:break-all">
	            <tr><td colspan="2"><%@ include file="top2.jsp" %></td></tr>
	            <tr>
	              <td width="180" valign="top"><%@ include file="left2.jsp" %></td>
	              <td width="597" align="left" valign="top" bgcolor="#FFFFFW">
	              <script type="text/javascript" src="<%=pathx %>/javaScript/calendar.js"></script>
	              <form  action="SignServlet" method="get" >
	      	<table border="0">
	        	<tr>
	          		<td>用户ID：</td>
	          		<td><input type="text" name="id"/></td>
	        	</tr>
	        	<tr>
	          		<td>时间：</td>
	          		<td><input type="text" name="date" value="" size="15" onclick="calendar.show(this);" /></td>
	        	</tr>
	        	
	        	<tr>
	         		 <td>签到：</td>
	         		 <td><input type="radio" name="sign" value="签到"/>签到</td>
	        	</tr> 
	        	<tr>
					<td></td>
	          		<td>
						<input type="submit" value="确定">&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;
						 <input type="hidden" name="operate" value="update"/>
						<input type="reset"  value="取消">	
	          		</td>
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
