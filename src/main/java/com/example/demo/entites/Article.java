package com.example.demo.entites;

import java.io.Serializable;

import javax.persistence.*;


import lombok.*;

@Entity
@Table(name="articles")
@Getter 
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Article implements Serializable {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name="title")
	private String title;
	
	@Column(name="description" , columnDefinition = "TEXT")
	private String desc;
	
	@Column(name="price")
	private String prix;
	
	@Column(name="img")
	private String img;
	
	@Column ( name = "category" ) 
	private String cat ; 

public Article() {
		super();
		// TODO Auto-generated constructor stub
	}

public Article(Long id, String title, String desc, String prix, String img, String cat) {
		super();
		this.id = id;
		this.title = title;
		this.desc = desc;
		this.prix = prix;
		this.img = img;
		this.cat = cat;
	}
public Article(String title, String desc, String prix, String img, String cat) {
	super();
	this.title = title;
	this.desc = desc;
	this.prix = prix;
	this.img = img;
	this.cat = cat;
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getTitle() {
	return title;
}

public void setTitle(String title) {
	this.title = title;
}

public String getDesc() {
	return desc;
}

public void setDesc(String desc) {
	this.desc = desc;
}

public String getPrix() {
	return prix;
}

public void setPrix(String prix) {
	this.prix = prix;
}

public String getImg() {
	return img;
}

public void setImg(String img) {
	this.img = img;
}

public String getCat() {
	return cat;
}

public void setCat(String cat) {
	this.cat = cat;
}


}
