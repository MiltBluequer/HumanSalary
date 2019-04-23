<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.ArrayList,nepu.edu.model.*"%>

<html>
	<head>
		<title>系统后台首页</title>
	</head>
	<body> 
	    <center>
	     <form action="RestServlet" method="get">
	        <table width="777" border="0" cellspacing="0" cellpadding="0" bgcolor="#FFFFFF" style="word-break:break-all">
	            <tr><td colspan="2"><%@ include file="top.jsp" %></td></tr>
	            <tr>
	                <td width="180" valign="top"><%@ include file="left.jsp" %></td>
	           
	           
	            <%  ArrayList restList=(ArrayList)request.getAttribute("restList");
	            
	             Integer pageNS=(Integer)request.getAttribute("pageN");
	            int pageN;
	            if(pageNS!=null){
	            pageN=pageNS.intValue();
	            }else{
	            pageN=1;
	            }
	            
	            
	           if(restList==null){
	           response.sendRedirect("RestServlet?operate=query");
	           }else{
	           %>
	              
	           <td width="597" align="left" valign="top" bgcolor="#FFFFFW">
						<!-- 显示员工信息  -->
						<table border="0" width="94%" rules="none"  style="margin-top:8px">
							<tr><td colspan="2" align="center">ID</td><td >日期</td><td >备注</td>
							<td colspan="2" align="center">操作</td></tr>
                            
							<tr height="1">
								<td background="images/line.jpg" colspan="6"></td>
							</tr>
							<!-- 在此处修改tr，td来通过java代码显示 员工信息 -->
							
							<%for (int i=0;i<restList.size();i++){
                             Rest rest=(Rest)restList.get(i);
                             %>
                            <tr>
                                <td><input type="checkbox" name ="ids" value="<%=rest.getId() %>"></td>
                                <td><%=rest.getId()%></td>
								<td><%=rest.getRestDate()%></td>
								<td><%=rest.getNote()%></td>
								<td><a href="<%=pathx %>/RestServlet?operate=frontupdate&id=<%=rest.getId()%>">修改</a></td>
                                <td><a href="RestServlet?id=<%=rest.getId()%>&operate=delete">删除</a></td>
							</tr>	
							<%}
							} %>
							<tr><td><input type="submit" value="批量删除"/>
							<input type="hidden" value="deleteAll" name="operate"/></td>
							</tr>
							<tr>
								<td colspan="10">
									&nbsp;
								</td>

							</tr>
							<tr><td colspan="10" align="right">
									<a href="#">首页</a>
									<a href="<%=pathx %>/RestServlet?operate=query&pageN=<%=pageN-1 %>">上一页</a>
									<a href="<%=pathx %>/RestServlet?operate=query&pageN=<%=pageN+1 %>">下一页</a>
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