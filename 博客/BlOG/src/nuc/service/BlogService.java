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
	//用于  通过博客  链接到  用户  评论 和 关注
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
	// 用于  通过指定id找到博客   链接到  用户  评论 和 关注
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
	// 通过  找到指定id的关注  链接到 用户信息
	public List<Attention> listattentionid(Integer userid) {
		List<Attention> blogs = null;
		blogs = dao.findattention(userid);
		for(Attention b : blogs){
			Regist ruser = dao.listuserid(b.getUserid());
			b.setRegistinfo(ruser);
		}		
		return blogs;
	}
	// 通过  找到指定id的粉丝（被关注的）  链接到 用户信息
	public List<Attention> listattentionuserid(Integer userid) {
		List<Attention> blogs = null;
		blogs = dao.findattentionuserid(userid);
		for(Attention b : blogs){
			Regist ruser = dao.listuserid(b.getId());
			b.setRegistinfo(ruser);
		}		
		return blogs;
	}
	// 用于  通过指定type找到博客   链接到  用户  评论 和 关注
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
