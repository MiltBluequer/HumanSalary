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
	           
	           
	            <%  ArrayList signList=(ArrayList)request.getAttribute("signList");
	           if(signList==null){
	           response.sendRedirect("SignServlet");
	           }else{
	           %>
	              
	           <td width="597" align="left" valign="top" bgcolor="#FFFFFW">
						<!-- 显示员工信息  -->
						<table border="0" width="94%" rules="none"  style="margin-top:8px">
					<tr><td >编号</td><td >日期</td><td>月份</td></tr>
                            
							<tr height="1">
								<td background="images/line.jpg" colspan="4"></td>
							</tr>
							<!-- 在此处修改tr，td来通过java代码显示 员工信息 -->
							
							<%for (int i=0,j=0;i<signList.size();i++){
                             Sign signmodel=(Sign)signList.get(i);
                             %>
                            <tr>
                            <%j++; %>
                            <td><%=j%></td>
								<td><%=signmodel.getDate()%></td>
								<td><%=signmodel.getSign()%></td>
							</tr>	
							<%}
							} %>
							<tr>
								<td colspan="4">
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
	    </center>
	</body>
</html>
