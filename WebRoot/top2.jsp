<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<html>
    <head>
    	<title>系统后台——页头</title>	   
    	<%String pathX = request.getContextPath();%> 
    	<link type="text/css" rel="stylesheet" href="<%=pathX %>/css/style_admin.css">	 	
    </head>
	<body background="<%=pathX %>/images/4.jpg">
	    <table width="100%" height="89" border="0" cellpadding="0" cellspacing="0" >
	        <tr>
	          <td height="65" colspan="2" background="<%=pathX %>/images/02.jpg">&nbsp;</td>
	        </tr>
	        <tr>
	          <td width="98%" height="24" align="right" bgcolor="#40aa70" class="word_white " style="background-color: rgb(187, 223, 168);">
	             <a href="<%=pathX %>/ChangePswEmployee.jsp" class="topA">【修改密码】</a>
		       	  <a href="<%=pathX %>/index.jsp" class="topA">【退出登录】</a>
	          </td>
	          <td width="2%" align="right" bgcolor="#40aa70" style="background-color: rgb(187, 223, 168);">&nbsp;</td>
	        </tr>
		</table> 
	</body>
</html>
