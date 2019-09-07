package nuc.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import nuc.db.Dao;
import nuc.entity.Attention;
import nuc.entity.Blog;
import nuc.entity.Comment;
import nuc.service.BlogService;

public class CommentAction extends ActionSupport implements ModelDriven{

	private Comment comment = new Comment();
	private List<Blog> listblogs = new ArrayList<Blog>();
	private BlogService bService = new BlogService();
    private List<Attention> listattentions = new ArrayList<Attention>();
    private List<Comment> listcomments = new ArrayList<Comment>();
    
	public List<Blog> getListblogs() {
		return listblogs;
	}

	public void setListblogs(List<Blog> listblogs) {
		this.listblogs = listblogs;
	}

	public List<Attention> getListattentions() {
		return listattentions;
	}

	public void setListattentions(List<Attention> listattentions) {
		this.listattentions = listattentions;
	}

	public Comment getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}

	Dao dao = new Dao();
	public String AddCommentMethod() {	
		comment.setId(comment.getId());
		comment.setUserid(comment.getUserid());
		comment.setContent(comment.getContent());
		comment.setTime(comment.getTime());
		dao.addcomment(comment);
		listblogs = bService.listblogs();
		listattentions = dao.findattention(comment.getId());
		return SUCCESS;
	}
	public String DeleteCommentMethod() {
		comment.setCommenttime(comment.getCommenttime());
		dao.deletetcommenttime(comment);
		listblogs = bService.listblogs();
		listattentions = dao.findattention(comment.getId());
		return SUCCESS;
	}
	/*public String ListCommentsMethod() {
		listcomments = dao.listcommenttimeid(comment.getTime());
		return "listcommentsOK";
	}*/
	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return comment;
	}

}
