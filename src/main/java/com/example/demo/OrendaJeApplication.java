
package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.demo.dao.ArticleDao;
import com.example.demo.dao.ClientDao;
import com.example.demo.entites.Article;
import com.example.demo.entites.Client;

@SpringBootApplication
public class OrendaJeApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(OrendaJeApplication.class, args);

		// Client 
		ClientDao cr  = ctx.getBean(ClientDao.class); 
		Client clt = new Client ("Hamza","Rahali","12 Street Djrissa","hamzarahali61@gmail.com","Hr123456789") ;
		cr.save(clt) ; 
		
		// Article 
		ArticleDao ad = ctx.getBean(ArticleDao.class) ; 
		Article a1 = new Article ("Chaîne HiFi Essentielb MS4001BT Bluetooth","Micro chaine GRUNDIG MS240.Lecteur CD compatible MP3/WMASimple cassette enregistreur (enregistre la radio, le CD, les ports USB ou SD )Enregistrement synchronisé CD/K7Tuner Digital PLL FM RDS 30 mémoiresPort USB + slot SD : Lecture MP3Fonctions Horloge, Alarme et SleepMise à l'heure automatique via le RDSLoudness AutomatiqueUltra Bass SystemEnceintes 2 voies Bass ReflexTélécommande.",500,"hifi1.jpg","hifi") ; 
		Article a2 = new Article ("Chaîne HiFi Essentielb MS4001BT Bluetooth","Micro chaine GRUNDIG MS240.Lecteur CD compatible MP3/WMASimple cassette enregistreur (enregistre la radio, le CD, les ports USB ou SD )Enregistrement synchronisé CD/K7Tuner Digital PLL FM RDS 30 mémoiresPort USB + slot SD : Lecture MP3Fonctions Horloge, Alarme et SleepMise à l'heure automatique via le RDSLoudness AutomatiqueUltra Bass SystemEnceintes 2 voies Bass ReflexTélécommande.",700,"hifi2.jpg","hifi") ; 
		Article a3 = new Article ("Chaîne HiFi Essentielb MS4001BT Bluetooth","Micro chaine GRUNDIG MS240.Lecteur CD compatible MP3/WMASimple cassette enregistreur (enregistre la radio, le CD, les ports USB ou SD )Enregistrement synchronisé CD/K7Tuner Digital PLL FM RDS 30 mémoiresPort USB + slot SD : Lecture MP3Fonctions Horloge, Alarme et SleepMise à l'heure automatique via le RDSLoudness AutomatiqueUltra Bass SystemEnceintes 2 voies Bass ReflexTélécommande.",420,"hifi3.jpg","hifi") ; 
		Article a4 = new Article ("Chaîne HiFi Essentielb MS4001BT Bluetooth","Micro chaine GRUNDIG MS240.Lecteur CD compatible MP3/WMASimple cassette enregistreur (enregistre la radio, le CD, les ports USB ou SD )Enregistrement synchronisé CD/K7Tuner Digital PLL FM RDS 30 mémoiresPort USB + slot SD : Lecture MP3Fonctions Horloge, Alarme et SleepMise à l'heure automatique via le RDSLoudness AutomatiqueUltra Bass SystemEnceintes 2 voies Bass ReflexTélécommande.",500,"hifi1.jpg","hifi") ; 
		Article a5 = new Article ("STAR ONE Four Electrique","STAR ONE Four Electrique - 36 Litres - Silver - Garantie 1 an\\n\" + \"Marque: STAR ONE | Produits similaires par STAR ONE",88,"four.jpg","electromenager") ; 

		ad.save(a1) ; 
		ad.save(a2) ; 
		ad.save(a3) ; 
		ad.save(a4) ; 
		ad.save(a5);

	}

}
