package com.example.demo.web;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.dao.ClientDao;
import com.example.demo.entites.Client;

@Controller 
@RequestMapping ("/OrendaJE")

public class PageAccueilController {

	@Autowired
	ClientDao cd ; 
	
	@RequestMapping ("/accueil")
	public String AccueilPage () {
		return "index" ; 
	}
	
	@RequestMapping ("/login")
	public String LoginPage () {
		return "login" ;
	}
	
	@RequestMapping ( value = "/register" , method = RequestMethod.GET )
	public String RegisterPage ( Model m ) {
		Client clt = new Client () ; 
		m.addAttribute("client", clt) ;
		m.addAttribute("erreur","") ; 
		return "register" ;
	}
	
	@RequestMapping ( value = "/save_client" , method = RequestMethod.POST )
	public String SaveClient ( Model m , Client client ) {
		Client clt_check = cd.findByEmail(client.getEmail())  ;
		if ( clt_check != null ) {
			m.addAttribute("erreur", "EMAIL VALID IN THE DATABASE") ;
			return "register" ; 
		} else {
			cd.save(client) ; 
			return "login" ;
		}
	}
	
}