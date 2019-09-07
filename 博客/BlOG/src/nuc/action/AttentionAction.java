package nuc.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import nuc.db.Dao;
import nuc.entity.Attention;
import nuc.entity.Blog;
import nuc.service.BlogService;

public class AttentionAction extends ActionSupport implements ModelDriven{

	private List<Blog> listblogs = new ArrayList<Blog>();
	private BlogService bService = new BlogService();
	private Attention attention = new Attention();
private List<Attention> listattentions = new ArrayList<Attention>();
    
	public List<Attention> getListattentions() {
		return listattentions;
	}

	public void setListattentions(List<Attention> listattentions) {
		this.listattentions = listattentions;
	}
	public List<Blog> getListblogs() {
		return listblogs;
	}

	public void setListblogs(List<Blog> listblogs) {
		this.listblogs = listblogs;
	}

	public Attention getAttention() {
		return attention;
	}

	public void setAttention(Attention attention) {
		this.attention = attention;
	}
    Dao dao = new Dao();
	public String AddAttentionMethod() {
		attention.setId(attention.getId());
		attention.setUserid(attention.getUserid());
		attention.setAttention("2.jpg");
		dao.addattention(attention);
		listblogs = bService.listblogs();
		listattentions = dao.findattention(attention.getId());
		return SUCCESS;
	}
	public String DeleteAttentionMethod() {
		attention.setId(attention.getId());
		attention.setUserid(attention.getUserid());
		dao.deletetattention(attention);
		listblogs = bService.listblogs();
		listattentions = dao.findattention(attention.getId());
		return SUCCESS;
	}
	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return attention;
	}

	
}
