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
	              
	              <%
	          //String id = request.getParameter("id");   
		      // String name = request.getParameter("name");
		     // name = new String(name.getBytes("ISO-8859-1"),"UTF-8");
	         // String sex = request.getParameter("sex");
	         // sex = new String(sex.getBytes("ISO-8859-1"),"UTF-8");
	        //  String degree = request.getParameter("degree");
	        // degree = new String(degree.getBytes("ISO-8859-1"),"UTF-8");
	        // String deptName = request.getParameter("deptName");
	        // deptName = new String(deptName.getBytes("ISO-8859-1"),"UTF-8");
	         
	         // String posID = request.getParameter("posID");
	         //String tel = request.getParameter("tel"); 
	         
	         Employee employee=(Employee)request.getAttribute("employee");
	               %>
	              <form action="EmployeeServlet" method="get">
	              <input type="hidden" name="operate" value="update"/>
							<table border="0" width="94%" rules="none" cellspacing="0"
								cellpadding="8" style="margin-top:8px; border:1px dashed #666;">
								<tr><td>用户ID：</td>
	          		                <td><input type="text" name="id" value="<%=employee.getId() %>"readonly/></td></tr>
								<tr><td>姓名：</td>
	          		                <td><input type="text" name="name" value="<%=employee.getName() %>"/></td></tr>
	          		            <tr><td>性别：</td>
	          		                <td><input type="text" name="sex" value="<%=employee.getSex()%>"/></td></tr>
	          		                <tr><td>学历：</td>
	          		                <td><input type="text" name="degree" value="<%=employee.getDegree()%>"/></td></tr>
	          		                <tr><td>所属部门：</td>
	          		                <td><input type="text" name="deptName" value="<%=employee.getDeptName()%>"/></td></tr>
	          		                 <tr><td>职位编号：</td>
	          		                <td><input type="text" name="posID" value="<%=employee.getPosID()%>"/></td></tr>
	          		                 <tr><td>联系方式：</td>
	          		                <td><input type="text" name="tel" value="<%=employee.getTel()%>"/></td></tr>
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