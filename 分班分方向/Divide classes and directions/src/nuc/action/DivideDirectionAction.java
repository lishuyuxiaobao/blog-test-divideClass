package nuc.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.omg.CORBA.PRIVATE_MEMBER;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import nuc.database.Dao;
import nuc.entity.Direction;
import nuc.entity.Directionlist;
import nuc.entity.Student;

public class DivideDirectionAction extends ActionSupport implements ModelDriven{

	private Direction dt = new Direction();
	private Directionlist dtl = new Directionlist();
	private List<Direction> lDirections = new ArrayList<Direction>();
	private List<Directionlist> ldList = new ArrayList<Directionlist>();
	private List<Directionlist> newldList = new ArrayList<Directionlist>();
	private String sid;
	
	
	public List<Directionlist> getNewldList() {
		return newldList;
	}

	public void setNewldList(List<Directionlist> newldList) {
		this.newldList = newldList;
	}

	public Directionlist getDtl() {
		return dtl;
	}

	public void setDtl(Directionlist dtl) {
		this.dtl = dtl;
	}



	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public List<Directionlist> getLdList() {
		return ldList;
	}

	public void setLdList(List<Directionlist> ldList) {
		this.ldList = ldList;
	}

	public List<Direction> getlDirections() {
		return lDirections;
	}

	public void setlDirections(List<Direction> lDirections) {
		this.lDirections = lDirections;
	}

	public Direction getDt() {
		return dt;
	}

	public void setDt(Direction dt) {
		this.dt = dt;
	}
	Dao dao = new Dao();
	public String AddDirectionMethod() {
		dt.setDirection(dt.getDirection());
		dt.setStatus("0");
		dao.adddirection(dt);
		lDirections = dao.listdirection();
		return SUCCESS;		
	}
	public String AddDirectionListMethod() {
		newldList = dao.listdirectionlist1(sid);
		Iterator iter = newldList.iterator();
		if (iter.hasNext()) {
			ActionContext.getContext().getSession().put("info","你已经报过名了，不能再报！");
			}
		else {
			dtl.setDirection(dt.getDirection());
	        dtl.setSid(sid);
	        dao.adddirectionlist(dtl);
			ActionContext.getContext().getSession().put("info","报名成功！");
			ldList = dao.listdirectionlist(dt.getDirection());
			ActionContext.getContext().getSession().put("num", ldList.size() );
			
		}
		return SUCCESS;		
	}
	
	public String SelectDirectionMethod() {
		lDirections = dao.listdirection();	
		return "listOK";
	}
	public String adddirectionMethod() {
		lDirections = dao.listdirection();	
		return "listOK";
	}
	
	public String SelectOpenDirectionMethod() {
		ActionContext.getContext().getSession().put("sid",sid );
		lDirections = dao.listopendirection("1");		
		return "listopenOK";
	}
	
	public String SelectDirectionNumMethod() {
		ldList = dao.listdirectionlist(dt.getDirection());
		ActionContext.getContext().getSession().put("info","已报人数！");
		ActionContext.getContext().getSession().put("num", ldList.size() );
		return "listnumsOK";
	}
	
	
	
	public String DirectionOperationMethod() {
		dt.setDirection(dt.getDirection());
		dt.setStatus(dt.getStatus());
		dt.setTime(dt.getTime());
		dao.updatestatus(dt);
		lDirections = dao.listdirection();
		return SUCCESS;
	}


	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return dt;
	}

}
