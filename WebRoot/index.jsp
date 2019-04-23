<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body background="1.jpg">
     <br/><br/>
     <h1 align="center"><font face="楷体" color="black">欢迎进入人事工资系统</font></h1>
     <%
      String mess = (String)request.getAttribute("mess");
      if(mess!=null)
      {
   %>
   <h5><%=mess %></h5>
   <%} %>
    <center>
    <br/><br/><br/><br/><br/><br/><br/><br/>
     <form  action="UserServlet" method="get" >
     <input type="hidden" name="operate" value="login"/>
	      	<table border="0">
	      	<tr>
	          		<td>用户类别：</td>
	          		<td><input type="radio" name="userType" value="0"/>管理员 &nbsp;&nbsp;&nbsp;&nbsp;
	          		<input type="radio" name="userType" value="1"/>员工</td>
	        	</tr>
	        	<tr>
	          		<td>用户ID：</td>
	          		<td><input type="text" name="id"/></td>
	        	</tr>
	        	<tr>
	         		 <td>密码：</td>
	         		 <td><input type="password" name="psw"/></td>
	        	</tr> 
	        	<tr>
					<td></td>
	          		<td>
						<input type="submit" value="登录">&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;
						<input type="reset"  value="重置">	
	          		</td>
	        	</tr>
	      	</table>
	    </form>
	   <script>
	
	   </script> 
    </center>

  </body>
</html>
