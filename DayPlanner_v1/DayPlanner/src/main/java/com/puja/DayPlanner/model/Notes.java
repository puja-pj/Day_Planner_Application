package com.puja.DayPlanner.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="notes")
public class Notes {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long noteid;
	
	

	@NotBlank
	@Column(nullable=false)
	private String noteName;
	
	@NotBlank
	@Lob
	@Column(nullable=false)
	private String content;
	
	@Column(nullable=false)
	private Date date=new Date();
	
	@ManyToOne
	@JoinColumn(name="id")
	private User user;

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	
	
	public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}
	
	

	public Long getNoteid() {
	return noteid;
}
public void setNoteid(Long noteid) {
	this.noteid = noteid;
}
	public String getNoteName() {
		return noteName;
	}
	public void setNoteName(String noteName) {
		this.noteName = noteName;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	
	
	public Notes() {}
	
	public Notes(Long noteid,String noteName, String content, User user) {
		super();
		this.noteid=noteid;
		this.noteName = noteName;
		this.content = content;
		this.user=user;
	}
	
	
	
	

}
