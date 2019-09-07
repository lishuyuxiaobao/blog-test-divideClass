package nuc.entity;

import java.util.List;

public class Classname {

	private String direction;
	private String classname;
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public String getClassname() {
		return classname;
	}
	public void setClassname(String classname) {
		this.classname = classname;
	}
	private List<Companylist> companylist;
	public List<Companylist> getCompanylist() {
		return companylist;
	}
	public void setCompanylist(List<Companylist> companylist) {
		this.companylist = companylist;
	}
	
}
