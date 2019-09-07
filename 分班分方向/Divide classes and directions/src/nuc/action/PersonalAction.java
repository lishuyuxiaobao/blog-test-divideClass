package nuc.action;

import java.util.ArrayList;
import java.util.List;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import nuc.database.Dao;
import nuc.entity.Direction;
import nuc.entity.Directionlist;
import nuc.entity.Student;

public class PersonalAction extends ActionSupport implements ModelDriven<Student>{

	private Student st = new Student();
	private List<Student> lStudents = new ArrayList<Student>();
	private List<Direction> directions = new ArrayList<Direction>();
	
	
	public List<Direction> getDirections() {
		return directions;
	}

	public void setDirections(List<Direction> directions) {
		this.directions = directions;
	}

	public List<Student> getlStudents() {
		return lStudents;
	}

	public void setlStudents(List<Student> lStudents) {
		this.lStudents = lStudents;
	}

	public Student getSt() {
		return st;
	}

	public void setSt(Student st) {
		this.st = st;
	}
	Dao dao = new Dao();
	public String PersonalMethod() {
		lStudents = dao.listpersonalinfo(st.getSid());
		List<Directionlist> lDirectionlists = null;
		for(Student st : lStudents) {
			lDirectionlists = dao.listdirectionlist1(st.getSid());
			st.setListd(lDirectionlists);
			System.out.println(lDirectionlists);
		}
		
		return SUCCESS;
	}

	@Override
	public Student getModel() {
		// TODO Auto-generated method stub
		return st;
	}

}
