package com.example.demo.web;

import java.util.List;

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

public class HifiController {

	@Autowired
	ClientDao cd ;
	@Autowired
	ArticleDao ad ;
	@Autowired
	CommandeDao cmdd ; 
	
	@RequestMapping ( value = "/hifi" , method = RequestMethod.GET )
	public String ViewHifi ( Model m , @RequestParam(name="email", defaultValue="0")String email ) {
		Client clt = cd.findByEmail(email) ; 
		m.addAttribute("y", true) ;
		m.addAttribute("client", clt ) ; 
		List liste = (List) ad.findByCat("hifi") ; 
		m.addAttribute("articles", liste) ;
		return "hifi" ; 
	}
	
	@RequestMapping ( value ="/addcard" , method = RequestMethod.GET ) 
	public String AddCard ( Model m , @RequestParam(name="email", defaultValue="0")String email , @RequestParam(name="id_art",defaultValue="0")int  id ) {
		Client clt = cd.findByEmail(email) ; 
		m.addAttribute("y", true) ;
		m.addAttribute("client", clt ) ; 
		m.addAttribute("z", true) ; 
		Article art = ad.Rech(new Long(id)) ; 
		m.addAttribute("article", art) ; 
		return "card" ;
	}
	
	@RequestMapping ( value = "/confirm" , method = RequestMethod.GET ) 
	public String ConfirmArticle ( Model m ,@RequestParam(name="email", defaultValue="0")String email , @RequestParam(name="id_art",defaultValue="0")int id ) {
		Client clt = cd.findByEmail(email) ; 
		Article art = ad.Rech(new Long(id)) ; 
		Commande cmds = new Commande (art,clt.getId()) ;
		cmdd.save(cmds) ;
		if ( cmds != null )
		m.addAttribute("y", true) ;
		m.addAttribute("client", clt ) ; 
		m.addAttribute("z", false) ; 
		List cmd = cmdd.findAll() ; 
		m.addAttribute("cmd", cmd) ; 
		return "card" ; 
	}
	
	@RequestMapping ( value = "/delete" , method = RequestMethod.GET ) 
	public String DeleteView ( Model m , @RequestParam(name="email", defaultValue="0")String email ) {
		Client clt = cd.findByEmail(email) ; 
		m.addAttribute("y", true) ;
		m.addAttribute("client", clt ) ; 
		List liste = (List) ad.findByCat("hifi") ;
		m.addAttribute("articles", liste) ;
	 	return "hifi" ; 
	}
	
}