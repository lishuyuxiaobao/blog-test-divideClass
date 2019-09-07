package nuc.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;

import nuc.db.Dao;
import nuc.entity.Regist;

public class RegistAction extends ActionSupport implements ModelDriven{
    private Regist ruser= new Regist();
    Dao dao = new Dao();
    private File file;
	private String fileContentType;
	private String fileFileName;
	private String savePath;
    private List<Regist> listusers = new ArrayList<Regist>();
    
	public List<Regist> getListusers() {
		return listusers;
	}

	public void setListusers(List<Regist> listusers) {
		this.listusers = listusers;
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

	public Regist getRuser() {
	return ruser;
}

    public void setRuser(Regist ruser) {
	this.ruser = ruser;
}
    public String RegistMethod() throws IOException {
    	String realpath=savePath + "/" +UUID.randomUUID()+"_"+ fileFileName;
		FileInputStream fis = new FileInputStream(file);
		FileOutputStream fos = new FileOutputStream(realpath);
		byte[] buffer = new byte[1024];
		int len=0;
		while((len = fis.read(buffer)) > 0) {
			fos.write(buffer, 0, len);
		}
		ruser.setId(ruser.getId());
		ruser.setUsername(ruser.getUsername());
		ruser.setPassword(ruser.getPassword());
		ruser.setEmail(ruser.getEmail());
		ruser.setHportrait(realpath);
		dao.addregist(ruser);
    	return "registOK";
    }
    public String UpdateRegistMethod() {
    	listusers = dao.finduserid(ruser.getId());
    	return SUCCESS;
    }
    public String UpdateRegistUserMethod() {
    	ruser.setId(ruser.getId());
    	dao.updateregist(ruser);
    	return SUCCESS;
    }
    
	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return ruser;
	}

}
