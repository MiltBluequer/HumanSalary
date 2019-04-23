package nepu.edu.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import nepu.edu.model.Employee;
import nepu.edu.model.Rest;
import nepu.edu.tools.DBManager;

public class RestDAO {
   //查询
	public ArrayList getRestArrayListDivPage(int pageN,int pageSize){
		
		ArrayList restList=new ArrayList();
		
		int beginNum= (pageN-1)*pageSize+1 ;
		int endNum= pageSize* pageN;
		
		String sql="SELECT  *	FROM  (SELECT *, num = row_number() over (order by id ASC)  from  Rest)  t WHERE  num BETWEEN   "+beginNum+" AND   "+endNum+"  ";
		DBManager db=new DBManager();
		ResultSet rs=(ResultSet) db.executeQuery(sql);
		try {
			while(rs.next()){
			Rest rest=new Rest();
			rest.setId(rs.getString(1));
		       rest.setRestDate(rs.getString(2));
		       rest.setNote(rs.getString(3));
			restList.add(rest);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return restList;	
	}
	
	
	
	
//	修改前查询传入修改表单
    public Rest queryRestByID(String id){
    	
    	
    	DBManager db=new DBManager();
		String sql="select * from Rest where id='"+id+"'";
		Rest rest=new Rest();
		ResultSet rs=(ResultSet) db.executeQuery(sql);
		try {
			 rs.next();
			rest.setId(rs.getString(1));
			rest.setRestDate(rs.getString(2));
			rest.setNote(rs.getString(3));

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rest;	
	}
    
    

    //添加
    public boolean addRest(Rest rest) {
		boolean t = false;
		DBManager db = new DBManager();
		String sql = "insert into Rest values('" + rest.getId() + "','" +rest.getRestDate()+ "','" +rest.getNote()+ "')";
		// 2 添加到数据库
		int count = db.executeUpdate(sql);
		if(count>0) t=true;
		return t;
	}
	
    
    //修改
    public boolean updateRest(Rest rest) {
 	   boolean t = false;
   		DBManager db = new DBManager();
   		String sql = "update Rest set id='"+rest.getId()+"',restDate='"+rest.getRestDate()+"',note='"+rest.getNote()+"' where id='"+rest.getId()+"'";
   		// 2 添加到数据库
   		int count = db.executeUpdate(sql);
   		if(count>0) t=true;
   		return t;
    }
    
    
    //删除
    public boolean deleteRest(Rest rest) {
 	   boolean t = false;
   		DBManager db = new DBManager();
   		String sql = "delete from Rest where id='"+rest.getId()+"'";
   		// 2 添加到数据库
   		int count = db.executeUpdate(sql);
   		if(count>0) t=true;
   		return t;
    }
    
    //批量删除
    public boolean deleteRestAll(String []id) {
 	   boolean t = false;
   		DBManager db = new DBManager();
   		for(int i=0;i<id.length;i++)
   		{
   		String sql="delete from Rest where id='"+id[i]+"'";
   		int count = db.executeUpdate(sql);
   		if(count>0) t=true;
   		}
   		return t;
	
    }
	
}
