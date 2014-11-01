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
	
	
	@RequestMapping(value = "/home")
	public String home(Model model) {
		return "home";
	}
	
}
