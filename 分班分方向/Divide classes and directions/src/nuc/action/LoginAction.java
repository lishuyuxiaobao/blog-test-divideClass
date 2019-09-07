package nuc.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import nuc.entity.Student;

public class LoginAction extends ActionSupport implements ModelDriven{

	private Student st = new Student();
	
	public Student getSt() {
		return st;
	}

	public void setSt(Student st) {
		this.st = st;
	}

	public String LoginMethod() {
		if(st.getType().equals("π‹¿Ì‘±")) {
			ActionContext.getContext().getSession().put("sid", st.getSid());
			return "adminOK";
		}
		ActionContext.getContext().getSession().put("sid", st.getSid());
		return SUCCESS;
	}
	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return st;
	}

}
