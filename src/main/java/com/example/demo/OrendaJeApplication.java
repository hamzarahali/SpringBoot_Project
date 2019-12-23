package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.demo.dao.ClientDao;

@SpringBootApplication
public class OrendaJeApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(OrendaJeApplication.class, args);
		ClientDao cr  = ctx.getBean(ClientDao.class); 
	}

}
