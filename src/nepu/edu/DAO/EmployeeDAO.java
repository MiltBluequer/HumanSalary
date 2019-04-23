package nepu.edu.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;







import nepu.edu.model.Employee;
import nepu.edu.tools.DBManager;

public class EmployeeDAO {
	
	
	//��ѯȫ��
        public ArrayList getEmloyeeArrayListDivPage(int pageN,int pageSize){
        	
        	
		ArrayList employeeList=new ArrayList();
		
		int beginNum= (pageN-1)*pageSize+1 ;
		int endNum= pageSize* pageN;

		
		String sql="SELECT  *	FROM  (SELECT *, num = row_number() over (order by id ASC)  from  Employee)  t WHERE  num BETWEEN   "+beginNum+" AND   "+endNum+"  ";
		
		
		DBManager db=new DBManager();
		ResultSet rs=(ResultSet) db.executeQuery(sql);
		try {
			while(rs.next()){
			Employee employee=new Employee();
			employee.setId(rs.getString(1));
		       employee.setName(rs.getString(2));
		       employee.setSex(rs.getString(3));
		       employee.setDegree(rs.getString(4));
		       employee.setDeptName(rs.getString(5));
		       employee.setPosID(rs.getString(6));
		       employee.setTel(rs.getString(7));
			employeeList.add(employee);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employeeList;	
	}
	
        
        //�޸�ǰ��ѯ�����޸ı�
        public Employee queryEmployeeByID(String id){
        	
        	
        	DBManager db=new DBManager();
    		String sql="select * from Employee where id='"+id+"'";
    		Employee employee=new Employee();
    		ResultSet rs=(ResultSet) db.executeQuery(sql);
    		try {
    			 rs.next();
    			employee.setId(rs.getString(1));
    		       employee.setName(rs.getString(2));
    		       employee.setSex(rs.getString(3));
    		       employee.setDegree(rs.getString(4));
    		       employee.setDeptName(rs.getString(5));
    		       employee.setPosID(rs.getString(6));
    		       employee.setTel(rs.getString(7));
 
    		} catch (SQLException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    		return employee;	
    	}
        

	//����ID��ѯ
	public ArrayList getEmloyeebyIDArrayList(String text){
		ArrayList employeeList=new ArrayList();
		String sql="select * from Employee where id='"+text+"'";
		DBManager db=new DBManager();
		ResultSet rs=(ResultSet) db.executeQuery(sql);
		try {
			while(rs.next()){
			Employee employee=new Employee();
			employee.setId(rs.getString(1));
		       employee.setName(rs.getString(2));
		       employee.setSex(rs.getString(3));
		       employee.setDegree(rs.getString(4));
		       employee.setDeptName(rs.getString(5));
		       employee.setPosID(rs.getString(6));
		       employee.setTel(rs.getString(7));
			   employeeList.add(employee);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employeeList;	
	}
	
	
	//����������ѯ
       public ArrayList getEmloyeebyNameArrayList(String text){
		
    	   ArrayList employeeList=new ArrayList();
    	   String sql="select * from Employee where name='"+text+"'";
   		DBManager db=new DBManager();
   		ResultSet rs=(ResultSet) db.executeQuery(sql);
   		try {
   			while(rs.next()){
   			Employee employee=new Employee();
   			employee.setId(rs.getString(1));
   		       employee.setName(rs.getString(2));
   		       employee.setSex(rs.getString(3));
   		       employee.setDegree(rs.getString(4));
   		       employee.setDeptName(rs.getString(5));
   		       employee.setPosID(rs.getString(6));
   		       employee.setTel(rs.getString(7));
   			employeeList.add(employee);
   			}
   		} catch (SQLException e) {
   			// TODO Auto-generated catch block
   			e.printStackTrace();
   		}
   		return employeeList;
	}
       
       //���ղ������Ʋ�ѯ
       public ArrayList getEmloyeebyDeptArrayList(String text){
    	   ArrayList employeeList=new ArrayList();
    	   String sql="select * from Employee where deptName='"+text+"'";
   		DBManager db=new DBManager();
   		ResultSet rs=(ResultSet) db.executeQuery(sql);
   		try {
   			while(rs.next()){
   			Employee employee=new Employee();
   			employee.setId(rs.getString(1));
   		       employee.setName(rs.getString(2));
   		       employee.setSex(rs.getString(3));
   		       employee.setDegree(rs.getString(4));
   		       employee.setDeptName(rs.getString(5));
   		       employee.setPosID(rs.getString(6));
   		       employee.setTel(rs.getString(7));
   			employeeList.add(employee);
   			}
   		} catch (SQLException e) {
   			// TODO Auto-generated catch block
   			e.printStackTrace();
   		}
   		return employeeList;
   		
   	}
 
       
       //���
       public boolean addEmployee(Employee employee) {
   		boolean t = false;
   		DBManager db = new DBManager();
   		String sql = "insert into Employee values('" + employee.getId() + "','" +employee.getName()+ "','" +employee.getSex()+ "','" +employee.getDegree()+ "','" +employee.getDeptName()+ "','"+ employee.getPosID()+ "','" + employee.getTel() + "')";
   		// 2 ��ӵ����ݿ�
   		int count = db.executeUpdate(sql);
   		if(count>0) t=true;
   		return t;
   	}
	
       
       //�޸�
       public boolean updateEmployee(Employee employee) {
    	   boolean t = false;
      		DBManager db = new DBManager();
      		String sql = "update Employee set id='"+employee.getId()+"',name='"+employee.getName()+"',sex='"+employee.getSex()+"',degree='"+employee.getDegree()+"',deptName='"+employee.getDeptName()+"',posID='"+employee.getPosID()+"',tel='"+employee.getTel()+"' where id='"+employee.getId()+"'";
      		// 2 ��ӵ����ݿ�
      		int count = db.executeUpdate(sql);
      		if(count>0) t=true;
      		return t;
       }
       
       
       //ɾ��
       public boolean deleteEmployee(Employee employee) {
    	   boolean t = false;
      		DBManager db = new DBManager();
      		String sql = "delete from Employee where id='"+employee.getId()+"'";
      		// 2 ��ӵ����ݿ�
      		int count = db.executeUpdate(sql);
      		if(count>0) t=true;
      		return t;
       }
       
       
       //����ɾ��
       public boolean deleteEmployeeAll(String []id) {
    	   boolean t = false;
      		DBManager db = new DBManager();
      		for(int i=0;i<id.length;i++)
      		{
      		String sql="delete from Employee where id='"+id[i]+"'";
      		int count = db.executeUpdate(sql);
      		if(count>0) t=true;
      		}
      		return t;
       
}
       
}
