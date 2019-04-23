<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%
	String pathx = request.getContextPath();
%>
<html>
    <head>
    	<title>系统-侧栏</title>
    </head>
	<body>
	    <center>
	    <table width="180" border="0" cellspacing="0" cellpadding="0">
	        <!-- 查看个人信息-->
	        <tr>
	            <td valign="top">
	                <table width="100%" border="0" cellspacing="0" cellpadding="0">
	                    <tr height="100"><td background="<%=pathx %>/images/03.jpg" style="text-indent:45;padding-top:8"><a href="<%=pathx %>/PersonSign.jsp"><b><font color="white">签到</font></b></a></td></tr>
	                </table>
	            </td>
	        </tr>
	        <!-- 查看本月工资信息 -->
	        <tr>
	            <td valign="top">
		            <table width="100%" border="0" cellspacing="0" cellpadding="0">
	                    <tr height="100"><td background="<%=pathx %>/images/03.jpg" style="text-indent:45;padding-top:8"><a href="<%=pathx %>/PersonMessage.jsp"><b><font color="white">查看员工信息</font></b></a></td></tr>
	                     
	                </table>
	            </td>
	        </tr>
			<!-- 查看个人考勤记录-->
			<tr>
	            <td valign="top">
		            <table width="100%" border="0" cellspacing="0" cellpadding="0">
	                    <tr height="100"><td background="<%=pathx %>/images/03.jpg" style="text-indent:45;padding-top:8"><a href="<%=pathx %>/PersonSalary.jsp"><b><font color="white">查看工资信息</font></b></a></td></tr>
			                </table>
	            </td>
	        </tr>
	        
	    </table>
	    </center> 
	</body>
</html>
