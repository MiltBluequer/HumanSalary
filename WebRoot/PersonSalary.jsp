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
	           
	           
	            <%  ArrayList salaryList=(ArrayList)request.getAttribute("salaryList");
	            
	            Integer pageNS=(Integer)request.getAttribute("pageN");
	            int pageN;
	            if(pageNS!=null){
	            pageN=pageNS.intValue();
	            }else{
	            pageN=1;
	            }
	            
	            
	           if(salaryList==null){
	           response.sendRedirect("SalaryServlet?operate=personquery");
	           }else{
	           %>
	              
	           <td width="597" align="left" valign="top" bgcolor="#FFFFFW">
						<!-- 显示员工信息  -->
						<table border="0" width="94%" rules="none"  style="margin-top:8px">
							<tr><td>ID</td><td >月份</td><td >基本工资</td><td >罚金</td>
							<td>奖金</td><td>个人所得税</td><td>总工资</td></tr>
                            
							<tr height="1">
								<td background="images/line.jpg" colspan="6"></td>
							</tr>
							<!-- 在此处修改tr，td来通过java代码显示 员工信息 -->
							
							<%for (int i=0;i<salaryList.size();i++){
                             Salary salary=(Salary)salaryList.get(i);
                             %>
                            <tr>
                                <td><%=salary.getId()%></td>
								<td><%=salary.getMonthTime()%></td>
								<td><%=salary.getBasepay()%></td>
								<%int a= Integer.parseInt(salary.getBasepay());%>
								<td><%=salary.getFine()%></td>
								<%int b= Integer.parseInt(salary.getFine());%>
								<td><%=salary.getBonus()%></td>
								<%int c= Integer.parseInt(salary.getBonus());%>
								<td><%=salary.getIncomeTax()%></td>
								<%int d= Integer.parseInt(salary.getIncomeTax());
								int pay=a+b+c+d;%>
								<td><%=pay%></td>
								
							</tr>	
							<%}
							} %>
							<tr>
								<td colspan="6">
									&nbsp;
								</td>

							</tr>
							<tr><td colspan="6" align="right">
									<a href="#">首页</a>
									<a href="<%=pathx %>/SalaryServlet?operate=personquery&pageN=<%=pageN-1 %>">上一页</a>
									<a href="<%=pathx %>/SalaryServlet?operate=personquery&pageN=<%=pageN+1 %>">下一页</a>
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