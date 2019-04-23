package nepu.edu.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import nepu.edu.DAO.EmployeeDAO;
import nepu.edu.DAO.UserDAO;
import nepu.edu.model.Employee;
import nepu.edu.model.UserAdmin;

public class UserServlet extends HttpServlet {

	/** 
	 */
	public UserServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String operate=request.getParameter("operate");
		String type=request.getParameter("type");
		if(operate.equals("ChangePswAdmin"))
			this.doChangePswAdmin(request, response);

		if(operate.equals("ChangePswEmployee"))
			this.doChangePswEmployee(request, response);
		if(operate.equals("login")){
		this.doLogin(request, response);
		}else if(operate.equals("add")){
			if(type.equals("0"))
			this.doAddAdmin(request, response);
			else if(type.equals("1"))
				this.doAddEmployee(request, response);
		}else if(operate.equals("queryAdmin")){
			this.doQueryAdmin(request, response);
		}else if(operate.equals("queryEmployee")){
			this.doQueryEmployee(request, response);
		}else if(operate.equals("frontupdateAdmin")){
		    this.doFrontUpdateAdmin(request, response);
	 }else if(operate.equals("updateAdmin")){
	    this.doUpdateAdmin(request, response);	 
	 }else if(operate.equals("deleteAdmin")){
		 this.doDeleteAdmin(request, response);
	 }else if(operate.equals("deleteAdminAll")){
		 this.doDeleteAdminAll(request, response);
	 }else if(operate.equals("frontupdateEmployee")){
		    this.doFrontUpdateEmployee(request, response);
	 }else if(operate.equals("updateEmployee")){
	    this.doUpdateEmployee(request, response);	
	 }else if(operate.equals("deleteEmployee")){
		    this.doDeleteEmployee(request, response);
	 }else if(operate.equals("deleteEmployeeAll")){
		    this.doDeleteEmployeeAll(request, response);
	    
	 } 
	}
	
	public void doDeleteAdminAll(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
		String[] id=request.getParameterValues("ids");
		UserDAO userDAO = new UserDAO();	
	       boolean t = userDAO.deleteAdminAll(id);   
	    	   this.doQueryAdmin(request, response);   	
	}
	
	public void doDeleteEmployeeAll(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
		String[] id=request.getParameterValues("ids");
		UserDAO userDAO = new UserDAO();	
	       boolean t = userDAO.deleteEmployeeAll(id);   
	    	   this.doQueryEmployee(request, response);   	
	}
	
	public void doChangePswEmployee(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
		
		String id = request.getParameter("id");
		String psw = request.getParameter("psw");
		String psw1 = request.getParameter("psw1");
		String psw2 = request.getParameter("psw2");

		UserDAO userDAO = new UserDAO();
		boolean t=false;
		RequestDispatcher rd=null;
		
		if(psw1.equals(psw2)){

			t=userDAO.employeeLogin(id,psw);
			if(t==true)  {
			
				UserAdmin userAdmin=new UserAdmin();
				   userAdmin.setId(id);
				   userAdmin.setPsw(psw1);
			       boolean x = userDAO.updatePswEmployee(userAdmin);   
			       if(x==true){
			    	   response.sendRedirect("index.jsp");  
			       }else{
			    	   response.sendRedirect("ChangePswEmployee.jsp");
			       }					
			}
				else{
					request.setAttribute("mess2", "您输入的用户名或密码有误！请您重新输入！");
				    rd = request.getRequestDispatcher("ChangePswEmployee.jsp");
					rd.forward(request, response);	
				    }	
		}else{
			request.setAttribute("mess1", "两次密码输入不一致！");
		    rd = request.getRequestDispatcher("ChangePswEmployee.jsp");
			rd.forward(request, response);		
		}
		
	}
	
	public void doChangePswAdmin(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String psw = request.getParameter("psw");
		String psw1 = request.getParameter("psw1");
		String psw2 = request.getParameter("psw2");

		UserDAO userDAO = new UserDAO();
		boolean t=false;
		RequestDispatcher rd=null;
		
		if(psw1.equals(psw2)){

			t=userDAO.adminLogin(id,psw);
			if(t==true)  {
			
				UserAdmin userAdmin=new UserAdmin();
				   userAdmin.setId(id);
				   userAdmin.setPsw(psw1);
			       boolean x = userDAO.updatePswAdmin(userAdmin);   
			       if(x==true){
			    	   response.sendRedirect("index.jsp");  
			       }else{
			    	   response.sendRedirect("ChangePswAdmin.jsp");
			       }					
			}
				else{
					request.setAttribute("mess2", "您输入的用户名或密码有误！请您重新输入！");
				    rd = request.getRequestDispatcher("ChangePswAdmin.jsp");
					rd.forward(request, response);	
				    }	
		}else{
			request.setAttribute("mess1", "两次密码输入不一致！");
		    rd = request.getRequestDispatcher("ChangePswAdmin.jsp");
			rd.forward(request, response);		
		}
		
	}
	public void doFrontUpdateAdmin(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
		String id=request.getParameter("id");
		UserDAO userDAO=new UserDAO();
		UserAdmin userAdmin=userDAO.queryAdminByID(id);
		request.setAttribute("userAdmin", userAdmin);
		RequestDispatcher rd = request.getRequestDispatcher("UpdateUserAdmin.jsp");
		rd.forward(request, response);
	}
	
	public void doFrontUpdateEmployee(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
		String id=request.getParameter("id");
		UserDAO userDAO=new UserDAO();
		UserAdmin userAdmin=userDAO.queryEmployeeByID(id);
		request.setAttribute("userAdmin", userAdmin);
		RequestDispatcher rd = request.getRequestDispatcher("UpdateUserEmployee.jsp");
		rd.forward(request, response);
	}
	
	
	public void doUpdateAdmin(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
		
		   String id = request.getParameter("id");   
		   String psw = request.getParameter("psw");
	       psw = new String(psw.getBytes("iso-8859-1"),"UTF-8");
	       String name = request.getParameter("name");
	       name = new String(name.getBytes("iso-8859-1"),"UTF-8");
	       String age = request.getParameter("degree");
	       String address = request.getParameter("address");
	       address = new String(address.getBytes("iso-8859-1"),"UTF-8");
	       String mail = request.getParameter("mail");

		   UserDAO userDAO = new UserDAO();	
		   UserAdmin userAdmin=new UserAdmin();
		   userAdmin.setId(id);
		   userAdmin.setPsw(psw);
		   userAdmin.setName(name);
		   userAdmin.setAge(age);
		   userAdmin.setAddress(address);
		   userAdmin.setMail(mail);
	      
	       boolean t = userDAO.updateAdmin(userAdmin);   
	       if(t==true){
	    	   this.doQueryAdmin(request, response);   
	       }else{
	    	   response.sendRedirect("UpdateUserAdmin.jsp");
	       }	
	}
	
	public void doUpdateEmployee(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		System.out.print("进入了修改员工方法");
		   String id = request.getParameter("id");   
		   String psw = request.getParameter("psw");
	       psw = new String(psw.getBytes("iso-8859-1"),"UTF-8");
	       String name = request.getParameter("name");
	       name = new String(name.getBytes("iso-8859-1"),"UTF-8");
	       String age = request.getParameter("age");
	       String address = request.getParameter("address");
	       address = new String(address.getBytes("iso-8859-1"),"UTF-8");
	       String mail = request.getParameter("mail");

		   UserDAO userDAO = new UserDAO();	
		   UserAdmin userAdmin=new UserAdmin();
		   userAdmin.setId(id);
		   userAdmin.setPsw(psw);
		   userAdmin.setName(name);
		   userAdmin.setAge(age);
		   userAdmin.setAddress(address);
		   userAdmin.setMail(mail);
	      
	       boolean t = userDAO.updateEmployee(userAdmin);   
	       if(t==true){
	    	   this.doQueryEmployee(request, response);   
	       }else{
	    	   response.sendRedirect("UpdateUserEmployee.jsp");
	       }	
	}
	
	public void doDeleteAdmin(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
		String id=request.getParameter("id");
		UserDAO userDAO = new UserDAO();	
		   UserAdmin userAdmin=new UserAdmin();
	       userAdmin.setId(id);
	       boolean t = userDAO.deleteAdmin(userAdmin);   
	    	   this.doQueryAdmin(request, response);   	
	}
	
	public void doDeleteEmployee(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
		String id=request.getParameter("id");
		UserDAO userDAO = new UserDAO();	
		   UserAdmin userAdmin=new UserAdmin();
	       userAdmin.setId(id);
	       boolean t = userDAO.deleteEmployee(userAdmin);   
	    	   this.doQueryEmployee(request, response);   	
	}
    
	public void doQueryAdmin(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
		UserDAO userDAO = new UserDAO();
		ArrayList userList=userDAO.getUserAdminArrayList();
		request.setAttribute("userList", userList);
		RequestDispatcher rd = request.getRequestDispatcher("SUDUserAdmin.jsp");
		rd.forward(request, response);
	}
	
	public void doQueryEmployee(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		UserDAO userDAO = new UserDAO();
		ArrayList userList=userDAO.getUserEmployeeArrayList();
		request.setAttribute("userList", userList);
		RequestDispatcher rd = request.getRequestDispatcher("SUDUserEmployee.jsp");
		rd.forward(request, response);
	}
	
	public void doAddAdmin(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
		   String id = request.getParameter("id");   
		   String name = request.getParameter("name");
	       name = new String(name.getBytes("iso-8859-1"),"UTF-8");
	       String psw = request.getParameter("psw");
	       psw = new String(psw.getBytes("iso-8859-1"),"UTF-8");
	       String age = request.getParameter("age");
	       String address = request.getParameter("address");
	       address = new String(address.getBytes("iso-8859-1"),"UTF-8");
	       String mail = request.getParameter("mail");
	       
	       UserDAO userDAO = new UserDAO();
	       UserAdmin userAdmin=new UserAdmin();
	       userAdmin.setId(id);
	       userAdmin.setName(name);
	       userAdmin.setPsw(psw);
	       userAdmin.setAge(age);
	       userAdmin.setAddress(address);
	       userAdmin.setMail(mail);
	       
	       boolean t = userDAO.addUserAdmin(userAdmin);   
	       if(t==true){
	    	   this.doQueryAdmin(request, response);   
	       }else{
	    	   response.sendRedirect("AddUser.jsp");
	       }
	}
	
	public void doAddEmployee(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
		
		String id = request.getParameter("id");   
		   String name = request.getParameter("name");
	       name = new String(name.getBytes("iso-8859-1"),"UTF-8");
	       String psw = request.getParameter("psw");
	       psw = new String(psw.getBytes("iso-8859-1"),"UTF-8");
	       String age = request.getParameter("age");
	       String address = request.getParameter("address");
	       address = new String(address.getBytes("iso-8859-1"),"UTF-8");
	       String mail = request.getParameter("mail");
	       
	       UserDAO userDAO = new UserDAO();
	       UserAdmin userAdmin=new UserAdmin();
	       userAdmin.setId(id);
	       userAdmin.setName(name);
	       userAdmin.setPsw(psw);
	       userAdmin.setAge(age);
	       userAdmin.setAddress(address);
	       userAdmin.setMail(mail);
	       
	       boolean t = userDAO.addUserEmployee(userAdmin);   
	       if(t==true){
	    	   this.doQueryEmployee(request, response);   
	       }else{
	    	   response.sendRedirect("AddUser.jsp");
	       }
		
	}
	
	
	
	public void doLogin(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String psw = request.getParameter("psw");
		String userType = request.getParameter("userType");
		UserDAO userDAO = new UserDAO();
		boolean t=false;
	    RequestDispatcher rd=null;

		if(userType.equals("0")){
		t=userDAO.adminLogin(id,psw);
		if(t==true)  {
			
			HttpSession session = request.getSession();
			session.setAttribute("id", id);
			
			rd=request.getRequestDispatcher("AdminIndex.jsp");
		    rd.forward(request, response);	}
			else{
				request.setAttribute("mess", "您输入的用户名或密码有误！请您重新输入！");
			    rd = request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);	
			    }
		}
		if(userType.equals("1")) {
		t=userDAO.employeeLogin(id,psw);

			if(t==true)  
				{
				HttpSession session = request.getSession();
				session.setAttribute("id", id);
				
				rd=request.getRequestDispatcher("EmployeeIndex.jsp");
				 rd.forward(request, response);
				}
			else{
				request.setAttribute("mess", "您输入的用户名或密码有误！请您重新输入！");
			    rd = request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);		
			}
	    }
		//if(t==true){
			//HttpSession session = request.getSession();
			//session.setAttribute("user", name);
			//response.sendRedirect("success.jsp");
	}
		
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occure
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}

