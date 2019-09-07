package nuc.service;

import nuc.database.TeacherDao;
import nuc.entity.Teacher;

public class TeacherService {
	
	TeacherDao tDao = new TeacherDao();
	
	public Teacher validateTea(Teacher tea){
		Teacher t = null;
			if(tDao.validateTea(tea) != null) {
				t = tDao.validateTea(tea);
			}
		return t;
	}
	
	public void updateTea(Teacher tea) {
		tDao.updateTea(tea);
	}

	public void insertTea(Teacher tea) {
		// TODO Auto-generated method stub
		tDao.insertTea(tea);
	}
}
