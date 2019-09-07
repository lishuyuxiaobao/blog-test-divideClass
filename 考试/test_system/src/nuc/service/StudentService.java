package nuc.service;

import java.util.List;

import nuc.database.StudentDao;
import nuc.entity.Student;

public class StudentService {
	
	StudentDao sDao = new StudentDao();
	
	//添加学生信息 //(注册)
	public void insertStu(Student stu) {
		sDao.insertStu(stu);
	}
	//查找所有学生
	public List<Student> findAllStu(Student stu){
		return sDao.findAllStu(stu);
	}
	//检验登录
	public Student validateStu(Student student){
		Student stu = null;
			if(sDao.validateStu(student) != null) {
				stu = sDao.validateStu(student);
			}
		return stu;
	}
	//修改
	public void updateStu(Student stu) {
		sDao.updateStu(stu);
	}
}
