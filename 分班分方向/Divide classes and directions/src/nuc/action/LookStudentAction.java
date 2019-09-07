package nuc.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import nuc.database.Dao;
import nuc.entity.Companylist;
import nuc.entity.Directionlist;

public class LookStudentAction extends ActionSupport {

	private List<Companylist> cList2 = new ArrayList<Companylist>();
	private List<Directionlist> dList = new ArrayList<Directionlist>();
	private String companys;
	
	
	public List<Directionlist> getdList() {
		return dList;
	}
	public void setdList(List<Directionlist> dList) {
		this.dList = dList;
	}

	public String getCompanys() {
		return companys;
	}
	public void setCompanys(String companys) {
		this.companys = companys;
	}
	public List<Companylist> getcList2() {
		return cList2;
	}
	public void setcList2(List<Companylist> cList2) {
		this.cList2 = cList2;
	}
	Dao dao= new Dao();
	public String SelectStudentMethod() {
		cList2 = dao.lisdirectioncompany();
		return SUCCESS;
	}
	public String ListStudentMethod() {
		dList = dao.liststudentlist(companys);
		System.out.println(dList);
		return "listOK";
	}
}
