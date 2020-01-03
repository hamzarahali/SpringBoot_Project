package com.example.demo.web;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dao.ArticleDao;
import com.example.demo.dao.ClientDao;
import com.example.demo.entites.Article;
import com.example.demo.entites.Client;

@Controller 
@RequestMapping ("/OrendaJE")

public class AccountController {

	@Autowired
	ClientDao cd ;
	@Autowired
	ArticleDao ad ;
	
	@RequestMapping ( value = "/auth" , method = RequestMethod.POST )
	public String CheckAccount ( Model m , Client clt ) {
		Client clt_Check = cd.findByEmail(clt.getEmail()) ; 
		if ( clt_Check == null || clt.getPassword().compareTo(clt_Check.getPassword()) !=0 ) {
			m.addAttribute("erreur", "Email or Password Invalid") ;
			m.addAttribute("x",true) ; 
			return "login" ; 
		} else  {
			m.addAttribute("y", true) ;
			m.addAttribute("client", clt_Check ) ; 
			return "index" ; 
			}
	}
	
	@RequestMapping ( value = "/profile" , method = RequestMethod.GET ) 
	public String ViewProfile ( Model m , @RequestParam(name="email", defaultValue="0")String email ) {
		Client clt = cd.findByEmail(email) ; 
		m.addAttribute("y", true) ;
		m.addAttribute("client", clt ) ; 
	 	return "profile" ; 
	}
	
	@RequestMapping ( value = "/update" , method = RequestMethod.POST ) 
	public String UpdateAccount ( Model m , Client client ) {
		cd.save(client) ;
		m.addAttribute("client", client) ; 
		m.addAttribute("y", true ) ;
 		return "profile" ;
	}
	
	@RequestMapping ( value = "/homeappliance" , method = RequestMethod.GET )
	public String ViewHomeAppliance ( Model m , @RequestParam(name="email", defaultValue="0")String email ) {
		Client clt = cd.findByEmail(email) ; 
		m.addAttribute("y", true) ;
		m.addAttribute("client", clt ) ;
		return "homeappliance" ; 
	}
	
}