package nuc.anction;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import nuc.service.StudentService;
import nuc.entity.Student;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class StuLoginAction extends ActionSupport implements ModelDriven{
	
	private Student stu = new Student();
	private StudentService  sService = new StudentService();
	private String checkCode;
	
	public String getCheckCode() {
		return checkCode;
	}
	public void setCheckCode(String checkCode) {
		this.checkCode = checkCode;
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
	@Override
	public String execute() throws SQLException{
		// TODO Auto-generated method stub
		stu.setS_id(stu.getS_id());
		stu.setS_pass(stu.getS_pass());
		if(sService.validateStu(stu)!= null) {
			stu = sService.validateStu(stu);
			ActionContext.getContext().getSession().put("user", stu);
			return "stuLoginOK";
		}else {
			addFieldError("error", "输入的用户名或者密码不正确,请重新输入");
			return "stuLoginNO";
		}
	}
	@Override
	public void validate() {
		// TODO Auto-generated method stub
		HttpSession session = ServletActionContext.getRequest().getSession();
        String checkCode2 = (String)session.getAttribute("checkCode");
        if(!checkCode.equals(checkCode2))
        {
            addFieldError(checkCode, "输入的验证码不正确,请重新输入");
        }	
	}
	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return stu;
	}
}
