package nuc.anction;

import java.awt.color.ICC_ColorSpace;
import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import nuc.database.Dao;
import nuc.entity.Student;
import nuc.entity.grader;
import nuc.entity.problem;
import nuc.service.StudentService;

public class GradeAction extends ActionSupport implements ModelDriven{
	grader gr = new grader();
	private List<Student> ls = new ArrayList<Student>();
	private StudentService  sService = new StudentService();
	private List<grader> lgd = new ArrayList<grader>();
	private String t_class;
	int id;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List getLgd() {
		return lgd;
	}
	public void setLgd(List lgd) {
		this.lgd = lgd;
	}
	public StudentService getsService() {
		return sService;
	}
	public void setsService(StudentService sService) {
		this.sService = sService;
	}
	
	public Dao getDao() {
		return dao;
	}
	public void setDao(Dao dao) {
		this.dao = dao;
	}
	public String getT_class() {
		return t_class;
	}
	public void setT_class(String t_class) {
		this.t_class = t_class;
	}
	public List<Student> getLs() {
		return ls;
	}
	public void setLs(List<Student> ls) {
		this.ls = ls;
	}
	public grader getGr() {
		return gr;
	}
	public void setGr(grader gr) {
		this.gr = gr;
	}
	private List<grader> graders = new ArrayList<grader>();

	public List<grader> getGraders() {
		return graders;
	}
	public void setGraders(List<grader> graders) {
		this.graders = graders;
	}
	Dao dao = new Dao();
	public String Findgrade() {
		graders = dao.listgraderid(gr.getS_id());
		for(grader g : graders) {
			problem pl = dao.listproblemt(g.getP_type());
			g.setPinfo(pl);
		}
		ActionContext.getContext().getSession().put("t_name", gr.getT_name());
		ActionContext.getContext().getSession().put("t_class", t_class);
		System.out.println(t_class);
		return SUCCESS;
	}
	public String UpdateGrade2() {
		Student stu = new Student();
		dao.updategrade2(gr.getGrader2(), gr.getS_id());
		System.out.println(gr.getGrader2());
		System.out.println(gr.getS_id());
		stu.setS_class(t_class);
		ls = sService.findAllStu(stu);
		System.out.println(t_class);
		return SUCCESS;
	}
	public String Personal() {
		System.out.println(id);
		lgd = dao.listgraderid(id);
		if(lgd.size()!=0) {
		int agr = lgd.get(0).getGrader1()+lgd.get(0).getGrader2();
		ActionContext.getContext().getSession().put("agr", agr);
		for(grader g : lgd) {
			problem pl = dao.listproblemt(g.getP_type());
			g.setPinfo(pl);
		}
		}
		System.out.println(lgd);
		return SUCCESS;
	}
	
	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return gr;
	}
 
}
