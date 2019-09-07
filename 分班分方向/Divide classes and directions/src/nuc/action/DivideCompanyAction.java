package nuc.action;

import java.security.KeyStore.PrivateKeyEntry;
import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import nuc.database.Dao;
import nuc.entity.Classname;
import nuc.entity.Companylist;
import nuc.entity.Directionlist;


public class DivideCompanyAction extends ActionSupport implements ModelDriven{

	private Companylist cl = new Companylist();
	private List<Classname> cList = new ArrayList<Classname>();
	private List<Companylist> cList2 = new ArrayList<Companylist>();
	private List<String> classnames;
	private List<String> companys;
	
	

	public List<Companylist> getcList2() {
		return cList2;
	}
	public void setcList2(List<Companylist> cList2) {
		this.cList2 = cList2;
	}
	public List<String> getClassnames() {
		return classnames;
	}
	public void setClassnames(List<String> classnames) {
		this.classnames = classnames;
	}
	public List<String> getCompanys() {
		return companys;
	}
	public void setCompanys(List<String> companys) {
		this.companys = companys;
	}
	public List<Classname> getcList() {
		return cList;
	}
	public void setcList(List<Classname> cList) {
		this.cList = cList;
	}
	public Companylist getCl() {
		return cl;
	}
	public void setCl(Companylist cl) {
		this.cl = cl;
	}
    Dao dao = new Dao();
	public String AddCompanyMethod() {
		cl.setDirection(cl.getDirection());
		cl.setCompany(cl.getCompany());
		dao.addcompany(cl);
		cList2 = dao.lisdirectioncompany();
		return SUCCESS;		
	}
	
	public String addcompanyMethod() {
		cList2 = dao.lisdirectioncompany();
		return "listOK";
	}
	
	public String DivideCompanyMethod() {
		cList = dao.lisclassname();
		List<Companylist> companylists = null;
		for(Classname cls : cList){
			companylists = dao.listcompanylist(cls.getDirection());
            cls.setCompanylist(companylists);
		}			
		return SUCCESS;
	}

	public String MutilDivideCompanyMethod() {
		for(int i=0;i<classnames.size();i++) {
			Directionlist dl = new Directionlist();
			dl.setClassname(classnames.get(i));
			dl.setCompany(companys.get(i));
			dao.updatecompany(dl);
		}	
		cList = dao.lisclassname();
		List<Companylist> companylists = null;
		for(Classname cls : cList){
			companylists = dao.listcompanylist(cls.getDirection());
            cls.setCompanylist(companylists);
		}			
		return SUCCESS;
	}
	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return cl;
	}
}
