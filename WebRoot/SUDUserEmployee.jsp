<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.ArrayList,nepu.edu.model.*"%>

<html>
	<head>
		<title>系统后台首页</title>
	</head>
	<body> 
	    <center>
	    <form action="UserServlet" method="get">
	        <table width="777" border="0" cellspacing="0" cellpadding="0" bgcolor="#FFFFFF" style="word-break:break-all">
	            <tr><td colspan="2"><%@ include file="top.jsp" %></td></tr>
	            <tr>
	                <td width="180" valign="top"><%@ include file="left.jsp" %></td>
	           
	           
	            <%  ArrayList userList=(ArrayList)request.getAttribute("userList");
	           if(userList==null){
	           response.sendRedirect("UserServlet?operate=queryEmployee");
	           }else{
	           %>
	              
	           <td width="597" align="left" valign="top" bgcolor="#FFFFFW">
						<!-- 显示员工信息  -->
						<table border="0" width="94%" rules="none"  style="margin-top:8px">
							<tr><td colspan="2" align="right">ID</td><td >密码</td><td >姓名</td><td >年龄</td>
							<td>地址</td><td>邮箱</td><td colspan="2">操作</td></tr>
                            
							<tr height="1">
								<td background="images/line.jpg" colspan="10"></td>
							</tr>
							<!-- 在此处修改tr，td来通过java代码显示 员工信息 -->
							
							<%for (int i=0;i<userList.size();i++){
                             UserAdmin userAdmin=(UserAdmin)userList.get(i);
                             %>
                            <tr>
                                <td><input type="checkbox" name ="ids" value="<%=userAdmin.getId() %>"></td>
                                <td><%=userAdmin.getId()%></td>
								<td><%=userAdmin.getPsw()%></td>
								<td><%=userAdmin.getName()%></td>
								<td><%=userAdmin.getAge()%></td>
								<td><%=userAdmin.getAddress()%></td>
								<td><%=userAdmin.getMail()%></td>

								<td><a href="<%=pathx %>/UserServlet?operate=frontupdateEmployee&id=<%=userAdmin.getId()%>">修改</a></td>
                                <td><a href="UserServlet?id=<%=userAdmin.getId()%>&operate=deleteEmployee">删除</a></td>
							</tr>	
							<%}
							} %>
							<tr><td><input type="submit" value="批量删除"/>
							<input type="hidden" value="deleteEmployeeAll" name="operate"/></td></tr>
							<tr>
								<td colspan="10">
									&nbsp;
								</td>

							</tr>
							<tr>

							</tr>
						</table>
					</td>

	            </tr> 
	            <tr><td colspan="2"><%@ include file="end.jsp" %></td></tr>
	        </table>
	        </form>
	    </center>
	</body>
</html>
