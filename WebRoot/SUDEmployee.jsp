<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.ArrayList,nepu.edu.model.*"%>

<html>
	<head>
		<title>系统后台首页</title>
	</head>
	<body> 
	    <center>
	    <form action="EmployeeServlet" method="get">
	        <table width="777" border="0" cellspacing="0" cellpadding="0" bgcolor="#FFFFFF" style="word-break:break-all">
	            <tr><td colspan="2"><%@ include file="top.jsp" %></td></tr>
	            <tr>
	                <td width="180" valign="top"><%@ include file="left.jsp" %></td>
	           
	           
	            <%  ArrayList employeeList=(ArrayList)request.getAttribute("employeeList");
	            Integer pageNS=(Integer)request.getAttribute("pageN");
	            int pageN;
	            if(pageNS!=null){
	            pageN=pageNS.intValue();
	            }else{
	            pageN=1;
	            }
	            
	            
	           if(employeeList==null){
	           response.sendRedirect("EmployeeServlet?operate=query");
	           }else{
	           %>
	              
	           <td width="597" align="left" valign="top" bgcolor="#FFFFFW">
						<!-- 显示员工信息  -->
						<table border="0" width="94%" rules="none"  style="margin-top:8px">
							<tr><td colspan="2" align="right">ID</td><td >姓名</td><td >性别</td><td >学历</td>
							<td>所属部门</td><td>职位编号</td><td>联系方式</td><td colspan="2">操作</td></tr>
                            
							<tr height="1">
								<td background="images/line.jpg" colspan="10"></td>
							</tr>
							<!-- 在此处修改tr，td来通过java代码显示 员工信息 -->
							
							<%for (int i=0;i<employeeList.size();i++){
                             Employee employee=(Employee)employeeList.get(i);
                             %>
                            <tr>
                                <td><input type="checkbox" name ="ids" value="<%=employee.getId() %>"></td>
                                <td><%=employee.getId()%></td>
								<td><%=employee.getName()%></td>
								<td><%=employee.getSex()%></td>
								<td><%=employee.getDegree()%></td>
								<td><%=employee.getDeptName()%></td>
								<td><%=employee.getPosID()%></td>
								<td><%=employee.getTel()%></td>
								<td><a href="<%=pathx %>/EmployeeServlet?operate=frontupdate&id=<%=employee.getId()%>">修改</a></td>
                                <td><a href="EmployeeServlet?id=<%=employee.getId()%>&operate=delete">删除</a></td>
							</tr>	
							
							<%}
							} %>
							<tr><td><input type="submit" value="批量删除"/>
							        <input type="hidden" value="deleteAll" name="operate"/>
							</td>   
							</tr>
							
							<tr>
								<td colspan="10">
									&nbsp;
								</td>

							</tr>
							<tr><td colspan="10" align="right">
									<a href="#">首页</a>
									<a href="<%=pathx %>/EmployeeServlet?operate=query&pageN=<%=pageN-1 %>">上一页</a>
									<a href="<%=pathx %>/EmployeeServlet?operate=query&pageN=<%=pageN+1 %>">下一页</a>
									<a href="#">尾页</a>
								</td>

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