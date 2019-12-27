package com.example.demo.web;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dao.ClientDao;
import com.example.demo.entites.Client;


@Controller 
@RequestMapping ("/OrendaJE")

public class PageAccueilController {

	@Autowired
	ClientDao cd ;
	
	
	@RequestMapping ( value = "/accueil" , method = RequestMethod.GET )
	public String AccueilPage ( Model m , @RequestParam(name="y" , defaultValue="false")boolean y , @RequestParam(name="email" , defaultValue="")String email ) {
		if ( y == true ) {
			Client clt = cd.findByEmail(email) ; 
			m.addAttribute("client", clt) ; 
			m.addAttribute("y", y) ; 
			return "index" ; 
		}
		m.addAttribute("y", false) ;
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
	
}