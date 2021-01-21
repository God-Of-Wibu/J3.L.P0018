package com.narga.fashion_blog.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Article {
	@Id
	@Column(name = "id")
	@GeneratedValue
	private int id;
	
	@Column(name = "title")
	private String title;
	
	public Article(String title, Date date, String icon, String poster, String content) {
		super();
		this.title = title;
		this.date = date;
		this.icon = icon;
		this.poster = poster;
		this.content = content;
	}

	@Column(name = "date")
	private Date date;
	
	@Column(name = "icon")
	private String icon;
	
	@Column(name = "poster")
	private String poster;

	@Column(name = "content", columnDefinition = "nvarchar(1000)")
	private String content;

}
