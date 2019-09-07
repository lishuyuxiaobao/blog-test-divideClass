package nuc.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import nuc.db.Dao;
import nuc.entity.Blog;
import nuc.entity.Comment;
import nuc.service.BlogService;

public class BlogAction extends ActionSupport implements ModelDriven {
    private Blog blog = new Blog();
    private File file;
	private String fileContentType;
	private String fileFileName;
	private String savePath;
	Dao dao = new Dao();
	private List<Blog> listblogs = new ArrayList<Blog>();
	private BlogService bService = new BlogService();
	private List<Comment> comments = new ArrayList<Comment>();
	
	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public List<Blog> getListblogs() {
		return listblogs;
	}

	public void setListblogs(List<Blog> listblogs) {
		this.listblogs = listblogs;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	public String getSavePath() {
		return savePath;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	public Blog getBlog() {
		return blog;
	}

	public void setBlog(Blog blog) {
		this.blog = blog;
	}
 
	public String BlogMethod() throws IOException {
/*		ActionContext.getContext().getSession().put("id", blog.getId());*/
		if(file!=null) {
	    String realpath=savePath + "/" +UUID.randomUUID()+"_"+ fileFileName;
		FileInputStream fis = new FileInputStream(file);
		FileOutputStream fos = new FileOutputStream(realpath);
		byte[] buffer = new byte[1024];
		int len=0;
		while((len = fis.read(buffer)) > 0) {
			fos.write(buffer, 0, len);
		}
		blog.setPhoto(realpath);
		}		
		blog.setId(blog.getId());
		blog.setType(blog.getType());
		blog.setContent(blog.getContent());
		dao.addblog(blog);
		listblogs = bService.listblogs();
		return "blogOK";
	}
	public String ListBlogMethod() {
		ActionContext.getContext().getSession().put("id", blog.getId());
		listblogs = bService.listblogs();
		return "listblogOk";
	}
	public String ListBlogTypeMethod() {
/*		ActionContext.getContext().getSession().put("id", blog.getId());*/
		listblogs = bService.listblogstype(blog.getType());
		
		return "listblogtypeOk";
	}
	public String DeleteBlogMethod() {
		dao.deletetblogtime(blog.getTime());
		dao.deletetblogcommenttime(blog.getTime());
		listblogs = bService.listblogs();
		return SUCCESS;
	}
	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return blog;
	}

}
