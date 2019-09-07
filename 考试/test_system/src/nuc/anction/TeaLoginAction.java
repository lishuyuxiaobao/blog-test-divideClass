package nuc.anction;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;

import nuc.service.TeacherService;

import nuc.entity.Teacher;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class TeaLoginAction extends ActionSupport implements ModelDriven{
	
	private Teacher tea = new Teacher();
	private TeacherService  tService = new TeacherService();
	
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

	
	@Override
	public String execute() throws SQLException{
		// TODO Auto-generated method stub
		tea.setT_id(tea.getT_id());
		tea.setT_pass(tea.getT_pass());
		if(tService.validateTea(tea)!= null) {
			tea = tService.validateTea(tea);
			ActionContext.getContext().getSession().put("user", tea);
			return "teaLoginOK";
		}else {
			addFieldError("error", "输入的用户名或者密码不正确,请重新输入");
			return "teaLoginNO";
		}
	}


	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return tea;
	}
}
