package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entites.Client;

public interface ClientDao extends JpaRepository<Client, Long> {

}
