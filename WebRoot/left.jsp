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
	    <left>
	    <table width="180" border="0" cellspacing="0" cellpadding="0">
	        <!-- 员工信息管理 -->
	        <tr>
	            <td valign="top">
	                <table width="100%" border="0" cellspacing="0" cellpadding="0">
	                    <tr height="29"><td background="<%=pathx %>/images/03.jpg" style="text-indent:45;padding-top:8"><b><font color="white">员工信息管理</font></b></td></tr>
	                    <tr height="40">
	                    	<td background="<%=pathx %>/images/05.jpg" style="text-indent:30">
	                    	 <a href="<%=pathx %>/FrontSelectEmployee.jsp">查询员工信息</a>
	                    	</td>
	                    </tr>
	                     <tr height="40">
	                    	<td background="<%=pathx %>/images/05.jpg" style="text-indent:30">
	                    	 <a href="<%=pathx %>/AddEmployee.jsp">添加员工信息</a>
	                    	</td>
	                    </tr>
	                    <tr height="40">
	                    	<td background="<%=pathx %>/images/05.jpg" style="text-indent:30">
	                    	<a href="<%=pathx %>/SUDEmployee.jsp">浏览/修改/删除员工信息</a>
	                    	</td>
	                    </tr> 
	                              
	                    <tr height="16">
	                    	<td background="<%=pathx %>/images/06.jpg" >
	                    	</td>
	                    </tr>
	                </table>
	            </td>
	        </tr>
	        <!-- 工资信息管理 -->
	        <tr>
	            <td valign="top">
		            <table width="100%" border="0" cellspacing="0" cellpadding="0">
	                    <tr height="29"><td background="<%=pathx %>/images/03.jpg" style="text-indent:45;padding-top:8"><b><font color="white">工资信息管理</font></b></td></tr>
	                    <tr height="40">
	                    	<td background="<%=pathx %>/images/05.jpg" style="text-indent:30">
	                    		<a href="<%=pathx %>/AddSalary.jsp">添加员工奖金</a>
	                    	</td>
	                    </tr>
	                    <tr height="40">
	                    	<td background="<%=pathx %>/images/05.jpg" style="text-indent:30">
	                    		<a href="<%=pathx %>/SelectSign.jsp">查看签到记录</a>
	                    	</td>
	                    </tr>
                       <tr height="40">
	                    	<td background="<%=pathx %>/images/05.jpg" style="text-indent:30">
	                    		<a href="<%=pathx %>/DownSalary.jsp">扣除员工罚金</a>
	                    	</td>
	                    </tr>
	                    <tr height="40">
	                    	<td background="<%=pathx %>/images/05.jpg" style="text-indent:30">
	                    		<a href="<%=pathx %>/QuerySalary.jsp">浏览工资信息</a>
	                    	</td>
	                    </tr>
	                   
	                    <tr height="16">
	                    	<td background="<%=pathx %>/images/06.jpg" >
	                    	</td>
	                    </tr>
	                </table>
	            </td>
	        </tr>
			<!-- 请假信息管理-->
			<tr>
	            <td valign="top">
		            <table width="100%" border="0" cellspacing="0" cellpadding="0">
	                    <tr height="29"><td background="<%=pathx %>/images/03.jpg" style="text-indent:45;padding-top:8"><b><font color="white">请假信息管理</font></b></td></tr>

        	<!-- 将以下tr改为动态生成的请假信息 -->
	                    <tr height="40">
	                    	<td background="<%=pathx %>/images/05.jpg" style="text-indent:30">
	                    		<a href="<%=pathx %>/AddRest.jsp">添加请假信息</a>
	                    	</td>
	                    </tr>
                       <tr height="40">
	                    	<td background="<%=pathx %>/images/05.jpg" style="text-indent:30">
	                    		<a href="<%=pathx %>/SUDRest.jsp">浏览/修改/删除请假信息</a>
	                    	</td>
	                    </tr>
              
                   <tr height="16">
	                    	<td background="<%=pathx %>/images/06.jpg" >
	                    	</td>
	                    </tr>
              
			                </table>
	            </td>
	        </tr>
	        
	        <!-- 用户管理-->
			<tr>
	            <td valign="top">
		            <table width="100%" border="0" cellspacing="0" cellpadding="0">
	                    <tr height="29"><td background="<%=pathx %>/images/03.jpg" style="text-indent:45;padding-top:8"><b><font color="white">用户管理</font></b></td></tr>

        	<!-- 将以下tr改为动态生成用户 -->
	                    <tr height="40">
	                    	<td background="<%=pathx %>/images/05.jpg" style="text-indent:30">
	                    		<a href="<%=pathx %>/AddUser.jsp">添加用户</a>
	                    	</td>
	                    </tr>
                       <tr height="40">
	                    	<td background="<%=pathx %>/images/05.jpg" style="text-indent:30">
	                    		<a href="<%=pathx %>/SUDUserAdmin.jsp">浏览/修改/删除管理员用户</a>
	                    	</td>
	                    </tr>
	                     <tr height="40">
	                    	<td background="<%=pathx %>/images/05.jpg" style="text-indent:30">
	                    		<a href="<%=pathx %>/SUDUserEmployee.jsp">浏览/修改/删除员工用户</a>
	                    	</td>
	                    </tr>
              
                   <tr height="16">
	                    	<td background="<%=pathx %>/images/06.jpg" >
	                    	</td>
	                    </tr>
              
			                </table>
	            </td>
	        </tr>
	    </table>
	    </left> 
	</body>
</html>
