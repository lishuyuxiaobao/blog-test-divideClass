package nuc.entity;

import java.util.List;

public class Blog {

	private int id;
	private String type;
	private String content;
	private String photo;
	private String time;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	private Regist registinfo;
	public Regist getRegistinfo() {
		return registinfo;
	}
	public void setRegistinfo(Regist registinfo) {
		this.registinfo = registinfo;
	}
	private Attention attentioninfo;
	public Attention getAttentioninfo() {
		return attentioninfo;
	}
	public void setAttentioninfo(Attention attentioninfo) {
		this.attentioninfo = attentioninfo;
	}
	private Comment commentinfo;
	public Comment getCommentinfo() {
		return commentinfo;
	}
	public void setCommentinfo(Comment commentinfo) {
		this.commentinfo = commentinfo;
	}
	private List<Comment> comments;
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	
}
