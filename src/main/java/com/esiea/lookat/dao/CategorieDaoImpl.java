package com.esiea.lookat.dao;

import static com.esiea.lookat.dao.DAOUtilitaire.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.esiea.lookat.entities.Categorie;
import com.esiea.lookat.entities.Commentaire;
import com.esiea.lookat.entities.Site;
import com.esiea.lookat.entities.Utilisateur;

public class CategorieDaoImpl implements ObjetDao {

	private static final String SQL_SELECT_PAR_ID = "SELECT * FROM categories WHERE id = ?";
    private static final String SQL_SELECT_ALLSITE_BY_CAT = "SELECT site.id, site.url, site.nom, site.description, site.idCat, site.nbClick, site.idUser FROM categories, site WHERE site.idCat = categories.id  AND categories.id = ?";
    private static final String SQL_SELECT_ALLCAT = "SELECT * FROM categories";

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

	@Override // R�cuperer la liste de toutes les categories
	public List<Categorie> getAllCategories() throws DAOException {
		 Connection connexion = null;
	        PreparedStatement preparedStatement = null;
	        ResultSet resultSet = null;
	        ArrayList <Categorie> cats = new ArrayList <Categorie>();

	        try {
	            connexion = daoFactory.getConnection();
	            preparedStatement = initialisationRequetePreparee(connexion, SQL_SELECT_ALLCAT, false);
	            resultSet = preparedStatement.executeQuery();
	            /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
	            while (resultSet.next()) {
	                cats.add(mapCategorie(resultSet));
	            }
	        } catch (SQLException e) {
	            throw new DAOException(e);
	        } finally {
	            fermeturesSilencieuses(resultSet, preparedStatement, connexion);
	        }
	        return cats;
	}

	@Override // R�cuperer la liste de sites appartenant � une categorie
	public List<Site> getCategorieSites(Categorie cat) throws DAOException {
		 	Connection connexion = null;
	        PreparedStatement preparedStatement = null;
	        ResultSet resultSet = null;
	        ArrayList <Site> sites = new ArrayList<Site>();

	        try {
	            connexion = daoFactory.getConnection();
	            preparedStatement = initialisationRequetePreparee(connexion, SQL_SELECT_ALLSITE_BY_CAT, false, cat.getId());
	            resultSet = preparedStatement.executeQuery();
	            /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
	            while (resultSet.next()) {
	                sites.add( mapSite(resultSet));
	            }
	        } catch (SQLException e) {
	            throw new DAOException(e);
	        } finally {
	            fermeturesSilencieuses(resultSet, preparedStatement, connexion);
	        }
	        return sites;
	}
	

	@Override
	public Categorie findCategorie(Integer id) throws DAOException {
		 Connection connexion = null;
	        PreparedStatement preparedStatement = null;
	        ResultSet resultSet = null;
	        Categorie cat = null;

	        try {
	            connexion = daoFactory.getConnection();
	            preparedStatement = initialisationRequetePreparee(connexion, SQL_SELECT_PAR_ID, false, id);
	            resultSet = preparedStatement.executeQuery();
	            /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
	            if (resultSet.next()) {
	                cat = mapCategorie(resultSet);
	            }
	        } catch (SQLException e) {
	            throw new DAOException(e);
	        } finally {
	            fermeturesSilencieuses(resultSet, preparedStatement, connexion);
	        }
	        return cat;
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

	@Override
	public Utilisateur findUser(Integer id) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Site> getUtilisateurSites(Utilisateur user) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}
	
}
