package nuc.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import nuc.entity.Teacher;

public class TeacherDao {
	
	Conn c = new Conn();
	Connection con = c.getConn();
	PreparedStatement pst = null;
	ResultSet rs = null;
	//�������Ա
	public Teacher validateTea(Teacher tea) {
		Teacher t = null;
		String sql = "select * from teacher where t_id=? and t_pass=?";
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, tea.getT_id());
			pst.setString(2, tea.getT_pass());
			rs = pst.executeQuery();
			if(rs.next()) {
				t = new Teacher();
				t.setT_id(rs.getInt("t_id"));
				t.setT_name(rs.getString("t_name"));
				t.setT_pass(rs.getString("t_pass"));
				t.setT_class(rs.getString("t_class"));
				System.out.println("�Ϸ�");
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("�û����Ϸ���");
		}
		return t;
	}
	
	public void updateTea(Teacher tea) { //�޸���Ϣ
		Conn c = new Conn();
		Connection con = c.getConn();
		PreparedStatement pst = null;
		String sql = "update teacher set t_name=?,t_pass=?,t_class=? where t_id=?";
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, tea.getT_name());
			pst.setString(2, tea.getT_pass());
			pst.setString(3,tea.getT_class());
			pst.setInt(4, tea.getT_id());
			pst.executeUpdate();
			System.out.println("�޸ĳɹ���");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("�޸�ʧ�ܣ�");
		}
	}

	public void insertTea(Teacher tea) {
		// TODO Auto-generated method stub
		String sql = "insert into teacher(t_id,t_name,t_pass,t_class) values (?,?,?,?)";
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, tea.getT_id());
			pst.setString(2, tea.getT_name());
			pst.setString(3, tea.getT_pass());
			pst.setString(4, tea.getT_class());
			pst.executeUpdate();
			System.out.println("����"+tea.getT_name()+"�û��ɹ���");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("����ʧ�ܣ�");
		}
	}
}
