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

import nepu.edu.DAO.SalaryDAO;
import nepu.edu.model.Salary;


public class SalaryServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public SalaryServlet() {
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
		 if(operate.equals("query")){
			 this.doQuery(request, response); 
		 }else if(operate.equals("personquery")){
			 this.doPersonQuery(request, response);
		 }else if(operate.equals("addbonus")){
			 this.doAddBonus(request, response);
		 }else if(operate.equals("addfine")){
			 this.doAddFine(request, response);
		 } 
	}
	
	public void doQuery(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
		SalaryDAO salaryDAO = new SalaryDAO();
		
		String pageNS=request.getParameter("pageN");
	    int pageN=1;
	    int pageSize=3;
	    if(pageNS!=null){
	    	 pageN=Integer.parseInt(pageNS);
        }else{
        pageN=1;
        }
	    
		ArrayList salaryList=salaryDAO.getSalaryArrayListDivPage(pageN,pageSize);
		request.setAttribute("salaryList", salaryList);
		
		request.setAttribute("pageN", pageN);
		
		RequestDispatcher rd = request.getRequestDispatcher("QuerySalary.jsp");
		rd.forward(request, response);
	}
	
	public void doPersonQuery(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
		SalaryDAO salaryDAO = new SalaryDAO();
		
		String pageNS=request.getParameter("pageN");
	    int pageN=1;
	    int pageSize=3;
	    if(pageNS!=null){
	    	 pageN=Integer.parseInt(pageNS);
        }else{
        pageN=1;
        }
	    
		ArrayList salaryList=salaryDAO.getSalaryArrayListDivPage(pageN,pageSize);
		request.setAttribute("salaryList", salaryList);
		
		request.setAttribute("pageN", pageN);
		RequestDispatcher rd = request.getRequestDispatcher("PersonSalary.jsp");
		rd.forward(request, response);
	}
	
	public void doAddBonus(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
		   String id = request.getParameter("id");   
	       String monthTime = request.getParameter("monthTime");
	       String bonus = request.getParameter("bonus");  
	       SalaryDAO salaryDAO = new SalaryDAO();
	       Salary salary=new Salary();
	       salary.setId(id);
	       salary.setMonthTime(monthTime);
	       salary.setBonus(bonus);
	       boolean t = salaryDAO.addBonus(salary);   
	       boolean x=salaryDAO.isexit(id,monthTime); 
	       RequestDispatcher rd=null;
	       if(x==true)  {
	    	   if(t==true){
		    	   this.doQuery(request, response);   
		       }else{
		    	   response.sendRedirect("AddSalary.jsp");
		       }
					}
				else{
					request.setAttribute("mess", "没有这个人！且还录入该月份基本工资！");
				    rd = request.getRequestDispatcher("AddSalary.jsp");
					rd.forward(request, response);	
				    }
			}
	
	public void doAddFine(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
		
		   String id = request.getParameter("id");   
	       String monthTime = request.getParameter("monthTime");
	       String fine = request.getParameter("fine");  
	       SalaryDAO salaryDAO = new SalaryDAO();
	       Salary salary=new Salary();
	       salary.setId(id);
	       salary.setMonthTime(monthTime);
	       salary.setFine(fine);
	       boolean t = salaryDAO.addFine(salary);    
	       boolean x=salaryDAO.isexit(id,monthTime); 
	       RequestDispatcher rd=null;
	       if(x==true)  {
	    	   if(t==true){
		    	   this.doQuery(request, response);   
		       }else{
		    	   response.sendRedirect("DownSalary.jsp");
		       }
					}
				else{
					request.setAttribute("mess", "没有这个人或未录入该月份基本工资！");
				    rd = request.getRequestDispatcher("AddSalary.jsp");
					rd.forward(request, response);	
				    }
		
		
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
