package nuc.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import nuc.entity.grader;
import nuc.entity.problem;

public class Dao {
//添加题目
	public void addsubject(problem pm) {
		try {
			Conn conn = new Conn();
			Connection sql = conn.getConn();
			String add = "insert into problem(p_type,p_name1,p_answer1,p_name2,p_answer2,p_option1,p_option2,p_name3,p_answer3,p_name4,p_answer4,p_name5,p_answer5) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement pst = sql.prepareStatement(add);
			pst.setString(1, pm.getP_type());
			pst.setString(2, pm.getP_name1());
			pst.setString(3, pm.getP_answer1());		
			pst.setString(4, pm.getP_name2());		
			pst.setString(5, pm.getP_answer2());		
			pst.setString(6, pm.getP_option1());		
			pst.setString(7, pm.getP_option2());
			pst.setString(8, pm.getP_name3());		
			pst.setString(9, pm.getP_answer3());	
			pst.setString(10, pm.getP_name4());		
			pst.setString(11, pm.getP_answer4());	
			pst.setString(12, pm.getP_name5());		
			pst.setString(13, pm.getP_answer5());	
			pst.executeUpdate();
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	// 查找题目
		public List<problem> listproblem(){
			List<problem> listproblems = new ArrayList<problem>();
			ResultSet rs = null;
			try {
				Conn conn = new Conn();
				Connection sql = conn.getConn();
				String list = "select * from problem";
				PreparedStatement pst = sql.prepareStatement(list);
				rs=pst.executeQuery();
				while(rs.next()) {
					problem dt = new problem();
					dt.setP_type(rs.getString("p_type"));
					dt.setP_name2(rs.getString("p_name2"));
					dt.setP_answer2(rs.getString("p_answer2"));
					dt.setP_name1(rs.getString("p_name1"));
					dt.setP_answer1(rs.getString("p_answer1"));
					dt.setP_option1(rs.getString("p_option1"));
					dt.setP_option2(rs.getString("p_option2"));
					dt.setP_name3(rs.getString("p_name3"));
					dt.setP_answer3(rs.getString("p_answer3"));
					dt.setP_name4(rs.getString("p_name4"));
					dt.setP_answer4(rs.getString("p_answer4"));
					dt.setP_name5(rs.getString("p_name5"));
					dt.setP_answer5(rs.getString("p_answer5"));
					listproblems.add(dt);
				}
				
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return listproblems;
		}
	//修改题目
		public void updateproblem(problem dt) {
			try {
			Conn conn = new Conn();
			Connection sql = conn.getConn();
			String updatestatus = "update problem set p_name1=?,p_answer1=?,p_type=?,p_name2=?,p_answer2=?,p_option1=?,p_option2=?,p_name3=?,p_answer3=?,p_name4=?,p_answer4=?,p_name5=?,p_answer5=? where p_name1=?";
			PreparedStatement pst = sql.prepareStatement(updatestatus);
			pst.setString(1, dt.getP_name1());
			pst.setString(2, dt.getP_answer1());
			pst.setString(3, dt.getP_type());		
			pst.setString(4, dt.getP_name2());		
			pst.setString(5, dt.getP_answer2());		
			pst.setString(6, dt.getP_option1());		
			pst.setString(7, dt.getP_option2());
			pst.setString(8, dt.getP_name3());		
			pst.setString(9, dt.getP_answer3());	
			pst.setString(10, dt.getP_name4());		
			pst.setString(11, dt.getP_answer4());	
			pst.setString(12, dt.getP_name5());		
			pst.setString(13, dt.getP_answer5());	
			pst.setString(14, dt.getP_name1());		
			pst.executeUpdate();	
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
		//删除题目
		public int deleteproblem(problem pm) {
			int rs=0;
			try{
				Conn conn = new Conn();
			Connection sql = conn.getConn();
			String sql_delete="delete from problem where p_name1=?";
			PreparedStatement pst=sql.prepareStatement(sql_delete);
			pst.setString(1, pm.getP_name1());
			rs=pst.executeUpdate();
			}
			catch(Exception e){
				e.printStackTrace();
			}
			return rs;
		}
		// 获取指定题目
		public List<problem> listproblemid(String problem){
			List<problem> listdirections = new ArrayList<problem>();
			ResultSet rs = null;
			try {
				Conn conn = new Conn();
				Connection sql = conn.getConn();
				String listproblemid = "select * from problem where p_name1=?";
				PreparedStatement pst = sql.prepareStatement(listproblemid);
				pst.setString(1, problem);
				rs=pst.executeQuery();
				problem newdt = null;
				while(rs.next()) {
					newdt = new problem();
					newdt.setP_type(rs.getString("p_type"));
					newdt.setP_name2(rs.getString("p_name2"));
					newdt.setP_answer2(rs.getString("p_answer2"));
					newdt.setP_name1(rs.getString("p_name1"));
					newdt.setP_answer1(rs.getString("p_answer1"));
					newdt.setP_option1(rs.getString("p_option1"));
					newdt.setP_option2(rs.getString("p_option2"));
					newdt.setP_name3(rs.getString("p_name3"));
					newdt.setP_answer3(rs.getString("p_answer3"));
					newdt.setP_name4(rs.getString("p_name4"));
					newdt.setP_answer4(rs.getString("p_answer4"));
					newdt.setP_name5(rs.getString("p_name5"));
					newdt.setP_answer5(rs.getString("p_answer5"));
					listdirections.add(newdt);
				}
				
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return listdirections;
		}
		// 获取指定类型的题目
				public List<problem> listproblemtype(String problem1){
					List<problem> listdirections = new ArrayList<problem>();
					ResultSet rs = null;
					try {
						Conn conn = new Conn();
						Connection sql = conn.getConn();
						String listproblemid = "select * from problem where p_type=?";
						PreparedStatement pst = sql.prepareStatement(listproblemid);
						pst.setString(1, problem1);
						rs=pst.executeQuery();
						problem newdt = null;
						while(rs.next()) {
							newdt = new problem();
							newdt.setP_name2(rs.getString("p_name2"));
							newdt.setP_answer2(rs.getString("p_answer2"));
							newdt.setP_name1(rs.getString("p_name1"));
							newdt.setP_answer1(rs.getString("p_answer1"));
							newdt.setP_name3(rs.getString("p_name3"));
							newdt.setP_answer3(rs.getString("p_answer3"));
							newdt.setP_name4(rs.getString("p_name4"));
							newdt.setP_answer4(rs.getString("p_answer4"));
							newdt.setP_name5(rs.getString("p_name5"));
							newdt.setP_answer5(rs.getString("p_answer5"));
							newdt.setP_option1(rs.getString("p_option1"));
							newdt.setP_option2(rs.getString("p_option2"));
							newdt.setP_type(rs.getString("p_type"));
							listdirections.add(newdt);
						}
						
					}catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
					return listdirections;
				}
				// 添加到成绩单
				public void addgrader(grader gr) {
					try {
						Conn conn = new Conn();
						Connection sql = conn.getConn();
						String add = "insert into grader(p_type,answer1,answer2,answer3,answer4,answer5,s_id) values(?,?,?,?,?,?,?)";
						PreparedStatement pst = sql.prepareStatement(add);
						pst.setString(1, gr.getP_type());
						pst.setString(2, gr.getAnswer1());		
						pst.setString(3, gr.getAnswer2());	
						pst.setString(4, gr.getAnswer3());		
						pst.setString(5, gr.getAnswer4());	
						pst.setString(6, gr.getAnswer5());	
						pst.setInt(7, gr.getS_id());		
						pst.executeUpdate();
						
					}catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
				}
				// 根据指定类型找题库信息
				public List<grader> listgraderid(int id){
					List<grader> newdts = new ArrayList<grader>();
					ResultSet rs  = null;
					try {
						Conn conn = new Conn();
						Connection sql = conn.getConn();
						String listuser="select * from grader where s_id=?";
						PreparedStatement pst=sql.prepareStatement(listuser);
						pst.setInt(1, id);
						rs=pst.executeQuery();
						if(rs.next()) {
							grader newdt = new grader();
							newdt.setS_id(rs.getInt("s_id"));
							newdt.setP_type(rs.getString("p_type"));
							newdt.setAnswer1(rs.getString("answer1"));
							newdt.setAnswer2(rs.getString("answer2"));
							newdt.setAnswer3(rs.getString("answer3"));
							newdt.setAnswer4(rs.getString("answer4"));
							newdt.setAnswer5(rs.getString("answer5"));
							newdt.setGrader1(rs.getInt("grader1"));
							newdt.setGrader2(rs.getInt("grader2"));
							newdts.add(newdt);
						}
					}catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
					return newdts;	
		}
				//调取 题目
				public problem listproblemt(String type){
					problem newdt = new problem();
					ResultSet rs  = null;
					try {
						Conn conn = new Conn();
						Connection sql = conn.getConn();
						String listuser="select * from problem where p_type=?";
						PreparedStatement pst=sql.prepareStatement(listuser);
						pst.setString(1, type);
						rs=pst.executeQuery();
						if(rs.next()) {
							newdt.setP_name2(rs.getString("p_name2"));
							newdt.setP_answer2(rs.getString("p_answer2"));
							newdt.setP_name1(rs.getString("p_name1"));
							newdt.setP_answer1(rs.getString("p_answer1"));
							newdt.setP_name3(rs.getString("p_name3"));
							newdt.setP_answer3(rs.getString("p_answer3"));
							newdt.setP_name4(rs.getString("p_name4"));
							newdt.setP_answer4(rs.getString("p_answer4"));
							newdt.setP_name5(rs.getString("p_name5"));
							newdt.setP_answer5(rs.getString("p_answer5"));
							newdt.setP_option1(rs.getString("p_option1"));
							newdt.setP_option2(rs.getString("p_option2"));
							newdt.setP_type(rs.getString("p_type"));
						}
					}catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
					return newdt;	
				}
				//修改成绩1
				public void updategrade1(Integer grade1,Integer s_id) {
					try {
					Conn conn = new Conn();
					Connection sql = conn.getConn();
					String updatestatus = "update grader set grader1=? where s_id=?";
					PreparedStatement pst = sql.prepareStatement(updatestatus);
					pst.setInt(1, grade1);
					pst.setInt(2, s_id);	
					pst.executeUpdate();	
				}catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
				//修改成绩2
				public void updategrade2(Integer grade2,Integer s_id) {
					try {
						Conn conn = new Conn();
						Connection sql = conn.getConn();
						String updatestatus = "update grader set grader2=? where s_id=?";
						PreparedStatement pst = sql.prepareStatement(updatestatus);
						pst.setInt(1, grade2);
						pst.setInt(2, s_id);	
						pst.executeUpdate();	
					}catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
				}
				
}
