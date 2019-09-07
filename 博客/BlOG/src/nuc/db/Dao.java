package nuc.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import nuc.entity.Attention;
import nuc.entity.Blog;
import nuc.entity.Comment;
import nuc.entity.Regist;


public class Dao {
//ע�� ����û�
	public void addregist(Regist ruser) {
		try {
			Conn conn = new Conn();
			Connection sql = conn.getConn();
			String addbbs = "insert into user(id,username,password,email,hportrait) values(?,?,?,?,?)";
			PreparedStatement pst = sql.prepareStatement(addbbs);
			pst.setInt(1, ruser.getId());
			pst.setString(2, ruser.getUsername());
			pst.setString(3, ruser.getPassword());
			pst.setString(4, ruser.getEmail());		
			pst.setString(5, ruser.getHportrait());
			pst.executeUpdate();
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	//�޸�  ��Ϣ
	public void updateregist(Regist ruser) {
		try {
			Conn conn = new Conn();
			Connection sql = conn.getConn();
			String addbbs = "update user set username=? , password=? , email=? where id=?";
			PreparedStatement pst = sql.prepareStatement(addbbs);
			pst.setString(1, ruser.getUsername());
			pst.setString(2, ruser.getPassword());
			pst.setString(3, ruser.getEmail());		
			pst.setInt(4, ruser.getId());
			pst.executeUpdate();	
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	//����������
	public void addblog(Blog blog) {
		try {
			Conn conn = new Conn();
			Connection sql = conn.getConn();
			String addbbs = "insert into blog(id,type,content,photo,time) values(?,?,?,?,?)";
			PreparedStatement pst = sql.prepareStatement(addbbs);
			pst.setInt(1, blog.getId());
			pst.setString(2, blog.getType());
			pst.setString(3, blog.getContent());
			pst.setString(4, blog.getPhoto());
			pst.setTimestamp(5, new Timestamp(System.currentTimeMillis()));
			pst.executeUpdate();
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	//�������
	public void addcomment(Comment comment) {
		try {
			Conn conn = new Conn();
			Connection sql = conn.getConn();
			String addbbs = "insert into comment(id,userid,content,time,commenttime) values(?,?,?,?,?)";
			PreparedStatement pst = sql.prepareStatement(addbbs);
			pst.setInt(1, comment.getId());
			pst.setInt(2, comment.getUserid());
			pst.setString(3, comment.getContent());
			pst.setString(4, comment.getTime());
			pst.setTimestamp(5, new Timestamp(System.currentTimeMillis()));
			pst.executeUpdate();
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	//��ȡ�û�ͷ��
	public Regist listuserid(Integer id){
		Regist ruser = new Regist();
		ResultSet rs  = null;
		try {
			Conn conn = new Conn();
			Connection sql = conn.getConn();
			String listuser="select * from user where id=?";
			PreparedStatement pst=sql.prepareStatement(listuser);
			pst.setInt(1, id);
			rs=pst.executeQuery();
			if(rs.next()) {
				
				ruser.setId(rs.getInt("id"));
				ruser.setUsername(rs.getString("username"));
				ruser.setHportrait(rs.getString("hportrait"));
				ruser.setEmail(rs.getString("email"));
				ruser.setPassword(rs.getString("password"));
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ruser;	
	}
	//��ȡ�û���Ϣ
	public List<Regist> finduserid(Integer id){
		List<Regist> rusers = new ArrayList<Regist>();
		ResultSet rs  = null;
		try {
			Conn conn = new Conn();
			Connection sql = conn.getConn();
			String listuser="select * from user where id=?";
			PreparedStatement pst=sql.prepareStatement(listuser);
			pst.setInt(1, id);
			rs=pst.executeQuery();
			if(rs.next()) {
				Regist ruser = new Regist();
				ruser.setId(rs.getInt("id"));
				ruser.setUsername(rs.getString("username"));
				ruser.setHportrait(rs.getString("hportrait"));
				ruser.setEmail(rs.getString("email"));
				ruser.setPassword(rs.getString("password"));
				rusers.add(ruser);
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return rusers;	
	}
	//��ȡ��ע�ͷ�˿
	public Attention listattentionid(Integer id,Integer userid){
		Attention attention = new Attention();
		ResultSet rs  = null;
		try {
			Conn conn = new Conn();
			Connection sql = conn.getConn();
			String listattentionid="select * from attention where id=? and userid=?";
			PreparedStatement pst=sql.prepareStatement(listattentionid);
			pst.setInt(1, id);
			pst.setInt(2, userid);
			rs=pst.executeQuery();
			if(rs.next()) {				
				attention.setId(rs.getInt("id"));
				attention.setUserid(rs.getInt("userid"));
				attention.setAttention(rs.getString("attention"));
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return attention;	
	}
	//��ȡ��������  (����)
	public Comment listcommenttimeid(String time){
		Comment comment = new Comment();
		ResultSet rs  = null;
		try {
			Conn conn = new Conn();
			Connection sql = conn.getConn();
			String listattentionid="select * from comment where time=?";
			PreparedStatement pst=sql.prepareStatement(listattentionid);
			pst.setString(1, time);
			rs=pst.executeQuery();
			while(rs.next()) {	
				comment.setId(rs.getInt("id"));
				comment.setUserid(rs.getInt("userid"));
				comment.setContent(rs.getString("content"));
				comment.setCommenttime(rs.getString("commenttime"));
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return comment;	
	}
	//��ȡ�������� (����)
	public List<Comment> listcommenttime(String time){
		List<Comment> comments = new ArrayList<Comment>();
		
		ResultSet rs  = null;
		try {
			Conn conn = new Conn();
			Connection sql = conn.getConn();
			String listattentionid="select * from comment where time=?";
			PreparedStatement pst=sql.prepareStatement(listattentionid);
			pst.setString(1, time);
			rs=pst.executeQuery();
			Comment comment = null;
			while(rs.next()) {	
			comment = new Comment();
				comment.setId(rs.getInt("id"));
				comment.setUserid(rs.getInt("userid"));
				comment.setContent(rs.getString("content"));
				comment.setCommenttime(rs.getString("commenttime"));
				comments.add(comment);
				
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return comments;	
	}
/*	//��ȡ��������
	public List<Comment> listcommenttimeid(String time){
		List<Comment> comments = new ArrayList<Comment>();
		ResultSet rs  = null;
		try {
			Conn conn = new Conn();
			Connection sql = conn.getConn();
			String listattentionid="select * from comment where time=?";
			PreparedStatement pst=sql.prepareStatement(listattentionid);
			pst.setString(1, time);
			rs=pst.executeQuery();
			Comment comment = null;
			while(rs.next()) {	
				comment = new Comment();
				comment.setId(rs.getInt("id"));
				comment.setUserid(rs.getInt("userid"));
				comment.setContent(rs.getString("content"));
				comment.setCommenttime(rs.getString("commenttime"));
				comments.add(comment);
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return comments;	
	}*/
	//��ȡ��������
	public List<Blog> findblog(){
		ResultSet rs  = null;
		List<Blog> blogs = new ArrayList<Blog>();
		try {
			Conn conn = new Conn();
			Connection sql = conn.getConn();
			String listblogs="select * from blog";
			PreparedStatement pst=sql.prepareStatement(listblogs);
			rs=pst.executeQuery();
			while(rs.next()) {
				Blog b = new Blog();
				b.setId(rs.getInt("id"));
				b.setType(rs.getString("type"));
				b.setContent(rs.getString("content"));
				b.setPhoto(rs.getString("photo"));
				b.setTime(rs.getString("time"));
				blogs.add(b);
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return blogs;
	}
	//��ȡָ��������Ϣ
	public List<Blog> findblogid(Integer id){
		ResultSet rs  = null;
		List<Blog> blogs = new ArrayList<Blog>();
		try {
			Conn conn = new Conn();
			Connection sql = conn.getConn();
			String listblogs="select * from blog where id=?";
			PreparedStatement pst=sql.prepareStatement(listblogs);
			pst.setInt(1, id);
			rs=pst.executeQuery();
			while(rs.next()) {
				Blog b = new Blog();
				b.setId(rs.getInt("id"));
				b.setType(rs.getString("type"));
				b.setContent(rs.getString("content"));
				b.setPhoto(rs.getString("photo"));
				b.setTime(rs.getString("time"));
				blogs.add(b);
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return blogs;
	}
	//��ȡ��ע�� �й�ע  ָ����id
	public List<Attention> findattentionid(Integer id){
		ResultSet rs  = null;
		List<Attention> blogs = new ArrayList<Attention>();
		try {
			Conn conn = new Conn();
			Connection sql = conn.getConn();
			String listblogs="select * from attention where id=?";
			PreparedStatement pst=sql.prepareStatement(listblogs);
			pst.setInt(1, id);
			rs=pst.executeQuery();
			Attention  b = null;
			while(rs.next()) {
				 b = new Attention();
				b.setId(rs.getInt("id"));
				b.setUserid(rs.getInt("userid"));
				blogs.add(b);
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return blogs;
	}
	//��ע���� �� ��ȡ��ע�� �й�ע  ָ����id
	public List<Attention> findattention(Integer id){
		ResultSet rs  = null;
		List<Attention> attentions = new ArrayList<Attention>();
		try {
			Conn conn = new Conn();
			Connection sql = conn.getConn();
			String listblogs="select * from attention where id=?";
			PreparedStatement pst=sql.prepareStatement(listblogs);
			pst.setInt(1, id);
			rs=pst.executeQuery();
			Attention b = null;
			while(rs.next()) {
				b = new Attention();
				b.setId(rs.getInt("id"));
				b.setUserid(rs.getInt("userid"));
				b.setAttention(rs.getString("attention"));
				attentions.add(b);
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return attentions;
	}
	//��˿���� �� ��ȡ��ע�� �з�˿  ָ����id
	public List<Attention> findattentionuserid(Integer id){
		ResultSet rs  = null;
		List<Attention> attentions = new ArrayList<Attention>();
		try {
			Conn conn = new Conn();
			Connection sql = conn.getConn();
			String listblogs="select * from attention where userid=?";
			PreparedStatement pst=sql.prepareStatement(listblogs);
			pst.setInt(1, id);
			rs=pst.executeQuery();
			Attention b = null;
			while(rs.next()) {
				b = new Attention();
				b.setId(rs.getInt("id"));
				b.setUserid(rs.getInt("userid"));
				b.setAttention(rs.getString("attention"));
				attentions.add(b);
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return attentions;
	}
	//���� ��ȡ��������
	public List<Blog> findblogtype(String type){
		ResultSet rs  = null;
		List<Blog> blogs = new ArrayList<Blog>();
		try {
			Conn conn = new Conn();
			Connection sql = conn.getConn();
			String listblogs="select * from blog where type=?";
			PreparedStatement pst=sql.prepareStatement(listblogs);
			pst.setString(1, type);
			rs=pst.executeQuery();
			Blog b = null;
			while(rs.next()) {
				b=new Blog();
				b.setId(rs.getInt("id"));
				b.setType(rs.getString("type"));
				b.setContent(rs.getString("content"));
				b.setPhoto(rs.getString("photo"));
				b.setTime(rs.getString("time"));
				blogs.add(b);
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return blogs;
	}
	//ȡ����ע  ɾ����ע����
	public void deletetattention(Attention attention) {
		try {
			Conn conn=new Conn();
			Connection sql=conn.getConn();
			String deleteattention="delete from attention where id=? and userid=?";
			PreparedStatement pst=sql.prepareStatement(deleteattention);
			pst.setInt(1, attention.getId());
			pst.setInt(2, attention.getUserid());
			pst.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	//ɾ��ָ������
	public void deletetcommenttime(Comment comment) {
		try {
			Conn conn=new Conn();
			Connection sql=conn.getConn();
			String deletecomment="delete from comment where commenttime=?";
			PreparedStatement pst=sql.prepareStatement(deletecomment);
			pst.setString(1, comment.getCommenttime());
			pst.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	//ɾ��ָ����������
	public void deletetblogtime(String blog) {
		try {
			Conn conn=new Conn();
			Connection sql=conn.getConn();
			/*String deleteblog="delete from blog where time=?";*/
			String deleteblog="delete from blog where time=?";
			PreparedStatement pst=sql.prepareStatement(deleteblog);
			pst.setString(1, blog);
			pst.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	//ɾ��ָ����������
	public void deletetblogcommenttime(String blog) {
		try {
			Conn conn=new Conn();
			Connection sql=conn.getConn();
			/*String deleteblog="delete from blog where time=?";*/
			String deleteblog="delete from comment where time=?";
			PreparedStatement pst=sql.prepareStatement(deleteblog);
			pst.setString(1, blog);
			pst.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	//��ӹ�ע
	public void addattention(Attention attention) {
		try {
			Conn conn = new Conn();
			Connection sql = conn.getConn();
			String addbbs = "insert into attention(id,userid,attention) values(?,?,?)";
			PreparedStatement pst = sql.prepareStatement(addbbs);
			pst.setInt(1, attention.getId());
			pst.setInt(2, attention.getUserid());
			pst.setString(3,attention.getAttention());
			pst.executeUpdate();
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
}
