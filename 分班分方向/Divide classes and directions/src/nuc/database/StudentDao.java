package nuc.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import nuc.entity.Student;
import nuc.database.*;

public class StudentDao{
	Conn con = new Conn();
	Connection conn= con.getConn();
	//查询单条数据
	public Student findById(Integer id) {
		Student c=new Student();
		try{
			 String sql_select="select * from student where s_id=?";
			 PreparedStatement pst=conn.prepareStatement(sql_select);
			 pst.setInt(1,id);
			 ResultSet rs=null;
			 rs=pst.executeQuery();
			 while(rs.next()){
				 c.setId(rs.getInt("id"));
				 c.setSid(rs.getString("sid"));
				 c.setClasses(rs.getInt("classes"));
				 c.setName(rs.getString("name"));
				c.setPassword(rs.getString("password"));
			 }
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return c;
	}


	//查询所有数据
	public List<Student> findAll() {
		String sql = "select * from student";
		List<Student> students= new ArrayList<Student>();
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				Student c= new Student();
				c.setId(rs.getInt("id"));
				 c.setSid(rs.getString("sid"));
				 c.setClasses(rs.getInt("classes"));
				 c.setName(rs.getString("name"));
				 c.setPassword(rs.getString("password"));
				students.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return students;
	}
//插入

	public int insert(Student s) {
		int rs=0;
		try{
		String sql_insert="insert into student(s_id,s_name,s_department,s_pass)values(?,?,?,?)";
		PreparedStatement pst=conn.prepareStatement(sql_insert);
		pst.setString(1, s.getSid());
		pst.setString(2,s.getName());
		pst.setString(3,s.getS_department());
		pst.setString(4,s.getPassword());
		rs=pst.executeUpdate();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return rs;
	}
   //更新
	
	public int update(Student t) {
		int rs=0;
		try{
		String sql_update="update student set sid=?,name=?,classes=?,password=? where id=?";
		PreparedStatement pst=conn.prepareStatement(sql_update);
		pst.setString(1, t.getSid());
		pst.setString(2,t.getName());
		pst.setInt(3,t.getClasses());
		pst.setString(4,t.getPassword());
		pst.setInt(5, t.getId());
		rs=pst.executeUpdate();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return rs;
	}
    //删除

	public int delete(int t) {
		int rs=0;
		try{
		String sql_delete="delete from student where id=?";
		PreparedStatement pst=conn.prepareStatement(sql_delete);
		pst.setInt(1, t);
		rs=pst.executeUpdate();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return rs;
	}
}
