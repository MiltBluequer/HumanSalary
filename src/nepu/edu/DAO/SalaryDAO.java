package nepu.edu.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import nepu.edu.model.Rest;
import nepu.edu.model.Salary;
import nepu.edu.tools.DBManager;

public class SalaryDAO {

	// 是否存在
public boolean isexit(String id,String monthTime){
		
		
		ResultSet rs=null;
		boolean t = false;
		DBManager db = new DBManager();
		String sql = "select id,monthTime from  Salary where id='" + id + "' and monthTime='" + monthTime + "'";
		rs = (ResultSet) db.executeQuery(sql);
		try {
			if(rs.next()){ t=true;}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			db.releaseSource();
		}
		return t;
		
	}
	
//	查询
	public ArrayList getSalaryArrayListDivPage(int pageN,int pageSize){
		
		ArrayList salaryList=new ArrayList();
		
		int beginNum= (pageN-1)*pageSize+1 ;
		int endNum= pageSize* pageN;
		
		String sql="SELECT  *	FROM  (SELECT *, num = row_number() over (order by id ASC)  from  Salary)  t WHERE  num BETWEEN   "+beginNum+" AND   "+endNum+"   ";
		DBManager db=new DBManager();
		ResultSet rs=(ResultSet) db.executeQuery(sql);
		try {
			while(rs.next()){
			Salary salary=new Salary();
			salary.setId(rs.getString(1));
			salary.setMonthTime(rs.getString(2));
			salary.setBasepay(rs.getString(3));
			salary.setFine(rs.getString(4));
			salary.setBonus(rs.getString(5));
			salary.setIncomeTax(rs.getString(6));
			salaryList.add(salary);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return salaryList;	
	}	
	
	
//	添加奖金
    public boolean addBonus(Salary salary) {
		boolean t = false;
		DBManager db = new DBManager();
		String sql = "update Salary set bonus='"+salary.getBonus()+"' where id='"+salary.getId()+"'and monthTime='"+salary.getMonthTime()+"'";
		int count = db.executeUpdate(sql);
		if(count>0) t=true;
		return t;
	}
    
//	添加罚金
    public boolean addFine(Salary salary) {
		boolean t = false;
		DBManager db = new DBManager();
		String sql = "update Salary set Fine='"+salary.getFine()+"' where id='"+salary.getId()+"'and monthTime='"+salary.getMonthTime()+"'";
		int count = db.executeUpdate(sql);
		if(count>0) t=true;
		return t;
	}
	
}
