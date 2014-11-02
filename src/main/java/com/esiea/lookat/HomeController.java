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
    
	
	/* ---------- Affichae des sites � partie de la cat�gorie ---------- */
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
	
	@RequestMapping(value = "/login") // il reste � manipuler les cas ou les pass sont pas correctes
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
	
	@RequestMapping(value = "/publishSite") // il reste � manipuler les cas ou les pass sont pas correctes
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
		if( (site !=  null) && (site.getUrl() != null) && (site.getDescription() != null) && (site.getNom() != null) && (site.getIdCat() !=  null) && (site.getIdCat() != 0) && (email != null))
		{
			Utilisateur util = utilisateurM.findUserByEmail(email);
			success = true;
			site.setIdUser(util.getId());
			site.setNbClick(0);
			model.addAttribute("bool", success); //l� success
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
		Boolean created = false;

		if(utilisateurM.findUserByEmail(user.getEmail()) != null)
		{

			present = true;
			created = false;
			model.addAttribute("present", present);
			model.addAttribute("created", created); // Success : compte cr�e
			return "signup";
		}
		else if ((user.getEmail().isEmpty()) || (user.getPassword().isEmpty()) || (user.getPassword().length() < 6) || !(user.getPassword().equals(confirmP)))
		{

			present = false;
			created = false;
			model.addAttribute("present", present); // Success : compte cr�e
			model.addAttribute("created", created); // Success : compte cr�e
			return "signup";
		}
		else
		{
			present = false;
			created = true;
			model.addAttribute("present", present); // Success : compte cr�e
			model.addAttribute("created", created); // Success : compte cr�e
			utilisateurM.createUser(user);
			return "signup";
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
		Boolean wrong = false;
		Utilisateur u = new Utilisateur();
		site = siteMetier.findSite(idS);
		if(site != null) // on check toujours si le site est trouvable 
		{
			if((pass != null) && (pass.equals(confirmP))) // on check le confirmP est bon
			{
				u = utilisateurM.findUser(site.getIdUser());
				if((email != null) && (email.equals(u.getEmail()))) // on check qu'il s'agit toujours d'un site appartenant � l'utilisateur en question
				{	
					// afin d'�viter qu'un utilisateur mal veillant supprime un site d'un autre user
					siteMetier.deleteSite(site);
					return "home"; // Si possible notification disant que le site a bien �t� supprim�
				}
				else
				{
					return "rights";
				}
			}
			else
			{
				wrong = true;
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
					if(com.getContenu() != null)
					{
						if(com.getEtoile() == null)
						{
							com.setEtoile(0);
						}
						com.setEtoile(0);
						commentaireM.createCom(com);
						return this.avis(model, site.getId());
					}
					else
					{
						return "addcoms";
					}
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
	
	@RequestMapping(value = "/modifyCommentf")
	public String modifyCommentf(Model model, HttpSession session, Integer idC)
	{
		String email = (String) session.getAttribute("email");
		if(idC != null)
		{
			if(email != null)
			{
				Commentaire com = new Commentaire();
				com = commentaireM.findCom(idC);
				if(com != null)
				{
					Utilisateur u = new Utilisateur();
					u = utilisateurM.findUser(com.getIdUser());
					if(u.getEmail().equals(email))
					{
						model.addAttribute("commentaire", new Commentaire());
						model.addAttribute("com", com);
						model.addAttribute("idC", idC);
						return "modifycom";
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
	
	@RequestMapping(value = "/modifyCom")
	public String modifyCom(Model model, Commentaire commentaire, HttpSession session, Integer idC)
	{
		String email = (String) session.getAttribute("email");
		if(idC != null)
		{
			if(email != null)
			{
				Commentaire com = new Commentaire();
				com = commentaireM.findCom(idC);
				if(com != null)
				{
					Utilisateur u = new Utilisateur();
					u = utilisateurM.findUser(com.getIdUser());
					if(u.getEmail().equals(email))
					{
						if(commentaire.getContenu() != null)
						{
							if(commentaire.getEtoile() == null)
							{
								commentaire.setEtoile(0);
							}
							commentaire.setId(com.getId());
							commentaire.setIdSite(com.getIdSite());
							commentaire.setIdUser(com.getIdUser());
							commentaireM.modifyCom(commentaire);
							return this.avis(model, commentaire.getIdSite());
						}
						else
						{
							return "modifycom";
						}
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
	
	@RequestMapping(value = "/deleteComment")
	public String deleteComment(Model model, HttpSession session, Integer idC)
	{
		String email = (String) session.getAttribute("email");
		if(idC != null)
		{
			if(email != null)
			{
				Commentaire com = new Commentaire();
				com = commentaireM.findCom(idC);
				if(com != null)
				{
					Utilisateur u = new Utilisateur();
					u = utilisateurM.findUser(com.getIdUser());
					if(u.getEmail().equals(email))
					{
						model.addAttribute("idC", idC);
						return "confirmPassC";
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
	
	@RequestMapping(value = "/confirmDeleteCom")
	public String confirmDeleteCom(Model model, HttpSession session, Integer idC, @RequestParam("confirmP")String confirmP)
	{
		String email = (String) session.getAttribute("email");
		String pass = (String) session.getAttribute("pass");
		Boolean wrong = false;
		if(idC != null)
		{
			if(email != null)
			{
				Commentaire com = new Commentaire();
				com = commentaireM.findCom(idC);
				if(com != null)
				{
					Utilisateur u = new Utilisateur();
					u = utilisateurM.findUser(com.getIdUser());
					if(u.getEmail().equals(email))
					{
						if(pass.equals(confirmP))
						{
							commentaireM.deleteCom(com);
							return avis(model, com.getIdSite());
						}
						else
						{
							wrong = true;
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
	
	
}
