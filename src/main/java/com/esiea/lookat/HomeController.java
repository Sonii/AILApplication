package com.esiea.lookat;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
import org.springframework.web.bind.annotation.RequestParam;

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
    
	
	/* ---------- Affichae des sites ï¿½ partie de la catï¿½gorie ---------- */
	@RequestMapping(value = "/mode")
	public String getmodeCatSites(Model model) {
		Categorie cat = new Categorie();
		cat = categorieM.findCategorie(1);
		List<Site> sites = new ArrayList<Site>();
		sites = categorieM.getCategorieSites(cat);
		List<String> users = new ArrayList<String>();
		for(Site site : sites)
		{
			Utilisateur u = utilisateurM.findUser(site.getIdUser());
			users.add(u.getPseudo());
		}
		model.addAttribute("users", users);
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
		List<String> users = new ArrayList<String>();
		for(Site site : sites)
		{
			Utilisateur u = utilisateurM.findUser(site.getIdUser());
			users.add(u.getPseudo());
		}
		model.addAttribute("users", users);
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
		List<String> users = new ArrayList<String>();
		for(Site site : sites)
		{
			Utilisateur u = utilisateurM.findUser(site.getIdUser());
			users.add(u.getPseudo());
		}
		model.addAttribute("users", users);
		model.addAttribute("site", new Site());
		model.addAttribute("liste", sites);
		return "sitesCat";
	}
	@RequestMapping(value = "/world")
	public String getmondeCatSites(Model model) {
		Categorie cat = new Categorie();
		cat = categorieM.findCategorie(4);
		List<Site> sites = new ArrayList<Site>();
		sites = categorieM.getCategorieSites(cat);
		List<String> users = new ArrayList<String>();
		for(Site site : sites)
		{
			Utilisateur u = utilisateurM.findUser(site.getIdUser());
			users.add(u.getPseudo());
		}
		model.addAttribute("users", users);
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
		List<String> users = new ArrayList<String>();
		for(Site site : sites)
		{
			Utilisateur u = utilisateurM.findUser(site.getIdUser());
			users.add(u.getPseudo());
		}
		model.addAttribute("users", users);
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
		List<String> users = new ArrayList<String>();
		for(Site site : sites)
		{
			Utilisateur u = utilisateurM.findUser(site.getIdUser());
			users.add(u.getPseudo());
		}
		model.addAttribute("users", users);
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
		List<String> users = new ArrayList<String>();
		for(Site site : sites)
		{
			Utilisateur u = utilisateurM.findUser(site.getIdUser());
			users.add(u.getPseudo());
		}
		model.addAttribute("users", users);
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
		List<String> users = new ArrayList<String>();
		for(Site site : sites)
		{
			Utilisateur u = utilisateurM.findUser(site.getIdUser());
			users.add(u.getPseudo());
		}
		model.addAttribute("users", users);
		model.addAttribute("site", new Site());
		model.addAttribute("liste", sites);
		return "sitesCat";
	}
	/* ---------------------------------------------------------- */
	
	/* ----------------- Site Comms ------------------ */
	@RequestMapping(value = "/avis")
	public String avis(Model model, Integer idC) {
		Site site = new Site();
		site = siteMetier.findSite(idC);
		if(site == null)
		{
			return "home";
		}
		else
		{
			List<Commentaire> comms = new ArrayList<Commentaire>();
			comms = siteMetier.getlistComs(site);
			List<String> users = new ArrayList<String>();
			for(Commentaire com : comms)
			{
				Utilisateur u = utilisateurM.findUser(com.getIdUser());
				users.add(u.getPseudo());
			}
			model.addAttribute("users", users);
			model.addAttribute("commentaire", new Commentaire());
			model.addAttribute("liste", comms);
			return "avisSite";
		}
	}
	/* ----------------------------------------------- */
	
	@RequestMapping(value = "/home")
	public String home(Model model) {
		return "home";
	}
	
	@RequestMapping(value = "/signin")
	public String signin(Model model, HttpSession session) {
		String email = (String) session.getAttribute("email");
		if(email == null)
		{
			return "signin";
		}
		else
		{
			return "signout";
		}
	}
	
	@RequestMapping(value = "/login") // il reste ï¿½ manipuler les cas ou les pass sont pas correctes
	public String login(@RequestParam("email")String email,  @RequestParam("pass")String pass, Model model, HttpSession session) {
		Boolean wrong = false;
		if(email.isEmpty())
		{
			return "signin";
		}
		else if(pass.isEmpty())
		{
			return "signin";
		}
		else if((utilisateurM.findUserByEmail(email) != null) && (utilisateurM.findUserByEmail(email).getPassword().equals(pass)))
		{
			session.setAttribute("email", email);
			session.setAttribute("pass", pass);
			return "home";
		}
		else
		{
			wrong = true;
			model.addAttribute("wrong", wrong); // erreur : pass ou email incorrectes
			return "signin";
		}
	}
	
	@RequestMapping(value = "/publishSite") // il reste ï¿½ manipuler les cas ou les pass sont pas correctes
	public String publishSite(Model model, Site site, HttpSession session) {
		String email = (String) session.getAttribute("email");
		if(email == null)
		{
			return "signin";
		}
		else
		{
			model.addAttribute("site", new Site());
			return "publishSite";
		}
	}
	
	@RequestMapping(value = "/savesite")
	public String saveSite(Model model, Site site, HttpSession session) {
		Boolean success;
		String email = (String) session.getAttribute("email");
		if((site.getUrl() != null) && (site.getDescription() != null) && (site.getNom() != null) && (site.getIdCat() != 0) && (email != null))
		{
			Utilisateur util = utilisateurM.findUserByEmail(email);
			success = true;
			site.setIdUser(util.getId());
			site.setNbClick(0);
			model.addAttribute("bool", success); //lï¿½ success
			siteMetier.createSite(site);
			if(site.getIdCat() == 1)
			{
				return getmodeCatSites(model);
			}
			else if(site.getIdCat() == 2)
			{
				return getsportCatSites(model);
			}
			else if(site.getIdCat() == 3)
			{
				return getitechCatSites(model);
			}
			else if(site.getIdCat() == 4)
			{
				return getmondeCatSites(model);
			}
			else if(site.getIdCat() == 5)
			{
				return getsalesCatSites(model);
			}
			else if(site.getIdCat() == 6)
			{
				return getcinemaCatSites(model);
			}
			else if(site.getIdCat() == 7)
			{
				return getpeopleCatSites(model);
			}
			else if(site.getIdCat() == 8)
			{
				return getjeuxCatSites(model);
			}
			else
			{
				return "home";
			}
		}
		else
		{
			return "publishSite";
		}
	}
	
	
	@RequestMapping(value = "/signup")
	public String signup(Model model) {
		model.addAttribute("user", new Utilisateur());
		return "signup";
	}
	
	@RequestMapping(value = "/saveuser")
	public String saveuser(Model model, Utilisateur user, @RequestParam("confirmP")String confirmP) {
		model.addAttribute("user", new Utilisateur());
		Boolean present = false;
		if(utilisateurM.findUserByEmail(user.getEmail()) != null)
		{
			present = true;
			model.addAttribute("present", present); //lï¿½ erreur contact existe deja
			return "signup";
		}
		else if ((user.getEmail().isEmpty()) || (user.getPassword().isEmpty()) || (user.getPassword().length() < 6) || (!user.getPassword().equals(confirmP)))
		{
			return "signup";
		}
		else
		{
			present = false;
			model.addAttribute("present", present); // Success : compte crï¿½e
			utilisateurM.createUser(user);
			return "signin";
		}
	}
	
	@RequestMapping(value = "/signout")
	public String signout(Model model, HttpSession session) {
		session.invalidate();
		return "signin";
	}
	
	@RequestMapping(value = "/deleteSite")
	public String deleteSite(Model model, HttpSession session, Integer idS) {
		String email = (String) session.getAttribute("email");
		Site site = new Site();
		Utilisateur u = new Utilisateur();
		site = siteMetier.findSite(idS);
		if(site != null)
		{
			u = utilisateurM.findUser(site.getIdUser());
			if(email == null)
			{
				return "signin";
			}
			else if(email.equals(u.getEmail()))
			{
				model.addAttribute("id", idS);
				return "confirmPass";
			}
			else
			{
				return "rights";
			}
		}
		else
		{
			return "home";
		}
	}
	
	@RequestMapping(value = "/confirmDelete")
	public String confirmDelete(Model model, HttpSession session, Integer idS, @RequestParam("confirmP")String confirmP) { 
		String email = (String) session.getAttribute("email"); // Thomas ne change stp surtt pas ce code si t'as des questions tu 
		String pass = (String) session.getAttribute("pass"); // me demande, Merci :-)
		Site site = new Site();
		Utilisateur u = new Utilisateur();
		site = siteMetier.findSite(idS);
		if(site != null) // on check toujours si le site est trouvable 
		{
			if((pass != null) && (pass.equals(confirmP))) // on check le confirmP est bon
			{
				u = utilisateurM.findUser(site.getIdUser());
				if((email != null) && (email.equals(u.getEmail()))) // on check qu'il s'agit toujours d'un site appartenant à l'utilisateur en question
				{	
					// afin d'éviter qu'un utilisateur mal veillant supprime un site d'un autre user
					siteMetier.deleteSite(site);
					return "home"; // Si possible notification disant que le site a bien été supprimé
				}
				else
				{
					return "rights";
				}
			}
			else
			{
				return "rights";
			}
		}
		else
		{
			return "rights";
		}
	}
	
	@RequestMapping(value = "/addcomf")
	public String addcomf(Model model, HttpSession session, Integer idS)
	{
		String email = (String) session.getAttribute("email");
		if(idS != null)
		{
			if(email != null)
			{
				Site site = new Site();
				site = siteMetier.findSite(idS);
				if(site != null)
				{
					model.addAttribute("idS", idS);
					model.addAttribute("com", new Commentaire());
					return "addcoms";
				}
				else
				{
					return "home";
				}
			}
			else
			{
				return "signin";
			}
		}
		else
		{
			return "home";
		}
	}
	
	@RequestMapping(value = "/addcoms")
	public String addcoms(Model model, HttpSession session, Integer idS, Commentaire com)
	{
		String email = (String) session.getAttribute("email");
		if(idS != null)
		{
			if(email != null)
			{
				Site site = new Site();
				site = siteMetier.findSite(idS);
				if(site != null)
				{
					Utilisateur u = new Utilisateur();
					u = utilisateurM.findUserByEmail(email);
					List<Site> liste = new ArrayList<Site>();
					com.setIdSite(idS);
					com.setIdUser(u.getId());
					if(com.getEtoile() == null)
					{
						com.setEtoile(0);
					}
					commentaireM.createCom(com);
					return this.avis(model, site.getId());
				}
				else
				{
					return "home";
				}
			}
			else
			{
				return "signin";
			}
		}
		else
		{
			return "home";
		}
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
