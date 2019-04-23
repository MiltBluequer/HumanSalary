 package nepu.edu.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;




import nepu.edu.model.Employee;
import nepu.edu.model.UserAdmin;
import nepu.edu.tools.DBManager;

public class UserDAO {

	public boolean adminLogin(String id,String psw){
		
		
		ResultSet rs=null;
		boolean t = false;
		DBManager db = new DBManager();
		String sql = "select id,psw from  Admin where id='" + id + "' and psw='"+ psw + "'";
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
	
	public boolean employeeLogin(String id,String psw){
		
		boolean t = false;
		DBManager db = new DBManager();
		String sql = "select id,psw from  EmployeeLogin where id='" + id + "' and psw='"+ psw + "'";
		ResultSet rs = (ResultSet) db.executeQuery(sql);
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
	
	
	//修改管理员密码
	
	
	public boolean updatePswAdmin(UserAdmin userAdmin) {
	 	   boolean t = false;
	   		DBManager db = new DBManager();
	   		String sql = "update Admin set id='"+userAdmin.getId()+"',psw='"+userAdmin.getPsw()+"' where id='"+userAdmin.getId()+"'";
	   		// 2 添加到数据库
	   		int count = db.executeUpdate(sql);
	   		if(count>0) t=true;
	   		return t;
	    }
	
//修改员工密码
	
	
	public boolean updatePswEmployee(UserAdmin userAdmin) {
	 	   boolean t = false;
	   		DBManager db = new DBManager();
	   		String sql = "update EmployeeLogin set id='"+userAdmin.getId()+"',psw='"+userAdmin.getPsw()+"' where id='"+userAdmin.getId()+"'";
	   		// 2 添加到数据库
	   		int count = db.executeUpdate(sql);
	   		if(count>0) t=true;
	   		return t;
	    }
	
	
	
//	修改前查询传入修改表单
    public UserAdmin queryAdminByID(String id){
    	
    	
    	DBManager db=new DBManager();
		String sql="select * from Admin where id='"+id+"'";
		UserAdmin userAdmin=new UserAdmin();
		ResultSet rs=(ResultSet) db.executeQuery(sql);
		try {
			 rs.next();
			 userAdmin.setId(rs.getString(1));
			 userAdmin.setPsw(rs.getString(2));
			 userAdmin.setName(rs.getString(3));
		       userAdmin.setAge(rs.getString(4));
		       userAdmin.setAddress(rs.getString(5));
		       userAdmin.setMail(rs.getString(6));
		

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userAdmin;	
	}
    
    
//	修改前查询传入修改表单
    public UserAdmin queryEmployeeByID(String id){
    	
    	
    	DBManager db=new DBManager();
		String sql="select * from EmployeeLogin where id='"+id+"'";
		UserAdmin userAdmin=new UserAdmin();
		ResultSet rs=(ResultSet) db.executeQuery(sql);
		try {
			 rs.next();
			 userAdmin.setId(rs.getString(1));
			 userAdmin.setPsw(rs.getString(2));
			 userAdmin.setName(rs.getString(3));
		       userAdmin.setAge(rs.getString(4));
		       userAdmin.setAddress(rs.getString(5));
		       userAdmin.setMail(rs.getString(6));
		

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userAdmin;	
	}
	
	
//	查询管理员用户全部
    public ArrayList getUserAdminArrayList(){
	ArrayList userList=new ArrayList();
	String sql="select * from Admin ";
	DBManager db=new DBManager();
	ResultSet rs=(ResultSet) db.executeQuery(sql);
	try {
		while(rs.next()){
		UserAdmin userAdmin=new UserAdmin();
		userAdmin.setId(rs.getString(1));
		userAdmin.setPsw(rs.getString(2));
		userAdmin.setName(rs.getString(3));
		userAdmin.setAge(rs.getString(4));
		userAdmin.setAddress(rs.getString(5));
		userAdmin.setMail(rs.getString(6));
		userList.add(userAdmin);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return userList;	
}
    
//	查询员工用户全部
    public ArrayList getUserEmployeeArrayList(){
	ArrayList userList=new ArrayList();
	String sql="select * from EmployeeLogin ";
	DBManager db=new DBManager();
	ResultSet rs=(ResultSet) db.executeQuery(sql);
	try {
		while(rs.next()){
		UserAdmin userAdmin=new UserAdmin();
		userAdmin.setId(rs.getString(1));
		userAdmin.setName(rs.getString(2));
		userAdmin.setPsw(rs.getString(3));
		userAdmin.setAge(rs.getString(4));
		userAdmin.setAddress(rs.getString(5));
		userAdmin.setMail(rs.getString(6));
		userList.add(userAdmin);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return userList;	
}
	
	
//	添加管理员用户
    public boolean addUserAdmin(UserAdmin userAdmin) {
		boolean t = false;
		DBManager db = new DBManager();
		String sql = "insert into Admin values('" + userAdmin.getId() + "','" +userAdmin.getPsw()+ "','" +userAdmin.getName()+ "','" +userAdmin.getAge()+ "','" +userAdmin.getAddress()+ "','"+ userAdmin.getMail()+ "')";
		// 2 添加到数据库
		int count = db.executeUpdate(sql);
		if(count>0) t=true;
		return t;
	}
    
    
//	添加员工用户
    public boolean addUserEmployee(UserAdmin userAdmin) {
		boolean t = false;
		DBManager db = new DBManager();
		String sql = "insert into EmployeeLogin values('" + userAdmin.getId() + "','" +userAdmin.getPsw()+ "','" +userAdmin.getName()+ "','" +userAdmin.getAge()+ "','" +userAdmin.getAddress()+ "','"+ userAdmin.getMail()+ "')";
		// 2 添加到数据库
		int count = db.executeUpdate(sql);
		if(count>0) t=true;
		return t;
	}
    
    
    
    //修改
    public boolean updateAdmin(UserAdmin userAdmin) {
 	   boolean t = false;
   		DBManager db = new DBManager();
   		String sql = "update Admin set id='"+userAdmin.getId()+"',psw='"+userAdmin.getPsw()+"',name='"+userAdmin.getName()+"',age='"+userAdmin.getAge()+"',address='"+userAdmin.getAddress()+"',mail='"+userAdmin.getMail()+"' where id='"+userAdmin.getId()+"'";
   		// 2 添加到数据库
   		int count = db.executeUpdate(sql);
   		if(count>0) t=true;
   		return t;
    }
    
    //修改
    public boolean updateEmployee(UserAdmin userAdmin) {
 	   boolean t = false;
   		DBManager db = new DBManager();
   		String sql = "update EmployeeLogin set id='"+userAdmin.getId()+"',psw='"+userAdmin.getPsw()+"',name='"+userAdmin.getName()+"',age='"+userAdmin.getAge()+"',address='"+userAdmin.getAddress()+"',mail='"+userAdmin.getMail()+"' where id='"+userAdmin.getId()+"'";
   		// 2 添加到数据库
   		int count = db.executeUpdate(sql);
   		if(count>0) t=true;
   		return t;
    }
    
    
    //删除
    public boolean deleteAdmin(UserAdmin userAdmin) {
 	   boolean t = false;
   		DBManager db = new DBManager();
   		String sql = "delete from Admin where id='"+userAdmin.getId()+"'";
   		// 2 添加到数据库
   		int count = db.executeUpdate(sql);
   		if(count>0) t=true;
   		return t;
    }
    
    
    
    //删除
    public boolean deleteEmployee(UserAdmin userAdmin) {
 	   boolean t = false;
   		DBManager db = new DBManager();
   		String sql = "delete from EmployeeLogin where id='"+userAdmin.getId()+"'";
   		// 2 添加到数据库
   		int count = db.executeUpdate(sql);
   		if(count>0) t=true;
   		return t;
    }
    
    
    
    //批量删除
    public boolean deleteAdminAll(String []id) {
 	   boolean t = false;
   		DBManager db = new DBManager();
   		for(int i=0;i<id.length;i++)
   		{
   		String sql="delete from Admin where id='"+id[i]+"'";
   		int count = db.executeUpdate(sql);
   		if(count>0) t=true;
   		}
   		return t;
    }
    
    
    
    //批量删除
    public boolean deleteEmployeeAll(String []id) {
 	   boolean t = false;
   		DBManager db = new DBManager();
   		for(int i=0;i<id.length;i++)
   		{
   		String sql="delete from EmployeeLogin where id='"+id[i]+"'";
   		int count = db.executeUpdate(sql);
   		if(count>0) t=true;
   		}
   		return t;
   		}
}
