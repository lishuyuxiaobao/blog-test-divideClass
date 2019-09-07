package nuc.anction;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.text.GapContent;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;

import nuc.database.Dao;
import nuc.entity.grader;
import nuc.entity.problem;

public class TestAction extends ActionSupport implements ModelDriven{

	private grader gd = new grader();
	private List<problem> lProblems = new ArrayList<problem>();
	private String s_name;
    private List<String> gradess = new ArrayList<String>();
	private List<grader> lGraders = new ArrayList<grader>();





	public List<String> getGradess() {
		return gradess;
	}


	public void setGradess(List<String> gradess) {
		this.gradess = gradess;
	}


	public List<grader> getlGraders() {
		return lGraders;
	}


	public void setlGraders(List<grader> lGraders) {
		this.lGraders = lGraders;
	}


	public String getS_name() {
		return s_name;
	}


	public void setS_name(String s_name) {
		this.s_name = s_name;
	}


	public List<problem> getlProblems() {
		return lProblems;
	}


	public void setlProblems(List<problem> lProblems) {
		this.lProblems = lProblems;
	}



    public grader getGd() {
		return gd;
	}


	public void setGd(grader gd) {
		this.gd = gd;
	}



	Dao dao = new Dao();
	public String FindProblem() {
		lGraders = dao.listgraderid(gd.getS_id());
		Iterator iter = lGraders.iterator();
		if(iter.hasNext()) {
			
			return LOGIN;
		}
		String random = "";
		String[] doc = {"A", "B", "C", "D"};
		int index = (int) (Math.random() * doc.length);
		random = doc[index];
		lProblems = dao.listproblemtype(random);
		ActionContext.getContext().getSession().put("s_name", s_name);
		ActionContext.getContext().getSession().put("s_id", gd.getS_id());
		ActionContext.getContext().getSession().put("p_type", random);
		return SUCCESS;
	}

	public String AddGrade() {
		gd.setP_name1(gd.getP_name1());
		gd.setP_name2(gd.getP_name2());
		gd.setP_name3(gd.getP_name3());
		gd.setP_name4(gd.getP_name4());
		gd.setP_name5(gd.getP_name5());
		gd.setAnswer1(gd.getAnswer1());
		gd.setAnswer2(gd.getAnswer2());
		gd.setAnswer3(gd.getAnswer3());
		gd.setAnswer4(gd.getAnswer4());
		gd.setAnswer5(gd.getAnswer5());
		gd.setP_type(gd.getP_type());
		gd.setS_id(gd.getS_id());
		dao.addgrader(gd);
		lGraders = dao.listgraderid(gd.getS_id());
		for(grader g : lGraders) {
			problem lsp = dao.listproblemt(g.getP_type());
	        g.setPinfo(lsp);
		}
		ActionContext.getContext().getSession().put("s_id", gd.getS_id());
		return SUCCESS;
	}
	public String UpdateGrade() {
		int j=0;
		System.out.println(gradess.size());
		System.out.println(gd.getS_id());
		if(gradess.size()!=0) {
		for(int i=0;i<gradess.size();i++) {
			j=j+10;
		}
		dao.updategrade1(j, gd.getS_id());
		}else {
			dao.updategrade1(0, gd.getS_id());
		}
		return SUCCESS;
	}
	
	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return gd;
	}

	
}
