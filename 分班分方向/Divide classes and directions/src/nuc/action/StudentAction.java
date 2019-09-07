package nuc.action;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import nuc.database.Dao;
import nuc.entity.Student;
import nuc.service.StudentService;
public class StudentAction extends ActionSupport implements ModelDriven<Student>{
	private File upload;
	private String uploadFileName;
	private String uploadContentType;
	private String savePath;
/*	private String class2;
	public String getClass2() {
		return class2;
	}
	public void setClass2(String class2) {
		this.class2 = class2;
	}*/
	private int min;
	private int max;
	private StudentService Students=new StudentService();
	private Student stu=new Student();
	private List<Student> students;
	Student s=new Student();
	public Student getS() {
		return s;
	}
	public void setS(Student s) {
		this.s = s;
	}
	public int getMin() {
		return min;
	}
	public void setMin(int min) {
		this.min = min;
	}
	public int getMax() {
		return max;
	}
	public void setMax(int max) {
		this.max = max;
	}
	public String getSavePath() {
		return savePath;
	}
	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}
	public File getUpload() {
		return upload;
	}
	public void setUpload(File upload) {
		this.upload = upload;
	}
	public String getUploadFileName() {
		return uploadFileName;
	}
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	public String getUploadContentType() {
		return uploadContentType;
	}
	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	//excel批量添加数据
	public String addStudents() throws Exception {
		System.out.println("1");
//	String pas="123456";
//	String realPath =savePath+ "/"+UUID.randomUUID()+uploadFileName.substring(uploadFileName.lastIndexOf("."));
//	FileOutputStream fos = new FileOutputStream(realPath);
//	FileInputStream fis = new FileInputStream(upload);
//	byte[] buf = new byte[1024];
//	int len = 0;
//	while((len = fis.read(buf)) > 0){
//			fos.write(buf, 0, len);
//			}
//		try
//		{
//			int a=0;
//		
//		InputStream in = new FileInputStream(realPath);
////		XSSFFactory fs = new XSSFFactory(realPath);
//		POIFSFileSystem fs = new POIFSFileSystem(in);
//		HSSFWorkbook wb = new HSSFWorkbook(fs);

		//XSSFWorkbook wb = new XSSFWorkbook(in);
		
		//HSSFSheet sheet = wb.getSheetAt(0);
//		in.close();
		//将最大行数设置为最后一行
//		if(max==0) {
//		max=sheet.getLastRowNum();
//		}
//		for(int i=min;i<=max;i++)
//		{
//		HSSFRow row=sheet.getRow(i);
//		HSSFCell cell0=row.getCell(0);
//		HSSFCell cell1=row.getCell(1);
//		String name=cell0.getStringCellValue();
		POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(upload));
		HSSFWorkbook wb = new HSSFWorkbook(fs);
		HSSFSheet hssfSheet = wb.getSheetAt(0); 
		if (hssfSheet != null) {
			for (int rowNum = 1; rowNum <=500; rowNum++) {
				HSSFRow hssfRow = hssfSheet.getRow(rowNum);
				if (hssfRow == null) {
					continue;
				}
//				if(ExcelUtil.formatCell(hssfRow.getCell(2)).equals("")||ExcelUtil.formatCell(hssfRow.getCell(8)).equals("")||ExcelUtil.formatCell(hssfRow.getCell(10)).equals("")) {
//					continue;
//				}
		s.setName(ExcelUtil.formatCell(hssfRow.getCell(0)));
		s.setSid(ExcelUtil.formatCell(hssfRow.getCell(1)));
//		int  sid=(int)cell1.getNumericCellValue();
//		String sid = cell1.getStringCellValue();
//		s.setClasses(sid);
//		String name=cell1.getStringCellValue();
//		s.setName(name);
//		int  classes=(int)cell0.getNumericCellValue();
//		s.setClasses(classes);
//		if (i<10) {
//			s.setSid(class2+'0'+i);
//		}else {
//			s.setSid(class2+i);
//		}
		s.setPassword("123456");
		s.setS_department("理学院");
		System.out.println(ExcelUtil.formatCell(hssfRow.getCell(0)));
		try {
		    Students.InsertStudent(s);
		}catch(Exception e){
		e.printStackTrace();
		}
	}
}
		return "studentOK"; 
		}
	//手动添加数据
	public String HandaddStudent() {
		int a=0;
		a=Students.InsertStudent(stu);
		return "handOK";
	}
	//查询所有数据
	public String ListStudent() {
		students=Students.listStudent();
		return "ListOk";
	}
	
	//更新数据
	public String updateStudent() {
		Students.UpdateStudent(stu);
		return "updateOK";
	}
	//查询详细数据
	public String FindClothDetail() {
		HttpServletRequest reqeust= ServletActionContext.getRequest();
		  int id=Integer.parseInt(reqeust.getParameter("id"));
		  
		s=Students.FindId(id);
		
		return "find";
	}
	//删除数据
	public String deleteStudent() {
		HttpServletRequest reqeust= ServletActionContext.getRequest();
		int id=Integer.parseInt(reqeust.getParameter("id"));
		Students.DeleteStudent(id);
		return "deleteOK";
	}
	public String deleteall() {
		Dao dao = new Dao();
		dao.delete();
		return SUCCESS;
	}
	@Override
	public Student getModel() {
		// TODO Auto-generated method stub
		return stu;
	}
}

