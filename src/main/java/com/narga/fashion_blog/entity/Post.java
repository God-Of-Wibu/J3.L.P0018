package com.narga.fashion_blog.entity;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Post {
	
	public enum Type{
		IMAGE, ARTICLE
	}
	
	@Id
	@Column(name = "id")
	@GeneratedValue
	private int id;
	
	@Column(name = "title")
	private String title;
	
	public Post(String title, Date date, Image image, Type type, String content) {
		super();
		this.title = title;
		this.date = date;
		this.image = image;
		this.type = type;
		this.content = content;
	}

	@Column(name = "date")
	private Date date;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "type")
	private Type type;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
	@JoinColumn(name = "image")
	private Image image;

	@Column(name = "content", columnDefinition = "nvarchar(1000)")
	private String content;

}
