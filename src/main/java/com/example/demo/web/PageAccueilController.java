package com.example.demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller 
@RequestMapping ("/OrendaJE")

public class PageAccueilController {

	@RequestMapping ("/accueil")
	public String AccueilPage () {
		return "index" ; 
	}
}