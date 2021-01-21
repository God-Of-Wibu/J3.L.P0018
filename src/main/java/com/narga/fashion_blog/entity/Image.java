package com.narga.fashion_blog.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Image {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "url", nullable = false)
	private String url;
	
	@Column(name = "file_location", nullable = true)
	private String fileLocation;

	public Image(String url, String fileLocation) {
		this.url = url;
		this.fileLocation = fileLocation;
	}

	public Image(String url) {
		this.url = url;
	}
	

}
