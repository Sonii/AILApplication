
package com.esiea.lookat.dao;

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

import static com.esiea.lookat.dao.DAOUtilitaire.*;

public class SiteDaoImpl implements ObjetDao {
	

    private static final String SQL_SELECT_PAR_ID = "SELECT id, url, nom, description, idCat, nbClick, idUser FROM site WHERE id = ?";
    private static final String SQL_INSERT = "INSERT INTO site (url, nom, description, idCat, nbClick, idUser) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE site SET id = ? , url = ?, nom = ?, description = ?, idCat = ?, nbClick = ?, idUser = ? WHERE id = ?";
    private static final String SQL_DELETE = "DELETE FROM site WHERE id = ?";
    private static final String SQL_SELECT_ALLCOM_BY_SITE = "SELECT commentaires.id, commentaires.etoile, commentaires.idSite, commentaires.contenu, commentaires.idUser FROM commentaires, site WHERE site.id = commentaires.idSite AND site.id = ?";
    private static final String SQL_SELECT_CAT_BY_SITE = "SELECT categorie.id, categorie.nom FROM categories, site WHERE site.idCat = categories.id AND site.id = ?";
    private static final String SQL_SELECT_ALLSITE = "SELECT * FROM site";
    private static final String SQL_SELECT_USER_BY_SITE = "SELECT utilisateurs.id, utilisateurs.pseudo, utilisateurs.password, utilisateurs.email FROM utilisateurs, site WHERE site.idUser = utilisateurs.id AND site.id = ?";
    
    private DAOFactory daoFactory;
    Logger logger = Logger.getLogger(SiteDaoImpl.class);

    public SiteDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	SiteDaoImpl( DAOFactory daoFactory ) {
        this.daoFactory = daoFactory;
    }
	
	@Override // liste de commentaires pour un site
	public List<Commentaire> getlistComs(Site site) throws DAOException {
		 Connection connexion = null;
	        PreparedStatement preparedStatement = null;
	        ResultSet resultSet = null;
	        ArrayList <Commentaire> coms = new ArrayList <Commentaire>();

	        try {
	            connexion = daoFactory.getConnection();
	            preparedStatement = initialisationRequetePreparee(connexion, SQL_SELECT_ALLCOM_BY_SITE, false, site.getId());
	            resultSet = preparedStatement.executeQuery();
	            /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
	            while (resultSet.next()) {
	                coms.add( mapCommentaire(resultSet));
	            }
	        } catch (SQLException e) {
	            throw new DAOException(e);
	        } finally {
	            fermeturesSilencieuses(resultSet, preparedStatement, connexion);
	        }
	        return coms;
	    }


	@Override // Categorie de site
	public Categorie getSiteCategorie(Site site) throws DAOException {
		 Connection connexion = null;
	        PreparedStatement preparedStatement = null;
	        ResultSet resultSet = null;
	        Categorie cat = null;

	        try {
	            connexion = daoFactory.getConnection();
	            preparedStatement = initialisationRequetePreparee(connexion, SQL_SELECT_CAT_BY_SITE, false, site.getId());
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

	@Override // la liste de sites
	public List<Site> getAllSites() throws DAOException {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ArrayList <Site> sites = new ArrayList <Site>();

        try {
            connexion = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connexion, SQL_SELECT_ALLSITE, false);
            resultSet = preparedStatement.executeQuery();
            /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
            while (resultSet.next()) {
                sites.add(mapSite(resultSet));
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            fermeturesSilencieuses(resultSet, preparedStatement, connexion);
        }
        return sites;
	}

	@Override // utilisateur du site
	public Utilisateur getSiteUser(Site site) throws DAOException {
		 Connection connexion = null;
	        PreparedStatement preparedStatement = null;
	        ResultSet resultSet = null;
	        Utilisateur user = null;

	        try {
	            connexion = daoFactory.getConnection();
	            preparedStatement = initialisationRequetePreparee(connexion, SQL_SELECT_USER_BY_SITE, false, site.getId());
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
    public Site findSite(Integer id) throws DAOException {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Site site = null;

        try {
            connexion = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connexion, SQL_SELECT_PAR_ID, false, id);
            resultSet = preparedStatement.executeQuery();
            /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
            if (resultSet.next()) {
                site = mapSite(resultSet);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            fermeturesSilencieuses(resultSet, preparedStatement, connexion);
        }
        return site;
    }

    

    /* Implémentation de la méthode définie dans l'interface UtilisateurDao */
    @Override
    public void createSite( Site site ) throws DAOException {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet valeursAutoGenerees = null;

        try {
            /* Récupération d'une connexion depuis la Factory */
            connexion = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee( connexion, SQL_INSERT, true, site.getUrl(), site.getNom(), site.getDescription(), site.getIdCat(), site.getNbClick(), site.getIdUser());
            int statut = preparedStatement.executeUpdate();
            /* Analyse du statut retourné par la requête d'insertion */
            if ( statut == 0 ) {
                throw new DAOException( "Échec de la création du site, aucune ligne ajoutée dans la table." );
            }
            /* Récupération de l'id auto-généré par la requête d'insertion */
            valeursAutoGenerees = preparedStatement.getGeneratedKeys();
            if ( valeursAutoGenerees.next() ) {
                /* Puis initialisation de la propriété id du bean Utilisateur avec sa valeur */
                site.setId( valeursAutoGenerees.getInt( 1 ) );
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
	public void modifySite(Site site) throws DAOException {
		 	Connection connexion = null;
	        PreparedStatement preparedStatement = null;
	        ResultSet resultSet = null;

	        try {
	            connexion = daoFactory.getConnection();
	            preparedStatement = initialisationRequetePreparee( connexion, SQL_UPDATE, false, site.getId(),site.getUrl(), site.getNom(), site.getDescription(), site.getIdCat(), site.getNbClick(), site.getIdUser(), site.getId());
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
	public void deleteSite(Site site) throws DAOException {
		Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connexion = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee( connexion, SQL_DELETE, false, site.getId());
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
	
	public void init() {
		logger.info("Site Dao Dependency Done");
	}

	@Override
	public void createCom(Commentaire commentaire) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	
	/* A ne pas toucher pour cette classe */
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
	public Categorie findCategorie(Integer id) throws DAOException {
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