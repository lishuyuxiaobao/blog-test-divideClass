package nuc.service;

import java.util.List;

import nuc.database.StudentDao;
import nuc.entity.Student;

public class StudentService {
	
	StudentDao sDao = new StudentDao();
	
	//���ѧ����Ϣ //(ע��)
	public void insertStu(Student stu) {
		sDao.insertStu(stu);
	}
	//��������ѧ��
	public List<Student> findAllStu(Student stu){
		return sDao.findAllStu(stu);
	}
	//�����¼
	public Student validateStu(Student student){
		Student stu = null;
			if(sDao.validateStu(student) != null) {
				stu = sDao.validateStu(student);
			}
		return stu;
	}
	//�޸�
	public void updateStu(Student stu) {
		sDao.updateStu(stu);
	}
}
