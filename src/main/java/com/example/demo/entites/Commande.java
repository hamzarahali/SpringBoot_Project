package com.example.demo.entites;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
	
	@Column ( name = "id_article" ) 
	private Long id_art ; 
	
	@Column ( name = "quantity" )
	private int qte ; 
	
	@Column ( name = "id_client" )
	private Long id_clt ;

	public Commande(Long id, Long id_art, int qte, Long id_clt) {
		super();
		this.id = id;
		this.id_art = id_art;
		this.qte = qte;
		this.id_clt = id_clt;
	}
	
	public Commande( Long id_art, Long id_clt) {
		this.id_art = id_art;
		this.id_clt = id_clt;
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

	public Long getId_art() {
		return id_art;
	}

	public void setId_art(Long id_art) {
		this.id_art = id_art;
	}

	public int getQte() {
		return qte;
	}

	public void setQte(int qte) {
		this.qte = qte;
	}

	public Long getId_clt() {
		return id_clt;
	}

	public void setId_clt(Long id_clt) {
		this.id_clt = id_clt;
	}
	
}