package com.esiea.lookat.metier;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.esiea.lookat.dao.*;
import com.esiea.lookat.entities.Categorie;
import com.esiea.lookat.entities.Commentaire;
import com.esiea.lookat.entities.Site;
import com.esiea.lookat.entities.Utilisateur;

public class CategorieMetierImpl implements ObjetMetier{

	private ObjetDao dao = new CategorieDaoImpl();
	
	public CategorieMetierImpl() {
		super();
		dao = DAOFactory.getInstance().getCategorieDao();
	}

	public void setDao(ObjetDao dao) {
		this.dao = dao;
	}
	
	@Override
	public List<Categorie> getAllCategories() {
		return dao.getAllCategories();
	}
	
	@Override
	public List<Site> getCategorieSites(Categorie catalogue) {
		List<Site> sites = new ArrayList<Site>();
		sites = dao.getCategorieSites(catalogue);
		Collections.sort(sites);
		return sites;
	}

	@Override
	public Categorie findCategorie(Integer id) {
		return dao.findCategorie(id);
	}
	
	@Override
	public void createSite(Site site) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifySite(Site site) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteSite(Site site) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Site findSite(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Commentaire> getlistComs(Site site) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Categorie getSiteCategorie(Site site) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createCom(Commentaire commentaire) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Commentaire findCom(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modifyCom(Commentaire commentaire) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCom(Commentaire commentaire) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Site getSiteCom(Commentaire commentaire) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createUser(Utilisateur utilisateur) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifyUser(Utilisateur utilisateur) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(Utilisateur utilisateur) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Site> getAllSites() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Utilisateur getSiteUser(Site site) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Utilisateur getComUser(Commentaire commentaire) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Utilisateur findUser(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Site> getUtilisateurSites(Utilisateur user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Utilisateur findUserByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

}
