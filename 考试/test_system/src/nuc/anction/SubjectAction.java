package nuc.anction;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import nuc.database.Dao;
import nuc.entity.problem;

public class SubjectAction extends ActionSupport implements ModelDriven{
    private List<problem> lProblems = new ArrayList<problem>();
	private problem pm = new problem();
	
	
	public List<problem> getlProblems() {
		return lProblems;
	}

	public void setlProblems(List<problem> lProblems) {
		this.lProblems = lProblems;
	}

	public problem getPm() {
		return pm;
	}

	public void setPm(problem pm) {
		this.pm = pm;
	}
    Dao dao = new Dao();
	public String AddSubject() {
		pm.setP_name1(pm.getP_name1());
		pm.setP_name2(pm.getP_name2());
		pm.setP_name3(pm.getP_name3());
		pm.setP_name4(pm.getP_name4());
		pm.setP_name5(pm.getP_name5());
		pm.setP_answer1(pm.getP_answer1());
		pm.setP_answer2(pm.getP_answer2());
		pm.setP_answer3(pm.getP_answer3());
		pm.setP_answer4(pm.getP_answer4());
		pm.setP_answer5(pm.getP_answer5());
		pm.setP_option1(pm.getP_option1());
		pm.setP_option2(pm.getP_option2());
		pm.setP_type(pm.getP_type());
		dao.addsubject(pm);	
		return SUCCESS;
	}
	public String ListSubject() {
		lProblems = dao.listproblem();
		System.out.println(lProblems);
		return SUCCESS;
	}
	
	public String DeleteSubject() {
		pm.setP_name1(pm.getP_name1());
		dao.deleteproblem(pm);
		lProblems = dao.listproblem();
		return SUCCESS;
	}
	 
	public String ListSubjectById() {
		lProblems = dao.listproblemid(pm.getP_name1());
		return SUCCESS;
	}
	
	public String UpdateSubjectById() {
		pm.setP_name1(pm.getP_name1());
		pm.setP_name2(pm.getP_name2());
		pm.setP_name3(pm.getP_name3());
		pm.setP_name4(pm.getP_name4());
		pm.setP_name5(pm.getP_name5());
		pm.setP_answer1(pm.getP_answer1());
		pm.setP_answer2(pm.getP_answer2());
		pm.setP_answer3(pm.getP_answer3());
		pm.setP_answer4(pm.getP_answer4());
		pm.setP_answer5(pm.getP_answer5());
		pm.setP_option1(pm.getP_option1());
		pm.setP_option2(pm.getP_option2());
		pm.setP_type(pm.getP_type());
		dao.updateproblem(pm);
		lProblems = dao.listproblem();
		return SUCCESS;
	}
	
	
	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return pm;
	}
}
