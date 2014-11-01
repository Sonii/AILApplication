package com.esiea.lookat.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import static com.esiea.lookat.dao.DAOUtilitaire.*;

import com.esiea.lookat.entities.Categorie;
import com.esiea.lookat.entities.Commentaire;
import com.esiea.lookat.entities.Site;
import com.esiea.lookat.entities.Utilisateur;

public class UtilisateurDaoImpl implements ObjetDao{
	
    private static final String SQL_SELECT_PAR_ID = "SELECT * FROM utilisateurs WHERE id = ?";
    private static final String SQL_SELECT_PAR_EMAIL = "SELECT * FROM utilisateurs WHERE email = ?";
    private static final String SQL_INSERT = "INSERT INTO utilisateurs (pseudo, password, email) VALUES (?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE utilisateurs SET id = ? , pseudo = ?, password = ?, email = ? WHERE id = ?";
    private static final String SQL_DELETE = "DELETE FROM utilisateurs WHERE id = ?";
    private static final String SQL_SELECT_ALLSITE_BY_USER = "SELECT site.id, site.url, site.nom, site.description, site.idCat, site.nbClick, site.idUser FROM utilisateurs, site WHERE site.idUser = utilisateurs.id  AND utilisateurs.id = ?";
    
	Logger logger = Logger.getLogger(UtilisateurDaoImpl.class);
	private DAOFactory daoFactory;

	public void init() {
		logger.info("User Dao Dependency Done");
	}

	public UtilisateurDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public UtilisateurDaoImpl(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }
	
	@Override
	public Utilisateur findUserByEmail(String email) throws DAOException {
		Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Utilisateur user = null;

        try {
            connexion = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connexion, SQL_SELECT_PAR_EMAIL, false, email);
            resultSet = preparedStatement.executeQuery();
            /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
            if (resultSet.next()) {
                user = mapUtilisateur(resultSet);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            fermeturesSilencieuses(resultSet, preparedStatement, connexion);
        }
        return user;
	}
	
	@Override // R�cuperer la liste de sites appartenant � une categorie
	public List<Site> getUtilisateurSites(Utilisateur user) throws DAOException {
		 	Connection connexion = null;
	        PreparedStatement preparedStatement = null;
	        ResultSet resultSet = null;
	        ArrayList <Site> sites = new ArrayList<Site>();

	        try {
	            connexion = daoFactory.getConnection();
	            preparedStatement = initialisationRequetePreparee(connexion, SQL_SELECT_ALLSITE_BY_USER, false, user.getId());
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
	public void createUser(Utilisateur utilisateur) throws DAOException {
		Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet valeursAutoGenerees = null;

        try {
            /* Récupération d'une connexion depuis la Factory */
            connexion = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee( connexion, SQL_INSERT, true, utilisateur.getPseudo(), utilisateur.getPassword(), utilisateur.getEmail());
            int statut = preparedStatement.executeUpdate();
            /* Analyse du statut retourné par la requête d'insertion */
            if ( statut == 0 ) {
                throw new DAOException( "Échec de la création du site, aucune ligne ajoutée dans la table." );
            }
            /* Récupération de l'id auto-généré par la requête d'insertion */
            valeursAutoGenerees = preparedStatement.getGeneratedKeys();
            if ( valeursAutoGenerees.next() ) {
                /* Puis initialisation de la propriété id du bean Utilisateur avec sa valeur */
                utilisateur.setId( valeursAutoGenerees.getInt( 1 ) );
            } else {
                throw new DAOException( "Échec de la création de l'utilisateur en base, aucun ID auto-généré retourné." );
            }
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            fermeturesSilencieuses( valeursAutoGenerees, preparedStatement, connexion );
        }
		
	}

	@Override
	public Utilisateur findUser(Integer id) throws DAOException {
		Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Utilisateur user = null;

        try {
            connexion = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connexion, SQL_SELECT_PAR_ID, false, id);
            resultSet = preparedStatement.executeQuery();
            /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
            if (resultSet.next()) {
                user = mapUtilisateur(resultSet);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            fermeturesSilencieuses(resultSet, preparedStatement, connexion);
        }
        return user;
	}

	@Override
	public void modifyUser(Utilisateur utilisateur) throws DAOException {
		Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connexion = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee( connexion, SQL_UPDATE, false, utilisateur.getId(), utilisateur.getPseudo(), utilisateur.getPassword(), utilisateur.getEmail(), utilisateur.getId());
            int statut = preparedStatement.executeUpdate();
            /* Analyse du statut retourné par la requête d'insertion */
            if ( statut == 0 ) {
                throw new DAOException( "Échec de la création du site, aucune ligne ajoutée dans la table." );
            }
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            fermeturesSilencieuses( resultSet, preparedStatement, connexion );
        }
		
	}

	@Override
	public void deleteUser(Utilisateur utilisateur) throws DAOException {
		Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connexion = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee( connexion, SQL_DELETE, false, utilisateur.getId());
            int statut = preparedStatement.executeUpdate();
            /* Analyse du statut retourné par la requête d'insertion */
            if ( statut == 0 ) {
                throw new DAOException( "Échec de la création du site, aucune ligne ajoutée dans la table." );
            }
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            fermeturesSilencieuses( resultSet, preparedStatement, connexion );
        }
		
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
	public Categorie findCategorie(Integer id) throws DAOException {
		// TODO Auto-generated method stub
		return null;
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
	public List<Categorie> getAllCategories() throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Site> getCategorieSites(Categorie catalogue)
			throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}




}
