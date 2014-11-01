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
import java.util.List;
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
    
	
	/* ---------- Affichae des sites à partie de la catégorie ---------- */
	@RequestMapping(value = "/mode")
	public String getmodeCatSites(Model model) {
		Categorie cat = new Categorie();
		cat = categorieM.findCategorie(1);
		List<Site> sites = new ArrayList<Site>();
		sites = categorieM.getCategorieSites(cat);
		model.addAttribute("site", new Site());
		model.addAttribute("liste", sites);
		return "sitesCat";
	}
	@RequestMapping(value = "/sport")
	public String getsportCatSites(Model model) {
		Categorie cat = new Categorie();
		cat = categorieM.findCategorie(2);
		List<Site> sites = new ArrayList<Site>();
		sites = categorieM.getCategorieSites(cat);
		model.addAttribute("site", new Site());
		model.addAttribute("liste", sites);
		return "sitesCat";
	}
	@RequestMapping(value = "/itech")
	public String getitechCatSites(Model model) {
		Categorie cat = new Categorie();
		cat = categorieM.findCategorie(3);
		List<Site> sites = new ArrayList<Site>();
		sites = categorieM.getCategorieSites(cat);
		model.addAttribute("site", new Site());
		model.addAttribute("liste", sites);
		return "sitesCat";
	}
	@RequestMapping(value = "/word")
	public String getmondeCatSites(Model model) {
		Categorie cat = new Categorie();
		cat = categorieM.findCategorie(4);
		List<Site> sites = new ArrayList<Site>();
		sites = categorieM.getCategorieSites(cat);
		model.addAttribute("site", new Site());
		model.addAttribute("liste", sites);
		return "sitesCat";
	}
	@RequestMapping(value = "/sales")
	public String getsalesCatSites(Model model) {
		Categorie cat = new Categorie();
		cat = categorieM.findCategorie(5);
		List<Site> sites = new ArrayList<Site>();
		sites = categorieM.getCategorieSites(cat);
		model.addAttribute("site", new Site());
		model.addAttribute("liste", sites);
		return "sitesCat";
	}
	@RequestMapping(value = "/cinema")
	public String getcinemaCatSites(Model model) {
		Categorie cat = new Categorie();
		cat = categorieM.findCategorie(6);
		List<Site> sites = new ArrayList<Site>();
		sites = categorieM.getCategorieSites(cat);
		model.addAttribute("site", new Site());
		model.addAttribute("liste", sites);
		return "sitesCat";
	}
	@RequestMapping(value = "/people")
	public String getpeopleCatSites(Model model) {
		Categorie cat = new Categorie();
		cat = categorieM.findCategorie(7);
		List<Site> sites = new ArrayList<Site>();
		sites = categorieM.getCategorieSites(cat);
		model.addAttribute("site", new Site());
		model.addAttribute("liste", sites);
		return "sitesCat";
	}
	@RequestMapping(value = "/jeux")
	public String getjeuxCatSites(Model model) {
		Categorie cat = new Categorie();
		cat = categorieM.findCategorie(8);
		List<Site> sites = new ArrayList<Site>();
		sites = categorieM.getCategorieSites(cat);
		model.addAttribute("site", new Site());
		model.addAttribute("liste", sites);
		return "sitesCat";
	}
	/* ---------------------------------------------------------- */
	
	/* ----------------- Site Comms ------------------ */
	@RequestMapping(value = "/avis")
	public String avis(Model model, Integer id) {
		Site site = new Site();
		site = siteMetier.findSite(id);
		List<Commentaire> comms = new ArrayList<Commentaire>();
		comms = siteMetier.getlistComs(site);
		model.addAttribute("commentaire", new Commentaire());
		model.addAttribute("liste", comms);
		return "avisSite";
	}
	/* ----------------------------------------------- */
	
	@RequestMapping(value = "/home")
	public String home(Model model) {
		return "home";
	}
	
	@RequestMapping(value = "/publishSite")
	public String publishSite(Model model) {

		return "publishSite";
	}
		////BASIC FUNCTION
		//Creation
		/*Utilisateur user1 =  new Utilisateur(1, "thomasremond@yahoo.fr", "Sonii", "123456");
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
		
		
		//ModifiÃ© puis chercher
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


		utilisateurM.deleteUser(user1);*/
	
}
