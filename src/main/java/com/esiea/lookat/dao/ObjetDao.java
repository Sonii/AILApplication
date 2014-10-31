package com.esiea.lookat.dao;

import java.util.List;

import com.esiea.lookat.entities.*;

public interface ObjetDao {

	/* ----------- Methods For Site Class ----------- */
	
	public void createSite(Site site) throws DAOException;
    public Site findSite(Integer id) throws DAOException;
    public void modifySite(Site site) throws DAOException;
    public void deleteSite(Site site) throws DAOException;
    public List<Commentaire> getlistComs(Site site) throws DAOException; // liste de commentaires pour un site
	public Categorie getSiteCategorie(Site site) throws DAOException; // Categorie de site
	public List<Site> getAllSites() throws DAOException; // la liste de sites
	public Utilisateur getSiteUser(Site site) throws DAOException; // utilisateur du site
    
    /* ----------- Methods For Commentaire Class ----------- */
    
	public void createCom( Commentaire commentaire) throws DAOException;
    public Commentaire findCom(Integer id) throws DAOException;
    public void modifyCom(Commentaire commentaire) throws DAOException;
    public void deleteCom(Commentaire commentaire) throws DAOException;
    public Site getSiteCom(Commentaire commentaire) throws DAOException; // R�cuperer le site du commentaire
    public Utilisateur getComUser(Commentaire commentaire) throws DAOException; // R�cuperer l'utilisateur du commentaire
    
    /* ----------- Methods For Categorie Class ----------- */
    
    public Categorie findCategorie(Integer id) throws DAOException;
    public List<Categorie> getAllCategories() throws DAOException; // R�cuperer la liste de sites appartenant � une categorie
    public List<Site> getCategorieSites(Categorie catalogue) throws DAOException; // R�cuperer la liste de toutes les categories
    
    /* ----------- Methods For Utilisateur Class ----------- */
    
    public void createUser(Utilisateur utilisateur) throws DAOException;
    public Utilisateur findUser(Integer id) throws DAOException;
    public void modifyUser(Utilisateur utilisateur) throws DAOException;
    public void deleteUser(Utilisateur utilisateur) throws DAOException; //Supprimer d'abbord tout ses commentaire et ses site sinon erreur clé externe sql
    
}