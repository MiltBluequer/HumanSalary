package nepu.edu.DAO;

import nepu.edu.tools.DBManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import nepu.edu.model.Employee;
import nepu.edu.model.Sign;
import nepu.edu.tools.DBManager;

public class SignDAO {

//	ÐÞ¸Ä
    public boolean updateSign(Sign signmodel) {
 	   boolean t = false;
   		DBManager db = new DBManager();
   		String sql = "insert into Sign values ('"+signmodel.getId()+"' ,'"+signmodel.getDate()+"','"+signmodel.getSign()+"')";
   		int count = db.executeUpdate(sql);
   		if(count>0) t=true;
   		return t;
    }
    
    
    
    public ArrayList getSignArrayList(String id){
		ArrayList signList=new ArrayList();
		String sql="select * from Sign where id='"+id+"'";
		DBManager db=new DBManager();
		ResultSet rs=(ResultSet) db.executeQuery(sql);
		try {
			while(rs.next()){
			Sign signmodel=new Sign();
			signmodel.setId(rs.getString(1));
			signmodel.setDate(rs.getString(2));
			signmodel.setSign(rs.getString(3));
		
			signList.add(signmodel);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return signList;	
	}
}
