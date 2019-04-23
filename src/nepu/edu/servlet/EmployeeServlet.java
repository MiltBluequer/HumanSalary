package nepu.edu.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nepu.edu.DAO.EmployeeDAO;
import nepu.edu.model.Employee;

public class EmployeeServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public EmployeeServlet() {
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
        
		String operate = request.getParameter("operate");
		
		String select = request.getParameter("select"); 
		 if(operate.equals("query")){
			 this.doQuery(request, response); 
		 }else if(operate.equals("personquery")){
			 this.doPersonQuery(request, response);
		 }else if(operate.equals("querybyIND")){
			 if(select.equals("1")) this.doQuerybyID(request, response);
			 if(select.equals("2")) this.doQuerybyName(request, response);
			 if(select.equals("3")) this.doQuerybydept(request, response);
		 }else if(operate.equals("add")){
			 this.doAdd(request, response);
		 }else if(operate.equals("frontupdate")){
			    this.doFrontUpdate(request, response);
		 }else if(operate.equals("update")){
		    this.doUpdate(request, response);	 
		 }else if(operate.equals("delete")){
			 this.doDelete(request, response);
		 }else if(operate.equals("deleteAll")){
			 this.doDeleteAll(request, response);
		 } 
	}
	
	
	public void doDeleteAll(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
		String[] id=request.getParameterValues("ids");
		EmployeeDAO employeeDAO = new EmployeeDAO();	
	       boolean t = employeeDAO.deleteEmployeeAll(id);   
	    	   this.doQuery(request, response);   	
	}
	
	public void doFrontUpdate(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
		String id=request.getParameter("id");
		EmployeeDAO employeeDAO=new EmployeeDAO();
		Employee employee=employeeDAO.queryEmployeeByID(id);
		request.setAttribute("employee", employee);
		RequestDispatcher rd = request.getRequestDispatcher("UpdateEmployee.jsp");
		rd.forward(request, response);
	}
	
	
	

	public void doQuery(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
		    EmployeeDAO employeeDAO = new EmployeeDAO();
		    
		    
		    String pageNS=request.getParameter("pageN");
		    int pageN=1;
		    int pageSize=3;
		    if(pageNS!=null){
		    	 pageN=Integer.parseInt(pageNS);
            }else{
            pageN=1;
            }
		    
		    
			ArrayList employeeList=employeeDAO.getEmloyeeArrayListDivPage(pageN,pageSize);
			request.setAttribute("employeeList", employeeList);
			
			request.setAttribute("pageN", pageN);
			
			RequestDispatcher rd = request.getRequestDispatcher("SUDEmployee.jsp");
			rd.forward(request, response);
	}
	
	public void doPersonQuery(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
		    EmployeeDAO employeeDAO = new EmployeeDAO();
		    
		    String pageNS=request.getParameter("pageN");
		    int pageN=1;
		    int pageSize=3;
		    if(pageNS!=null){
		    	 pageN=Integer.parseInt(pageNS);
            }else{
            pageN=1;
            }
		    
		    
		    
			ArrayList employeeList=employeeDAO.getEmloyeeArrayListDivPage(pageN,pageSize);
			request.setAttribute("employeeList", employeeList);
			RequestDispatcher rd = request.getRequestDispatcher("PersonMessage.jsp");
			rd.forward(request, response);
	}
   
	public void doQuerybyID(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
	    
		System.out.print("进入了BYID方法");
		String text = request.getParameter("text");
		System.out.print(text);
		text = new String(text.getBytes("iso-8859-1"),"UTF-8");
        EmployeeDAO employeeDAO = new EmployeeDAO();
		ArrayList employeeList=employeeDAO.getEmloyeebyIDArrayList(text);
		request.setAttribute("employeeList", employeeList);
		RequestDispatcher rd = request.getRequestDispatcher("SelectEmployee.jsp");
		rd.forward(request, response);
	}
	
	public void doQuerybyName(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
	    
		String text = request.getParameter("text");
		text = new String(text.getBytes("iso-8859-1"),"UTF-8");
        EmployeeDAO employeeDAO = new EmployeeDAO();
		ArrayList employeeList=employeeDAO.getEmloyeebyNameArrayList(text);
		request.setAttribute("employeeList", employeeList);
		RequestDispatcher rd = request.getRequestDispatcher("SelectEmployee.jsp");
		rd.forward(request, response);
	}
	
	public void doQuerybydept(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
	
		String text = request.getParameter("text");
		text = new String(text.getBytes("iso-8859-1"),"UTF-8");
        EmployeeDAO employeeDAO = new EmployeeDAO();
		ArrayList employeeList=employeeDAO.getEmloyeebyDeptArrayList(text);
		request.setAttribute("employeeList", employeeList);
		RequestDispatcher rd = request.getRequestDispatcher("SelectEmployee.jsp");
		rd.forward(request, response);
	}
	
	public void doAdd(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
	
		   String id = request.getParameter("id");   
		   String name = request.getParameter("name");
	       name = new String(name.getBytes("iso-8859-1"),"UTF-8");
	       String sex = request.getParameter("sex");
	       sex = new String(sex.getBytes("iso-8859-1"),"UTF-8");
	       String degree = request.getParameter("degree");
	       degree = new String(degree.getBytes("iso-8859-1"),"UTF-8");
	       String deptName = request.getParameter("deptName");
	       deptName = new String(deptName.getBytes("iso-8859-1"),"UTF-8");
	       String posID = request.getParameter("posID");
	       String tel = request.getParameter("tel");  
	       EmployeeDAO employeeDAO = new EmployeeDAO();
	       Employee employee=new Employee();
	       employee.setId(id);
	       employee.setName(name);
	       employee.setSex(sex);
	       employee.setDegree(degree);
	       employee.setDeptName(deptName);
	       employee.setPosID(posID);
	       employee.setTel(tel);
	       boolean t = employeeDAO.addEmployee(employee);   
	       if(t==true){
	    	   this.doQuery(request, response);   
	       }else{
	    	   response.sendRedirect("AddEmployee.jsp");
	       }
	}
	
	public void doUpdate(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		   String id = request.getParameter("id");   
		   String name = request.getParameter("name");
	       name = new String(name.getBytes("iso-8859-1"),"UTF-8");
	       String sex = request.getParameter("sex");
	       sex = new String(sex.getBytes("iso-8859-1"),"UTF-8");
	       String degree = request.getParameter("degree");
	       degree = new String(degree.getBytes("iso-8859-1"),"UTF-8");
	       String deptName = request.getParameter("deptName");
	       deptName = new String(deptName.getBytes("iso-8859-1"),"UTF-8");
	       String posID = request.getParameter("posID");
	       String tel = request.getParameter("tel"); 
		   EmployeeDAO employeeDAO = new EmployeeDAO();	
		   Employee employee=new Employee();
	       employee.setId(id);
	       employee.setName(name);
	       employee.setSex(sex);
	       employee.setDegree(degree);
	       employee.setDeptName(deptName);
	       employee.setPosID(posID);
	       employee.setTel(tel);
	       boolean t = employeeDAO.updateEmployee(employee);   
	       if(t==true){
	    	   this.doQuery(request, response);   
	       }else{
	    	   response.sendRedirect("UpdateEmployee.jsp");
	       }	
	}
	
	public void doDelete(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
		String id=request.getParameter("id");
		EmployeeDAO employeeDAO = new EmployeeDAO();	
		   Employee employee=new Employee();
	       employee.setId(id);
	       boolean t = employeeDAO.deleteEmployee(employee);   
	    	   this.doQuery(request, response);   	
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

