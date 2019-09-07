package nuc.anction;

import java.util.ArrayList;
import java.util.List;
import nuc.service.StudentService;
import nuc.service.TeacherService;
import nuc.entity.Teacher;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class TeacherAction extends ActionSupport implements ModelDriven{
	
	private Teacher tea = new Teacher();
	private TeacherService tService = new TeacherService();
	
	public Teacher getTea() {
		return tea;
	}

	public void setTea(Teacher tea) {
		this.tea = tea;
	}

	public TeacherService gettService() {
		return tService;
	}

	public void settService(TeacherService tService) {
		this.tService = tService;
	}

	//修改信息
	public String updateTea() {
		tea.setT_id(tea.getT_id());
		tea.setT_name(tea.getT_name());
		tea.setT_pass(tea.getT_pass());
		tea.setT_class(tea.getT_class());
		tService.updateTea(tea);
		this.addFieldError("update", "修改成功");
		return "updateTeaOK";
	}
	//增加教师
	public String addTea() {
		tea.setT_id(tea.getT_id());
		tea.setT_name(tea.getT_name());
		tea.setT_pass(tea.getT_pass());
		tea.setT_class(tea.getT_class());
		tService.insertTea(tea);
		return "addTeaOK";
	}
	
	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return tea;
	}

}
