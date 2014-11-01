package com.esiea.lookat.metier;

import java.util.List;

import com.esiea.lookat.dao.*;
import com.esiea.lookat.entities.Categorie;
import com.esiea.lookat.entities.Commentaire;
import com.esiea.lookat.entities.Site;
import com.esiea.lookat.entities.Utilisateur;

public class CommentaireMetierImpl implements ObjetMetier{

	private ObjetDao dao = new CommentaireDaoImpl();

	public void setDao(ObjetDao dao) {
		this.dao = dao;
	}

	public CommentaireMetierImpl() {
		super();
		dao = DAOFactory.getInstance().getCommentaireDao();
	}

	@Override
	public void createCom(Commentaire commentaire) {
		dao.createCom(commentaire);
	}
	
	@Override
	public Utilisateur getComUser(Commentaire commentaire) {
		return dao.getComUser(commentaire);
	}


	@Override
	public Site getSiteCom(Commentaire commentaire) {
		return dao.getSiteCom(commentaire);
	}
	
	@Override
	public Commentaire findCom(Integer id) {
		return dao.findCom(id);
	}

	@Override
	public void modifyCom(Commentaire commentaire) {
		dao.modifyCom(commentaire);
	}

	@Override
	public void deleteCom(Commentaire commentaire) {
		dao.deleteCom(commentaire);
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
	public Categorie findCategorie(Integer id) {
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
	public Categorie getSiteCategorie(Site site) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Commentaire> getlistComs(Site site) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Site> getAllSites() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Categorie> getAllCategories() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Utilisateur getSiteUser(Site site) {
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
