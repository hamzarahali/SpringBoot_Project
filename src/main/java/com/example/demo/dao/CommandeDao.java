package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entites.Commande;

public interface CommandeDao extends JpaRepository<Commande, Long> {

}
