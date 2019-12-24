package com.example.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.dao.ClientDao;
import com.example.demo.dao.UserDao;
import com.example.demo.entites.Client;
import com.example.demo.entites.User;

@Controller 
@RequestMapping ("/OrendaJE")

public class PageAccueilController {

	@Autowired
	ClientDao cd ; 
	UserDao ud ;
	
	@RequestMapping ("/accueil")
	public String AccueilPage ( ) {
		return "index" ; 
	}
	
	@RequestMapping ( value = "/login" , method = RequestMethod.GET )
	public String LoginPage ( Model m ) {
		Client clt = new Client () ; 
		m.addAttribute("x",false) ;
		m.addAttribute("erreur","") ; 
		m.addAttribute("client", clt) ; 
		return "login" ;
	}
	
	@RequestMapping ( value = "/register" , method = RequestMethod.GET )
	public String RegisterPage ( Model m ) {
		Client clt = new Client () ; 
		m.addAttribute("client", clt) ;
		m.addAttribute("x",false) ;
		m.addAttribute("erreur","") ; 
		return "register" ;
	}
	
	@RequestMapping ( value = "/save_client" , method = RequestMethod.POST )
	public String SaveClient ( Model m , Client client ) {
		Client clt_check = cd.findByEmail (client.getEmail())  ;
		if ( clt_check != null ) {
			m.addAttribute("erreur", "Email valid in the database") ;
			m.addAttribute("x",true) ; 
			return "register" ; 
		} else {
			cd.save(client) ; 
			return "login" ;
		}
	}
	
	@RequestMapping ( value = "/auth" , method = RequestMethod.POST )
	public String CheckAccount ( Model m , Client clt) {
		Client clt_Check = cd.findByEmail(clt.getEmail()) ; 
		if ( clt_Check == null ) {
			m.addAttribute("erreur", "Email or Password Invalid") ;
			m.addAttribute("x",true) ; 
			return "login" ; 
		} else 
			return "index" ; 
	}

}