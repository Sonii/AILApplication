package com.esiea.lookat.metier;

import java.util.List;

import com.esiea.lookat.dao.*;
import com.esiea.lookat.entities.*;

public interface ObjetMetier {

	
	/* ----------- SiteMetierImpl Class Methods -----------*/
	
	public void createSite(Site site);
	public void modifySite(Site site);
	public void deleteSite(Site site);
	public Site findSite(Integer id);
	public List<Commentaire> getlistComs(Site site); // liste de commentaires pour un site
	public Categorie getSiteCategorie(Site site); // Categorie de site
	public List<Site> getAllSites(); // la liste de sites
	public Utilisateur getSiteUser(Site site); // utilisateur du site
	
	/* ----------- CommentaireetierImpl Class Methods -----------*/
	
	public void createCom( Commentaire commentaire);
    public Commentaire findCom(Integer id);
    public void modifyCom(Commentaire commentaire);
    public void deleteCom(Commentaire commentaire);
    public Site getSiteCom(Commentaire commentaire);
    public Utilisateur getComUser(Commentaire commentaire);
    
	/* ----------- CategorieMetierImpl Class Methods -----------*/
    
    public Categorie findCategorie(Integer id);
    public List<Categorie> getAllCategories();// R�cuperer la liste de toutes les categories
    public List<Site> getCategorieSites(Categorie catalogue); // R�cuperer la liste de sites appartenant � une categorie
    
	/* ----------- UtilisateurMetierImpl Class Methods -----------*/
    
    public void createUser(Utilisateur utilisateur);
    public Utilisateur findUser(Integer id);
    public void modifyUser(Utilisateur utilisateur);
    public void deleteUser(Utilisateur utilisateur);
    public List<Site> getUtilisateurSites(Utilisateur user);
    public Utilisateur findUserByEmail (String email);

}
