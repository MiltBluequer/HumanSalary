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
import nepu.edu.DAO.RestDAO;
import nepu.edu.model.Employee;
import nepu.edu.model.Rest;


public class RestServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public RestServlet() {
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
		 }else if(operate.equals("add")){
			 this.doAdd(request, response);
		 }else if(operate.equals("update")){
		    this.doUpdate(request, response);	
		 }else if(operate.equals("frontupdate")){
			    this.doFrontUpdate(request, response);
		 }else if(operate.equals("delete")){
			 this.doDelete(request, response);
		 }else if(operate.equals("deleteAll")){
			 this.doDeleteAll(request, response);
		 } 
	}
	
	
	public void doDeleteAll(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
		String[] id=request.getParameterValues("ids");
		RestDAO restDAO = new RestDAO();	
	       boolean t = restDAO.deleteRestAll(id);   
	    	   this.doQuery(request, response);   	
	}
	
	public void doFrontUpdate(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
		String id=request.getParameter("id");
		RestDAO restDAO=new RestDAO();
		Rest rest=restDAO.queryRestByID(id);
		request.setAttribute("rest", rest);
		RequestDispatcher rd = request.getRequestDispatcher("UpdateRest.jsp");
		rd.forward(request, response);
	}

	public void doQuery(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

		RestDAO restDAO = new RestDAO();
		
		String pageNS=request.getParameter("pageN");
	    int pageN=1;
	    int pageSize=3;
	    if(pageNS!=null){
	    	 pageN=Integer.parseInt(pageNS);
        }else{
        pageN=1;
        }
		
		
		ArrayList restList=restDAO.getRestArrayListDivPage(pageN,pageSize);
		request.setAttribute("restList", restList);
		
		request.setAttribute("pageN", pageN);
		RequestDispatcher rd = request.getRequestDispatcher("SUDRest.jsp");
		rd.forward(request, response);
	}
	
	public void doAdd(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
		   String id = request.getParameter("id");   
	       String restDate = request.getParameter("restDate");
	       String note = request.getParameter("note");
	       note = new String(note.getBytes("iso-8859-1"),"UTF-8");  
	       RestDAO restDAO = new RestDAO();
	       Rest rest=new Rest();
	       rest.setId(id);
	       rest.setRestDate(restDate);
	       rest.setNote(note);
	       boolean t = restDAO.addRest(rest);   
	       if(t==true){
	    	   this.doQuery(request, response);   
	       }else{
	    	   response.sendRedirect("AddRest.jsp");
	       }
	}
	
	public void doUpdate(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
		   String id = request.getParameter("id");   
		   String restDate = request.getParameter("restDate");
	       String note = request.getParameter("note");
	       note = new String(note.getBytes("iso-8859-1"),"UTF-8");
		   RestDAO restDAO = new RestDAO();	
		   Rest rest=new Rest();
	       rest.setId(id);
	       rest.setRestDate(restDate);
	       rest.setNote(note);
	       boolean t = restDAO.updateRest(rest);   
	       if(t==true){
	    	   this.doQuery(request, response);   
	       }else{
	    	   response.sendRedirect("UpdateRest.jsp");
	       }	
	}
	
	public void doDelete(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
		String id=request.getParameter("id");
		RestDAO restDAO = new RestDAO();	
		   Rest rest=new Rest();
	       rest.setId(id);
	       boolean t = restDAO.deleteRest(rest);   
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
