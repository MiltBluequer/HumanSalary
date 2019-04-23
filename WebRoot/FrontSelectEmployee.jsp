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
						<!-- 查询 条件 -->
						<form action="EmployeeServlet" method="get">
						<input type="hidden" name="operate" value="querybyIND"/>
							<table border="0" width="94%" rules="none" cellspacing="0"
								cellpadding="8" style="margin-top:8px; border:1px dashed #666;">
								<tr align="left"><td colspan="7">【请选择查询条件】</td></tr>
								 <tr><td align="2">   <select name="select">
											<option value="0">------请选择--------</option>
											<option value="1">id</option>
											<option value="2">姓名</option>
											<option value="3">部门</option>
										    </select>
									</td>
									<td><input type="text" name="text" /></td>
								</tr>
								<tr><td colspan="3" align="right"><input type="submit" name="" value="查询" /></td></tr>
							</table>
						</form>
						
							</td>
	           
	           
	           
	           
	           
	            </tr> 
	            <tr><td colspan="2"><%@ include file="end.jsp" %></td></tr>
	        </table>
	    </center>
	</body>
</html>