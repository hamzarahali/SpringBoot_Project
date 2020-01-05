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
	private int prix;
	
	@Column(name="img")
	private String img;
	
	@Column ( name = "category" ) 
	private String cat ; 
	
	@OneToOne ( mappedBy = "article" )
	public Commande commande ;

public Article() {
		super();
		// TODO Auto-generated constructor stub
	}

public Article(Long id, String title, String desc, int prix, String img, String cat, Commande commande) {
	super();
	this.id = id;
	this.title = title;
	this.desc = desc;
	this.prix = prix;
	this.img = img;
	this.cat = cat;
	this.commande = commande;
}
public Article(String title, String desc, int prix, String img, String cat) {
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

public int getPrix() {
	return prix;
}

public void setPrix(int prix) {
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

public Commande getCommande() {
	return commande;
}

public void setCommande(Commande commande) {
	this.commande = commande;
}

}
