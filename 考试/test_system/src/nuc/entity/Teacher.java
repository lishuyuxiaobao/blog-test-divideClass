package nuc.entity;

public class Teacher {
	private int t_id;
	private String t_name;
	private String t_pass;
	private String t_class;
	
	public String getT_class() {
		return t_class;
	}
	public void setT_class(String t_class) {
		this.t_class = t_class;
	}
	public int getT_id() {
		return t_id;
	}
	public void setT_id(int t_id) {
		this.t_id = t_id;
	}
	public String getT_name() {
		return t_name;
	}
	public void setT_name(String t_name) {
		this.t_name = t_name;
	}
	public String getT_pass() {
		return t_pass;
	}
	public void setT_pass(String t_pass) {
		this.t_pass = t_pass;
	}
	
}
