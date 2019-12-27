package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entites.Client;

public interface ClientDao extends JpaRepository<Client, Long> {

	Client findByEmail ( String email ) ;
	Optional<Client> findById ( Long id ) ;

}