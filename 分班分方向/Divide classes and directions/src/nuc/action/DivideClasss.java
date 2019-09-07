package nuc.action;

import java.security.KeyStore.PrivateKeyEntry;
import java.util.*;

import org.apache.commons.lang3.StringUtils;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.org.apache.bcel.internal.generic.NEW;

import nuc.database.Dao;
import nuc.entity.*;

public class DivideClasss extends ActionSupport{
	private String direction;
	private Classname cn = new Classname();
	
	public Classname getCn() {
		return cn;
	}
	public void setCn(Classname cn) {
		this.cn = cn;
	}
	private String num;
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	Dao dao=new Dao();
	List<Directionlist> dList=null;
	List<Directionlist> dList2=null;
public List<Directionlist> getdList2() {
		return dList2;
	}
	public void setdList2(List<Directionlist> dList2) {
		this.dList2 = dList2;
	}
public List<Directionlist> getdList() {
		return dList;
	}
	public void setdList(List<Directionlist> dList) {
		this.dList = dList;
	}
	//得到报名方向人数
public String  GetNum(){
	dList=dao.listdirectionlist(direction);
	ActionContext.getContext().getSession().put("direction",direction);
	return SUCCESS;
}
List<Direction> directions;
public List<Direction> getDirections() {
	return directions;
}
public void setDirections(List<Direction> directions) {
	this.directions = directions;
}
//分方向
public String direct() {
	directions=dao.listopendirection("0");
	return "ok";
}
//分班
public String Dclass() {
	dList=dao.listdirectionlist(direction);
	  System.out.println(num); 
	  String[] strArr=StringUtils.split(num,",");
	  int j=1;
	  for (int i=0;i<strArr.length-1;i++) {
	  	System.out.println(strArr[i]);
	  	dList2=dList.subList(Integer.valueOf(strArr[i]),Integer.valueOf(strArr[i+1]));
	  	for(Directionlist dl : dList2) {
	  		dl.setClassname(direction+j+"班");
			dl.setSid(dl.getSid());
			dao.updateclassesname(dl);
	  	}
	  	cn.setDirection(direction);
	  	cn.setClassname(direction+j+"班");
	  	dao.addclassname(cn);
	  	j++;
	  	System.out.println(j);
	  }

	return "Dok";
 }
}

