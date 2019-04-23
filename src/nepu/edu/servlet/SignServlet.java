package nepu.edu.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nepu.edu.DAO.EmployeeDAO;
import nepu.edu.DAO.SignDAO;
import nepu.edu.model.Sign;

public class SignServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public SignServlet() {
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
		 }else if(operate.equals("update")){
			 this.doUpdate(request, response);
			 }
		
	}

	public void doQuery(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
		String id=request.getParameter("id");
		SignDAO signDAO = new SignDAO();
		ArrayList signList=signDAO.getSignArrayList(id);
		request.setAttribute("signList", signList);
		RequestDispatcher rd = request.getRequestDispatcher("SignRecord.jsp");
		rd.forward(request, response);
		
	}

	public void doUpdate(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		   String id = request.getParameter("id");   
		   String date = request.getParameter("date");
	       String sign = request.getParameter("sign");
	       sign = new String(sign.getBytes("iso-8859-1"),"UTF-8");
		   SignDAO signDAO = new SignDAO();	
		   Sign signmodel=new Sign();
	       signmodel.setId(id);
	       signmodel.setDate(date);
	       signmodel.setSign(sign);
	       boolean t = signDAO.updateSign(signmodel);   
	       if(t==true){
	    	   response.sendRedirect("EmployeeIndex.jsp");   
	       }else{
	    	   response.sendRedirect("PersonSign.jsp");
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
