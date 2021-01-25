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
public class Message {
	@Id
	@Column(name = "id")
	@GeneratedValue
	private Integer id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "content")
	private String content;
	
	@Column(name = "time_stamp")
	private Date timeStamp;

	public Message(String name, String email, String content, Date timeStamp) {
		super();
		this.name = name;
		this.email = email;
		this.content = content;
		this.timeStamp = timeStamp;
	}	
	
	
}
