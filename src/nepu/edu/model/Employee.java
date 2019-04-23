package nepu.edu.model;

public class Employee {

	
	private String id="";
	  private String name="";
	  private String sex="";
	  private String degree="";
	  private String deptName="";
	  private String posID="";
	  private String tel="";

	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPosID() {
		return posID;
	}
	public void setPosID(String posID) {
		this.posID = posID;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
}
