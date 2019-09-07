package nuc.entity;

public class Attention {

	private int id;
	private int userid;
	private String attention;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getAttention() {
		return attention;
	}
	public void setAttention(String attention) {
		this.attention = attention;
	}
	private Regist registinfo;
	public Regist getRegistinfo() {
		return registinfo;
	}
	public void setRegistinfo(Regist registinfo) {
		this.registinfo = registinfo;
	}
	
}
