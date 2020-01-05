package com.example.demo.entites;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table ( name = "Commandes" )
@Getter 
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Commande implements Serializable {
	
	@Id
	@GeneratedValue
	private Long id ; 
	
	@OneToOne
	private Article article ; 
	
	@OneToOne
	private Client client ;
	
	@Column ( name = "quantity" )
	private int qte ;

	public Commande(Long id, Article article, Client client, int qte) {
		super();
		this.id = id;
		this.article = article;
		this.client = client;
		this.qte = qte;
	}

	public Commande() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public int getQte() {
		return qte;
	}

	public void setQte(int qte) {
		this.qte = qte;
	} 
	
	
}