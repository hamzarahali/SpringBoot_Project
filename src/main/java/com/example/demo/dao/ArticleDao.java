package com.example.demo.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entites.Article;

public interface ArticleDao extends JpaRepository<Article, Long> {

}
