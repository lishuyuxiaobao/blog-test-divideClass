package nuc.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import nuc.entity.Student;

public class StudentDao {
	Conn c = new Conn();
	Connection con = c.getConn();
	PreparedStatement pst = null;
	ResultSet rs = null;
	//��student������һ���û�(ע���ʱ������)
	public void insertStu(Student stu) {
		String sql = "insert into student(s_id,s_name,s_pass,s_class) values (?,?,?,?)";
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, stu.getS_id());
			pst.setString(2, stu.getS_name());
			pst.setString(3, stu.getS_pass());
			pst.setString(4, stu.getS_class());
			pst.executeUpdate();
			System.out.println("����"+stu.getS_name()+"�û��ɹ���");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("����ʧ�ܣ�");
		}
	}
	//����ָ���༶����ѧ����Ϣ
	public List<Student> findAllStu(Student s){
		List<Student> ls = new ArrayList<Student>();
		String sql = "select * from student where s_class=?";
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1,s.getS_class());
			rs = pst.executeQuery();
			while(rs.next()) {
				Student stu = new Student();
				stu.setS_id(rs.getInt("s_id"));
				stu.setS_name(rs.getString("s_name"));
				stu.setS_pass(rs.getString("s_pass"));
				stu.setS_class(rs.getString("s_class"));
				ls.add(stu);
				System.out.println("��ѯѧ���ɹ���");
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("��ѯʧ�ܣ�");
		}
		return ls;
	}
	
	//�޸���Ϣ
		public void updateStu(Student stu) {
			Conn c = new Conn();
			Connection con = c.getConn();
			PreparedStatement pst = null;
			String sql = "update student set s_name=?,s_pass=?,s_class=? where s_id=?";
			try {
				pst = con.prepareStatement(sql);
				pst.setString(1, stu.getS_name());
				pst.setString(2, stu.getS_pass());
				pst.setString(3, stu.getS_class());
				pst.setInt(4, stu.getS_id());
				pst.executeUpdate();
				System.out.println("�޸ĳɹ���");
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				System.out.println("�޸�ʧ�ܣ�");
			}
		}
	//�ж�ѧ���Ƿ�Ϸ�
	public Student validateStu(Student stu) {
		Student student = null;
		String sql = "select * from student where s_id=? and s_pass=?";
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, stu.getS_id());
			pst.setString(2, stu.getS_pass());
			rs = pst.executeQuery();
			if(rs.next()) {
				student = new Student();
				student.setS_id(rs.getInt("s_id"));
				student.setS_name(rs.getString("s_name"));
				student.setS_pass(rs.getString("s_pass"));
				student.setS_class(rs.getString("s_class"));
				System.out.println("�Ϸ�");
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("�û����Ϸ���");
		}
		return student;
	} 
}
