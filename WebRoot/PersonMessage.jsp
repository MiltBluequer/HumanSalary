<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.ArrayList,nepu.edu.model.*"%>

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
	           
	           
	            <%  ArrayList employeeList=(ArrayList)request.getAttribute("employeeList");
	            
	             Integer pageNS=(Integer)request.getAttribute("pageN");
	            int pageN;
	            if(pageNS!=null){
	            pageN=pageNS.intValue();
	            }else{
	            pageN=1;
	            }
	            
	            
	           if(employeeList==null){
	           response.sendRedirect("EmployeeServlet?operate=personquery");
	           }else{
	           %>
	              
	           <td width="597" align="left" valign="top" bgcolor="#FFFFFW">
						<!-- 显示员工信息  -->
						<table border="0" width="94%" rules="none"  style="margin-top:8px">
							<tr><td>ID</td><td >姓名</td><td >性别</td><td >学历</td>
							<td>所属部门</td><td>职位编号</td><td>联系方式</td></tr>
                            
							<tr height="1">
								<td background="images/line.jpg" colspan="7"></td>
							</tr>
							<!-- 在此处修改tr，td来通过java代码显示 员工信息 -->
							
							<%for (int i=0;i<employeeList.size();i++){
                             Employee employee=(Employee)employeeList.get(i);
                             %>
                            <tr>
                                <td><%=employee.getId()%></td>
								<td><%=employee.getName()%></td>
								<td><%=employee.getSex()%></td>
								<td><%=employee.getDegree()%></td>
								<td><%=employee.getDeptName()%></td>
								<td><%=employee.getPosID()%></td>
								<td><%=employee.getTel()%></td>
							</tr>	
							<%}
							} %>
							<tr>
								<td colspan="7">
									&nbsp;
								</td>

							</tr>
							<tr><td colspan="7" align="right">
									<a href="#">首页</a>
									<a href="<%=pathx %>/EmployeeServlet?operate=personquery&pageN=<%=pageN-1 %>">上一页</a>
									<a href="<%=pathx %>/EmployeeServlet?operate=personquery&pageN=<%=pageN+1 %>">下一页</a>
									<a href="#">尾页</a>
								</td>

							</tr>
						</table>
					</td>

	            </tr> 
	            <tr><td colspan="2"><%@ include file="end.jsp" %></td></tr>
	        </table>
	    </center>
	</body>
</html>