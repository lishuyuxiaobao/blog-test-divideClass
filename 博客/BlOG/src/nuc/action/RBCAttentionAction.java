package nuc.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import nuc.db.Dao;
import nuc.entity.Attention;
import nuc.entity.Blog;
import nuc.entity.Regist;
import nuc.service.BlogService;

public class RBCAttentionAction extends ActionSupport implements ModelDriven{

	private Regist ruser = new Regist();
	private List<Regist> listusers = new ArrayList<Regist>();
	private List<Blog> listblogs = new ArrayList<Blog>();
	private BlogService bService = new BlogService();
    private List<Attention> listattentions = new ArrayList<Attention>();
    private List<Attention> listattentionsuserid = new ArrayList<Attention>();
    private List<Attention> listhortrait = new ArrayList<Attention>();
    private List<Attention> listattentionhortrait = new ArrayList<Attention>();
    
	public List<Attention> getListattentionhortrait() {
		return listattentionhortrait;
	}

	public void setListattentionhortrait(List<Attention> listattentionhortrait) {
		this.listattentionhortrait = listattentionhortrait;
	}

	public List<Attention> getListhortrait() {
		return listhortrait;
	}

	public void setListhortrait(List<Attention> listhortrait) {
		this.listhortrait = listhortrait;
	}

	public List<Attention> getListattentions() {
		return listattentions;
	}

	public void setListattentions(List<Attention> listattentions) {
		this.listattentions = listattentions;
	}

	public List<Attention> getListattentionsuserid() {
		return listattentionsuserid;
	}

	public void setListattentionsuserid(List<Attention> listattentionsuserid) {
		this.listattentionsuserid = listattentionsuserid;
	}

	public List<Blog> getListblogs() {
		return listblogs;
	}

	public void setListblogs(List<Blog> listblogs) {
		this.listblogs = listblogs;
	}

	public List<Regist> getListusers() {
		return listusers;
	}

	public void setListusers(List<Regist> listusers) {
		this.listusers = listusers;
	}

	public Regist getRuser() {
		return ruser;
	}

	public void setRuser(Regist ruser) {
		this.ruser = ruser;
	}
	Dao dao = new Dao();
	//个人信息  和  他人信息的展示
	public String RBCAttentionMethod() {
		listusers = dao.finduserid(ruser.getId());
		listblogs = bService.listblogsid(ruser.getId());
		listattentions = dao.findattention(ruser.getId());
		listattentionsuserid = dao.findattentionuserid(ruser.getId());
		listhortrait = bService.listattentionid(ruser.getId());
		listattentionhortrait = bService.listattentionuserid(ruser.getId());
		return SUCCESS;	
	}

	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return ruser;
	}

}
