package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entites.Commande;

public interface CommandeDao extends JpaRepository<Commande, Long> {
	@Query(
			  value = "SELECT * FROM commandes c WHERE c.id = :x", 
			  nativeQuery = true)
			Commande Rech( @Param ("x") long id_cmd );
	

}
