package nepu.edu.tools;
import java.sql.*;

public class DBManager {
   private Connection conn = null;
   private Statement stmt = null;
   private ResultSet rs = null;
   private String uri = "jdbc:sqlserver://localhost:1433;DatabaseName=HumanSalary";
   private String user = "sa";
   private String passWord = "123456";
	
   public DBManager(){
	   
	   this.conn = this.getConnection();
   }
   /** �������ݿⷽ��
    * 
    * @return conn
    */
   private Connection getConnection(){
	   
	   try {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		conn = DriverManager.getConnection(uri,user,passWord);
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println("��������");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println("��ȡ���Ӵ���");
	}
	   
	   return conn;
   } 
   
   /** ��ѯ����
    * @param sql
    * @return rs
    */
   public ResultSet executeQuery(String sql){
	   try {
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println("ִ��sql������");
	}
	   
	   return rs;
   }
   /** �ͷ���Դ
    * 
    */
   public void releaseSource(){
	  
		try {
			 if(rs!=null) rs.close();
			 if(stmt!=null) stmt.close();
			 if(conn!=null) conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   
   }
   
   /**
	 * ���·���
	 * 
	 * @param sql
	 * @return count
	 */
	public int executeUpdate(String sql) {

		int count = 0;
		try {
			stmt = conn.createStatement();
			count = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("����ʧ�ܣ�");
		}

		return count;

	}
}
