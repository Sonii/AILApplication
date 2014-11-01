package com.esiea.lookat.metier;

import java.util.List;

import com.esiea.lookat.dao.*;
import com.esiea.lookat.entities.Categorie;
import com.esiea.lookat.entities.Commentaire;
import com.esiea.lookat.entities.Site;
import com.esiea.lookat.entities.Utilisateur;

public class SiteMetierImpl implements ObjetMetier{

	private ObjetDao dao = new SiteDaoImpl();
	private CommentaireMetierImpl comM = new CommentaireMetierImpl();
	
	public SiteMetierImpl() {
		super();
		dao = DAOFactory.getInstance().getSiteDao();
	}

	public void setDao(ObjetDao Dao) {
		this.dao = Dao;
	}
	
	@Override
	public List<Site> getAllSites()
	{
		return dao.getAllSites();
	}
	
	@Override
	public Utilisateur getSiteUser(Site site) {
		return dao.getSiteUser(site);
	}
	
	@Override
	public List<Commentaire> getlistComs(Site site) {
		return dao.getlistComs(site);
	}

	@Override
	public Categorie getSiteCategorie(Site site) {
		return dao.getSiteCategorie(site);
	}

	@Override
	public void createSite(Site site) {
		dao.createSite(site);
	}

	@Override
	public void modifySite(Site site) {
		dao.modifySite(site);
	}

	@Override
	public void deleteSite(Site site) {
		for (Commentaire c : dao.getlistComs(site)){
			comM.deleteCom(c);
		}
		dao.deleteSite(site);
	}

	@Override
	public Site findSite(Integer id) {
		return dao.findSite(id);
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
	public Site getSiteCom(Commentaire commentaire) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Categorie findCategorie(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Categorie> getAllCategories() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Utilisateur getComUser(Commentaire commentaire) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Site> getCategorieSites(Categorie catalogue) {
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
