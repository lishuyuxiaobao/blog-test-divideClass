package nuc.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.sun.xml.internal.bind.v2.runtime.reflect.Lister.IDREFSIterator;

import nuc.db.Dao;
import nuc.entity.Attention;
import nuc.entity.Blog;
import nuc.entity.Regist;
import nuc.service.BlogService;

public class LoginAction extends ActionSupport implements ModelDriven{

	private Blog blog = new Blog();
    private Regist ruser = new Regist();
    private List<Regist> listusers = new ArrayList<Regist>();
    private List<Attention> listattentions = new ArrayList<Attention>();
    private List<Attention> listattentionsuserid = new ArrayList<Attention>();
    
	public List<Attention> getListattentionsuserid() {
		return listattentionsuserid;
	}

	public void setListattentionsuserid(List<Attention> listattentionsuserid) {
		this.listattentionsuserid = listattentionsuserid;
	}

	public List<Attention> getListattentions() {
		return listattentions;
	}

	public void setListattentions(List<Attention> listattentions) {
		this.listattentions = listattentions;
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

	public Blog getBlog() {
		return blog;
	}

	public void setBlog(Blog blog) {
		this.blog = blog;
	}
    Dao dao = new Dao();
	public String LoginMethod() {
		ActionContext.getContext().getSession().put("id", ruser.getId());
		/*listblogs = bService.listblogs();*/
		listusers = dao.finduserid(ruser.getId());
		Iterator iter = listusers.iterator();
		if (iter.hasNext()) {
			Regist newruser = (Regist) iter.next();
			if(newruser.getPassword().equals(ruser.getPassword())) {
				listattentions = dao.findattention(ruser.getId());
				listattentionsuserid = dao.findattentionuserid(ruser.getId());

				return "loginOK";
			}
		}
		this.addFieldError("error", "用户名或密码错误！");
		return LOGIN;		
	}
	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return ruser;
	}

	
}
