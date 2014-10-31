package com.esiea.lookat.dao;

import java.util.List;

import org.apache.log4j.Logger;

import com.esiea.lookat.entities.Categorie;
import com.esiea.lookat.entities.Commentaire;
import com.esiea.lookat.entities.Site;
import com.esiea.lookat.entities.Utilisateur;

public class CategorieDaoImpl implements ObjetDao {

	Logger logger = Logger.getLogger(CategorieDaoImpl.class);
	private DAOFactory daoFactory;

	public void init() {
		logger.info("Catalogue Dao Dependency Done");
	}
	
	public CategorieDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public CategorieDaoImpl( DAOFactory daoFactory ) {
        this.daoFactory = daoFactory;
    }

	@Override // Récuperer la liste de toutes les categories
	public List<Categorie> getAllCategories() throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override // Récuperer la liste de sites appartenant à une categorie
	public List<Site> getCategorieSites() throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void createCategorie(Categorie catalogue) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Categorie findCategorie(Integer id) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modifyCategorie(Categorie catalogue) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCategorie(Categorie catalogue) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createSite(Site site) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Site findSite(Integer id) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modifySite(Site site) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteSite(Site site) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createCom(Commentaire commentaire) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Commentaire findCom(Integer id) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modifyCom(Commentaire commentaire) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCom(Commentaire commentaire) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createUser(Utilisateur utilisateur) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Utilisateur findUser(String email) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modifyUser(Utilisateur utilisateur) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(Utilisateur utilisateur) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Commentaire> getlistComs(Site site) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Categorie getSiteCategorie(Site site) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Site> getAllSites() throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Utilisateur getSiteUser(Site site) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Site getSiteCom(Commentaire commentaire) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Utilisateur getComUser(Commentaire commentaire) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}
	
}
