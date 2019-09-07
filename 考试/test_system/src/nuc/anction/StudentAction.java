package nuc.anction;

import java.util.ArrayList;
import java.util.List;
import nuc.service.StudentService;
import nuc.entity.Student;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class StudentAction extends ActionSupport implements ModelDriven{
	
	private Student stu = new Student();
	private StudentService  sService = new StudentService();
	private List<Student> ls = new ArrayList<Student>();
	private String t_class;
	private String t_name;
	
	public String getT_name() {
		return t_name;
	}

	public void setT_name(String t_name) {
		this.t_name = t_name;
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

	public Student getStu() {
		return stu;
	}

	public void setStu(Student stu) {
		this.stu = stu;
	}

	public StudentService getsService() {
		return sService;
	}

	public void setsService(StudentService sService) {
		this.sService = sService;
	}

	//添加一个学生信息 //(注册)
	public String insertStu() {
		stu.setS_id(stu.getS_id());
		stu.setS_name(stu.getS_name());
		stu.setS_pass(stu.getS_pass());
		stu.setS_class(stu.getS_class());
		sService.insertStu(stu);
		this.addFieldError("success", "注册成功，请登录！");
		return "insertStuOK";
	}
	//修改信息
	public String updateStu() {
		stu.setS_id(stu.getS_id());
		stu.setS_name(stu.getS_name());
		stu.setS_pass(stu.getS_pass());
		stu.setS_class(stu.getS_class());
		sService.updateStu(stu);
		this.addFieldError("update", "修改成功");
		return "updateStuOK";
	}
	//所有学生信息
	public String findAllStu() {
		stu.setS_class(t_class);
		ls = sService.findAllStu(stu);
		ActionContext.getContext().getSession().put("t_name", t_name);
		ActionContext.getContext().getSession().put("t_class", t_class);
		return "findAllStuOK";
	}
	//
	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return stu;
	}

}
