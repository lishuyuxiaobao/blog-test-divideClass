package nuc.service;
import java.util.List;
import nuc.database.*;
import nuc.entity.*;
public class StudentService{
  private StudentDao cd=new StudentDao();
//��ѯȫ��ѧ����Ϣ
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
	//��ѯ����ѧ����Ϣ
	public Student FindId(int id) {
		// TODO Auto-generated method stub
		Student c=new Student();
		c=cd.findById(id);
		return c;
	}
	//ɾ��ѧ����Ϣ
	public int DeleteStudent(int id) {
		// TODO Auto-generated method stub
		int tc=0;
		tc=cd.delete(id);
		return tc;
	}
//����ѧ����Ϣ
	public int UpdateStudent(Student stt) {
		// TODO Auto-generated method stub
		int tc=0;
		tc=cd.update(stt);
		return tc;
	}
}
