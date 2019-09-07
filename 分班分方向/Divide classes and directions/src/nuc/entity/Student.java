package nuc.entity;

import java.util.List;

public class Student {
private String name;
private int id;
private int classes;
private String sid;
private String password;
private List<Directionlist> listd;
private String type;
private long s_id;
private String s_department;

public String getS_department() {
	return s_department;
}
public void setS_department(String s_department) {
	this.s_department = s_department;
}


public long getS_id() {
	return s_id;
}
public void setS_id(long s_id) {
	this.s_id = s_id;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public List<Directionlist> getListd() {
	return listd;
}
public void setListd(List<Directionlist> listd) {
	this.listd = listd;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getSid() {
	return sid;
}
public void setSid(String sid) {
	this.sid = sid;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getClasses() {
	return classes;
}
public void setClasses(int classes) {
	this.classes = classes;
}
}
