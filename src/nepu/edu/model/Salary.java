package nepu.edu.model;

public class Salary {

	private String id="";
	private String monthTime="";
	private String basepay="";
	private String fine="";
	private String bonus="";
	private String incomeTax="";
	public String getBasepay() {
		return basepay;
	}
	public void setBasepay(String basepay) {
		this.basepay = basepay;
	}
	public String getBonus() {
		return bonus;
	}
	public void setBonus(String bonus) {
		this.bonus = bonus;
	}
	public String getFine() {
		return fine;
	}
	public void setFine(String fine) {
		this.fine = fine;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getIncomeTax() {
		return incomeTax;
	}
	public void setIncomeTax(String incomeTax) {
		this.incomeTax = incomeTax;
	}
	public String getMonthTime() {
		return monthTime;
	}
	public void setMonthTime(String monthTime) {
		this.monthTime = monthTime;
	}

	
	
}
