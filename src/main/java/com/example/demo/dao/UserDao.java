package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entites.User;

public interface UserDao extends JpaRepository<User, Long>{
	
	User findByLogin ( String login ) ; 
	
}