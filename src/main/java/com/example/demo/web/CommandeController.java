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
		m.addAttribute("client", clt ) ;
		m.addAttribute("msg", "") ; 
		List cmd = cmdd.findAll() ; 
		m.addAttribute("cmd", cmd) ;
		boolean z ; 
		if ( cmd.isEmpty() ) 
			z = false ; 
		else z = true ; 
		m.addAttribute("z", z) ; 
		return "card" ;
	}

	@RequestMapping ( value = "/deletecmd" , method = RequestMethod.GET ) 
	public String DeleteCommande ( Model m , @RequestParam(name="email", defaultValue="0")String email , @RequestParam(name="cmd", defaultValue="0")long id_cmd) {
		Client clt = cd.findByEmail(email) ;
		m.addAttribute("y", true) ;
		m.addAttribute("client", clt ) ;
		cmdd.deleteById(id_cmd);
		m.addAttribute("msg", "Command delete successfully") ; 
		List cmd = cmdd.findAll() ; 
		m.addAttribute("cmd", cmd) ;
		boolean z ; 
		if ( cmd.isEmpty() ) 
			z = false ; 
		else z = true ; 
		m.addAttribute("z", z) ; 
		return "card" ;
	}
	
	@RequestMapping ( value = "/editcmd" , method = RequestMethod.GET )
	public String EditPageCommande ( Model m , @RequestParam(name="email", defaultValue="0")String email , @RequestParam(name="art", defaultValue="0")long id_art , @RequestParam(name="cmd", defaultValue="0")long id_cmd) {
		Client clt = cd.findByEmail(email) ;
		m.addAttribute("y", true) ;
		m.addAttribute("client", clt ) ;
		m.addAttribute("z", true) ; 
		Article art = ad.Rech(id_art) ; 
		m.addAttribute("article", art) ;
		Commande cmd = cmdd.Rech(id_cmd) ;
		m.addAttribute("cmd", cmd);
		return "addcard" ;
	}
	
	@RequestMapping ( value = "/confirmedit" , method = RequestMethod.POST )
	public String EditCommande ( Model m , Commande cmd , @RequestParam(name="email", defaultValue="0")String email , @RequestParam(name="cmd", defaultValue="0")int id_cmd , @RequestParam(name="id_art",defaultValue="0")int id ) {
		cmdd.deleteById(new Long(id_cmd));
		Client clt = cd.findByEmail(email) ; 
		Article art = ad.Rech(new Long(id)) ; 
		cmd.setArticle(art);
		cmd.setClient(clt);
		cmdd.save(cmd) ;
		m.addAttribute("y", true) ;
		m.addAttribute("client", clt ) ; 
		m.addAttribute("z", true) ; 
		List liste = cmdd.findAll() ; 
		m.addAttribute("cmd", liste) ;
		m.addAttribute("msg", "Edit command successfully") ;
		return "card" ; 
	}

	@RequestMapping ( value = "/print" , method = RequestMethod.GET )
	public String PrintCommandeView ( Model m , @RequestParam(name="email", defaultValue="0")String email , @RequestParam(name="cmd", defaultValue="0")long id_cmd ) {
		Client clt = cd.findByEmail(email) ; 
		m.addAttribute("y", true) ;
		m.addAttribute("client", clt ) ; 
		Commande cmd = cmdd.Rech(id_cmd) ;
		m.addAttribute("cmd", cmd) ; 
		return "print" ; 
	}
}