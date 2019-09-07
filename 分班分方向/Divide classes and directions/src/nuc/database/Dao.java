package nuc.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.core.pattern.EncodingPatternConverter;

import nuc.entity.Classname;
import nuc.entity.Companylist;
import nuc.entity.Direction;
import nuc.entity.Directionlist;
import nuc.entity.Student;

public class Dao {
	
    // 增加技术方向（实现添加方向的功能）
	public void adddirection(Direction dt) {
		try {
			Conn conn = new Conn();
			Connection sql = conn.getConn();
			String adddirection = "insert into divide_direction(direction,status) values(?,?)";
			PreparedStatement pst = sql.prepareStatement(adddirection);
		    pst.setString(1, dt.getDirection());	
		    pst.setString(2, dt.getStatus());	
		    pst.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	// 增加技术方向的公司企业（实现添加方向的功能）
	public void addcompany(Companylist cl) {
		try {
			Conn conn = new Conn();
			Connection sql = conn.getConn();
			String adddirection = "insert into company_list(direction,company) values(?,?)";
			PreparedStatement pst = sql.prepareStatement(adddirection);
			pst.setString(1, cl.getDirection());	
			pst.setString(2, cl.getCompany());	
			pst.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	// 增加技术方向的班级（实现添加方向的功能）
	public void addclassname(Classname cn) {
		try {
			Conn conn = new Conn();
			Connection sql = conn.getConn();
			String adddirection = "insert into divide_class(direction,classname) values(?,?)";
			PreparedStatement pst = sql.prepareStatement(adddirection);
			pst.setString(1, cn.getDirection());	
			pst.setString(2, cn.getClassname());	
			pst.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	// 增加技术方向（实现添加方向的功能）
	public void adddirectionlist(Directionlist dt) {
		try {
			Conn conn = new Conn();
			Connection sql = conn.getConn();
			String adddirection = "insert into direction_list(sid,direction) values(?,?)";
			PreparedStatement pst = sql.prepareStatement(adddirection);
			pst.setString(1, dt.getSid());
			pst.setString(2, dt.getDirection());	
			pst.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	// 列出所有方向名称和状态信息 （执行查询功能）
	public List<Direction> listdirection(){
		List<Direction> listdirections = new ArrayList<Direction>();
		ResultSet rs = null;
		try {
			Conn conn = new Conn();
			Connection sql = conn.getConn();
			String listdirection = "select * from divide_direction";
			PreparedStatement pst = sql.prepareStatement(listdirection);
			rs=pst.executeQuery();
			while(rs.next()) {
				Direction dt = new Direction();
				dt.setDirection(rs.getString("direction"));
				dt.setStatus(rs.getString("status"));
				dt.setTime(rs.getString("time"));
				listdirections.add(dt);
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return listdirections;
	}
	
	// 列出所有方向班级名称 （执行查询功能）
	public List<Classname> lisclassname(){
		List<Classname> lisclassnames = new ArrayList<Classname>();
		ResultSet rs = null;
		try {
			Conn conn = new Conn();
			Connection sql = conn.getConn();
			String lisclassname = "select * from divide_class";
			PreparedStatement pst = sql.prepareStatement(lisclassname);
			rs=pst.executeQuery();
			while(rs.next()) {
				Classname cn = new Classname();
				cn.setDirection(rs.getString("direction"));
				cn.setClassname(rs.getString("classname"));
				lisclassnames.add(cn);
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return lisclassnames;
	}
	// 列出所有技术方向的企业（执行查询功能）
	public List<Companylist> lisdirectioncompany(){
		List<Companylist> lisdirectioncompanys = new ArrayList<Companylist>();
		ResultSet rs = null;
		try {
			Conn conn = new Conn();
			Connection sql = conn.getConn();
			String liscompany = "select * from company_list";
			PreparedStatement pst = sql.prepareStatement(liscompany);
			rs=pst.executeQuery();
			while(rs.next()) {
				Companylist cn = new Companylist();
				cn.setDirection(rs.getString("direction"));
				cn.setCompany(rs.getString("company"));
				lisdirectioncompanys.add(cn);
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return lisdirectioncompanys;
	}
	// 通过班级方向获取指定公司
	public List<Companylist> listcompanylist(String direction){
		List<Companylist> listcompanylists = new ArrayList<Companylist>();
		
		ResultSet rs  = null;
		try {
			Conn conn = new Conn();
			Connection sql = conn.getConn();
			String companylists="select * from company_list where direction=?";
			PreparedStatement pst=sql.prepareStatement(companylists);
			pst.setString(1, direction);
			rs=pst.executeQuery();
			Companylist cl = null;
			while(rs.next()) {	
				cl = new Companylist();
                cl.setDirection(rs.getString("direction"));
                cl.setCompany(rs.getString("company"));
                listcompanylists.add(cl);
				
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return listcompanylists;	
	}
	// 列出所有开放方向的名称信息 （执行查询功能）
	public List<Direction> listopendirection(String dt){
		List<Direction> listdirections = new ArrayList<Direction>();
		ResultSet rs = null;
		try {
			Conn conn = new Conn();
			Connection sql = conn.getConn();
			String listopendirection = "select * from divide_direction where status=?";
			PreparedStatement pst = sql.prepareStatement(listopendirection);
			pst.setString(1, dt);
			rs=pst.executeQuery();
			Direction newdt = null;
			while(rs.next()) {
				newdt = new Direction();
				newdt.setDirection(rs.getString("direction"));
				newdt.setStatus(rs.getString("status"));
				newdt.setTime(rs.getString("time"));
				listdirections.add(newdt);
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return listdirections;
	}
	// 列出所有开放方向的名称信息 （执行查询功能）
	public List<Direction> listopendirection2(String dt,String di){
		List<Direction> listdirections = new ArrayList<Direction>();
		ResultSet rs = null;
		try {
			Conn conn = new Conn();
			Connection sql = conn.getConn();
			String listopendirection = "select * from divide_direction where status=? and direction=?";
			PreparedStatement pst = sql.prepareStatement(listopendirection);
			pst.setString(1, dt);
			pst.setString(2, di);
			rs=pst.executeQuery();
			Direction newdt = null;
			while(rs.next()) {
				newdt = new Direction();
				newdt.setDirection(rs.getString("direction"));
				newdt.setStatus(rs.getString("status"));
				newdt.setTime(rs.getString("time"));
				listdirections.add(newdt);
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return listdirections;
	}
	// 获取方向的名单信息 （执行查询功能）
	public List<Directionlist> listdirectionlist(String direction){
		List<Directionlist> listdirections = new ArrayList<Directionlist>();
		ResultSet rs = null;
		try {
			Conn conn = new Conn();
			Connection sql = conn.getConn();
			String listopendirection = "select * from direction_list where direction=?";
			PreparedStatement pst = sql.prepareStatement(listopendirection);
			pst.setString(1, direction);
			rs=pst.executeQuery();
			Directionlist newdt = null;
			while(rs.next()) {
				newdt = new Directionlist();
				newdt.setDirection(rs.getString("direction"));
                newdt.setSid(rs.getString("sid"));
				listdirections.add(newdt);
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return listdirections;
	}
	// 获取公司的名单信息 （执行查询功能）
	public List<Directionlist> liststudentlist(String company){
		List<Directionlist> listdirections = new ArrayList<Directionlist>();
		ResultSet rs = null;
		try {
			Conn conn = new Conn();
			Connection sql = conn.getConn();
			String listopendirection = "select * from direction_list where company=?";
			PreparedStatement pst = sql.prepareStatement(listopendirection);
			pst.setString(1, company);
			rs=pst.executeQuery();
			Directionlist newdt = null;
			while(rs.next()) {
				newdt = new Directionlist();
				newdt.setCompany(rs.getString("company"));
				newdt.setDirection(rs.getString("direction"));
				newdt.setClassname(rs.getString("classname"));
				newdt.setSid(rs.getString("sid"));
				listdirections.add(newdt);
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return listdirections;
	}
	// 判断该同学是否已经选择方向 （执行查询功能）
	public List<Directionlist> listdirectionlist1(String sid){
		List<Directionlist> listdirections = new ArrayList<Directionlist>();
		ResultSet rs = null;
		try {
			Conn conn = new Conn();
			Connection sql = conn.getConn();
			String listopendirection = "select * from direction_list where sid=?";
			PreparedStatement pst = sql.prepareStatement(listopendirection);
			pst.setString(1, sid);
			rs=pst.executeQuery();
			Directionlist newdt = null;
			if(rs.next()) {
				newdt = new Directionlist();
				newdt.setDirection(rs.getString("direction"));
				newdt.setClassname(rs.getString("classname"));
				newdt.setCompany(rs.getString("company"));
				newdt.setSid(rs.getString("sid"));
				listdirections.add(newdt);
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return listdirections;
	}
	// 对状态的操作开放与关闭  （执行修改语句）
	public void updatestatus(Direction dt) {
		try {
		Conn conn = new Conn();
		Connection sql = conn.getConn();
		String updatestatus = "update divide_direction set status=?,time=? where direction=?";
		PreparedStatement pst = sql.prepareStatement(updatestatus);
		pst.setString(1, dt.getStatus());
		pst.setString(2, dt.getTime());
		pst.setString(3, dt.getDirection());		
		pst.executeUpdate();	
	}catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
}
    //分班  (修改语句)
	public void updateclassesname(Directionlist dt) {
		try {
		Conn conn = new Conn();
		Connection sql = conn.getConn();
		String updatestatus = "update direction_list set classname=? where sid=?";
		PreparedStatement pst = sql.prepareStatement(updatestatus);
		pst.setString(1, dt.getClassname());
		pst.setString(2, dt.getSid());		
		pst.executeUpdate();	
	}catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
}
	  //给开放的班级分授课企业  (修改语句)
		public void updatecompany(Directionlist dt) {
			try {
			Conn conn = new Conn();
			Connection sql = conn.getConn();
			String updatestatus = "update direction_list set company=? where classname=?";
			PreparedStatement pst = sql.prepareStatement(updatestatus);
			pst.setString(1, dt.getCompany());
			pst.setString(2, dt.getClassname());
			pst.executeUpdate();	
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
		// 查找个人信息
		public List<Student> listpersonalinfo(String id){
			List<Student> lStudents = new ArrayList<Student>();
			ResultSet rs = null;
			try {
				Conn conn = new Conn();
				Connection sql= conn.getConn();
				String ls = "select * from student where sid=?";
				PreparedStatement pst = sql.prepareStatement(ls);
				pst.setString(1, id);
				rs=pst.executeQuery();
				if(rs.next()) {
					Student student = new Student();
					student.setName(rs.getString("name"));
					student.setSid(rs.getString("sid"));
					student.setClasses(rs.getInt("classes"));
					lStudents.add(student);
				}
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return lStudents;
		}
		public int delete() {
			int rs=0;
			try{
				Conn conn = new Conn();
				Connection sql = conn.getConn();
			String sql_delete="delete from divide_class";
			String sql_delete1="delete from direction_list";
			PreparedStatement pst=sql.prepareStatement(sql_delete);
			PreparedStatement pst1=sql.prepareStatement(sql_delete1);
			rs=pst.executeUpdate();
			rs=pst1.executeUpdate();
			}
			catch(Exception e){
				e.printStackTrace();
			}
			return rs;
		}
}
