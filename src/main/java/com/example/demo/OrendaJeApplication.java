
package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.demo.dao.ClientDao;
import com.example.demo.entites.Client;

@SpringBootApplication
public class OrendaJeApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(OrendaJeApplication.class, args);
		
		
		
		ClientDao cr  = ctx.getBean(ClientDao.class); 
		Client clt = new Client ("Hamza","Rahali","12 Street Djrissa","hamzarahali61@gmail.com","Hr123456789") ;
		cr.save(clt) ; 

	}

}
