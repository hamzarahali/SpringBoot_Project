package com.example.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dao.ArticleDao;
import com.example.demo.dao.ClientDao;
import com.example.demo.dao.CommandeDao;
import com.example.demo.entites.Article;
import com.example.demo.entites.Client;
import com.example.demo.entites.Commande;

@Controller 
@RequestMapping ("/OrendaJE")

public class CommandeController {

	@Autowired
	ClientDao cd ;
	@Autowired
	ArticleDao ad ;
	@Autowired
	CommandeDao cmdd ; 

	@RequestMapping ( value = "/card" , method = RequestMethod.GET ) 
	public String ViewCard ( Model m , @RequestParam(name="email", defaultValue="0")String email ) {
		Client clt = cd.findByEmail(email) ;
		m.addAttribute("y", true) ;
		m.addAttribute("z", false) ;
		m.addAttribute("client", clt ) ;
		Commande cmd = (Commande) cmdd.findAll() ; 
		Article art = ad.Rech(cmd.getId_art()) ; 
		m.addAttribute("cmd", cmd) ; 
		m.addAttribute("art", art) ;
		return "card" ;
	}
	
	
}
