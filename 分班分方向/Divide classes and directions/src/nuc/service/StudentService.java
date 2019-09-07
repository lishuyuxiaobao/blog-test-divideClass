package nuc.service;
import java.util.List;
import nuc.database.*;
import nuc.entity.*;
public class StudentService{
  private StudentDao cd=new StudentDao();
//查询全部学生信息
	public List<Student> listStudent() {
		List<Student> students = null;
		students= cd.findAll();
	
		return students;
	}
	public int InsertStudent(Student s) {
		// TODO Auto-generated method stub
		int tc=0;
		tc=cd.insert(s);
		return tc;
	}
	//查询单个学生信息
	public Student FindId(int id) {
		// TODO Auto-generated method stub
		Student c=new Student();
		c=cd.findById(id);
		return c;
	}
	//删除学生信息
	public int DeleteStudent(int id) {
		// TODO Auto-generated method stub
		int tc=0;
		tc=cd.delete(id);
		return tc;
	}
//更新学生信息
	public int UpdateStudent(Student stt) {
		// TODO Auto-generated method stub
		int tc=0;
		tc=cd.update(stt);
		return tc;
	}
}
