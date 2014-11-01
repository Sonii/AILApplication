package com.esiea.lookat;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.esiea.lookat.dao.*;
import com.esiea.lookat.entities.*;
import com.esiea.lookat.metier.*;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	public static final String CONF_DAO_FACTORY = "daofactory";
	
	@Autowired
	private ObjetMetier siteMetier = new SiteMetierImpl();
	
	@Autowired
	private ObjetMetier commentaireM = new CommentaireMetierImpl();
    
	@Autowired
	private ObjetMetier categorieM = new CategorieMetierImpl();
	
	@Autowired
	private ObjetMetier utilisateurM = new UtilisateurMetierImpl();
    
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {

		
		////BASIC FUNCTION
		//Creation
		Utilisateur user1 =  new Utilisateur(1, "thomasremond@yahoo.fr", "Sonii", "123456");
		utilisateurM.createUser(user1);
		model.addAttribute("user1", user1.toString());
		
		
		Site site1 = new Site(1,"http://localhost.fr",1,"Mon PC en Local","LocalHost",0,user1.getId());
		Site site2 = new Site(1,"http://www.google.fr",1,"Ca c google","Google",0,user1.getId());
		siteMetier.createSite(site1);
		model.addAttribute("site1", site1.toString());
		siteMetier.createSite(site2);
		model.addAttribute("site2", site2.toString());
		
		Commentaire com1 =  new Commentaire (1,2,site1.getId(),"Tres bon site",user1.getId());
		Commentaire com2 =  new Commentaire (1,3,site1.getId(),"Exellent",user1.getId());
		commentaireM.createCom(com1);
		model.addAttribute("com1", com1.toString());
		commentaireM.createCom(com2);
		model.addAttribute("com2", com2.toString());
		
		
		//Modifié puis chercher
		user1.setPassword("LOL");
		utilisateurM.modifyUser(user1);
		user1=utilisateurM.findUser(user1.getId());
		model.addAttribute("user12", user1.toString());
		
		site1.setDescription("Mon PC 2");
		siteMetier.modifySite(site1);
		site1=siteMetier.findSite(site1.getId());
		model.addAttribute("site12", site1.toString());
		
		com1.setContenu("En faite c null lol");
		commentaireM.modifyCom(com1);
		com1=commentaireM.findCom(com1.getId());
		model.addAttribute("com12", com1.toString());
		
		////Advanced Function
		//Site
		ArrayList <Commentaire> comssite = (ArrayList<Commentaire>) siteMetier.getlistComs(site1);
		model.addAttribute("coms",comssite.toString());
		
		Categorie catsite = siteMetier.getSiteCategorie(site1);
		model.addAttribute("catsite",catsite.toString());
		
		ArrayList <Site> sitessite = (ArrayList<Site>) siteMetier.getAllSites();
		model.addAttribute("sites", sitessite.toString());
		
		Utilisateur usersite = siteMetier.getSiteUser(site1);
		model.addAttribute("usersite", usersite.toString());
		

		
		
		//Commentaire
		Site sitecom = commentaireM.getSiteCom(com1);
		model.addAttribute("sitecom", sitecom.toString());
		
		Utilisateur usercom = commentaireM.getComUser(com1);
		model.addAttribute("usercom", usercom.toString());
		
		
		
		//Categorie
		Categorie catcat = categorieM.findCategorie(1);
		model.addAttribute("catcat",catcat.toString());
		
		ArrayList <Categorie> catscat = (ArrayList<Categorie>) categorieM.getAllCategories();
		model.addAttribute("catscat", catscat.toString());
		
		ArrayList <Site> sitescat = (ArrayList<Site>) categorieM.getCategorieSites(catcat);
		model.addAttribute("sitescat", sitescat);


		utilisateurM.deleteUser(user1);
		
		return "home";
	}
	
}
