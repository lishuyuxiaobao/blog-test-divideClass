package nuc.service;

import java.util.List;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import nuc.db.Dao;
import nuc.entity.Attention;
import nuc.entity.Blog;
import nuc.entity.Comment;
import nuc.entity.Regist;


public class BlogService{
	Dao dao = new Dao();
	//����  ͨ������  ���ӵ�  �û�  ���� �� ��ע
	public List<Blog> listblogs() {
		List<Blog> blogs = null;
		List<Comment> comments = null;
		blogs = dao.findblog();
		int id = (int)ActionContext.getContext().getSession().get("id");
		for(Blog b : blogs){
			Regist ruser = dao.listuserid(b.getId());
			Attention attention = dao.listattentionid(id, b.getId());
			comments = dao.listcommenttime(b.getTime());
			Comment comment = dao.listcommenttimeid(b.getTime());
			b.setRegistinfo(ruser);
			b.setAttentioninfo(attention);
			b.setCommentinfo(comment);
			b.setComments(comments);
		}		
		return blogs;
	}
	// ����  ͨ��ָ��id�ҵ�����   ���ӵ�  �û�  ���� �� ��ע
	public List<Blog> listblogsid(Integer userid) {
		List<Blog> blogs = null;
		List<Comment> comments = null;
		blogs = dao.findblogid(userid);
		int id = (int)ActionContext.getContext().getSession().get("id");
		for(Blog b : blogs){
			Regist ruser = dao.listuserid(b.getId());
			Attention attention = dao.listattentionid(id, b.getId());
			comments = dao.listcommenttime(b.getTime());
			Comment comment = dao.listcommenttimeid(b.getTime());
			b.setRegistinfo(ruser);
			b.setAttentioninfo(attention);
			b.setCommentinfo(comment);
			b.setComments(comments);
		}		
		return blogs;
	}
	// ͨ��  �ҵ�ָ��id�Ĺ�ע  ���ӵ� �û���Ϣ
	public List<Attention> listattentionid(Integer userid) {
		List<Attention> blogs = null;
		blogs = dao.findattention(userid);
		for(Attention b : blogs){
			Regist ruser = dao.listuserid(b.getUserid());
			b.setRegistinfo(ruser);
		}		
		return blogs;
	}
	// ͨ��  �ҵ�ָ��id�ķ�˿������ע�ģ�  ���ӵ� �û���Ϣ
	public List<Attention> listattentionuserid(Integer userid) {
		List<Attention> blogs = null;
		blogs = dao.findattentionuserid(userid);
		for(Attention b : blogs){
			Regist ruser = dao.listuserid(b.getId());
			b.setRegistinfo(ruser);
		}		
		return blogs;
	}
	// ����  ͨ��ָ��type�ҵ�����   ���ӵ�  �û�  ���� �� ��ע
	public List<Blog> listblogstype(String type) {
		List<Blog> blogs = null;
		List<Comment> comments = null;
		blogs = dao.findblogtype(type);
		int id = (int)ActionContext.getContext().getSession().get("id");
		for(Blog b : blogs){
			Regist ruser = dao.listuserid(b.getId());
			Attention attention = dao.listattentionid(id, b.getId());
			comments = dao.listcommenttime(b.getTime());
			b.setRegistinfo(ruser);
			b.setAttentioninfo(attention);
			b.setComments(comments);
		}		
		return blogs;
	}

}
