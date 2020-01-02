package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entites.Article;

public interface ArticleDao extends JpaRepository<Article, Long> {
	
	@Query(
			  value = "SELECT * FROM articles a WHERE a.id = :x", 
			  nativeQuery = true)
			Article Rech( @Param ("x") Long id );
	
}